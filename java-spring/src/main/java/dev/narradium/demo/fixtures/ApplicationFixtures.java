package dev.narradium.demo.fixtures;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.narradium.demo.models.i18n.Country;
import dev.narradium.demo.models.i18n.LocalizedCode;
import dev.narradium.demo.models.i18n.LocalizedCountry;
import dev.narradium.demo.repositories.CountryRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApplicationFixtures implements CommandLineRunner {

    record DataCountry(String isocode, Map<String, String> names) {
    }
    record DataCountries(List<DataCountry> countries) {
    }

    private final CountryRepository countryRepository;

    @Autowired
    public ApplicationFixtures(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void run(String... args) throws IOException {
        log.info("[SampleData] Initialization");
        log.info("[SampleData] Loading countries...");
        ObjectMapper objectMapper = new ObjectMapper();
        var file = new ClassPathResource("sampledata/countries.json").getFile();
        DataCountries countries = objectMapper.readValue(file, DataCountries.class);
        var result = countries.countries.stream().map(data -> {
            var country = new Country();
            country.setIsocode(data.isocode());
            data.names().forEach((key, value) -> {
                var tempCountry = new LocalizedCountry();
                tempCountry.setLocalizedCode(new LocalizedCode(key));
                tempCountry.setName(value);
                tempCountry.setCountry(country);
                country.getLocalizations().put(key, tempCountry);
            });
            return country;
        }).toList();
        this.countryRepository.saveAll(result);

        log.info("[SampleData] End of process");
    }
}

package dev.narradium.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import dev.narradium.demo.models.i18n.Country;
import dev.narradium.demo.repositories.CountryRepository;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountries() {
        var countries = this.countryRepository.findAll();
        return countries;
    }

    // TODO: should `orElseThrow` be in the service layer or controller layer?
    public Country getCountry(String isocode) {
        var country = this.countryRepository.findById(isocode).orElseThrow();
        return country;
    }
}

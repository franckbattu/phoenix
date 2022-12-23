package dev.narradium.demo.controllers;

import dev.narradium.demo.models.i18n.Country;
import dev.narradium.demo.services.CountryService;

import java.util.List;
import java.util.Locale;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/countries")
public class CountryController {

    record CountryDto(String isocde, String name) {}

    private final CountryService countryService;

    public CountryController(CountryService countryService)
    {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getCountries()
    {
        return this.countryService.getCountries();
    }

    @GetMapping("{isocode}")
    public CountryDto getCountry(@PathVariable("isocode") String isocode, Locale locale)
    {
        var country = this.countryService.getCountry(isocode);
        return new CountryDto(country.getIsocode(), country.getName(locale.getLanguage()));
    }
}

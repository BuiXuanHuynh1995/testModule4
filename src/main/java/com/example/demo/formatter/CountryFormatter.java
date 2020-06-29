package com.example.demo.formatter;

import com.example.demo.model.Country;
import com.example.demo.service.ICountryService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class CountryFormatter implements Formatter<Country> {
    private ICountryService countryService;

    public CountryFormatter(ICountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        Optional<Country> countryOptional = countryService.findById(Long.parseLong(text));
        return countryOptional.get();
    }

    @Override
    public String print(Country object, Locale locale) {
        return "["+ object.getId() +","+object.getName()+"]";
    }
}

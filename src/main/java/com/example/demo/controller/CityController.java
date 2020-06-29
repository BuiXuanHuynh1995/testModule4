package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.ICityService;
import com.example.demo.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    private ICountryService countryService;

    @Autowired
    private ICityService cityService;

    @ModelAttribute("country")
    public List<Country> findAllCountry() {
        return countryService.findAll();
    }

    @GetMapping("/cities")
    private ModelAndView listCity() {
        ModelAndView modelAndView = new ModelAndView("city/list");
        List<City> cityList = cityService.findAll();
        modelAndView.addObject("cityList", cityList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateCity() {
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView createCity(@ModelAttribute("city") City city, RedirectAttributes redirect) {
        cityService.save(city);
        redirect.addFlashAttribute("message", "create city successfully !");
        return new RedirectView("/cities");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEditCity(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()){
            ModelAndView modelAndView = new ModelAndView("city/edit");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/edit")
    public RedirectView editCity(@ModelAttribute("city") City city, RedirectAttributes redirect){
        cityService.save(city);
        redirect.addFlashAttribute("message", "edit city successfully !");
        return new RedirectView("/cities");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDeleteCity(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()){
            ModelAndView modelAndView = new ModelAndView("city/delete");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/delete")
    public RedirectView deleteCity(@ModelAttribute("city") City city, RedirectAttributes redirect){
        cityService.delete(city.getId());
        redirect.addFlashAttribute("message", "edit city successfully !");
        return new RedirectView("/cities");
    }

    @GetMapping("/views/{id}")
    public ModelAndView showDetailCity(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()){
            ModelAndView modelAndView = new ModelAndView("city/views");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error");
        }
    }

}

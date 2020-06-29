package com.example.demo.model;

import com.fasterxml.jackson.annotation.JacksonInject;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double area;

    private int population;

    private double gdb;

    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "country_id")
    private Country country;

    public City() {
    }

    public City(String name, double area, int population, double gdb, String description, Country country) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdb = gdb;
        this.description = description;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getGdb() {
        return gdb;
    }

    public void setGdb(double gdb) {
        this.gdb = gdb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", country =" + country + "]";
    }

}

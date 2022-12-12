package org.example.hw;

import java.util.Map;
import java.util.stream.Collectors;

public class Exercises {
    private final Cities citiesRepo;

    public Exercises(Cities citiesRepo) {
        this.citiesRepo = citiesRepo;
    }

    public Map<String, Long> getCountryCitiesCount() {
        // Find the number of cities of each country (use grouping)
        var cities = citiesRepo.getAllCities();
        return cities.values().stream()
                .collect(Collectors.groupingBy(City::getCountryCode,
                                Collectors.counting()
                        )
                );
    }

    public City mostPopulatedCity() {
        // Find the most populated city
        return null;
    }

    public City minPopulatedCity() {
        // Find the min populated city
        return null;
    }

    public String mostPopulatedCountry() {
        // Find the most populated city
        return null;
    }

    public String minPopulatedCountry() {
        // Find the most populated city
        return null;
    }

    public Long totalPopulation() {
        // Find the most populated city
        return null;
    }

    public Map<String,Integer> populationOfEachCountry() {
        // Find the most populated city
        return null;
    }

    public Integer populationOfSpecificCountry(String countryCode) {
        // Find the most populated city
        return null;
    }

    public City specificCy(String city) {
        // Find the most populated city
        return null;
    }


}
package com.napier.sem;

import com.napier.sem.Models.City;
import com.napier.sem.Reports.CityReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityIntegrationTest {
    private static App app;
    private static CityReport cityReport;

    @BeforeAll
    static void init() {
        app = new App();

        // Connect to the database
        app.connect("localhost:33060", 30000);
        cityReport = new CityReport(app.getConnection());
    }

    @Test
    void testGetTopPopulatedCities() {
        ArrayList<City> cities = cityReport.getTopPopulatedCities(5);
        // test if return list has correct size
        assertEquals(5, cities.size());

        // test to see if list has correct values
        assertEquals("Mumbai (Bombay)", cities.get(0).name);
        assertEquals(9981619, cities.get(1).population);
        assertEquals("BRA", cities.get(2).countryCode);
    }

    @Test
    void testGetTopPopulatedCitiesByRegion() {
        ArrayList<City> cities = cityReport.getTopPopulatedCitiesByRegion("British Islands",5);
        // test if return list has correct size
        assertEquals(5, cities.size());

        // test to see if list has correct values
        assertEquals("London", cities.get(0).name);
        assertEquals(1013000, cities.get(1).population);
        assertEquals("GBR", cities.get(2).countryCode);
    }
    @Test
    void testGetCitiesByCountry() {
        ArrayList<City> cities = cityReport.getCitiesByCountry("Austria");

        // test to see if list has correct values
        assertEquals("Wien", cities.get(0).name);
        assertEquals(188022, cities.get(2).population);
        assertEquals(240967, cities.get(1).population);
        assertEquals("AUT", cities.get(3).countryCode);

    }
    @Test
    void testGetTopPopulatedCitiesInContinent() {
        ArrayList<City> cities = cityReport.getTopPopulatedCitiesInContinent(5,"South America");

        // test if return list has correct size
        assertEquals(5, cities.size());

        // test to see if list has correct values
        assertEquals("Buenos Aires", cities.get(0).name);
        assertEquals(1157507, cities.get(2).population);
        assertEquals(1266461, cities.get(1).population);
        assertEquals("ARG", cities.get(3).countryCode);

    }
    @Test
    void testGetTopPopulatedCitiesInRegion() {
        ArrayList<City> cities = cityReport.getTopPopulatedCitiesInRegion(5,"Southern Europe");

        // test if return list has correct size
        assertEquals(5, cities.size());

        // test to see if list has correct values
        assertEquals("Madrid", cities.get(0).name);
        assertEquals(2643581, cities.get(2).population);
        assertEquals(1266461, cities.get(1).population);
        assertEquals("ITA", cities.get(3).countryCode);

    }
    @Test
    void testGetTopPopulatedCitiesInCountry() {
        ArrayList<City> cities = cityReport.getTopPopulatedCitiesInCountry(5,"Italy");

        // test if return list has correct size
        assertEquals(5, cities.size());

        // test to see if list has correct values
        assertEquals("Roma", cities.get(0).name);
        assertEquals(1002619, cities.get(2).population);
        assertEquals(1300977, cities.get(1).population);
        assertEquals("ITA", cities.get(3).countryCode);
    }
    
//    @Test
//    void testGetTopNPopulatedCitiesInADistrict() {
//        ArrayList<City> cities = cityReport.getTopNPopulatedCitiesInADistrict(3,"Italy");
//
//        // test if return list has correct size
//        assertEquals(3, cities.size());
//
//        // test to see if list has correct values
//        assertEquals("Roma", cities.get(0).name);
//        assertEquals(1002619, cities.get(2).population);
//        assertEquals(1300977, cities.get(1).population);
//        assertEquals("ITA", cities.get(3).countryCode);
//
//    }
//





}
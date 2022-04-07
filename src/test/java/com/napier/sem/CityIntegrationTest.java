package com.napier.sem;

import com.napier.sem.Models.City;
import com.napier.sem.Reports.CityReport;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityIntegrationTest {
    private static App app;
    private static CityReport cityReport;

    /**
     * Integration test initialisation
     */
    @BeforeAll
    static void init() {
        app = new App();

        // Connect to the database
        app.connect("localhost:33060", 30000);
        cityReport = new CityReport(app.getConnection());
    }

    /**
     * Integration test for the getTopPopulatedCities() method
     */
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

    /**
     * Integration test for the getTopPopulatedCitiesByRegion() method
     */
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

    /**
     * Integration test for the getCitiesByCountry() method
     */
    @Test
    void testGetCitiesByCountry() {
        ArrayList<City> cities = cityReport.getCitiesByCountry("Austria");

        // test to see if list has correct values
        assertEquals("Wien", cities.get(0).name);
        assertEquals(188022, cities.get(2).population);
        assertEquals(240967, cities.get(1).population);
        assertEquals("AUT", cities.get(3).countryCode);

    }

    /**
     * Integration test for the getTopPopulatedCitiesInContinent() method
     */
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

    /**
     * Integration test for the getTopPopulatedCitiesInRegion() method
     */
    @Test
    void testGetTopPopulatedCitiesInRegion() {
        ArrayList<City> cities = cityReport.getTopPopulatedCitiesInRegion(5,"Southern Europe");

        // test if return list has correct size
        assertEquals(5, cities.size());

        // test to see if list has correct values
        assertEquals("Madrid", cities.get(0).name);
        assertEquals(1503451, cities.get(2).population);
        assertEquals(2643581, cities.get(1).population);
        assertEquals("ITA", cities.get(3).countryCode);

    }

    /**
     * Integration test for the getTopPopulatedCitiesInCountry() method
     */
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

    /**
     * Integration test for the getTopNPopulatedCitiesInADistrict() method
     */
    @Test
    void testGetTopNPopulatedCitiesInADistrict() {
        ArrayList<City> cities = cityReport.getTopNPopulatedCitiesInADistrict(3,"Noord-Brabant");

        // test if return list has correct size
        assertEquals(3, cities.size());

        // test to see if list has correct values
        assertEquals("Eindhoven", cities.get(0).name);
        assertEquals(160398, cities.get(2).population);
        assertEquals(193238, cities.get(1).population);
        assertEquals("NLD", cities.get(2).countryCode);
    }

    /**
     * Integration test for the getCitiesInContinent() method
     */
    @Test
    void testGetCitiesInContinent() {
        ArrayList<City> cities = cityReport.getCitiesInContinent("Oceania");

        // test if return list has correct size
        assertEquals(55, cities.size());

        // test to see if list has correct values
        assertEquals("Sydney", cities.get(0).name);
        assertEquals("Victoria", cities.get(1).district);
        assertEquals(3494, cities.get(5).id);
    }

    /**
     * After integration test
     */
    @AfterAll
    static void afterAll() {
        app.disconnect();
    }
}
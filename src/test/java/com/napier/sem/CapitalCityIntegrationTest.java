package com.napier.sem;

import com.napier.sem.Models.City;
import com.napier.sem.Models.Continent;
import com.napier.sem.Reports.CapitalCityReport;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CapitalCityIntegrationTest {
    private static App app;
    private static CapitalCityReport capitalCityReport;

    /**
     * Integration test initialisation
     */
    @BeforeAll
    static void init() {
        app = new App();

        // Connect to database
        app.connect("localhost:33060", 30000);

        capitalCityReport = new CapitalCityReport(app.getConnection());
    }

    /**
     * Integration test for the getTopNPopulatedCapitalCitiesInAContinent() method
     */
    @Test
    void testGetTopNPopulatedCapitalCitiesInAContinent() {
        ArrayList<City> cities = capitalCityReport.getTopNPopulatedCapitalCitiesInAContinent(Continent.Africa, 5);

        // test if return list has correct size
        assertEquals(5, cities.size());

        // test to see if list has correct values
        assertEquals("Cairo", cities.get(0).name);
        assertEquals(2290000, cities.get(3).population);
        assertEquals("Alger", cities.get(4).district);
    }

    /**
     * Integration test for the getTopNPopulatedCapitalCitiesInTheWorldFromLargeToSmall() method
     */
    @Test
    void testGetTopNPopulatedCapitalCitiesInTheWorldFromLargeToSmall() {
        ArrayList<City> cities = capitalCityReport.getTopNPopulatedCapitalCitiesInTheWorldFromLargeToSmall(3);

        // test if return list has correct size
        assertEquals(3, cities.size());

        // test to see if list has correct values
        assertEquals("Seoul", cities.get(0).name);
        assertEquals(9604900, cities.get(1).population);
        assertEquals("Distrito Federal", cities.get(2).district);
    }

    /**
     * Integration test for the getTopNPopulatedCapitalCitiesInAContinentFromLargestToSmallest() method
     */
    @Test
    void testGetTopNPopulatedCapitalCitiesInAContinentFromLargestToSmallest() {
        ArrayList<City> cities = capitalCityReport.getTopNPopulatedCapitalCitiesInAContinentFromLargestToSmallest(Continent.Europe, 4);

        // test if return list has correct size
        assertEquals(4, cities.size());

        // test to see if list has correct values
        assertEquals("Moscow", cities.get(0).name);
        assertEquals(7285000, cities.get(1).population);
        assertEquals("Berliini", cities.get(2).district);
        assertEquals("Madrid", cities.get(3).name);
    }

    /**
     * Integration test for the getTopPopulatedCapitalCities() method
     */
    @Test
    void testGetTopPopulatedCapitalCities() {
        ArrayList<City> cities = capitalCityReport.getTopPopulatedCapitalCities(5);

        // test if return list has correct size
        assertEquals(5, cities.size());

        // test to see if list has correct values
        assertEquals("Seoul", cities.get(0).name);
        assertEquals(9604900, cities.get(1).population);
        assertEquals("Distrito Federal", cities.get(2).district);
        assertEquals("Moscow", cities.get(3).name);
        assertEquals(7980230, cities.get(4).population);
    }

    /**
     * Integration test for the getTopPopulatedCapitalCitiesForRegion() method
     */
    @Test
    void testGetTopPopulatedCapitalCitiesForRegion() {
        ArrayList<City> cities = capitalCityReport.getTopPopulatedCapitalCitiesForRegion("Southern Europe", 3);
        ArrayList<City> cities2 = capitalCityReport.getTopPopulatedCapitalCitiesForRegion("Southern Europe", 0);

        // test if return list has correct size
        assertEquals(3, cities.size());

        // test to see if list has correct values
        assertEquals("Madrid", cities.get(0).name);
        assertEquals("Madrid", cities2.get(0).name);
        assertEquals(2643581, cities.get(1).population);
        assertEquals("Central Serbia", cities.get(2).district);
    }

    /**
     * After integration test
     */
    @AfterAll
    static void afterAll() {
        app.disconnect();
    }
}


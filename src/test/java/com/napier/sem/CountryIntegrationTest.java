package com.napier.sem;

import com.napier.sem.Models.Country;
import com.napier.sem.Reports.CapitalCityReport;
import com.napier.sem.Reports.CountryReport;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryIntegrationTest {
    private static App app;
    private static CountryReport countryReport;

    /**
     * Integration test initialisation
     */
    @BeforeAll
    static void init() {
        app = new App();

        // Connect to database
        app.connect("localhost:33060", 30000);

        countryReport = new CountryReport(app.getConnection());
    }

    /**
     * Integration test for the getTopPopulatedCountries() method
     */
    @Test
    void testGetTopPopulatedCountries(){
        ArrayList<Country> countries = countryReport.getTopPopulatedCountries(4);

        // test if return list has correct size
        assertEquals(4, countries.size());

        // test to see if list has correct values
        assertEquals("China", countries.get(0).name);
        assertEquals(1013662000, countries.get(1).population);
        assertEquals("North America", countries.get(2).region);
        assertEquals("Indonesia", countries.get(3).name);
    }

    /**
     * Integration test for the getTopPopulatedCountriesInARegion() method
     */
    @Test
    void testGetTopPopulatedCountriesInARegion(){
        ArrayList<Country> countries = countryReport.getTopPopulatedCountriesInARegion("Central America", 3);

        // test if return list has correct size
        assertEquals(3, countries.size());

        // test to see if list has correct values
        assertEquals("Mexico", countries.get(0).name);
        assertEquals(11385000, countries.get(1).population);
        assertEquals("Honduras", countries.get(2).name);
        assertEquals("Central America", countries.get(2).region);
    }

    /**
     * After integration test
     */
    @AfterAll
    static void afterAll() {
        app.disconnect();
    }
}
package com.napier.sem;

import com.napier.sem.Reports.CountryReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class CountryUnitTest {
    private static CountryReport countryReport;

    /**
     * Unit test initialisation
     */
    @BeforeAll
    static void init() {
        countryReport = new CountryReport(null);
    }

    /**
     * Unit test for getTopPopulatedCountries() method
     */
    @Test
    void testGetTopPopulatedCountries(){
        assertNull(countryReport.getTopPopulatedCountries(0));
    }

    /**
     * Unit test for getTopPopulatedCountriesInARegion(String region, int n) method
     */
    @Test
    void testGetTopPopulatedCountriesInARegion(){ assertNull(countryReport.getTopPopulatedCountriesInARegion(null, 0)); }

    /**
     * Unit test for getTopPopulatedCountriesInAContinent(String continent, int n) method
     */
    @Test
    void testGetTopPopulatedCountriesInAContinent(){ assertNull(countryReport.getTopPopulatedCountriesInAContinent(null, 0)); }
}

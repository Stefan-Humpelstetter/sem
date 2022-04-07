package com.napier.sem;

import com.napier.sem.Reports.CapitalCityReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CapitalCityUnitTest {

    private static CapitalCityReport capitalCityReport;

    /**
     * Unit test initialisation
     */
    @BeforeAll
    static void init()
    {
        capitalCityReport = new CapitalCityReport(null);
    }

    /**
     * Unit test for getTopNPopulatedCapitalCitiesInAContinent() method
     */
    @Test
    void testGetTopNPopulatedCapitalCitiesInAContinent() {
        capitalCityReport.getTopNPopulatedCapitalCitiesInAContinent(null,0);
    }

    /**
     * Unit test for getTopNPopulatedCapitalCitiesInTheWorldFromLargeToSmall() method
     */
    @Test
    void testGetTopNPopulatedCapitalCitiesInTheWorldFromLargeToSmall() {
        capitalCityReport.getTopNPopulatedCapitalCitiesInTheWorldFromLargeToSmall(-1);
    }

    /**
     * Unit test for getTopNPopulatedCapitalCitiesInAContinentFromLargestToSmallest() method
     */
    @Test
    void testGetTopNPopulatedCapitalCitiesInAContinentFromLargestToSmallest() {
        capitalCityReport.getTopNPopulatedCapitalCitiesInAContinentFromLargestToSmallest(null,0);
    }

    /**
     * Unit test for getTopPopulatedCapitalCities() method
     */
    @Test
    void testGetTopPopulatedCapitalCities() {
        capitalCityReport.getTopPopulatedCapitalCities(-1);
    }

    /**
     * Unit test for getTopPopulatedCapitalCitiesForRegion() method
     */
    @Test
    void testGetTopPopulatedCapitalCitiesForRegion() {
        capitalCityReport.getTopPopulatedCapitalCitiesForRegion(null,-1);
    }
}

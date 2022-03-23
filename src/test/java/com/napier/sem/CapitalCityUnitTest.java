package com.napier.sem;

import com.napier.sem.Reports.CapitalCityReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CapitalCityUnitTest {

    private static CapitalCityReport capitalCityReport;

    @BeforeAll
    static void init()
    {
        capitalCityReport = new CapitalCityReport(null);
    }

    @Test
    void testGetTopNPopulatedCapitalCitiesInAContinent() {
        capitalCityReport.getTopNPopulatedCapitalCitiesInAContinent(null,0);
    }

    @Test
    void testGetTopNPopulatedCapitalCitiesInTheWorldFromLargeToSmall() {
        capitalCityReport.getTopNPopulatedCapitalCitiesInTheWorldFromLargeToSmall(-1);
    }

    @Test
    void testGetTopNPopulatedCapitalCitiesInAContinentFromLargestToSmallest() {
        capitalCityReport.getTopNPopulatedCapitalCitiesInAContinentFromLargestToSmallest(null,0);
    }

    @Test
    void testGetTopPopulatedCapitalCities() {
        capitalCityReport.getTopPopulatedCapitalCities(-1);
    }

    @Test
    void testGetTopPopulatedCapitalCitiesForRegion() {
        capitalCityReport.getTopPopulatedCapitalCitiesForRegion(null,-1);
    }
}

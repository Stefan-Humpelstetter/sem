package com.napier.sem;

import com.napier.sem.Reports.CityReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CityUnitTest {
    private static CityReport cityReport;

    /**
     * Unit test initialisation
     */
    @BeforeAll
    static void init()
    {
        cityReport = new CityReport(null);
    }

    /**
     * Unit test for getTopPopulatedCities() method
     */
    @Test
    void testGetTopPopulatedCities() {
        cityReport.getTopPopulatedCities(0);
    }

    /**
     * Unit test for getTopPopulatedCitiesByRegion() method
     */
    @Test
    void testGetTopPopulatedCitiesByRegion() {
        cityReport.getTopPopulatedCitiesByRegion(null,0);
    }

    /**
     * Unit test for getCitiesByCountry() method
     */
    @Test
    void testGetCitiesByCountry() {
        cityReport.getCitiesByCountry(null);
    }

    /**
     * Unit test for getTopPopulatedCitiesInRegion() method
     */
    @Test
    void testGetTopPopulatedCitiesInRegion() {
        cityReport.getTopPopulatedCitiesInRegion(0,null);
    }

    /**
     * Unit test for getTopPopulatedCitiesInCountry() method
     */
    @Test
    void testGetTopPopulatedCitiesInCountry() {
        cityReport.getTopPopulatedCitiesInCountry(-1,null);
    }

    /**
     * Unit test for getTopNPopulatedCitiesInADistrict() method
     */
    @Test
    void testGetTopNPopulatedCitiesInADistrict() {
        cityReport.getTopNPopulatedCitiesInADistrict(0,null);
    }

    @Test
    void testGetTopNPopulatedCitiesInAContinent() {
        cityReport.getTopPopulatedCitiesInContinent(0, null);
    }

}

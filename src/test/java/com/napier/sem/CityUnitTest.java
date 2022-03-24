package com.napier.sem;

import com.napier.sem.Reports.CapitalCityReport;
import com.napier.sem.Reports.CityReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CityUnitTest {
    private static CityReport cityReport;

    @BeforeAll
    static void init()
    {
        cityReport = new CityReport(null);
    }

    @Test
    void testGetTopPopulatedCities() {
        cityReport.getTopPopulatedCities(0);
    }

    @Test
    void testGetTopPopulatedCitiesByRegion() {
        cityReport.getTopPopulatedCitiesByRegion(null,0);
    }

    @Test
    void testGetCitiesByCountry() {
        cityReport.getCitiesByCountry(null);
    }

    @Test
    void testGetTopPopulatedCitiesInRegion() {
        cityReport.getTopPopulatedCitiesInRegion(0,null);
    }

    @Test
    void testGetTopPopulatedCitiesInCountry() {
        cityReport.getTopPopulatedCitiesInCountry(-1,null);
    }
//    @Test
//    void testGetTopNPopulatedCitiesInADistrict() {
//        cityReport.getTopNPopulatedCitiesInADistrict(0,null);
//    }

}

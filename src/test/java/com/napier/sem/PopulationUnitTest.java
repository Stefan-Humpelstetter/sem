package com.napier.sem;

import com.napier.sem.Models.Continent;
import com.napier.sem.Reports.PopulationReport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PopulationUnitTest {
    private static PopulationReport populationReport;

    @BeforeAll
    static void init()
    {
        populationReport = new PopulationReport(null);
    }

    @Test
    void testWorldPopulation()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertEquals(0,populationReport.getWorldPopulation());
    }

    @Test
    void testContientPopulation()
    {
        // Test if program does not crash when there is no connection
        Assertions.assertEquals(0,populationReport.getPopulationOfContinent(Continent.North_America));
    }

    @Test
    void testDistrictPopulation()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertEquals(0,populationReport.getDistrictTotalPopulation("Kabol"));
    }

    @Test
    void testCountryPopulation()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertEquals(0, populationReport.getTotalPopulationCountry("Italy"));
    }

    @Test
    void testCityPopulation()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertEquals(0,populationReport.getPopulationOfCity("Edinburgh"));
    }

    @Test
    void testRegionPopulation()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertEquals(0,populationReport.getPopulationOfRegion("Caribbean"));
    }

    @Test
    void testPopulationByContinent()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->populationReport.printPopulationReportForPeopleLivingInCitiesByContinent(Continent.Europe).get(0));
    }

    @Test
    void testPopulationByRegion()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> populationReport.getPopulationOfPeopleLivingInAndOutACityByRegion("Caribbean").get(0));
    }

    @Test
    void testPopulationByCountry()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->populationReport.getPopulationOfPeopleLivingInAndOutACityByCountry("Bulgaria").get(0));
    }
}
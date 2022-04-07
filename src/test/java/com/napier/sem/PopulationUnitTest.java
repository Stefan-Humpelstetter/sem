package com.napier.sem;

import com.napier.sem.Models.Continent;
import com.napier.sem.Reports.PopulationReport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PopulationUnitTest {
    private static PopulationReport populationReport;

    /**
     * Unit test initialisation
     */
    @BeforeAll
    static void init()
    {
        populationReport = new PopulationReport(null);
    }

    /**
     * Unit test for getWorldPopulation() method
     */
    @Test
    void testWorldPopulation()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertEquals(0,populationReport.getWorldPopulation());
    }

    /**
     * Unit test for getPopulationOfContinent() method
     */
    @Test
    void testContinentPopulation()
    {
        // Test if program does not crash when there is no connection
        Assertions.assertEquals(0,populationReport.getPopulationOfContinent(Continent.North_America));
    }

    /**
     * Unit test for getDistrictTotalPopulation() method
     */
    @Test
    void testDistrictPopulation()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertEquals(0,populationReport.getDistrictTotalPopulation("Kabol"));
    }

    /**
     * Unit test for getTotalPopulationCountry() method
     */
    @Test
    void testCountryPopulation()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertEquals(0, populationReport.getTotalPopulationCountry("Italy"));
    }

    /**
     * Unit test for getPopulationOfCity() method
     */
    @Test
    void testCityPopulation()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertEquals(0,populationReport.getPopulationOfCity("Edinburgh"));
    }

    /**
     * Unit test for getPopulationOfRegion() method
     */
    @Test
    void testRegionPopulation()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertEquals(0,populationReport.getPopulationOfRegion("Caribbean"));
    }

    /**
     * Unit test for printPopulationReportForPeopleLivingInCitiesByContinent() method
     */
    @Test
    void testPopulationByContinent()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->populationReport.printPopulationReportForPeopleLivingInCitiesByContinent(Continent.Europe).get(0));
    }

    /**
     * Unit test for getPopulationOfPeopleLivingInAndOutACityByRegion() method
     */
    @Test
    void testPopulationByRegion()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> populationReport.getPopulationOfPeopleLivingInAndOutACityByRegion("Caribbean").get(0));
    }

    /**
     * Unit test for getPopulationOfPeopleLivingInAndOutACityByCountry() method
     */
    @Test
    void testPopulationByCountry()
    {
        //Test if program does not crash when there is no connection
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->populationReport.getPopulationOfPeopleLivingInAndOutACityByCountry("Bulgaria").get(0));
    }
}
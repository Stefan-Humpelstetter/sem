package com.napier.sem;

import com.napier.sem.Models.Continent;
import com.napier.sem.Reports.PopulationReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PopulationTest {
    private static PopulationReport populationReport;
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
        populationReport = new PopulationReport(app.getConnection());
    }

    @Test
    void testWorldPopulation()
    {
        // Test World Population
        assertEquals(6078749450L, populationReport.getWorldPopulation());
    }

    @Test
    void testContientPopulation()
    {
        // Test population of North America
        assertEquals(482993000, populationReport.getPopulationOfContinent(Continent.North_America));
    }

    @Test
    void testDistrictPopulation()
    {
        // Test total district population
        assertEquals(1780000, populationReport.getDistrictTotalPopulation("Kabol"));
    }

    @Test
    void testCountryPopulation()
    {
        // Test total country population
        assertEquals(57680000, populationReport.getTotalPopulationCountry("Italy"));
    }

    @Test
    void testCityPopulation()
    {
        // Test total city population
        assertEquals(450180,populationReport.getPopulationOfCity("Edinburgh") );
    }

    @Test
    void testRegionPopulation()
    {
        // Test total region population
        assertEquals(38140000, populationReport.getPopulationOfRegion("Caribbean"));
    }

    @Test
    void testPopulationByContinent()
    {
        int value = populationReport.printPopulationReportForPeopleLivingInCitiesByContinent(Continent.Europe).get(0);
        // Test total region population
        assertEquals(730074600, value);
    }

    @Test
    void testPopulationInCityByContinent()
    {
        int value = populationReport.printPopulationReportForPeopleLivingInCitiesByContinent(Continent.Europe).get(1);
        // Test total region population
        assertEquals(241942813, value);
    }

    @Test
    void testPopulationOutCityByContinent()
    {
        int value = populationReport.printPopulationReportForPeopleLivingInCitiesByContinent(Continent.Europe).get(2);
        // Test total region population
        assertEquals(488131787, value);
    }

    @Test
    void testPopulationByRegion()
    {
        int value = populationReport.getPopulationOfPeopleLivingInAndOutACityByRegion("Caribbean").get(0);
        // Test total region population
        assertEquals(288771000, value);
    }

    @Test
    void testPopulationInCityByRegion()
    {
        // Test total region population of people living inside city
        int value = populationReport.getPopulationOfPeopleLivingInAndOutACityByRegion("Caribbean").get(1);
        assertEquals(11067550, value);
    }

    @Test
    void testPopulationOutCityByRegion()
    {
        // Test total region population of people living outside city
        int value = populationReport.getPopulationOfPeopleLivingInAndOutACityByRegion("Caribbean").get(2);
        assertEquals(277703450, value);
    }

    @Test
    void testPopulationByCountry()
    {
         // Test total country population
        int value = populationReport.getPopulationOfPeopleLivingInAndOutACityByCountry("Bulgaria").get(0);
        assertEquals(8190900, value);
    }

    @Test
    void testPopulationInCityByCountry()
    {
         // Test total country population of people living inside city
        int value = populationReport.getPopulationOfPeopleLivingInAndOutACityByCountry("Bulgaria").get(1);

        assertEquals(2696915, value);
    }

    @Test
    void testPopulationOutCityByCountry()
    {
        // Test total country population of people living outside city
        int value = populationReport.getPopulationOfPeopleLivingInAndOutACityByCountry("Bulgaria").get(2);

        assertEquals(5493985, value);
    }

}
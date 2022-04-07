package com.napier.sem;

import com.napier.sem.Models.Continent;
import com.napier.sem.Reports.PopulationReport;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PopulationIntegrationTest {
    private static PopulationReport populationReport;
    static App app;

    /**
     * Integration test initialisation
     */
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
        populationReport = new PopulationReport(app.getConnection());
    }

    /**
     * Integration test for the getWorldPopulation() method
     */
    @Test
    void testWorldPopulation()
    {
        // Test World Population
        assertEquals(6078749450L, populationReport.getWorldPopulation());
    }

    /**
     * Integration test for the getPopulationOfContinent() method
     */
    @Test
    void testContinentPopulation()
    {
        // Test population of North America
        assertEquals(482993000, populationReport.getPopulationOfContinent(Continent.North_America));
    }

    /**
     * Integration test for the getDistrictTotalPopulation() method
     */
    @Test
    void testDistrictPopulation()
    {
        // Test total district population
        assertEquals(1780000, populationReport.getDistrictTotalPopulation("Kabol"));
    }

    /**
     * Integration test for the getTotalPopulationCountry() method
     */
    @Test
    void testCountryPopulation()
    {
        // Test total country population
        assertEquals(57680000, populationReport.getTotalPopulationCountry("Italy"));
    }

    /**
     * Integration test for the getPopulationOfCity() method
     */
    @Test
    void testCityPopulation()
    {
        // Test total city population
        assertEquals(450180,populationReport.getPopulationOfCity("Edinburgh") );
    }

    /**
     * Integration test for the getPopulationOfRegion() method
     */
    @Test
    void testRegionPopulation()
    {
        // Test total region population
        assertEquals(38140000, populationReport.getPopulationOfRegion("Caribbean"));
    }

    /**
     * Integration test for the printPopulationReportForPeopleLivingInCitiesByContinent() method
     */
    @Test
    void testPopulationByContinent()
    {
        // Test total continent population
        int value = populationReport.printPopulationReportForPeopleLivingInCitiesByContinent(Continent.Europe).get(0);
        assertEquals(730074600, value);
    }

    /**
     * Integration test for the printPopulationReportForPeopleLivingInCitiesByContinent() method
     */
    @Test
    void testPopulationInCityByContinent()
    {
        // Test total continent population of people living inside city
        int value = populationReport.printPopulationReportForPeopleLivingInCitiesByContinent(Continent.Europe).get(1);
        assertEquals(241942813, value);
    }

    /**
     * Integration test for the printPopulationReportForPeopleLivingInCitiesByContinent() method
     */
    @Test
    void testPopulationOutCityByContinent()
    {
        // Test total continent population of people living outside city
        int value = populationReport.printPopulationReportForPeopleLivingInCitiesByContinent(Continent.Europe).get(2);
        assertEquals(488131787, value);
    }

    /**
     * Integration test for the getPopulationOfPeopleLivingInAndOutACityByRegion() method
     */
    @Test
    void testPopulationByRegion()
    {
        // Test total region population
        int value = populationReport.getPopulationOfPeopleLivingInAndOutACityByRegion("Caribbean").get(0);
        assertEquals(288771000, value);
    }

    /**
     * Integration test for the getPopulationOfPeopleLivingInAndOutACityByRegion() method
     */
    @Test
    void testPopulationInCityByRegion()
    {
        // Test total region population of people living inside city
        int value = populationReport.getPopulationOfPeopleLivingInAndOutACityByRegion("Caribbean").get(1);
        assertEquals(11067550, value);
    }

    /**
     * Integration test for the getPopulationOfPeopleLivingInAndOutACityByRegion() method
     */
    @Test
    void testPopulationOutCityByRegion()
    {
        // Test total region population of people living outside city
        int value = populationReport.getPopulationOfPeopleLivingInAndOutACityByRegion("Caribbean").get(2);
        assertEquals(277703450, value);
    }

    /**
     * Integration test for the getPopulationOfPeopleLivingInAndOutACityByCountry() method
     */
    @Test
    void testPopulationByCountry()
    {
         // Test total country population
        int value = populationReport.getPopulationOfPeopleLivingInAndOutACityByCountry("Bulgaria").get(0);
        assertEquals(8190900, value);
    }

    /**
     * Integration test for the getPopulationOfPeopleLivingInAndOutACityByCountry() method
     */
    @Test
    void testPopulationInCityByCountry()
    {
         // Test total country population of people living inside city
        int value = populationReport.getPopulationOfPeopleLivingInAndOutACityByCountry("Bulgaria").get(1);

        assertEquals(2696915, value);
    }

    /**
     * Integration test for the getPopulationOfPeopleLivingInAndOutACityByCountry() method
     */
    @Test
    void testPopulationOutCityByCountry()
    {
        // Test total country population of people living outside city
        int value = populationReport.getPopulationOfPeopleLivingInAndOutACityByCountry("Bulgaria").get(2);

        assertEquals(5493985, value);
    }

    /**
     * After integration test
     */
    @AfterAll
    static void afterAll() {
        app.disconnect();
    }
}
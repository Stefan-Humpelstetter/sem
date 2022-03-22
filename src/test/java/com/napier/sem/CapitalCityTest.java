package com.napier.sem;

import com.napier.sem.Models.City;
import com.napier.sem.Models.Continent;
import com.napier.sem.Reports.CapitalCityReport;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CapitalCityTest {
    private static App app;
    private static CapitalCityReport capitalCityReport;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect();
        capitalCityReport = new CapitalCityReport(app.getConnection());
    }

    @Test
    void testGetTopNPopulatedCapitalCitiesInAContinent()
    {
        ArrayList<City> cities = capitalCityReport.getTopNPopulatedCapitalCitiesInAContinent(Continent.Africa,5);

        // test if return list has correct size
        assertEquals(5,cities.size());
    }

    @AfterAll
    static void afterAll() {
        app.disconnect();
    }
}


package com.napier.sem;

import com.napier.sem.Models.Continent;
import com.napier.sem.Reports.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * entry point of the program
     *
     * @param args input arguments
     */
    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Create report
        CountryReport countryReport = new CountryReport(a.con);
        CapitalCityReport capitalCityReport = new CapitalCityReport(a.con);
        PopulationReport populationReport = new PopulationReport(a.con);
        CityReport cityReport = new CityReport(a.con);
        LanguageReport languageReport = new LanguageReport(a.con);

        System.out.println("--- Capital City Reports ---");

        // Print top n populated capital cities
        capitalCityReport.getTopPopulatedCapitalCities(3);

        // Print n most populated capital cities of region 'Eastern Africa'
        capitalCityReport.getTopPopulatedCapitalCities("Eastern Africa", 5);

        // Print the top N populated capital cities in a given continent
        capitalCityReport.getTopNPopulatedCapitalCitiesInAContinent(Continent.Oceania, 4);

        // Print report for people living in cities for continent 'Europe'
        populationReport.printPopulationReportForPeopleLivingInCitiesByContinent(Continent.Europe);

        // Print population of North America
        populationReport.getPopulationOfContinent(Continent.North_America);

        // Print total population of a district
        populationReport.getDistrictTotalPopulation("Kabol");

        // Print total country population
        populationReport.getTotalPopulationCountry("Italy");

        // Print population of City based on the cityName(String)
        populationReport.getPopulationOfCity("Edinburgh");

        // Print population of the world based on sum population of all the countries
        populationReport.getWorldPopulation();

        // Print sum population of the region based on the regionName(String)
        populationReport.getPopulationOfRegion("Caribbean");

        // Print the population of people living in a city and outside of a city by region
        populationReport.getPopulationOfPeopleLivingInAndOutACityByRegion("Caribbean");

        // Print the population of people living in a city and outside of a city by country
        populationReport.getPopulationOfPeopleLivingInAndOutACityByCountry("Bulgaria");
        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "world");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Returns connection
     * @return connection
     */
    public Connection getConnection() {
        return con;
    }
}
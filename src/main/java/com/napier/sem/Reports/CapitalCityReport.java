package com.napier.sem.Reports;

import com.napier.sem.Models.City;
import com.napier.sem.Models.Continent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * this class contains methods to create reports for capital cities
 */
public class CapitalCityReport extends AReport {

    /**
     * constructor needs connection to the database
     * @param connection to the database
     */
    public CapitalCityReport(Connection connection) {
        super(connection);
    }

    /**
     * Prints the n top populated capital cities
     * @param n
     */
    public void getTopPopulatedCapitalCities (int n){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT * "
                            + "FROM city JOIN country ON city.CountryCode = country.Code "
                            + "WHERE city.ID IN (SELECT Capital FROM country) "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + n;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract capital city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                cities.add(new City(rset));
            }

            // Print data
            System.out.println("\nTop " + n + " populated capitals:");
            for (City city : cities){
                System.out.println(city.toString(true));
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities population information");
        }
    }

    /**
     * Prints the n biggest cities in the given region
     * @param region the name of a region
     * @param n number of cities to be returned
     */
    public void getTopPopulatedCapitalCities(String region, int n) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT * " +
                            "FROM city JOIN country ON city.CountryCode = country.Code " +
                            "WHERE  city.ID IN (SELECT Capital FROM country) " +
                            "AND country.Region = '" + region + "' " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT " + n;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract capital city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
                cities.add(new City(rset));

            // Print data
            System.out.println("\n" + n + " most populated capital cities of the region " + region + "'Eastern Africa'");
            for (City city : cities){
                System.out.println(city.toString(true));
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities population information");
        }
    }
    /**
     * Prints the n top populated capital cities in the given continent
     * @param continent the name of the continent
     * @param n number of top populated capital cities to be returned
     */
    public void getTopNPopulatedCapitalCitiesInAContinent( Continent continent, int n) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT *" +
                            "FROM city JOIN country ON city.CountryCode = country.Code " +
                            "WHERE  city.ID IN (SELECT Capital FROM country) " +
                            "AND country.Continent= '"+continent.toString()+"' " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT " + n;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract capital city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
                cities.add(new City(rset));

            // Print data
            System.out.println("\n" + n + " most populated capital cities in countries in " + continent.toString() + ":");
            for (City city : cities){
                System.out.println(city.toString(true));
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities population information");
        }
    }
}

package com.napier.sem.Reports;

import com.napier.sem.Models.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * this class contains methods to create reports for cities
 */
public class CityReport extends AReport {

    /**
     * constructor needs connection to the database
     * @param connection to the database
     */
    public CityReport(Connection connection) {
        super(connection);
    }

    /**
     * Returns the n top populated capital cities
     * @param n
     * @return cities
     */
    public ArrayList<String> getTopPopulatedCapitalCities (int n){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name "
                            + "FROM city JOIN country ON city.CountryCode = country.Code "
                            + "WHERE city.ID IN (SELECT Capital FROM country) "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + n;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<String> cities = new ArrayList<String>();
            while (rset.next())
            {
                String name = rset.getString("city.Name");
                cities.add(name);
            }

            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    /**
     * Queries for n biggest cities in the given region
     * @param region
     * @param n states how many cities should be returned
     * @return list of n cities with the most population in the given region
     */
    public ArrayList<String> getTopPopulatedCapitalCities(String region, int n) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name " +
                            "FROM city JOIN country ON city.CountryCode = country.Code " +
                            "WHERE  city.ID IN (SELECT Capital FROM country) " +
                            "AND country.region = '" + region + "' " +
                            "ORDER BY city.population DESC " +
                            "LIMIT " + n;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            //ArrayList<City> cities = new ArrayList<City>();
            ArrayList<String> cities = new ArrayList<String>();

            while (rset.next())
                cities.add(rset.getString("city.Name"));


            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
}

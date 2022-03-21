package com.napier.sem.Reports;

import com.napier.sem.Models.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CityReport extends AReport {
    /**
     * constructor needs connection to the database
     * @param connection to the database
     */
    public CityReport(Connection connection) {
        super(connection);
    }

    /**
     * Prints the n biggest cities in the given region
     * @param n number of cities to be returned, when n = 0, all cities of region are returned
     * @return list of n biggest cities in the given region
     */
    public ArrayList<City> getTopPopulatedCities(int n) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT * " +
                            "FROM city JOIN country ON city.CountryCode = country.Code " +
                            "ORDER BY city.Population DESC " +
                            (n > 0? "LIMIT " + n: "");

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
                cities.add(new City(rset));

            // Print data
            System.out.println("\n" + (n > 0? n : "All") + " most populated cities in the world: ");
            for (City city : cities){
                System.out.println(city.toString(true));
            };

            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities population information");
        }
        return null;
    }

    public ArrayList<City> getTopPopulatedCities(String region, int n) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT * " +
                            "FROM city JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Region = '" + region + "' " +
                            "ORDER BY city.Population DESC " +
                            (n > 0? "LIMIT " + n: "");

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
                cities.add(new City(rset));

            // Print data
            System.out.println("\n" + (n > 0? n : "All") + " most populated cities of the region " + region);
            for (City city : cities){
                System.out.println(city.toString(true));
            };

            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities population information");
        }
        return null;
    }



}

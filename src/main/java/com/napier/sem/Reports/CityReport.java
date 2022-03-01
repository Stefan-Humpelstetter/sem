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

    public ArrayList<String> getTopPopulatedCapitalCities(String n) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code"
                            + "WHERE city.ID = country.Capital "
                            + "ORDER BY city.Population"
                            + "LIMIT " + n + " ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            //ArrayList<City> cities = new ArrayList<City>();
            ArrayList<String> cities = new ArrayList<String>();
            while (rset.next()) {
                //City city = new City(rset);
                //city.id = rset.getInt("ID");
                String name = rset.getString("city.Name");
                //city.countryCode = rset.getString("CountryCode");
                //city.district = rset.getString("District");
                //city.population = rset.getInt("Population");
                cities.add(name);
            }

            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }


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

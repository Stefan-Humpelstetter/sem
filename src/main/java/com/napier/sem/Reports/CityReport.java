package com.napier.sem.Reports;

import com.napier.sem.Models.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CityReport extends AReport {
    /**
     * constructor needs connection to the database
     *
     * @param connection to the database
     */
    public CityReport(Connection connection) {
        super(connection);
    }

    /**
     * Prints the n biggest cities of the world
     * @param n number of cities to be returned, when n = 0, all cities are returned
     * @return list of n biggest cities in the world
     */
    public ArrayList<City> getTopPopulatedCities(int n) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT * FROM city ORDER BY city.Population DESC " + (n > 0 ? "LIMIT " + n : "");

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();

            // Print data
            System.out.println("\n" + (n > 0 ? n + " most" : "All") + " populated cities in the world: ");
            while (rset.next()) {
                City city = new City(rset);
                cities.add(city);
                System.out.println(city.toString(false));
            }

            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities information");
        }
        return null;
    }

    /**
     * Prints the n biggest cities in the given region
     * @param region the region the report should be created for
     * @param n      number of cities to be returned, when n = 0, all cities of region are returned
     * @return list of the n biggest cities in the given region
     */
    public ArrayList<City> getTopPopulatedCitiesByRegion(String region, int n) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT * " +
                            "FROM city JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Region = '" + region + "' " +
                            "ORDER BY city.Population DESC " +
                            (n > 0 ? "LIMIT " + n : "");

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
                cities.add(new City(rset));

            // Print data
            System.out.println("\n" + (n > 0 ? n + " most" : "All") + " populated cities of the region " + region);
            for (City city : cities) {
                System.out.println(city.toString(false));
            }

            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities population information");
        }
        return null;
    }

    /**
     * Generate report for all the cities of a country ordered by population
     * @param countryName the name of the country the report should be made for
     * @return list of the cities of the report
     */
    public ArrayList<City> getCitiesByCountry(String countryName) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT c.* FROM city c JOIN country ON country.code = c.CountryCode " +
                    "WHERE country.name='Austria' ORDER BY c.population DESC;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Create list to store the city information
            ArrayList<City> cities = new ArrayList<City>();

            // Print data
            System.out.println("\nCities of " + countryName + ":");
            while (rset.next()) {
                City city = new City(rset);
                System.out.println(city.toString(false));
                cities.add(city);
            }

            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities information");
        }
        return null;
    }

    /**
     * Prints top N populated cities in a specific continent
     *
     * @param n         number of cities to be returned
     * @param continent the continent to analyse
     * @return list of the cities of the report
     */
    public ArrayList<City> getTopPopulatedCitiesInContinent(int n, String continent) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT * FROM city WHERE city.CountryCode = (SELECT country.Code FROM country WHERE country.Continent = '" + continent + "' LIMIT 1) ORDER BY city.Population DESC LIMIT " + n + ";";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();

            // Print data
            System.out.println("\n" + n + " most populated cities in " + continent + ": ");
            while (rset.next()) {
                City city = new City(rset);
                cities.add(city);
                System.out.println(city.toString(false));
            }

            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities information");
        }
        return null;
    }

    /**
     * Prints top N populated cities in a specific region
     *
     * @param n      number of cities to be returned
     * @param region the region to analyse
     * @return list of the cities of the report
     */
    public ArrayList<City> getTopPopulatedCitiesInRegion(int n, String region) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT * FROM city WHERE city.CountryCode IN (SELECT country.Code FROM country WHERE region = '" + region + "') ORDER BY city.Population DESC LIMIT " + n + ";";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();

            // Print data
            System.out.println("\n" + n + " most populated cities in " + region + ": ");
            while (rset.next()) {
                City city = new City(rset);
                cities.add(city);
                System.out.println(city.toString(false));
            }

            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities information");
        }
        return null;
    }

    /**
     * Prints top N populated cities in a specific country
     *
     * @param n       number of cities to be returned
     * @param country the region to analyse
     * @return list of the cities of the report
     */
    public ArrayList<City> getTopPopulatedCitiesInCountry(int n, String country) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT * FROM city WHERE city.CountryCode = (SELECT country.Code FROM country WHERE country.Name = '" + country + "') ORDER BY city.Population DESC "+(n > 0 ? "LIMIT " + n : "");

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();

            // Print data
            System.out.println("\n" + (n > 0 ? n + " most" : "All") + " most populated cities in " + country + ": ");
            while (rset.next()) {
                City city = new City(rset);
                cities.add(city);
                System.out.println(city.toString(false));
            }

            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities information");
        }
        return null;
    }

    /**
     * Prints top N populated cities in a specific district
     *
     * @param n        number of cities to be returned
     * @param district the district to analyse
     * @return list of the  top n populated cities in given district
     */
    public ArrayList<City> getTopNPopulatedCitiesInADistrict(int n, String district) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT * " +
                    "FROM city " +
                    "WHERE District ='" + district +"' "+
                    "ORDER BY population DESC " + (n > 0 ? "LIMIT " + n : "");

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();

            // Print data
            System.out.println("\n" + (n > 0 ? n + " most" : "All") + " populated cities in the " + district + " district: ");
            while (rset.next()) {
                City city = new City(rset);
                cities.add(city);
                System.out.println(city.toString(false));
            }

            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities information");
        }
        return null;
    }

    /**
     * Prints cities in a continent sorted by population descending
     * @param continent the continent to analyse
     * @return list of cities in a continent
     */
    public ArrayList<City> getCitiesInContinent(String continent) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT * FROM city WHERE city.CountryCode IN (SELECT country.Code " +
                    "FROM country WHERE country.Continent = '" + continent + "') ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Create list to store the city information
            ArrayList<City> cities = new ArrayList<City>();

            // Print data
            System.out.println("\nCities in " + continent + ":");
            while (rset.next()) {
                City city = new City(rset);
                System.out.println(city.toString(false));
                cities.add(city);
            }

            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities information");
        }
        return null;
    }
}

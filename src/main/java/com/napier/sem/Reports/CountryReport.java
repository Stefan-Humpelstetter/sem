package com.napier.sem.Reports;

import com.napier.sem.Models.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * this class contains methods to create reports for countries
 */
public class CountryReport extends AReport {

    /**
     * constructor needs connection to the database
     * @param connection to the database
     */
    public CountryReport(Connection connection) {
        super(connection);
    }

    /**
     * Prints the n biggest countries of the world
     * @param n number of countries to be returned, when n = 0, all countries are returned
     * @return list of n biggest countries in the world
     */
    public ArrayList<Country> getTopPopulatedCountries(int n) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT * FROM country ORDER BY population DESC " + (n > 0 ? "LIMIT " + n : "");

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<Country>();

            // Print data
            System.out.println("\n" + (n > 0 ? n : "All") + " most populated countries in the world: ");
            while (rset.next()) {
                Country country = new Country(rset);
                countries.add(country);
                System.out.println(country.toString());
            }

            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
        }
        return null;
    }

    /**
     * Prints the n most populated countries in a specific region
     * @param region the specified region
     * @param n the number of countries to select, if n = 0 then all countries selected
     * @return list of n most populated countries in a region
     */
    public ArrayList<Country> getTopPopulatedCountriesInARegion(String region, int n) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT * FROM country WHERE Region = '" + region + "' ORDER BY Population DESC" + (n > 0 ? " LIMIT " + n : "");


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<Country>();

            // Print data

            System.out.println("\n" + (n > 0 ? +n : "All")  + " most populated countries in the " + region + " region: ");
            while (rset.next()) {
                Country country = new Country(rset);
                countries.add(country);
                System.out.println(country.toString());
            }

            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
        }
        return null;
    }

    /**
     * Prints the n most populated countries in a specific region
     * @param continent the specified region
     * @param n the number of countries to select, if n = 0 then all countries selected
     * @return list of n most populated countries in a region
     */
    public ArrayList<Country> getTopPopulatedCountriesInAContinent(String continent, int n) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT * FROM country WHERE Continent = '" + continent + "' ORDER BY Population DESC" + (n > 0 ? " LIMIT " + n : "");


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<Country>();

            // Print data

            System.out.println("\n" + (n > 0 ? +n : "All")  + " most populated countries in the " + continent + " continent: ");
            while (rset.next()) {
                Country country = new Country(rset);
                countries.add(country);
                System.out.println(country.toString());
            }

            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
        }
        return null;
    }

    /**
     * Prints the n most populated countries in the world
     * @param n the number of countries to select, if n = 0 then all countries selected
     * @return list of n most populated countries worldwide
     */
    public ArrayList<Country> getTopNPopulatedCountriesWorldwide( int n) {
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT * " +
                    "FROM country " +
                    "ORDER BY population DESC " +
                    (n > 0 ? " LIMIT " + n : "") ;


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<Country>();

            // Print data

            System.out.println("\n" + (n > 0 ? +n : "Top")  + " most populated countries in the world :");
            while (rset.next()) {
                Country country = new Country(rset);
                countries.add(country);
                System.out.println(country.toString());
            }

            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
        }
        return null;
    }
}

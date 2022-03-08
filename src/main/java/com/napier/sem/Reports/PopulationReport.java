package com.napier.sem.Reports;

import com.napier.sem.Models.Continent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * this class contains methods to create reports for populations
 */
public class PopulationReport extends AReport{

    /**
     * constructor needs connection to the database
     * @param connection to the database
     */
    public PopulationReport(Connection connection) {
        super(connection);
    }

    /**
     * Returns population of the world
     */
    public void getWorldPopulation(){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT sum(population) as 'population' FROM country";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract and print population information
            if (rset.next()) System.out.println("\nTotal world population: " + rset.getLong("population"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world population details");
        }
    }

    /**
     * Returns population of given continent
     * @param continent a continent
     */
    public void getPopulationOfContinent(Continent continent){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT sum(population) as 'population' FROM country WHERE continent='" + continent.toString() + "'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract and print population information
            if (rset.next()) System.out.println("\nPopulation of " + continent + ": " + rset.getInt("population"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent population details");
        }
    }

    /**
     * Returns population of given region
     * @param regionName name of a region
     */
    public void getPopulationOfRegion(String regionName){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) AS population FROM country WHERE Region = '" + regionName + "'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract and print population information
            if (rset.next()) System.out.println("\nPopulation of the " + regionName + " region: " + rset.getInt("population"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get region population details");
        }
    }

    /**
     * Returns population of given city
     * @param cityName name of a city
     */
    public void getPopulationOfCity(String cityName){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT Population FROM city WHERE Name = '" + cityName + "'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract and print population information
            if (rset.next()) System.out.println("\nPopulation of " + cityName + ": " + rset.getInt("Population"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city population details");
        }
    }

    /**
     * Returns the total population of a district
     * @param districtName the name of a district
     */
    public void getDistrictTotalPopulation(String districtName)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) AS 'District Total Population'"
                            + "FROM city "
                            + "WHERE District = '" + districtName + "' ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract and print population information
            if (rset.next()) System.out.println("\nPopulation of the " + districtName + " district: " + rset.getInt("District Total Population"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get district population details");
        }
    }

    /**
     * Returns the total population of a country
     * @param countryName the name of a country
     */
    public void getTotalPopulationCountry(String countryName)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect =
                      "SELECT Population "
                              + "FROM country "
                              + "WHERE Name = '" + countryName + "' ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract and print population information
            if (rset.next()) System.out.println("\nTotal population of " + countryName + ": " + rset.getInt("Population"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population details");
        }
    }
}

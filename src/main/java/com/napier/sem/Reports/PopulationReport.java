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
     * Returns population of given continent
     * @param continent
     * @return population of the given continent
     */
    public Integer getPopulationOfContinent(Continent continent){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT sum(population) as 'population' FROM country WHERE continent='" + continent.toString() + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next())
                return rset.getInt("population");
            return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Returns population of given city
     * @param cityName Uses name of the City
     * @return population of the given city
     */

    public Integer getPopulationOfCity(String cityName){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT population FROM city WHERE Name = '" + cityName + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) return rset.getInt("population");
            return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Returns the total population of a district
     * @param district
     * @return population
     */
    public Integer getDistrictTotalPopulation(String district)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) AS 'District Total Population'"
                            + "FROM city "
                            + "WHERE District = '" + district + "' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            Integer population = 0;
            while (rset.next())
            {
                population = rset.getInt("District Total Population");
            }
            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the district total population");
            return null;
        }
    }

    /**
     * Returns the total population of a country
     * @param country
     * @return population
     */
    public Integer getTotalPopulationCountry(String country)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect =
                      "SELECT Population "
                              + "FROM country "
                              + "WHERE Name = '" + country + "' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            Integer population = 0;
            if (rset.next()){
                population = rset.getInt("Population");
            }
            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the country total population");
            return null;
        }
    }
}

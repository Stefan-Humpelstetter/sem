package com.napier.sem.Reports;

import com.napier.sem.Models.City;
import com.napier.sem.Models.Continent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PopulationReport extends AReport{
    public PopulationReport(Connection connection) {
        super(connection);
    }

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
     * Returns the total population of a district
     * @return population
     */
    public Integer getDistrictTotalPopulation()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) AS 'District Total Population'"
                            + "FROM city "
                            + "WHERE District = 'Kabol' ";
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
}

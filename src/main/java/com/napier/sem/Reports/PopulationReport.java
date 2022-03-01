package com.napier.sem.Reports;

import com.napier.sem.Models.Continent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PopulationReport extends AReport{
    public PopulationReport(Connection connection) {
        super(connection);
    }

    public int getPopulationOfContinent(Continent continent){
        return 0;
    }

    /**
     * Returns the total population of a district
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
}

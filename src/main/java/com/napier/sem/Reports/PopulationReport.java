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

    public int getPopulationOfContinent(Continent continent){
/*        try
        {
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT id, " +
                            "name, " +
                            "countrycode," +
                            "district," +
                            "population "
                            + "FROM city "
                            + "WHERE id = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            City city = new City(rset);
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }*/
    }
}

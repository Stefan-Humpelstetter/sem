package com.napier.sem.Reports;

import com.napier.sem.Models.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CityReport extends AReport{
    public CityReport(Connection connection) {
        super(connection);
    }

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
                            + "LIMIT " + Integer.toString(n) + " ";
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
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
}

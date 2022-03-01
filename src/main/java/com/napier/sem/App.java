package com.napier.sem;

import com.napier.sem.Models.City;
import com.napier.sem.Models.Continent;
import com.napier.sem.Reports.CityReport;
import com.napier.sem.Reports.CountryReport;
import com.napier.sem.Reports.PopulationReport;

import java.sql.*;

public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * entry point of the program
     * @param args input arguments
     */
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        CountryReport countryReport = new CountryReport(a.con);
        CityReport cityReport = new CityReport(a.con);
        PopulationReport populationReport = new PopulationReport(a.con);


        // print population of North America
        System.out.println("Population of North America:");
        System.out.println(populationReport.getPopulationOfContinent(Continent.North_America));
        System.out.println();

        // Print total population of a district
        System.out.println("Population of the district Kabol:");
        System.out.println(populationReport.getDistrictTotalPopulation());
        System.out.println();

        // print most populated capital of region 'Eastern Africa'
        System.out.println("Most populated capital cities of the region 'Eastern Africa'");
        System.out.println(cityReport.getTopPopulatedCapitalCities("Eastern Africa",5));
        System.out.println();
        System.out.println(populationReport.getDistrictTotalPopulation("Kabol"));

        //Print top n populated capital cities
        for (String name : cityReport.getTopPopulatedCapitalCities(3)){
            System.out.println(name);
        }

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "world");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

}
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

    /**
     * Prints the total amount (and %) of people from a continent living in a city and
     * prints the total amount (and %) of people from a continent not living in a city
     * @param continent contintent the report needs to be created for
     */
    public void printPopulationReportForPeopleLivingInCitiesByContinent(Continent continent){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT (SELECT sum(population) FROM country WHERE Continent='"+continent.toString()+"') as 'Population Total', " +
                            "(SELECT sum(city.population) FROM city " +
                            "JOIN country ON city.CountryCode = country.code WHERE country.Continent='"+continent.toString()+"') as 'Population City' " +
                            "FROM DUAL;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            if (rset.next()){
                int totalPopulation = rset.getInt("Population Total");
                int cityPopulation = rset.getInt("Population City");

                System.out.println("\nPopulation Report from Continent "+continent+":");
                System.out.println("Total Population: "+totalPopulation);
                float cityPercent = ((float)cityPopulation/(float)totalPopulation)*100;
                System.out.println("Total Population of people living in cities: "
                        +cityPopulation
                        +" ("
                        + cityPercent
                        +"%)");
                float noCityPercent = (((float)totalPopulation-(float)cityPopulation)/(float)totalPopulation)*100;
                System.out.println("Total Population of people not living in cities: "
                        +(totalPopulation-cityPopulation)
                        +" ("
                        + noCityPercent
                        +"%)");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the continents population report data");
        }
    }
    /**
     * Prints the population of a given region, which lives in a city
     * Prints the population of a given region, which does not live in a city
     * @param region region needed for the report to be created
     */
    public void getPopulationOfPeopleLivingInAndOutACityByRegion(String region){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Region, SUM(city.Population) AS 'People living In a city', SUM(country.Population)-SUM(city.Population) AS 'People not living in a city' "+
                            "FROM city JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Region = '" + region +"'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            if (rset.next()){
                System.out.println("\nPopulation report for people living in and out a city for the" +region+ "region:" +rset.getInt("People living in a city")+ rset.getInt("People not living in a city"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the continents population report data");
        }
    }
}

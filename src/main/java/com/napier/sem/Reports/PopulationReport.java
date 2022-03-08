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
     * Returns population of given city
     * @return population of the given city
     */

    public Long getWorldPopulation(){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT sum(population) as 'population' FROM country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) return rset.getLong("population");
            return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get World details");
            return null;
        }
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
     * Returns population of given Region
     * @param regionName Uses name of the Region
     * @return population of the given Region
     */

    public Integer getPopulationOfRegion(String regionName){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) AS population FROM country WHERE Region = '" + regionName + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) return rset.getInt("population");
            return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get region details");
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
}

package com.napier.sem.Reports;

import com.napier.sem.Models.Continent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
     * Prints population of the world
     * @return the worlds' population as long
     */
    public long getWorldPopulation(){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT sum(population) as 'population' FROM country";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract and print population information
            if (rset.next())
            {
                long population = rset.getLong("population");
                System.out.println("\nTotal world population: " + population);

                return population;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world population details");
        }

        return 0;
    }

    /**
     * Prints population of given continent
     * @param continent a continent
     * @return the population of the given continent as integer
     */
    public int getPopulationOfContinent(Continent continent){
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
            if (rset.next()) {
                int population = rset.getInt("population");
                System.out.println("\nPopulation of " + continent + ": " + population);
                return population;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent population details");
        }
        return 0;
    }

    /**
     * Prints population of given region
     * @param regionName name of a region
     * @return population of the given region as integer
     */
    public int getPopulationOfRegion(String regionName){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) AS population FROM country WHERE Region = '" + regionName + "'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract and print population information
            if (rset.next()) {
                int population = rset.getInt("population");
                System.out.println("\nPopulation of the " + regionName + " region: " + population);
                return population;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get region population details");
        }
        return 0;
    }

    /**
     * Print population of given city
     * @param cityName name of a city
     * @return population of the given city as integer
     */
    public int getPopulationOfCity(String cityName){
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT Population FROM city WHERE Name = '" + cityName + "'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract and print population information
            if (rset.next()){
                int population = rset.getInt("Population");
                System.out.println("\nPopulation of " + cityName + ": " + population);
                return population;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city population details");
        }
        return 0;
    }

    /**
     * Prints the total population of a district
     * @param districtName the name of a district
     * @return population of the given district as integer
     */
    public int getDistrictTotalPopulation(String districtName)
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
            if (rset.next())
            {
                int population = rset.getInt("District Total Population");
                System.out.println("\nPopulation of the " + districtName + " district: " + population);
                return population;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get district population details");
        }
        return 0;
    }

    /**
     * Prints the total population of a country
     * @param countryName the name of a country
     * @return population of the given country as integer
     */
    public int getTotalPopulationCountry(String countryName)
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
            if (rset.next()) {
                int population = rset.getInt("Population");
                System.out.println("\nTotal population of " + countryName + ": " + population);
                return population;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population details");
        }
        return 0;
    }

    /**
     * Prints the total amount (and %) of people from a continent living in a city and
     * prints the total amount (and %) of people from a continent not living in a city
     * @param continent contintent the report needs to be created for
     */
    public ArrayList<Integer> printPopulationReportForPeopleLivingInCitiesByContinent(Continent continent){
        ArrayList<Integer> populationValues = new ArrayList<Integer>();
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

                populationValues.add(totalPopulation);
                populationValues.add(cityPopulation);
                populationValues.add((totalPopulation-cityPopulation));

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
        return populationValues;
    }
    /**
     * Prints the population (and %) of a given region, which lives in a city
     * Prints the population (and %) of a given region, which does not live in a city
     * @param region region needed for the report to be created
     */
    public ArrayList<Integer> getPopulationOfPeopleLivingInAndOutACityByRegion(String region){
        ArrayList<Integer> populationValues = new ArrayList<Integer>();
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Region, SUM(city.Population) AS 'People living in a city', SUM(country.Population)-SUM(city.Population) AS 'People not living in a city' "+
                            "FROM city JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Region = '" + region +"' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            if (rset.next()){
                int peopleInCity = rset.getInt("People living in a city");
                int peopleOutCity = rset.getInt("People not living in a city");
                System.out.println("\nPopulation Report for people living in a city and out of a city in the "+ region + " region:");
                float peopleInCityPercentage = ((float)peopleInCity/((float)peopleInCity+(float)peopleOutCity))*100;
                float peopleOutCityPercentage = ((float)peopleOutCity/((float)peopleInCity+(float)peopleOutCity))*100;
                System.out.println("Total population for the region: "+ (peopleInCity+peopleOutCity));
                System.out.println("Total Population of people living in cities: " +
                        peopleInCity
                        +" ("
                        + peopleInCityPercentage
                        +"%)");
                System.out.println("Total Population of people living out of a city: " +
                        peopleOutCity
                        +" ("
                        + peopleOutCityPercentage
                        +"%)");
                populationValues.add((peopleInCity + peopleOutCity));
                populationValues.add(peopleInCity);
                populationValues.add(peopleOutCity);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the region population report data");
        }
        return populationValues;
    }
    /**
     * Prints the population(and %) of a given country, which lives in a city
     * Prints the population(and %) of a given country, which does not live in a city
     * @param countryName needed for the population report to be created
     */
    public ArrayList<Integer> getPopulationOfPeopleLivingInAndOutACityByCountry(String countryName){
        ArrayList<Integer> populationValues = new ArrayList<Integer>();
        try
        {
            // Create an SQL statement
            Statement stmt = connection.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name,country.Code, SUM(city.Population) AS 'People living In a City',country.Population-SUM(city.Population) AS 'People not living in City' "
                            +"FROM city JOIN country ON city.CountryCode= country.Code "
                            +"WHERE country.Name='" +countryName+ "' "
                            +"GROUP by country.Code ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            if (rset.next()){
                int peopleInCity = rset.getInt("People living In a City");
                int peopleOutCity= rset.getInt("People not living in City");
                System.out.println("\nPopulation Report for people living in a city and out of a city in " + countryName);
                float peopleInCityPercentage = ((float)peopleInCity/((float)peopleInCity+(float)peopleOutCity))*100;
                float peopleOutCityPercentage = ((float)peopleOutCity/((float)peopleInCity+(float)peopleOutCity))*100;
                System.out.println("Total population for the country: "+ (peopleInCity+peopleOutCity));
                System.out.println("Total Population of people living in cities: " +
                        (peopleInCity)
                        +" ("
                        + peopleInCityPercentage
                        +"%)");
                System.out.println("Total Population of people living out of a city: " +
                        (peopleOutCity)
                        +" ("
                        + peopleOutCityPercentage
                        +"%)");
                populationValues.add((peopleInCity + peopleOutCity));
                populationValues.add(peopleInCity);
                populationValues.add(peopleOutCity);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the country population report data");
        }
        return populationValues;
    }
}

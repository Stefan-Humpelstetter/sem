package com.napier.sem.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represents a city
 */
public class City extends AModel {

    /**
     * constructor takes a ResultSet to create the model
     * @param rset representation of the model in the database
     * @throws SQLException
     */
    public City(ResultSet rset) throws SQLException {
        super(rset);
    }

    /**
     * constructs the model with the given rset
     * @throws SQLException
     */
    @Override
    protected void construct() throws SQLException {
        if (rset.isBeforeFirst())
            rset.next();

        this.id = rset.getInt("id");
        this.name = rset.getString("name");
        this.countryCode = rset.getString("countrycode");
        this.district = rset.getString("district");
        this.population = rset.getInt("population");
    }

    /**
     * City's id
     */
    public int id;

    /**
     * City's name
     */
    public String name;

    /**
     * City's country code
     */
    public String countryCode;

    /**
     * City's district
     */
    public String district;

    /**
     * City's population
     */
    public int population;

    /**
     * Returns the necessary columns of the city for the reports
     * @param capital determines if the report is a capital city report
     * @return returns the string representation of the model
     */
    public String toString(boolean capital) {
        String returnString = "City: name=" + name +
                ", countryCode=" + countryCode +
                ", population=" + population;

        if(capital)
            returnString+=", district=" + district;

        return returnString;
    }
}

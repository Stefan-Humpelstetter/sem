package com.napier.sem.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represents a city
 */
public class City extends AModel {

    public City(ResultSet rset) throws SQLException {
        super(rset);
    }

    @Override
    protected void construct() throws SQLException {
        if (rset.isBeforeFirst())
            rset.next();

        this.id = rset.getInt("id");
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
}

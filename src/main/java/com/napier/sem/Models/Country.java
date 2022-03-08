package com.napier.sem.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Represents a country
 */
public class Country extends AModel {

    /**
     * constructor takes a ResultSet to create the model
     * @param rset representation of the model in the database
     * @throws SQLException
     */
    public Country(ResultSet rset) throws SQLException {
        super(rset);
    }

    /**
     * constructs the model with the given ResultSet
     * @throws SQLException
     */
    @Override
    protected void construct() throws SQLException {
        if (rset.isBeforeFirst())
            rset.next();

        this.code = rset.getString("Code");
        this.name = rset.getString("Name");
        this.continent = stringToContinent(rset.getString("Continent"));
        this.region = rset.getString("Region");
        this.surfaceArea = rset.getInt("SurfaceArea");
        this.indepYear = rset.getInt("IndepYear");
        this.population = rset.getInt("Population");
        this.lifeExpectancy = rset.getInt("LifeExpectancy");
        this.gnp = rset.getFloat("GNP");
        this.gnpOld = rset.getFloat("GNPOld");
        this.localName = rset.getString("LocalName");
        this.governmentForm = rset.getString("GovernmentForm");
        this.headOfState = rset.getString("HeadOfState");
        this.capital = rset.getString("Capital");
        this.code2 = rset.getString("Code2");
    }

    /**
     * Converts a string to the Continent enum
     * @param continent string of a continent
     * @return the enum representation of a continent
     */
    private Continent stringToContinent(String continent) {
        if (Objects.equals(continent, "North America"))
            return Continent.North_America;
        if (Objects.equals(continent, "South America"))
            return Continent.South_America;

        return Continent.valueOf(continent);
    }

    /**
     * Country's code
     */
    public String code;

    /**
     * Country's name
     */
    public String name;

    /**
     * Country's continent
     */
    public Continent continent;

    /**
     * Country's region
     */
    public String region;

    /**
     * Country's surfaceArea
     */
    public int surfaceArea;

    /**
     * Country's indepYear
     */
    public int indepYear;

    /**
     * Country's population
     */
    public int population;

    /**
     * Country's lifeExpectancy
     */
    public int lifeExpectancy;

    /**
     * Country's gnp
     */
    public float gnp;

    /**
     * Country's gnpOld
     */
    public float gnpOld;

    /**
     * Country's localName
     */
    public String localName;

    /**
     * Country's governmentForm
     */
    public String governmentForm;

    /**
     * Country's headOfState
     */
    public String headOfState;

    /**
     * Country's capital
     */
    public String capital;

    /**
     * Country's code2
     */
    public String code2;

    /**
     * Returns the necessary columns of the country for the reports
     * @return returns the string representation of the model
     */
    @Override
    public String toString() {
        return "Country: " + "code=" + code +
                ", name=" + name +
                ", continent=" + continent +
                ", region=" + region +
                ", population=" + population +
                ", capital=" + capital;
    }
}

package com.napier.sem.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Country extends AModel {

    public Country(ResultSet rset) throws SQLException {
        super(rset);
    }

    @Override
    protected void construct() throws SQLException {
        if(rset.next()){
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
    }

    private Continent stringToContinent(String continent){
        if(Objects.equals(continent, "North America"))
            return Continent.North_America;
        if (Objects.equals(continent, "South America"))
            return Continent.South_America;

        return Continent.valueOf(continent);
    }

    public String code;

    public String name;

    public Continent continent;

    public String region;

    public int surfaceArea;

    public int indepYear;

    public int population;

    public int lifeExpectancy;

    public float gnp;

    public float gnpOld;

    public String localName;

    public String governmentForm;

    public String headOfState;

    public String capital;

    public String code2;
}

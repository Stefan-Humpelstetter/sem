package com.napier.sem.Models;

import com.napier.sem.Continent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Country extends AModel {

    public Country(ResultSet rset) throws SQLException {
        super(rset);
    }

    @Override
    protected void construct() {

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

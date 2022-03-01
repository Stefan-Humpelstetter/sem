package com.napier.sem.Reports;

import com.napier.sem.Models.Continent;

import java.sql.Connection;

public class PopulationReport extends AReport{
    public PopulationReport(Connection connection) {
        super(connection);
    }

    public int getPopulationOfContinent(Continent continent){
        return 0;
    }
}

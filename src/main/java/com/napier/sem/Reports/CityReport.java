package com.napier.sem.Reports;

import com.napier.sem.Models.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CityReport extends AReport {
    /**
     * constructor needs connection to the database
     * @param connection to the database
     */
    public CityReport(Connection connection) {
        super(connection);
    }
}

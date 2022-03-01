package com.napier.sem.Reports;

import java.sql.Connection;

/**
 * this class contains methods to create reports for countries
 */
public class CountryReport extends AReport{
    public CountryReport(Connection connection) {
        super(connection);
    }
}

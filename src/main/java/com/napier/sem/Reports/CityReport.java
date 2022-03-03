package com.napier.sem.Reports;

import java.sql.Connection;

public class CityReport extends AReport {
    /**
     * constructor needs connection to the database
     * @param connection to the database
     */
    public CityReport(Connection connection) {
        super(connection);
    }
}

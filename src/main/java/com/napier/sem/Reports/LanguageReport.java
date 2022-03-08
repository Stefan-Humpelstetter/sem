package com.napier.sem.Reports;

import java.sql.Connection;

public class LanguageReport extends AReport {
    /**
     * constructor needs connection to the database
     * @param connection to the database
     */
    public LanguageReport(Connection connection) {
        super(connection);
    }
}

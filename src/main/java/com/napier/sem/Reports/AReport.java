package com.napier.sem.Reports;
import java.sql.*;

/**
 * Abstract base class for the report classes
 */
public abstract class AReport {

    /**
     * Connection to MySQL database.
     */
    protected Connection connection;

    /**
     * constructor needs connection to the database
     * @param connection to the database
     */
    public AReport(Connection connection){
        this.connection = connection;
    }

}

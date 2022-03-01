package com.napier.sem.Reports;
import java.sql.*;

public abstract class AReport {

    protected Connection connection;

    public AReport(Connection connection){
        this.connection = connection;
    }

}

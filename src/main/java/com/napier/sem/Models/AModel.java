package com.napier.sem.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Abstract representation of a model
 */
public abstract class AModel {

    /**
     * Model's ResultSet that it will be constructed from
     */
    protected ResultSet rset;

    /**
     * constructor takes a ResultSet to create the model
     * @param rset representation of the model in the database
     * @throws SQLException
     */
    public AModel(ResultSet rset) throws SQLException {
        this.rset=rset;
        construct();
    }

    /**
     * Method to construct the model
     * @throws SQLException
     */
    protected abstract void construct() throws SQLException;
}

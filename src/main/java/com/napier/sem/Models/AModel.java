package com.napier.sem.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AModel {

    protected ResultSet rset;

    public AModel(ResultSet rset) throws SQLException {
        this.rset=rset;
        construct();
    }

    protected abstract void construct() throws SQLException;
}

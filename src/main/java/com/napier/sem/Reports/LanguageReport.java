package com.napier.sem.Reports;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class LanguageReport extends AReport {
    /**
     * constructor needs connection to the database
     * @param connection to the database
     */
    public LanguageReport(Connection connection) {
        super(connection);
    }


    /**
     * Creates language report for Chinese, English, Hindi and Spanish
     */
    public Map<String, Integer> getLanguagesAmountAndPercentage(){
        Map<String, Integer> languageMap = new HashMap<>();
        try {
            // Create an SQL statement
            Statement stmt = connection.createStatement();

            // Create string for SQL statement
            String strSelect ="SELECT " +
                    "cl.language, " +
                    "FLOOR(SUM(c.population / 100 * cl.Percentage)) as amount, " +
                    "ROUND(SUM(c.population / 100 * cl.Percentage)/(w.world/100),2) as percentage " +
                    "FROM country c " +
                    "JOIN countrylanguage cl ON c.code = cl.CountryCode " +
                    "JOIN (SELECT sum(population) as 'world' FROM country) as w " +
                    "WHERE cl.language IN ('Chinese','English','Hindi','Spanish','Arabic') " +
                    "GROUP BY cl.language, w.world " +
                    "ORDER BY amount DESC;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // print rows
            while (rset.next()) {
                String language = rset.getString("language");
                int population = rset.getInt("amount");
                languageMap.put(language, population);
                System.out.println(language + " - Amount: " + population + " | Percentage: " + rset.getFloat("percentage"));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get language information");
        }
        return languageMap;
    }
}

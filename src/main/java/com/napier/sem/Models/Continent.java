package com.napier.sem.Models;

/**
 * Represents a continent
 */
public enum Continent {
    Asia("Asia"),
    Europe("Europe"),
    North_America("North America"),
    Africa("Africa"),
    Oceania("Oceania"),
    Antarctica("Antarctica"),
    South_America("South America");

    /**
     * Continent's display name
     */
    private final String displayName;

    /**
     * sets the displayName of the continent
     * @param displayName
     */
    Continent(String displayName) {
        this.displayName = displayName;
    }

    /**
     * returns the display name
     * @return displayName
     */
    public String displayName() {
        return displayName;
    }

    /**
     * Converts the enum to a string
     * @return returns the string representation of the enum
     */
    @Override
    public String toString() {
        return displayName;
    }

}

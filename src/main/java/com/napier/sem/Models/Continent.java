package com.napier.sem.Models;

public enum Continent {
    Asia("Asia"),
    Europe("Europe"),
    North_America("North America"),
    Africa("Africa"),
    Oceania("Oceania"),
    Antarctica("Antarctica"),
    South_America("South America");

    private final String displayName;

    Continent(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    // Optionally and/or additionally, toString.
    @Override public String toString() { return displayName; }

    }

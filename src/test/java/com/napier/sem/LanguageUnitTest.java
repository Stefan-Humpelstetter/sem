package com.napier.sem;

import com.napier.sem.Reports.LanguageReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageUnitTest {
    private static LanguageReport languageReport;

    @BeforeAll
    static void init() {
        languageReport = new LanguageReport(null);
    }

    @Test
    void testGetLanguagesAmountAndPercentage() {
        // test if program does not crash when there is no connection
        languageReport.getLanguagesAmountAndPercentage();
    }
}

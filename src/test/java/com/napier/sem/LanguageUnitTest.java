package com.napier.sem;

import com.napier.sem.Reports.LanguageReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LanguageUnitTest {
    private static LanguageReport languageReport;

    /**
     * Unit test initialisation
     */
    @BeforeAll
    static void init() {
        languageReport = new LanguageReport(null);
    }

    /**
     * Unit test for getLanguagesAmountAndPercentage() method
     */
    @Test
    void testGetLanguagesAmountAndPercentage() {
        //Test if program does not crash when there is no connection
        languageReport.getLanguagesAmountAndPercentage();
    }
}

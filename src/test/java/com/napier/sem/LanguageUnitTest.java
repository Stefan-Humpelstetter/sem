package com.napier.sem;

import com.napier.sem.Reports.LanguageReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LanguageUnitTest {
    private static LanguageReport languageReport;

    @BeforeAll
    static void init() {
        languageReport = new LanguageReport(null);
    }

    @Test
    void testGetLanguagesAmountAndPercentage() {
        //Test if program does not crash when there is no connection
        languageReport.getLanguagesAmountAndPercentage();
    }
}

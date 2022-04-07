package com.napier.sem;

import com.napier.sem.Reports.LanguageReport;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageIntegrationTest {
    private static LanguageReport languageReport;
    static App app;

    /**
     * Integration test initialisation
     */
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
        languageReport = new LanguageReport(app.getConnection());
    }

    /**
     * Integration test for the getLanguagesAmountAndPercentage() method for the language 'Chinese'
     */
    @Test
    void testChineseSpeakers()
    {
        // Test number of Chinese speakers returned
        int languageSpeakers = languageReport.getLanguagesAmountAndPercentage().get("Chinese");
        assertEquals(1191843539, languageSpeakers);
    }

    /**
     * Integration test for the getLanguagesAmountAndPercentage() method for the language 'Hindi'
     */
    @Test
    void testHindiSpeakers()
    {
        // Test number of Hindi speakers returned
        int languageSpeakers = languageReport.getLanguagesAmountAndPercentage().get("Hindi");
        assertEquals(405633070, languageSpeakers);
    }

    /**
     * Integration test for the getLanguagesAmountAndPercentage() method for the language 'Spanish'
     */
    @Test
    void testSpanishSpeakers()
    {
        // Test number of Spanish speakers returned
        int languageSpeakers = languageReport.getLanguagesAmountAndPercentage().get("Spanish");
        assertEquals(355029462, languageSpeakers);
    }

    /**
     * Integration test for the getLanguagesAmountAndPercentage() method for the language 'English'
     */
    @Test
    void testEnglishSpeakers()
    {
        // Test number of English speakers returned
        int languageSpeakers = languageReport.getLanguagesAmountAndPercentage().get("English");
        assertEquals(347077867, languageSpeakers);
    }

    /**
     * Integration test for the getLanguagesAmountAndPercentage() method for the language 'Arabic'
     */
    @Test
    void testArabicSpeakers()
    {
        // Test number of Arabic speakers returned
        int languageSpeakers = languageReport.getLanguagesAmountAndPercentage().get("Arabic");
        assertEquals(233839238, languageSpeakers);
    }

    /**
     * After integration test
     */
    @AfterAll
    static void afterAll() {
        app.disconnect();
    }
}
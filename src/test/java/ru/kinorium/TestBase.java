package ru.kinorium;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.KinoPage;

public class TestBase {
    KinoPage kinoPage = new KinoPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://en.kinorium.com/";
        Configuration.browserSize = "3840x2160";
        // Configuration.holdBrowserOpen = true;
    }
}
package test_engine.out.web.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.base.Strings;
import io.qameta.allure.selenide.AllureSelenide;
import test_engine.out.web.selenium.Highlighter;

public class SelenideAdapter {

    public static void configuration() {
        Configuration.timeout = 6000;
        if (Strings.isNullOrEmpty(Configuration.remote)) {
            WebDriverRunner.addListener(new Highlighter());
        }
    }

    public static void addAllureListener() {
        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false)
        );
    }

}

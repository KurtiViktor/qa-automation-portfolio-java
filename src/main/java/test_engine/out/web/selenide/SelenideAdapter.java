package test_engine.out.web.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.base.Strings;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.experimental.UtilityClass;
import test_engine.out.web.selenium.Highlighter;

/**
 * Класс общей конфигурации параметров библиотеки Selenide.
 */
@UtilityClass
public class SelenideAdapter {

    /**
     * Метод общей конфигурации параметров Selenide.
     */
    public void configuration() {
        Configuration.timeout = 6000;
        if (Strings.isNullOrEmpty(Configuration.remote)) {
            WebDriverRunner.addListener(new Highlighter());
        }
    }

    /**
     * Метод, который добавляет Allure Listener.
     */
    public void addAllureListener() {
        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false)
        );
    }

}

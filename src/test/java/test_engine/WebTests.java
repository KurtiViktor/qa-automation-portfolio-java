package test_engine;

import com.automation.remarks.junit5.Video;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import test_engine.out.web.selenide.SelenideAdapter;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Юнит-тесты для проверки web-функциональности.
 */
@Tag("web")
@DisplayName("Юнит-тесты для проверки web-функциональности")
class WebTests {

    @BeforeAll
    @DisplayName("Фикстура перед всеми web тестами")
    static void setUp() {
        SelenideAdapter.configuration();
        SelenideAdapter.addAllureListener();
        System.out.println("Фикстура перед всеми web тестами " + Thread.currentThread().getName());
    }

    /**
     * В поиске янедкса (https://www.yandex.ru/) при вводе ключевого слова "погода" всплывает окно вариантов выбора.
     * Первый из них -- это вариант с указанием текущей погоды, например "погода 0 С".
     * Задача вывести на экран значение погоды в градусах. Язык реализации Java.
     */
    @Test
    @Video
    @DisplayName("Задача по поиску температуры на сегодня")
    void yandexWeatherSearch() {
        System.out.println("Задача по поиску температуры на сегодня " + Thread.currentThread().getName());
        open("https://www.yandex.ru/");
        setTextToSearch("погода");
        String text = getPopupQuickAnswerText();
        assertThat(text)
                .matches("[−+]\\d °C");
    }

    @Step("Задать текст {text} на поиск")
    void setTextToSearch(String text) {
        $(By.xpath("//*[@class='input__box']/input"))
                .setValue(text);
    }

    @Step("Получить текст первого быстрого ответа из popup")
    String getPopupQuickAnswerText() {
        ElementsCollection suggestions = $$(By.xpath("//div[@class='popup__content']//li"));
        SelenideElement suggestion = suggestions.first();
        return suggestion
                .find(By.xpath("//*[contains(text(),'Быстрый ответ:')]/.."))
                .getText();
    }

}

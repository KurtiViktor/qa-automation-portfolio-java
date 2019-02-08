package test_engine.out.config;

import org.aeonbits.owner.Config;

/**
 * Класс с общими настройками проекта с помощью библиотеки OWNER.
 */
public interface TestEngineCfg extends Config {

    /**
     * Базовый url для апи.
     *
     * @return the string
     */
    @DefaultValue("https://reqres.in/")
    String apiBaseUrl();
}

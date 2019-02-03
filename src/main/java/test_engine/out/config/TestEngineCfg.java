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

    /**
     * Jdbc driver string.
     *
     * @return the string
     */
    @DefaultValue("org.sqlite.JDBC")
    String jdbcDriver();

    /**
     * Jdbc url string.
     *
     * @return the string
     */
    String jdbcUrl();

    /**
     * Jdbc name string.
     *
     * @return the string
     */
    @DefaultValue("root")
    String jdbcName();

    /**
     * Jdbc password string.
     *
     * @return the string
     */
    @DefaultValue("root")
    String jdbcPassword();

}

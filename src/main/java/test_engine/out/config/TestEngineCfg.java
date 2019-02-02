package test_engine.out.config;

import org.aeonbits.owner.Config;

public interface TestEngineCfg extends Config {

    @DefaultValue("https://reqres.in/")
    String apiBaseUrl();

    @DefaultValue("org.sqlite.JDBC")
    String jdbcDriver();

    @DefaultValue("jdbc:sqlite:V:/Автоматизация тестирвоания/code/java/portfolio/test_engine/src/test/resources/dbtest.db")
    String jdbcUrl();

    @DefaultValue("root")
    String jdbcName();

    @DefaultValue("root")
    String jdbcPassword();

}

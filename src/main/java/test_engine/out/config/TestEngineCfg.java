package test_engine.out.config;

import org.aeonbits.owner.Config;

public interface TestEngineCfg extends Config {
    @DefaultValue("https://reqres.in/")
    String baseUrl();
}

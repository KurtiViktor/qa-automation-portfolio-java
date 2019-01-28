package test_engine.ext.junit5;

import org.aeonbits.owner.ConfigCache;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import test_engine.api.rest.retrofit.APIRequests;
import test_engine.api.rest.retrofit.RetrofitAdapter;
import test_engine.out.config.TestEngineCfg;

public class APIParameterResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == APIRequests.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        TestEngineCfg cfg = ConfigCache.getOrCreate(TestEngineCfg.class);
        return RetrofitAdapter.build(cfg.baseUrl());
    }

}

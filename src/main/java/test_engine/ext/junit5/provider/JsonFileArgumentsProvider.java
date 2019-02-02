package test_engine.ext.junit5.provider;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.Cleanup;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;
import org.junit.platform.commons.util.Preconditions;
import test_engine.api.testdata.model.TestData;
import test_engine.ext.junit5.interf.JsonFileSource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class JsonFileArgumentsProvider implements AnnotationConsumer<JsonFileSource>, ArgumentsProvider {

    private String filePath;

    @Override
    public void accept(JsonFileSource jsonFileSource) {
        filePath = jsonFileSource.filePath();
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws IOException {
        Class<?> testClass = context.getRequiredTestClass();
        @Cleanup InputStream inputStream = testClass.getResourceAsStream(filePath);
        @Cleanup JsonReader reader = new JsonReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        Preconditions.notNull(reader, () -> "Classpath resource does not exist: " + filePath);
        TestData td = new Gson().fromJson(reader, TestData.class);
        return Stream.of(Arguments.of(td));
    }

}

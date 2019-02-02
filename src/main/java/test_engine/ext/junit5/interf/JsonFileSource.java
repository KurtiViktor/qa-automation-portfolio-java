package test_engine.ext.junit5.interf;

import org.junit.jupiter.params.provider.ArgumentsSource;
import test_engine.ext.junit5.provider.JsonFileArgumentsProvider;

import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(JsonFileArgumentsProvider.class)
public @interface JsonFileSource {
    String filePath();
}

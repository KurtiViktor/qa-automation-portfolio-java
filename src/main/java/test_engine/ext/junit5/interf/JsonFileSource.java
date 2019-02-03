package test_engine.ext.junit5.interf;

import org.junit.jupiter.params.provider.ArgumentsSource;
import test_engine.ext.junit5.provider.JsonFileArgumentsProvider;

import java.lang.annotation.*;

/**
 * Custom аннотация для Junit 5 для работы с json источниками тестовых данных.
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(JsonFileArgumentsProvider.class)
public @interface JsonFileSource {

    /**
     * Путь к файлу с json-источником тестовых данных.
     *
     * @return the string
     */
    String filePath();
}

package test_engine.ext.junit5.interf;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

/**
 * Custom аннотация для Junit 5 для работы с web.
 */
@Tag("web")
@Execution(CONCURRENT)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface WEB {
}

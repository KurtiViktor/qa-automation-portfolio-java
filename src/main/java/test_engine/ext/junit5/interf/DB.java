package test_engine.ext.junit5.interf;

import eu.drus.jpa.unit.api.JpaUnit;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import test_engine.ext.junit5.resolver.DBParameterResolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(JpaUnit.class)
@ExtendWith(DBParameterResolver.class)
@Tag("db")
@Execution(CONCURRENT)
public @interface DB {
}

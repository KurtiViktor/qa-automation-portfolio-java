package test_engine.db.jpa.service;

import javax.persistence.EntityManager;
import java.util.List;

public interface JPAService {
    <T> List<T> findAll(EntityManager entityManager, Class<T> model, String queryName);
    <T> T findById(EntityManager entityManager, Class<T> model, Long id);
    <T> void save(EntityManager entityManager, T model);
    <T> void delete(EntityManager entityManager, T model);
}

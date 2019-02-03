package test_engine.db.jpa.service.impl;

import lombok.extern.slf4j.Slf4j;
import test_engine.db.jpa.service.JPAService;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Класс-имплементация JPA сервисов.
 */
@Slf4j
public class JPAServiceImpl implements JPAService {

    @Override
    public <T> List<T> findAll(EntityManager entityManager, Class<T> model, String queryName) {
        return entityManager
                .createNamedQuery(queryName, model)
                .getResultList();
    }

    @Override
    public <T> T findById(EntityManager entityManager, Class<T> modelCls, Long id) {
        T model = entityManager.find(modelCls, id);
        log.info("find existing Entity: " + model);
        return model;
    }

    @Override
    public <T> void save(EntityManager entityManager, T model) {
        entityManager.persist(model);
        log.info("Inserting new Entity");
    }

    @Override
    public <T> void delete(EntityManager entityManager, T model) {
        entityManager.remove(model);
        log.info("Entity with id: " + model + " deleted successfully");
    }

}
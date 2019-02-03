package test_engine.db.jpa.service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Класс JPA сервисов.
 */
public interface JPAService {

    /**
     * Найти все элементы из таблицы.
     *
     * @param <T>           the type parameter
     * @param entityManager the entity manager
     * @param model         класс таблицы с аннотацией Entity
     * @param queryName     имя именованного запроса
     * @return лист всех строк таблицы
     */
    <T> List<T> findAll(EntityManager entityManager, Class<T> model, String queryName);

    /**
     * Поиск по id в таблице.
     *
     * @param <T>           the type parameter
     * @param entityManager the entity manager
     * @param model         класс таблицы с аннотацией Entity
     * @param id            the id
     * @return the t
     */
    <T> T findById(EntityManager entityManager, Class<T> model, Long id);

    /**
     * Сохранить объект в таблицу.
     *
     * @param <T>           the type parameter
     * @param entityManager the entity manager
     * @param model         класс таблицы с аннотацией Entity
     */
    <T> void save(EntityManager entityManager, T model);

    /**
     * Удалить объект из таблицы.
     *
     * @param <T>           the type parameter
     * @param entityManager the entity manager
     * @param model         класс таблицы с аннотацией Entity
     */
    <T> void delete(EntityManager entityManager, T model);

}

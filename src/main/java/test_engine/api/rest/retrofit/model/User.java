package test_engine.api.rest.retrofit.model;

import lombok.Data;

/**
 * Класс модель для чтения тестовых данных из апи.
 * Сущность User.
 */
@Data
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String avatar;
}

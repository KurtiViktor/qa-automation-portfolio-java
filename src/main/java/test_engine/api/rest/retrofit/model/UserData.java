package test_engine.api.rest.retrofit.model;

import lombok.Data;
import lombok.NonNull;

/**
 * Класс модель для чтения тестовых данных из апи.
 * Агрегатор для сущности User.
 * В ответе апи-сервера соотвествует тэгу data.
 */
@Data
public class UserData {
    @NonNull private User data;
}

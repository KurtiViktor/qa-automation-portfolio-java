package test_engine.api.testdata.model;

import lombok.Data;
import test_engine.api.rest.retrofit.model.UserData;

/**
 * Класс данных для тестов как сущности, чтобы читать данные из json.
 */
@Data
public class TestData {
    private String test_id;
    private String user_id;
    private int response_status;
    private UserData response;
}

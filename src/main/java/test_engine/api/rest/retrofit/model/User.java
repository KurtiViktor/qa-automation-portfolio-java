package test_engine.api.rest.retrofit.model;

import lombok.Data;

@Data
public class User {
    private long id;
    private String first_name;
    private String last_name;
    private String avatar;
}

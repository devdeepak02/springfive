package com.learning.springfive.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by kumade1 on 1/3/18.
 */
@Data
@Getter
@Setter
@Document(collection = "users")
public class User {

    @Id
    @JsonProperty
    private String userid;

    @JsonProperty
    private String username;

    @JsonProperty
    private String password;

}

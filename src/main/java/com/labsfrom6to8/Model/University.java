package com.labsfrom6to8.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class University {

    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("location")
    private String location;

    @JsonProperty("student_count")
    private Integer studentCount;

    @JsonProperty("is_public")
    private Boolean isPublic;
}

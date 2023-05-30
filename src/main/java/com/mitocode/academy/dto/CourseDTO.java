package com.mitocode.academy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {

    @EqualsAndHashCode.Include
    private Integer idCourse;

    @EqualsAndHashCode.Include
    @NotNull
    private String name;

    @EqualsAndHashCode.Include
    @NotNull
    private String acronym;

    @NotNull
    private boolean enabledCourse;
}

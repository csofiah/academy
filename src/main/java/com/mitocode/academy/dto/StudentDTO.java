package com.mitocode.academy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
public class StudentDTO {

    @EqualsAndHashCode.Include
    private Integer idStudent;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    @NotEmpty
    private String dni;

    @Min(value = 1)
    @Max(value = 150)
    private Integer age;

    @NotNull
    private boolean enabledStudent;
}

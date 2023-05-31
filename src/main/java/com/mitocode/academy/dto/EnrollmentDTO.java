package com.mitocode.academy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDTO {

    @EqualsAndHashCode.Include
    private Integer idEnrollment;

    @NotNull
    private LocalDateTime dateEnrollment;

    @JsonIncludeProperties(value = {"idStudent", "name", "lastName"})
    @EqualsAndHashCode.Include
    @NotNull
    private StudentDTO student;

    @NotNull
    @JsonManagedReference
    private List<EnrollmentDetailDTO> details;

    @NotNull
    private boolean enabledEnrollment;
}

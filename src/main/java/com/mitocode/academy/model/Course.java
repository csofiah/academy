package com.mitocode.academy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Course {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer idCourse;

    @EqualsAndHashCode.Include
    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String acronym;

    @Column(nullable = false)
    private boolean enabledCourse;
}

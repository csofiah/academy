package com.mitocode.academy.controller;

import com.mitocode.academy.dto.StudentDTO;
import com.mitocode.academy.model.Student;
import com.mitocode.academy.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception{
        List<StudentDTO> students = service.readAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    private StudentDTO convertToDto(Student student) {
        return mapper.map(student, StudentDTO.class);
    }

    private Student convertToEntity(StudentDTO dto){
        return mapper.map(dto, Student.class);
    }
}

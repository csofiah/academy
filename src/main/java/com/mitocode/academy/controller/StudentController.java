package com.mitocode.academy.controller;

import com.mitocode.academy.dto.StudentDTO;
import com.mitocode.academy.model.Student;
import com.mitocode.academy.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;

    @Qualifier("studentMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception{
        List<StudentDTO> students = service.readAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO dto) throws Exception{
        Student obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") Integer id) throws Exception {
        StudentDTO dto = this.convertToDto(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody StudentDTO dto) throws Exception{
        dto.setIdStudent(id);
        Student obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/studentsByAge")
    public ResponseEntity<List<Student>> studentsByAge() throws Exception {
        List<Student> students = service.studentsByAge();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    private StudentDTO convertToDto(Student student) {
        return mapper.map(student, StudentDTO.class);
    }

    private Student convertToEntity(StudentDTO dto){
        return mapper.map(dto, Student.class);
    }

}

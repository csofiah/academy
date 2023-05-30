package com.mitocode.academy.config;

import com.mitocode.academy.dto.StudentDTO;
import com.mitocode.academy.model.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

   /* @Bean("studentMapper")
    public ModelMapper studentMapper(){
        ModelMapper mapper = new ModelMapper();
        TypeMap<StudentDTO, Student> typeMap1 = mapper.createTypeMap(StudentDTO.class, Student.class);
        TypeMap<Student, StudentDTO> typeMap2 = mapper.createTypeMap(Student.class, StudentDTO.class);

        typeMap1.addMapping(StudentDTO::getIdStudent, (dest, v)-> dest.setIdStudent((Integer) v));
        typeMap2.addMapping(Student::getIdStudent, (dest, v) -> dest.setIdStudent((Integer) v));

        return mapper;
    }*/

    @Bean("defaultMapper")
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }
}

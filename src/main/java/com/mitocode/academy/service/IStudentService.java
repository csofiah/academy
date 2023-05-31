package com.mitocode.academy.service;

import com.mitocode.academy.model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService extends ICrud<Student, Integer> {
    List<Student> studentsByAge();
}

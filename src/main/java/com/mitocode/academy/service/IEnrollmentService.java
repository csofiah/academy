package com.mitocode.academy.service;

import com.mitocode.academy.model.Enrollment;
import com.mitocode.academy.model.EnrollmentDetail;
import com.mitocode.academy.model.Student;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IEnrollmentService extends ICrud<Enrollment, Integer> {
    Map<String, Map<String,List<EnrollmentDetail>>> enrollmentsByStudents();
}

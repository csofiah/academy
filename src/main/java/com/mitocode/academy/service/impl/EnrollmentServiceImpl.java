package com.mitocode.academy.service.impl;

import com.mitocode.academy.model.Enrollment;
import com.mitocode.academy.model.EnrollmentDetail;
import com.mitocode.academy.model.Student;
import com.mitocode.academy.repo.IEnrollmentRepo;
import com.mitocode.academy.repo.IGenericRepo;
import com.mitocode.academy.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CrudImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepo repo;

    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }

    /**
     * Cursos matriculados y sus esdiantes
     * @return
     */
    @Override
    public Map<String, Map<String,List<EnrollmentDetail>>> enrollmentsByStudents() {
        Stream<Enrollment> enrollmentStream = repo.findAll().stream();
        Stream<List<EnrollmentDetail>> details = enrollmentStream.map(Enrollment::getDetails);

        //stream detalle
        Stream<EnrollmentDetail> detailStream = details
                .flatMap(Collection::stream);

        //agrupa por nombre curso y listado de enrollments
        var enrollemntsByCourse = detailStream
                .collect(groupingBy(ed -> ed.getCourse().getName(),groupingBy(this::getNameStudent)));


        var mapFinal = enrollemntsByCourse.entrySet()
                .stream()
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));


        return mapFinal;
    }

    /**
     * Obtiene el nombre del estudiante
     * @param enrollmentDetail objeto de EnrollmentDetail
     * @return nombre
     */
    private String getNameStudent(EnrollmentDetail enrollmentDetail){
        return enrollmentDetail.getEnrollment().getStudent().getName();
    }
}

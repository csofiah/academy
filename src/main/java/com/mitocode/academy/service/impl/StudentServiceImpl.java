package com.mitocode.academy.service.impl;

import com.mitocode.academy.model.Student;
import com.mitocode.academy.repo.IGenericRepo;
import com.mitocode.academy.repo.IStudentRepo;
import com.mitocode.academy.service.IStudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.springframework.data.util.Pair.toMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CrudImpl<Student, Integer> implements IStudentService {

    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Student> studentsByAge() {
        Comparator<Student> inverse = (x1, x2) -> x2.getAge() - x1.getAge();

       return repo.findAll().stream()
                .sorted(inverse)
                .peek(e -> log.info(e.toString()))
                .collect(Collectors.toList());

    }
}

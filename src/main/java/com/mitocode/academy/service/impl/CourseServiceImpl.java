package com.mitocode.academy.service.impl;

import com.mitocode.academy.model.Course;
import com.mitocode.academy.repo.IGenericRepo;
import com.mitocode.academy.repo.ICourseRepo;
import com.mitocode.academy.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CrudImpl<Course, Integer> implements ICourseService {

    private final ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }
}

package com.mitocode.academy.service.impl;

import com.mitocode.academy.model.Enrollment;
import com.mitocode.academy.repo.IEnrollmentRepo;
import com.mitocode.academy.repo.IGenericRepo;
import com.mitocode.academy.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CrudImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepo repo;

    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }
}

package com.mitocode.academy.service.impl;

import com.mitocode.academy.model.Student;
import com.mitocode.academy.repo.IGenericRepo;
import com.mitocode.academy.repo.IStudentRepo;
import com.mitocode.academy.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CrudImpl<Student, Integer> implements IStudentService {

    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }
}

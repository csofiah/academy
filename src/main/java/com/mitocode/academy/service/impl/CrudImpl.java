package com.mitocode.academy.service.impl;

import com.mitocode.academy.repo.IGenericRepo;
import com.mitocode.academy.service.ICrud;

import java.util.List;

public abstract class CrudImpl<T,ID> implements ICrud<T,ID> {

    protected  abstract IGenericRepo<T,ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        //TODO mejorar excepcion
        getRepo().findById(id).orElseThrow(() -> new NullPointerException("Id not exits: " + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        //TODO mejorar excepcion
        return getRepo().findById(id).orElseThrow(() -> new NullPointerException("Id not exits: " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        //TODO mejorar excepcion
        getRepo().findById(id).orElseThrow(() -> new NullPointerException("Id not exits: " + id));
        getRepo().deleteById(id);
    }
}

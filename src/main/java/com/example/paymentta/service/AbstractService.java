package com.example.paymentta.service;

import com.example.paymentta.dto.CustomerDto;
import com.example.paymentta.entity.Customer;
import com.example.paymentta.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class AbstractService <R extends JpaRepository<E, Long> , E>{

    @Autowired
    protected  R repository;


    public void insert(E e) throws ServiceException {

        repository.save(e);
    }

    public void update(E e) throws ServiceException {
        repository.save(e);
    }


    public Optional<E> findById(Long id) throws Exception {
        return repository.findById(id);
    }


}

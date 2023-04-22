package com.example.paymentta.service;

import com.example.paymentta.entity.Customer;
import com.example.paymentta.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService <R extends JpaRepository<E, Long> , E>{

    @Autowired
    protected  R repository;


    public E insert(E e) throws ServiceException {

        return repository.save(e);

    }

    public Customer update(E e) throws ServiceException {
        repository.save(e);
        return null;
    }


    public E findById(Long id) throws ServiceException {
        return repository.findById(id).get();
    }


}

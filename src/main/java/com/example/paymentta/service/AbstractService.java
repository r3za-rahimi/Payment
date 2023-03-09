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

    public R getRepository() {
        return repository;
    }


    //    public  E getById(Long id) throws ServiceException {
//
//        try {
//            return (E) repository.findById(id)
//                    .orElseThrow(()->new ServiceException("customer not found"));
//        } catch (Throwable e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
}

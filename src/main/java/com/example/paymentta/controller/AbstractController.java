package com.example.paymentta.controller;

import com.example.paymentta.dto.convertor.BaseConvertor;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.AbstractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AbstractController <E,D , S extends AbstractService<? extends JpaRepository<E, Long>, E> >{


    @Autowired
    protected S service;

    @Autowired
    protected BaseConvertor<D, E> converter;


    @GetMapping()
    @Transactional
    public D get(Long id) throws ServiceException {

        return converter.convertEntity( service.findById(id));
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void add(@Valid @RequestBody D d) throws ServiceException {

        service.insert(converter.convertDto(d));
    }

}

package com.example.paymentta.dto.convertor;

import com.example.paymentta.exceptions.ServiceException;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseConvertor<D, E> {

    E convertDto(D d) ;

    D convertEntity(E e);


    default List<E> convertDTo(List<D> dList) throws ServiceException{

        if (dList != null) {
            return dList.stream()
                    .map(this::convertDto).collect(Collectors.toList());

        }
        return null;

    }

    default List<D> convertEntity(List<E> dList) {

        if (dList != null) {
            return dList.stream()
                    .map(this::convertEntity).collect(Collectors.toList());
        }
        return null;

    }

}

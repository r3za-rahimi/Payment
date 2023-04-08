package com.example.paymentta.service;


import com.example.paymentta.dto.CustomerBillDto;
import com.example.paymentta.entity.CustomerBill;
import com.example.paymentta.repository.CustomerBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class CustomerBillService extends AbstractService<CustomerBillRepository, CustomerBill> {


    public CustomerBill getBill(Long number) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CustomerBill> billResponseEntity = restTemplate.getForEntity("http://localhost:8082/bill/" + number, CustomerBill.class);
        if (billResponseEntity.getStatusCode().is2xxSuccessful()) {

            repository.save(Objects.requireNonNull(billResponseEntity.getBody()));
            return billResponseEntity.getBody();
        } else {

            return null;
        }
//        return repository.findByMobileNumber(number);

    }

}

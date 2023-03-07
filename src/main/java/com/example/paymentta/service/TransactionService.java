package com.example.paymentta.service;

import com.example.paymentta.dto.TransactionDto;
import com.example.paymentta.entity.Customer;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.repository.CustomerRepository;
import com.example.paymentta.repository.TransactionRepository;

import com.example.paymentta.service.notifications.NotificationSender;
import com.example.paymentta.service.notifications.NotificationText;
import com.example.paymentta.service.notifications.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service

public class TransactionService extends AbstractService<TransactionRepository ,Transaction> {
    @Autowired
    private CustomerService customerService;
//    @Autowired
//    private TransactionRepository transactionRepository;
//
    @Autowired
    private NotificationSender notificationSender;





    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public void insert(Transaction trx) throws ServiceException {

        Customer sender = customerService.withdraw(trx.getSender().getCardNumber(), trx.getAmount());


        if (sender == null) {
            throw new ServiceException(" your balance is not enough");
        }

        Customer receiver = customerService.deposit(trx.getReceiver().getCardNumber(), trx.getAmount());

        if (receiver == null) {
            throw new ServiceException("receiver card number is not valid ");
        }

        Transaction trxEntity= new Transaction();
        trxEntity.setAmount(trx.getAmount());
        trxEntity.setReceiver(receiver);
        trxEntity.setSender(sender);
        trxEntity.setDate(new Date());

        super.getRepository().save(trxEntity);

        notificationSender.send(NotificationType.EMAIL, new NotificationText("kasr ", sender.getCardNumber(), trx.getAmount(), trxEntity.getDate()));
        notificationSender.send(NotificationType.SMS, new NotificationText("plus", receiver.getCardNumber(), trx.getAmount(), trxEntity.getDate()));



    }
//
//
//
//    public void getTransactions(String carNumber, String cardNumber2, Date start, Date end) {
//
//
////        List<Transaction> transactions = transactionRepository.findBySenderCardNumberOrRecieverCardNumberAndDateBetween(carNumber, cardNumber2, start, end);
//
////        System.out.println(transactions);
//    }
}

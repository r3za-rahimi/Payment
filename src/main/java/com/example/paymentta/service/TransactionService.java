package com.example.paymentta.service;

import com.example.paymentta.dto.OperationDto;
import com.example.paymentta.dto.TransactionDto;
import com.example.paymentta.dto.convertor.BaseConvertor;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.exceptions.ServiceException;
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

public class TransactionService extends AbstractService<TransactionRepository, Transaction> {
    @Autowired
    private AccountService accountService;
    @Autowired
    private NotificationSender notificationSender;


    @Transactional(rollbackFor = ServiceException.class)
    public void doTransaction(Transaction sender, Transaction receiver) throws ServiceException {

        accountService.withdraw(sender.getAccount(), sender.getAmount());

        accountService.deposit(receiver.getAccount(), receiver.getAmount());


        repository.save(sender);
        repository.save(receiver);


        notificationSender.send(NotificationType.SMS, new NotificationText("Deduction money from your account ", sender.getAccount().getCard().getCardNumber().toString(), sender.getAmount(), sender.getDate()));
        notificationSender.send(NotificationType.SMS, new NotificationText("addition Money to your account", receiver.getAccount().getCard().getCardNumber().toString(), receiver.getAmount(), receiver.getDate()));


    }


    public List<Transaction> transactionList(Long accountId) {
        System.out.print( repository.findByAccount_Id(accountId));
        return repository.findByAccount_Id(accountId);
    }



}

package com.example.paymentta.service;

import com.example.paymentta.entity.Customer;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.entity.account.Account;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.repository.TransactionRepository;

import com.example.paymentta.service.notifications.NotificationSender;
import com.example.paymentta.service.notifications.NotificationText;
import com.example.paymentta.service.notifications.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service

public class TransactionService extends AbstractService<TransactionRepository ,Transaction> {
    @Autowired
    private AccountService accountService;
    @Autowired
    private NotificationSender notificationSender;

    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public void insert(Transaction trx) throws ServiceException {

        Account sender = accountService.withdraw(trx.getSenderAccount(), trx.getAmount());


        if (sender == null) {
            throw new ServiceException(" your balance is not enough");
        }

        Account receiver = accountService.deposit(trx.getReceiverAccount(), trx.getAmount());

        if (receiver == null) {
            throw new ServiceException("receiver card number is not valid ");
        }




        trx.setSender(sender.getCustomer());
        trx.setReceiver(receiver.getCustomer());
        trx.setDate(new Date());
        repository.save(trx);


        notificationSender.send(NotificationType.SMS, new NotificationText("Deduction money from your account ", sender.getCard().getCardNumber().toString(), trx.getAmount(), trx.getDate()));
        notificationSender.send(NotificationType.SMS, new NotificationText("addition Money to your account", receiver.getCard().getCardNumber().toString(), trx.getAmount(), trx.getDate()));



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

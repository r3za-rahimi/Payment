package com.example.paymentta.service;

import com.example.paymentta.dto.OperationDto;
import com.example.paymentta.entity.Operation;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.entity.account.Account;
import com.example.paymentta.entity.account.DealType;
import com.example.paymentta.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OperationService {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;


    public void doTransaction(Operation operation) throws ServiceException {


        switch (operation.getType()) {

            case CARDTOCARD -> {


                Account senderAccount = accountService.getByCardNumber(operation.getSource());
                if (senderAccount == null) {

                    throw new ServiceException("invalid_Sender_CardNumber");

                }

                Transaction senderTrx = new Transaction(new Date(), senderAccount, operation.getAmount(), DealType.WITHDRAW);


                Account receiverAccount = accountService.getByCardNumber(operation.getDestination());

                if (receiverAccount == null) {

                    throw new ServiceException("invalid_receiver_CardNumber");

                }

                Transaction receiverTrx = new Transaction(new Date(), receiverAccount, operation.getAmount(), DealType.DEPOSIT);


                transactionService.doTransaction(senderTrx, receiverTrx);

            }
            case ACCOUNT_NUMBER -> {

                Account senderAccount = accountService.getByAccountNumber(operation.getSource());
                if (senderAccount == null) {

                    throw new ServiceException("invalid_Sender_AccountNumber");

                }
                Transaction senderTrx = new Transaction(new Date(), senderAccount, operation.getAmount(), DealType.WITHDRAW);
                Account receiverAccount = accountService.getByAccountNumber(operation.getDestination());
                if (receiverAccount == null) {

                    throw new ServiceException("invalid_receiver_AccountNumber");

                }

                Transaction receiverTrx = new Transaction(new Date(), receiverAccount, operation.getAmount(), DealType.DEPOSIT);

                transactionService.doTransaction(senderTrx, receiverTrx);
            }
            case SHEBA -> {

            }
            case PAYA -> {

            }
        }
    }


}

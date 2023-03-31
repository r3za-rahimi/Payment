//package com.example.paymentta.dto.convertor;//package com.example.paymentta.dto.convertor;
//
//import com.example.paymentta.dto.TransactionDto;
//import com.example.paymentta.entity.Transaction;
//import com.example.paymentta.entity.account.Account;
//import com.example.paymentta.exceptions.ServiceException;
//import com.example.paymentta.service.AccountService;
//import com.example.paymentta.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class TransactionConvertorNoMapStruct implements BaseConvertor<TransactionDto, Transaction> {
//
//    @Autowired
//    private AccountService accountService;
//
//    @Override
//    public  Transaction convertDto(TransactionDto transactionDto) throws ServiceException {
//
//        Transaction trx = new Transaction();
//
//        switch (transactionDto.getType()) {
//
//            case CARDTOCARD -> {
//
//                Account senderAccount = accountService.getByCardNumber(transactionDto.getSource());
//                Account receiverAccount = accountService.getByCardNumber(transactionDto.getDestination());
//                trx.setAmount(transactionDto.getAmount());
//                trx.setSenderAccount(senderAccount);
//                trx.setReceiverAccount(receiverAccount);
//                return trx;
//            }
//            case ACCOUNT_NUMBER -> {
//
//                Account senderAccount = accountService.getByAccountNumber(transactionDto.getSource());
//                Account receiverAccount = accountService.getByAccountNumber(transactionDto.getDestination());
//
//                trx.setSenderAccount(senderAccount);
//                trx.setReceiverAccount(receiverAccount);
//
//            }
//        }
//
//        return null;
//
//    }
//
//    @Override
//    public TransactionDto convertEntity(Transaction transaction) {
//        return null;
//    }
//
//    @Override
//    public List<Transaction> convertDTo(List<TransactionDto> transactionDtos) throws ServiceException {
//        return BaseConvertor.super.convertDTo(transactionDtos);
//    }
//
//    @Override
//    public List<TransactionDto> convertEntity(List<Transaction> dList) {
//        return BaseConvertor.super.convertEntity(dList);
//    }
//
//
//
//
//}

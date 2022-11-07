package com.aninfo.service;

import com.aninfo.model.Transaction;
import com.aninfo.model.TransactionOperation;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.DocumentEvent;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction deposit(Long cbu, Double amount){
        Transaction transaction =  new Transaction(TransactionOperation.DEPOSIT, cbu, applyPromo(amount));
        return this.transactionRepository.save(transaction);
    }

    public Transaction withdraw(Long cbu, Double amount){
        Transaction transaction = new Transaction(TransactionOperation.WITHDRAW, cbu, amount);
        return this.transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByCbu(Long cbu){
        return this.transactionRepository.findAllByBankAccountCbu(cbu);
    }

    public Optional<Transaction> getTransaction(Long transactionId){
        return this.transactionRepository.findById(transactionId);
    }

    public void deleteTransaction(Long transactionId){
        transactionRepository.deleteById(transactionId);
    }

    public Double applyPromo(Double amount){
        if (amount >= 2000){
            Double promo = amount * 0.1;
            if (promo > 500){
                promo = 500.00;
            }
            amount += promo;
        }
        return amount;
    }

}
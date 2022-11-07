package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TransactionOperation operation;

    private Long bankAccountCbu;

    private Double amount;

    public Transaction(TransactionOperation operation, Long bankAccountCbu, Double amount){
        this.operation = operation;
        this.bankAccountCbu = bankAccountCbu;
        this.amount = amount;
    }

    public Transaction(){}

    public Long getOperationId() {
        return id;
    }

    public TransactionOperation getTransactionOperation(){
        return operation;
    }

    public Double getAmount() {
        return amount;
    }

    public Long getAccountCbu() {
        return bankAccountCbu;
    }
}
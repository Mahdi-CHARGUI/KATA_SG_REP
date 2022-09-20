package bank.service.impl;

import bank.model.Account;
import bank.model.Operation;
import bank.model.OperationType;
import bank.service.AccountService;

import java.math.BigDecimal;
import java.util.Date;

public class AccountServiceImpl implements AccountService {

    @Override
    public void makeDeposit(BigDecimal amount, Account account) {
        //Amount must be positive
        if (amount.compareTo(BigDecimal.ZERO) >= 0) {
            //modify the balance
            account.setBalance(account.getBalance().add(amount));
            //set the operation
            Operation deposit = new Operation();
            deposit.setAmount(amount);
            deposit.setBalance(account.getBalance());
            deposit.setDate(new Date());
            deposit.setType(OperationType.DEPOSIT);
            account.getOperations().add(deposit);
        } else {
            throw new IllegalArgumentException("The amount of deposit must be positive");
        }
    }

    @Override
    public void makeWithdrawal(BigDecimal amount, Account account) {
//Amount must be positive
        if (amount.compareTo(BigDecimal.ZERO) >= 0) {
            //check if the client have enough balance for the amount
            if (account.getBalance().compareTo(amount)>0) {
                //modify the balance
                account.setBalance(account.getBalance().subtract(amount));
                //set the operation
                Operation withdrawal = new Operation();
                withdrawal.setAmount(amount);
                withdrawal.setBalance(account.getBalance());
                withdrawal.setDate(new Date());
                withdrawal.setType(OperationType.WITHDRAWAL);
                account.getOperations().add(withdrawal);
            }else {
                System.out.print("You do not have balance for this withdrawal");
            }
        } else {
            throw new IllegalArgumentException("The amount of withdrawal must be positive");
        }
    }
}

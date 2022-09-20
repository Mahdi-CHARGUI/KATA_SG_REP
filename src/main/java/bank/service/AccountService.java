package bank.service;

import bank.model.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.Optional;

public interface AccountService {

    void makeDeposit(BigDecimal amount, Account account);
    void makeWithdrawal(BigDecimal amount, Account account);

}

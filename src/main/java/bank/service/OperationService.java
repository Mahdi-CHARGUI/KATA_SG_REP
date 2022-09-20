package bank.service;

import bank.model.Account;
import bank.model.Operation;

import java.util.List;

public interface OperationService {

    void seeHistory(Account account);

}

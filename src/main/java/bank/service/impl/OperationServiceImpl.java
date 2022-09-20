package bank.service.impl;

import bank.model.Account;
import bank.model.Operation;
import bank.service.OperationService;

import java.util.List;

public class OperationServiceImpl implements OperationService {

    @Override
    public void seeHistory(Account account) {
        //display account name and number
        System.out.println("Name :" + account.getName() + " bank.model.Account Number : " + account.getAccountNum() + "\n Operations : ");
        //display all the operations
        for (Operation operation : account.getOperations()) {
            System.out.println(operation);
        }
    }
}

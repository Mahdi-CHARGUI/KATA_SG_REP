package bank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private String name;
    private int accountNum;
    private BigDecimal balance;
    private List<Operation> operations;

    public Account() {
        this.operations = new ArrayList<Operation>();
        this.balance = new BigDecimal(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }

}
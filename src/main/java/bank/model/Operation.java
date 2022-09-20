package bank.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Operation {
    private OperationType type;
    private Date date;
    private BigDecimal amount;
    private BigDecimal balance;

    public OperationType getType() {
        return type;
    }
    public void setType(OperationType type) {
        this.type = type;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    // override the toString method to display operations
    @Override
    public String toString() {
        return (getType().toString() + " Opertion on " + new SimpleDateFormat("dd/mm/yyyy hh:mm:ss").format(getDate()) + " of Amount: " + getAmount() + ",  Balance : " + getBalance() + "\n" );

    }
}
package manage;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import bank.service.impl.AccountServiceImpl;
import bank.service.impl.OperationServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bank.model.Account;

public class BankKataTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    OperationServiceImpl operationServiceImpl = new OperationServiceImpl();
    AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }



	/*
	 *
	 US 1:
		In order to save money
		As a bank client
		I want to make a deposit in my account

		*/

    //the balance must increase by the amount
    @Test
    public void test_deposit_with_positive_value() {
        //create account
        Account account = new Account();
        //make a deposit
        BigDecimal deposit = new BigDecimal(100);
        accountServiceImpl.makeDeposit(deposit,account);
        //test
        assertEquals(100 , account.getBalance().longValue());
    }

    // An exception must be thrown when making a deposit with a negative value
    @Test
    public void test_deposit_with_negative_value() {
        try {
            //create account
            Account account = new Account();
            //make a deposit
            BigDecimal deposit = new BigDecimal(-50);
            accountServiceImpl.makeDeposit(deposit,account);
            fail("Should throw exception when making a deposit of a negative number");
        }catch(IllegalArgumentException aExp){
            assert(aExp.getMessage().contains("The amount of deposit must be positive"));
        }
    }
	/*
	 * US 2:
		In order to retrieve some or all of my savings
		As a bank client
		I want to make a withdrawal from my account
	 */

    //the balance must decrease by the amount
    @Test
    public void test_withdrawal_with_positive_value() {
        //create account
        Account account = new Account();
        // make a deposit
        BigDecimal deposit = new BigDecimal(100);
        accountServiceImpl.makeDeposit(deposit,account);
        //make a withdrawal
        BigDecimal withdrawal = new BigDecimal(50);
        accountServiceImpl.makeWithdrawal(withdrawal,account);
        //test
        assertEquals(50 , account.getBalance().longValue());
    }

    // An exception must be thrown when making a withdrawal with a negative value
    @Test
    public void test_withdrawal_with_negative_value() {
        try {
            //create account
            Account account = new Account();
            // make a deposit
            BigDecimal deposit = new BigDecimal(100);
            accountServiceImpl.makeDeposit(deposit,account);
            //make a withdrawal
            BigDecimal withdrawal = new BigDecimal(-50);
            accountServiceImpl.makeWithdrawal(withdrawal,account);
            fail("Should throw exception when making a withdrawal of a negative number");
        }catch(IllegalArgumentException aExp){
            assert(aExp.getMessage().contains("The amount of withdrawal must be positive"));
        }
    }


    // A message must be shown in the output when the amount is greater then the balance
    @Test
    public void test_withdrawal_with_amount_greater_then_balance() {
        //create account
        Account account = new Account();
        // make a deposit
        BigDecimal deposit = new BigDecimal(100);
        accountServiceImpl.makeDeposit(deposit,account);
        //make a withdrawal
        BigDecimal withdrawal = new BigDecimal(120);
        accountServiceImpl.makeWithdrawal(withdrawal,account);
        //test
        assertEquals("You do not have balance for this withdrawal" , outContent.toString());
    }

	/*
	 * US 3:
		In order to check my operations
		As a bank client
		I want to see the history (operation, date, amount, balance) of my operations
		*/

    @Test
    public void test_history_display() {
        System.setOut(originalOut);
        //create account
        Account account = new Account();
        account.setAccountNum(123456);
        account.setName("Mark Frau");

        //performing some operations
        BigDecimal firstdeposit = new BigDecimal(100);
        accountServiceImpl.makeDeposit(firstdeposit,account);
        BigDecimal firstWithdrawal = new BigDecimal(20);
        accountServiceImpl.makeWithdrawal(firstWithdrawal,account);
        BigDecimal secondDeposit = new BigDecimal(200);
        accountServiceImpl.makeDeposit(secondDeposit,account);
        BigDecimal secondWithdrawal = new BigDecimal(180);
        accountServiceImpl.makeWithdrawal(secondWithdrawal,account);

        //display History
        operationServiceImpl.seeHistory(account);

        //test
        assertEquals(100 , account.getBalance().longValue());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}
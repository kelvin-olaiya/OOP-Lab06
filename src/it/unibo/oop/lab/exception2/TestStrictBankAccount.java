package it.unibo.oop.lab.exception2;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {
	private final int MAX_ATM_TRANSACTIONS = 10;

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         */
    	AccountHolder rossi = new AccountHolder("Mario", "Rossi", 1);
    	AccountHolder bianchi = new AccountHolder("Luigi", "Bianchi", 2);
    	BankAccount accountRossi = new StrictBankAccount(1, 10_000, MAX_ATM_TRANSACTIONS);
    	BankAccount accountBianchi = new StrictBankAccount(2, 10_000, MAX_ATM_TRANSACTIONS);
    	/*
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	/*
    	 *  WrongAccountExcetionTest
    	 */
    	try {
    		accountRossi.deposit(bianchi.getUserID(), 23);
    		Assert.fail();
    	} catch (WrongAccountHolderException e) {
    		Assert.assertNotNull(e);
    		System.out.println(e.getMessage());
    	}
    	/*
    	 *  NotEnoughFoundsExcetionTest
    	 */
    	try {
    		accountRossi.withdraw(rossi.getUserID(), 23_000);
    		Assert.fail();
    	} catch (NotEnoughFoundsException e) {
    		Assert.assertNotNull(e);
    		System.out.println(e.getMessage());
    	}
    	/*
    	 *  TransactionsOverQuotaTest
    	 */
    	try {
    		for (var i = 0; i <= MAX_ATM_TRANSACTIONS; i++) {
    			accountRossi.withdrawFromATM(rossi.getUserID(), 10);
    		}
    		accountRossi.withdrawFromATM(rossi.getUserID(), 10);
    		Assert.fail();
    	} catch (TransactionsOverQuotaException e) {
    		Assert.assertNotNull(e);
    		System.out.println(e.getMessage());
    	}
    }
}

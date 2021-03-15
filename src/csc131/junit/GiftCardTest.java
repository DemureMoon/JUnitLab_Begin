package csc131.junit;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GiftCardTest {

	@Test
	public void testGetIssuingStore() {
		
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()",issuingStore, card.getIssuingStore());
	}
	@Test
	public void getBalance() {
		double balance;
		GiftCard card;
		int issuingStore;
		double tolerance;
		
		issuingStore = 1337;
		balance = 100.00;
		tolerance = 0.001;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getbalance()", balance, card.getBalance(), tolerance);
	}
	@Test
	public void deduct_RemainingBalance() {
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		String result;
		
		result = "Remaining Balance: " + String.format("%6.2f", Math.abs(balance));
		assertEquals("deduct remaining balance", result, card.deduct(0.0));
	}
	@Test
	public void deduct_AmmountDue() {
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		String result;
		
		result = "Amount Due: " + String.format("%6.2f", 30.0);
		assertEquals("deduct 130.0 from 100.0", result, card.deduct(130.0));
	}
	@Test
	public void deduct_InvalidTransaction() {
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		String result;
		
		result = "Invalid Transaction";
		assertEquals("deduct -1.0 from 100.0", result, card.deduct(-1.0));
	}
	@Test
	public void testExpectedException() {
		Assert.assertThrows(IllegalArgumentException.class, () -> {
			new GiftCard(1, -100.00);
		});
	}
	@Test
	public void constructor_IncorrectID_Low() {
		Assert.assertThrows(IllegalArgumentException.class, () -> {
			new GiftCard(-1, -100.00);
		});
	}
	@Test
	public void constructor_IncorrectID_High() {
		Assert.assertThrows(IllegalArgumentException.class, () -> {
			new GiftCard(10000, -100.00);
		});
	}
	

}
package com.ubs.currency;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CurrencyExchangeTest {
	
	CurrencyExchange obj;
	String fileLocation; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		obj = new CurrencyExchange();
		fileLocation = "C:\\FILE.DAT";//change the location where  you are placing the ,dat file
	}

	@Test
	public final void testGetAverageAmountForLondon() throws FileNotFoundException {
		assertEquals(559.7260233777777, obj.getAverageAmount(fileLocation, "London", "A"),0.0);	
	}
	
	@Test
	public final void testGetAverageAmountForUSA() throws FileNotFoundException {
		assertEquals(0.0, obj.getAverageAmount(fileLocation, "USA", "A"),0.0);	
	}

}

package com.ubs.currency;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.ubs.currency.model.CurrencyDetails;

public class CurrencyExchange {
	
	Map<String, Map<String, Double>> groupByCountryAndCreditRatingWithAverageAmount;
	Map<String, Map<String, List<CurrencyDetails>>> groupByCountryAndCreditRating;

	public double getAverageAmount(String fileName, String countryCode, String creditRatingCode) throws FileNotFoundException {
	   Scanner read = new Scanner (new File(fileName));
	   read.useDelimiter("	");
	   int recordCounter = 0;
	   List<CurrencyDetails> list = new ArrayList<CurrencyDetails>();
	   while (read.hasNextLine()) {
		   recordCounter++;
		   String[] columns = read.nextLine().split("	");
		   if ( recordCounter == 1) continue;
		   int companyCode = columns[0] != null ? Integer.parseInt(columns[0]) : 0;
		   String account =  columns[1];
		   String city = columns[2];
		   String country = columns[3];
		   String creditRating = columns[4];
		   String currency = columns[5];
		   BigDecimal amount = columns[6] != null ? new BigDecimal(columns[6]) : new BigDecimal(0);
		   BigDecimal amountUSD =  amount;
		   BigDecimal amountEUR =  amount;
		   if ( country == null || country.trim().length() == 0) country = city;
		   switch(currency) {
		   case "GBP": 
			   		amountUSD = amountUSD.multiply(new BigDecimal(1.654));
		   			amountEUR = amountUSD.divide(new BigDecimal(1.35), RoundingMode.CEILING);
		   			break;
		   case "CHF":
			   		amountUSD = amountUSD.multiply(new BigDecimal(1.10));
			   		amountEUR = amountUSD.divide(new BigDecimal(1.35), RoundingMode.CEILING);
			   		break;
		   default:
			   		amountUSD = amount;
			   		amountEUR = amount;
			   		break;	
		   }
		   
		   double doubleEUR = amountEUR.doubleValue();
		   CurrencyDetails currencyObj = new CurrencyDetails(companyCode, account, city, country, creditRating, currency, amount,amountUSD, amountEUR, doubleEUR);
		   list.add(currencyObj);
        }
	   //this is only for checking the full list
       groupByCountryAndCreditRating = list.
         stream().
           collect(
                Collectors.
                    groupingBy(
                    		CurrencyDetails::getCountry,
                        Collectors.
                            groupingBy(
                            		CurrencyDetails::getCreditRating
                                      )
                               )
                 );
	   
	   
       groupByCountryAndCreditRatingWithAverageAmount = list.
         stream().
           collect(
                Collectors.
                    groupingBy(
                    		CurrencyDetails::getCountry,
                        Collectors.
                            groupingBy(
                            		CurrencyDetails::getCreditRating,
                            		Collectors.averagingDouble(CurrencyDetails::getAmountDoubleEUR)
                                      )
                               )
                 );
	   //only for testing
	   //System.out.println(groupByCountryAndCreditRatingWithAverageAmount.get("IND").get("Aaa+"));
	   //System.out.println(groupByCountryAndCreditRating.get("London").get("A"));
       read.close();
       return getAverageAmount(countryCode, creditRatingCode);
	}
	
	public double getAverageAmount(String country, String creditRating) {
		double val;
		try {
			val = groupByCountryAndCreditRatingWithAverageAmount.get(country).get(creditRating);
		}
		catch (Exception e) {
			val= 0.0;
		}
		System.out.println("Country : "+country+"\t  || 	Average Amount : "+val);
		return val;
	}
}

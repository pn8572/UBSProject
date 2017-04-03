Currency Exchange program

Download the project to local file. Setup the maven repository or simply create java project for testing
Assumption :
=============

The FILE.DAT file is placed at C:\\   directly. 
i.e C:\\FILE.DAT

Java version 1.8

Sample output from maven build :

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.ubs.currency.CurrencyExchangeTest
Country : London          ||    Average Amount : 559.7260233777777
Country : USA             ||    Average Amount : 0.0
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.493 sec

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

The average amount is calculated after grouped by Country and Credit Rating.  
Where a country is not available, the city used instead.

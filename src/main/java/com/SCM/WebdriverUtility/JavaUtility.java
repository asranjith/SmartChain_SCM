package com.SCM.WebdriverUtility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

import io.netty.util.internal.ThreadLocalRandom;

public class JavaUtility {
	
   public String getSystemTime() {
	   return LocalDateTime.now().toString().replace(':', '-');
   }
   
   public int getRandomNumber() {
 	  Random random = new Random();
 	  int num = random.nextInt(500);
 	  return num;
   }
   public int getRandomAreaCode() {
	 	  Random random = new Random();
	 	 int randomCode = 560000 + random.nextInt(10000);
	 	  return randomCode;
	   }
   public String getRandomPhoneNumber() {
	 	 int firstDigit = ThreadLocalRandom.current().nextInt(6, 10);
	 	long remainingDigits = ThreadLocalRandom.current().nextLong(100000000L, 1000000000L);
	 	String phoneNumber = firstDigit + String.valueOf(remainingDigits);
	 	  return phoneNumber;
	   }
   
   public String getSystemDatedd_MM_yyyy() {
 	  Date dateobj = new Date();
 	  SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
 	  String date = sim.format(dateobj);
 	  return date;
   }
}

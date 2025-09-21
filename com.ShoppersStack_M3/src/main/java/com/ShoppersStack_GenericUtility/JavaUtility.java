package com.ShoppersStack_GenericUtility;

import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {

	public String localDateAndTime() {

		String value = LocalDateTime.now().toString().replace("-", "").replace(":", "").replace(".", "");
		return value;

	}

	public int generateRandomNumber() {

		Random r = new Random();
		int num = r.nextInt(1000);
		return num;

	}

}

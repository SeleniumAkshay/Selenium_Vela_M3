package com.ShoppersStack_GenericUtility;

public interface FrameWorkConstants {

	JavaUtility javaUtility = new JavaUtility();

	static final String propertyPath = "./src/test/resources/testData/shopperData.properties";

	static final String excelPath = "./src/test/resources/testData/shopperData.xlsx";

	static final String screenshotPath = "./screenshot/" + javaUtility.localDateAndTime() + ".png";

	static final String reportPath = "./reports/" + javaUtility.localDateAndTime() + ".html";

}

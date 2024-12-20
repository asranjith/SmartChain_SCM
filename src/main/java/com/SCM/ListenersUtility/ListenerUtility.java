package com.SCM.ListenersUtility;

import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.SCM.Basetest.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenerUtility extends BaseClass implements ITestListener, ISuiteListener{
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Report cofiguration", true);
		String date = LocalDateTime.now().toString().replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReport/report_" + date + ".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window-11");
		report.setSystemInfo("BROWSER", "CHROME-118.0.5993.71");
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("Report bachup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() + ">=========start==========>");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName() + "==> STARTED <==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		Reporter.log(result.getMethod().getMethodName() + ">=========success==========>");
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName() + "==> COMPLETED <==");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		//String methodName=result.getName();
		Reporter.log(testMethodName + ">=========failure==========>");
		String date = LocalDateTime.now().toString().replace(":", "_");
		TakesScreenshot efWebDriver = (TakesScreenshot) BaseClass.sdriver;
		String filepath = efWebDriver.getScreenshotAs(OutputType.BASE64);
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filepath, testMethodName + "_" + date);
		UtilityClassObject.getTest().log(Status.FAIL, testMethodName);
		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() + ">=========skipped==========>");
		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());
	}

}

package com.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listner1 implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+"--test started");
		test=report.createTest(MethodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		
		String MethodName = result.getMethod().getMethodName();
		//System.out.println(MethodName+"--test passed");
		test.log(Status.PASS, MethodName+"--test passed");
		String ScreenShotName = MethodName+"--"+jutil.getSystemDateInFormat();
		try {
			 wutil.screnShoot(BaseClass.sDriver, ScreenShotName);
			 test.addScreenCaptureFromPath(ScreenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String MethodName = result.getMethod().getMethodName();
		//System.out.println(MethodName+"--test fail");
		test.log(Status.FAIL,MethodName+"--test fail");
		test.log(Status.INFO, result.getThrowable());
		JavaUtility jutil=new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		String ScreenShotName = MethodName+jutil.getSystemDateInFormat();
		try {
			 wutil.screnShoot(BaseClass.sDriver, ScreenShotName);
			test.addScreenCaptureFromPath(ScreenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String MethodName = result.getMethod().getMethodName();
		//System.out.println(MethodName+"--test skipped");
		test.log(Status.SKIP, MethodName+"--test skipped");
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		String ScreenShotName = MethodName+"--"+jutil.getSystemDateInFormat();
		try {
			 wutil.screnShoot(BaseClass.sDriver, ScreenShotName);
			test.addScreenCaptureFromPath(ScreenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite execution started");
		ExtentSparkReporter htmlreport= new ExtentSparkReporter(".\\ExtentReports\\report-"+new JavaUtility().getSystemDateInFormat());
		htmlreport.config().setDocumentTitle("prohect01Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("project 100 ");
		
		 report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("BaseUrl", "https:google.com");
		report.setSystemInfo("BaseBrowser", "firefox");
		report.setSystemInfo("ReporterName", "Toshif");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite execution stopped");
		report.flush();
		
	}
	

}

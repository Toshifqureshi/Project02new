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

public class Listners implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+"--"+ "Test Script Execution Started");
		test=report.createTest(MethodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		JavaUtility jutil=new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		String MethodName = result.getMethod().getMethodName();
		
		//System.out.println(MethodName+"--"+"Test sucessful");
		
		test.log(Status.PASS,MethodName+"--"+"Test sucessful" );
		
		String ScreenShotName = MethodName+"--"+jutil.getSystemDateInFormat();
		try {
			String path = wutil.screnShoot(BaseClass.sDriver, ScreenShotName);
			test.addScreenCaptureFromPath(ScreenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		JavaUtility jutil=new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		String MethodName = result.getMethod().getMethodName();
		//System.out.println(MethodName+"--"+"Test Fail");
		test.log(Status.FAIL, MethodName+"--"+"Test Fail");
		test.log(Status.INFO, result.getThrowable());
		String ScreenShotName = MethodName+"--"+jutil.getSystemDateInFormat();
		try {
			String path = wutil.screnShoot(BaseClass.sDriver, ScreenShotName);
			test.addScreenCaptureFromPath(ScreenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		JavaUtility jutil=new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		String MethodName = result.getMethod().getMethodName();
		//System.out.println(MethodName+"--"+"Test Skipped");
		test.log(Status.SKIP, MethodName+"--"+"Test Skipped");
		
		String ScreenShotName = MethodName+"--"+jutil.getSystemDateInFormat();
		try {
			String path = wutil.screnShoot(BaseClass.sDriver, ScreenShotName);
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
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat());
		htmlreport.config().setDocumentTitle("Project01 execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("PROJECT01 EXECUTION");
		
		report= new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("BaseUrl", "https://localhost:8888");
		report.setSystemInfo("BaseBrowser", "Firefox");
		report.setSystemInfo("ReporterName", "Toshif");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite execution finished");
		report.flush();
		
	}
	
	
	

}

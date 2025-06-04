package utilities;



import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.BaseTest;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String reportName;


	public void onStart(ITestContext context) {

		//sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/"+reportName);


		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // e.g., 2025.05.20.14.32.10
		reportName = "myreport_" + timeStamp + ".html";
		String reportPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + reportName;

		sparkReporter = new ExtentSparkReporter(reportPath);



		sparkReporter.config().setDocumentTitle("Automation Testing");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);

		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Computer name ", "Local host");
		extent.setSystemInfo("Application","Automation Exercise");
		extent.setSystemInfo("Enviroment", "QA");
		extent.setSystemInfo("Sub module","Customers");
		extent.setSystemInfo("Tester name", "salman malik");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Environment", "QA");


		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);

		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);

		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}


	}


	public void onTestSuccess(ITestResult result) {

		test=extent.createTest(result.getTestClass().getName()); // create a new entry in the report (class name)
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName()+"Got successfull executed");  //update status

	}

	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName()); // create a new entry in the report
		test.assignCategory(result.getMethod().getGroups());

		test.log(Status.FAIL,result.getName()+"got failed");  //update status
		test.log(Status.INFO,result.getThrowable().getMessage());  //throwable

		try {
			String imgPath=new BaseTest().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		test=extent.createTest(result.getTestClass().getName()); // create a new entry in the report
		test.assignCategory(result.getMethod().getGroups());      //Groups name 

		test.log(Status.SKIP,result.getName()+"got Skipped");  //update status
		test.log(Status.INFO,result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext context) {
		extent.flush();

		String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + reportName;
		File extentReport =new File(pathOfExtentReport);
		if (extentReport.exists()) {
			try {
				Desktop.getDesktop().browse(extentReport.toURI());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Report file not found: " + pathOfExtentReport);
		}



		//for email

//		try {
//
//			@SuppressWarnings("deprecation")
//			URL url = new URL("file:///"+System.getProperty("user.dir")+".\\reports\\" + reportName); 
//			// Create the email message 
//			ImageHtmlEmail email = new ImageHtmlEmail(); 
//			email.setDataSourceResolver(new DataSourceUrlResolver(url)); 
//			email.setHostName("smtp.googlemail.com"); 
//			email.setSmtpPort(587); 
//			email.setAuthenticator(new DefaultAuthenticator("salmanmalik2116@gmail.com", "Malik@1234")); 
//			email.setSSLOnConnect(true); 
//			email.setStartTLSEnabled(true);
//			email.setFrom("salmanmalik2116@gmail.com"); //Sender 
//			email.setSubject("Test Results"); 
//			email.setMsg("Please find Attached Report...."); 
//			email.addTo("mr77655026@gmail.com"); //Receiver 
//			email.attach(url, "extent report", "please check report..."); 
//			email.send(); // send the email 
//		} 
//		catch(Exception e){
//			e.printStackTrace(); 
//
//
//		}


	}



}





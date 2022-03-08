package utilities;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import freemarker.template.SimpleDate;

public class Reporting extends TestListenerAdapter {
	
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest logger;
	
	public void onTestStart(ITestResult tr)
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName="DTT"+timeStamp+".html";
		
		spark=new ExtentSparkReporter("./test-output/"+reportName);
		extent=new ExtentReports();
		extent.attachReporter(spark);
		
		spark.config().setDocumentTitle("Data Driven Testing");
		
		System.out.println("Test Started");
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, "Test Pass");
		extent.flush();
		
		
	}
	public void onTestFailure(ITestResult tr)
	{
		System.out.println("Test Failure");
	}
	
	

}

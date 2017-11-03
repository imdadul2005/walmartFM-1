package walmartHomePage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import common.base;

public class Listener implements ITestListener{
base b = new base();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("(yyMMddHHmmssZ)");
        Date date = new Date();
        df.format(date);
        
        
		try {
			b.takeScreenShot("Pass_"+result.getName()+  df.format(date));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("(yyMMddHHmmssZ)");
        Date date = new Date();
        df.format(date);
        
		try {
			b.takeScreenShot("Fail_"+result.getName()+df.format(date));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}

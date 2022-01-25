package com.actime.genericlibrary;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImp extends BaseClass implements ITestListener {
	

		@Override
		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTestFailure(ITestResult result) {
			String tcName = result.getName();
			TakesScreenshot t=(TakesScreenshot) driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			File dest=new File("./ScreenShot/"+tcName+".png");
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				
			}
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

}

package com.actime.genericlibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImp  implements ITestListener {
	

	

		public void onTestFailure(ITestResult result) {
			String tcName = result.getName();
			TakesScreenshot driver=null;
			TakesScreenshot t=(TakesScreenshot) driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			File dest=new File("./ScreenShot/"+tcName+".png");
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				
			}
		}

		
}

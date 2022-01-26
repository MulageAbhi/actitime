package customer;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actime.genericlibrary.FileLibrary;

import objectRepository.EnterTimeTrackPage;
import objectRepository.TaskListPage;

@Listeners(com.actime.genericlibrary.ListImp.class)
public class CustomerModule {

	@Test
	public void testCreateCustomer() throws  EncryptedDocumentException, IOException, InvalidFormatException {
		Reporter.log("CreateCustomer",true);
		FileLibrary f=new FileLibrary();
		String custName = f.getExcelData("CreateCustomer", 1, 2);
		String custDescrpt = f.getExcelData("CreateCustomer", 1, 3);
		WebDriver driver=null;
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.clickTaskTab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustomerOption().click();
		t.getEnterCustNameTbx().sendKeys(custName);
		t.getEnterCustDescTbx().sendKeys(custDescrpt);
		t.getSelectCustDD().click();
		t.getOurCompanyOption().click();
		t.getCreateCustomerBtn().click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustCreated(), custName));
		String actualCustText = t.getActualCustCreated().getText();
		Assert.assertEquals(actualCustText, custName);
	}


}

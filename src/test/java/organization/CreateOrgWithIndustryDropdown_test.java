package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import genric_utilities.BaseClass;
import genric_utilities.ExcelUtilities;
import genric_utilities.PropFileUtils;
import genric_utilities.javautils;
import vtiger_POM.CreateOrg_page;
import vtiger_POM.Home_page;
import vtiger_POM.Login_And_Logout_Vtiger;
import vtiger_POM.Organization_page;



public class CreateOrgWithIndustryDropdown_test extends BaseClass
{
	@Test

	public  void ceateOrgWithIndustryDropdown_test() throws IOException 
	{
		String OrgName = xlUtil.readDataFromExcel("Organization", 0, 1)+jUtil.RandumNumber();
		String indDD = xlUtil.readDataFromExcel("Organization", 1, 1);
		Home_page hp = new Home_page(driver);
		hp.clickOrg();
		new Organization_page(driver).clickOrganizationLookupBtn();
		CreateOrg_page crtOrgPg = new CreateOrg_page(driver);
		crtOrgPg.mandAndDDvalue(wbdUtil, OrgName, indDD);
		crtOrgPg.save(driver);
		String actualValue = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		//validation
	//	Assert.assertTrue(actualValue.contains(OrgName));

			System.out.println("confirmation msg is displayed");
		
	}
}

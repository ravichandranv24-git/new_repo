package organization;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import genric_utilities.BaseClass;
import vtiger_POM.CreateOrg_page;
import vtiger_POM.Home_page;
import vtiger_POM.Organization_page;

public class CreateOrgWithMandatoryFields_test extends BaseClass
{
	@Test
	public void createOrgWithMandatoryFields_test() throws EncryptedDocumentException, IOException 
	{
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notification");
//		//create random num
//		Random ran = new Random();
//		int random = ran.nextInt();// to avoid duplicate value.
//	
//		
////		Launch the Application 
//		WebDriver driver=new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.get("http://localhost:8888");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////		Login to the Application 
//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("admin");
//		driver.findElement(By.id("submitButton")).click();
//		Click on 'ORGANIZATIONS' link 
	//	driver.findElement(By.xpath("//a[contains(.,'Organizations')]/parent::td[@align='center']")).click();
		Home_page hp = new Home_page(driver);
		hp.clickOrg();
//		"Click on 'Create Organization' lookup button"
		Organization_page orgPg = new Organization_page(driver);
		orgPg.clickOrganizationLookupBtn();
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		Enter mandatory fields with valid data
		String orgName = xlUtil.readDataFromExcel("Organization", 0, 1)+jUtil.RandumNumber();
		String indDD = xlUtil.readDataFromExcel("Organization", 1, 1);
		CreateOrg_page creatOrgPg = new CreateOrg_page(driver);
		creatOrgPg.mandAndDDvalue(wbdUtil, orgName, indDD);
		//driver.findElement(By.name("accountname")).sendKeys("Keera Bonda");
		
//		Click on'Save' button
		creatOrgPg.save(driver);
		//driver.findElement(By.xpath("//input[@name='button' and @value='  Save  ' ]")).click();

		
	}
}

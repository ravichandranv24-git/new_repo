package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import vtiger_POM.Login_And_Logout_Vtiger;

public class RestoringDeletedOrg_test 
{
	@Test
	public  void restoringDeletedOrg_test() throws IOException 
	{
		WebDriver driver=null;
		//fetching data from property file
		FileInputStream fis = new FileInputStream("./src/test/resources/files/commonfile.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String Browser = prop.getProperty("browser");
		String Url = prop.getProperty("url");
		String UN = prop.getProperty("username");
		String PWD = prop.getProperty("password");
		

		//		Login to application 
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		if(Browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();// maximize the window.
		driver.get(Url);//launching the application.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Synchronization
		Login_And_Logout_Vtiger vpom = new Login_And_Logout_Vtiger(driver);
		vpom.login(UN, PWD);

		//		click on 'More' dropdown and click on 'Recycle Bin' link
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.xpath("//a[text()='Recycle Bin']")).click();
		

		//		Click on 'check box'
		String expecteddata="	Keera Bonda354";
		driver.findElement(By.xpath("//a[text()='"+expecteddata+"']/../preceding-sibling::td/input[@name='selected_id']")).click();

		// click on restore button
		driver.findElement(By.xpath("//input[@value='Restore' and @type='button']")).click();
		
		//		Click on ok button in Alert popup
		driver.switchTo().alert().accept();
		
		//logout
		vpom.signOut(driver);
		
	}

}

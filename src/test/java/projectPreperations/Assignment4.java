package projectPreperations;

import java.time.Duration;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
 
import org.openqa.selenium.OutputType;
 
import org.openqa.selenium.TakesScreenshot;
 
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment4 {
	static WebDriver driver=null;
		public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//hyperlink();
		//checkbox();
		//userregistration();
		//checksignin();
			screenshot();
	}
	public static void hyperlink() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Nandi/eclipse-workspace/Assignments/src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div/h1/a")).click();
		driver.findElement(By.id("benzradio")).click();
		driver.findElement(By.id("benzcheck")).click();
		Assert.assertTrue(driver.findElement(By.id("benzcheck")).isSelected());
		Thread.sleep(2000);
		driver.close();
	}
	public static void checkbox() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Nandi/eclipse-workspace/Assignments/src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)","");
		driver.findElement(By.id("female")).click();
		driver.findElement(By.id("tuesday")).click();
		Assert.assertTrue(driver.findElement(By.id("tuesday")).isSelected());
		driver.findElement(By.id("friday")).click();
		Assert.assertTrue(driver.findElement(By.id("friday")).isSelected());
		Thread.sleep(2000);
		driver.close();
		
	}
	public static void userregistration() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Nandi/eclipse-workspace/Assignments/src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.className("login")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,0500)", "");
		driver.findElement(By.id("email_create")).sendKeys("anit3@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("id_gender2")));
		driver.findElement(By.id("id_gender2")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("abcd");
		driver.findElement(By.id("customer_lastname")).sendKeys("ABCD");
		driver.findElement(By.id("passwd")).sendKeys("xyz@123");
		js.executeScript("window.scrollBy(0,0300)", "");
		WebElement staticdropdown= driver.findElement(By.id("days"));
		Select day= new Select(staticdropdown);
		day.selectByIndex(12);
		WebElement staticdropdown2= driver.findElement(By.id("months"));
		Select month= new Select(staticdropdown2);
		month.selectByIndex(04);
		WebElement staticdropdown3= driver.findElement(By.id("years"));
		Select year= new Select(staticdropdown3);
		year.selectByIndex(26);
		driver.findElement(By.xpath("//input[@name='newsletter']")).click();
		driver.findElement(By.id("firstname")).sendKeys("abcd");
		driver.findElement(By.id("lastname")).sendKeys("ABCD");
		driver.findElement(By.id("company")).sendKeys("riddle");
		js.executeScript("window.scrollBy(0,0400)", "");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("bharat lanes");
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("bldg43");
		driver.findElement(By.id("city")).sendKeys("naker");
		WebElement staticdropdown4= driver.findElement(By.id("id_state"));
		Select state= new Select(staticdropdown4);
		state.selectByIndex(26);
		js.executeScript("window.scrollBy(0,0400)", "");
		driver.findElement(By.id("postcode")).sendKeys("12345");
		driver.findElement(By.id("phone")).sendKeys("123456781");
		driver.findElement(By.id("submitAccount")).click();
		}
		public static void checksignin() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:/Users/Nandi/eclipse-workspace/Assignments/src/test/resources/driver/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://automationpractice.com/index.php");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//a[@class='login']")).click();
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,0400)", "");
			driver.findElement(By.id("email_create")).sendKeys("anit3@gmail.com");
			driver.findElement(By.id("SubmitCreate")).click();
			Thread.sleep(2000);
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			 // now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\Nandi\\.p2/error.png"));
			}
			 
			catch (IOException e)
			 {
			  System.out.println(e.getMessage());
			 
			 }

			
		}
		public static void screenshot() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:/Users/Nandi/eclipse-workspace/Assignments/src/test/resources/driver/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://automationpractice.com/index.php");
			driver.manage().window().maximize();
			driver.findElement(By.className("login")).click();
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,0400)", "");
			driver.findElement(By.id("email")).sendKeys("anita@gmail.com");
			driver.findElement(By.id("passwd")).sendKeys("xyz@123");
			driver.findElement(By.id("SubmitLogin")).click();
			Thread.sleep(2000);
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			 // now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\Nandi\\.p2/error.png"));
			}
			 
			catch (IOException e)
			 {
			  System.out.println(e.getMessage());
			 
			 }
			Thread.sleep(2000);
			driver.close();
		}
}

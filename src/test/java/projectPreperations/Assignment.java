package projectPreperations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nandi\\eclipse-workspace\\Assignments\\src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dsportalapp.herokuapp.com/");
		driver.manage().window().maximize();
		driver.navigate().back();
		driver.navigate().forward();
		driver.findElement(By.xpath("//button[@class='btn']")).click();
		driver.findElement(By.xpath("//ul/a[2]")).click();
		driver.findElement(By.id("id_username")).sendKeys("anita1");
		driver.findElement(By.id("id_password1")).sendKeys("Horse@182");
		driver.findElement(By.id("id_password2")).sendKeys("Horse@182");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		System.out.println("successful registration");
		//driver.close();
	
	}

}

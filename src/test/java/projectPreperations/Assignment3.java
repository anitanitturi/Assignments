package projectPreperations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
	static WebDriver driver=null;
	static {
		System.setProperty("webdriver.chrome.driver","C:/Users/Nandi/eclipse-workspace/Assignments/src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dsportalapp.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.className("btn")).click();
		driver.findElement(By.xpath("//ul/a[3]")).click();
	}
	  public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//login();
		//loginwithincorrectusername();
		//invalidpassword();
		invalidusernamepassword();
	}
		public static void login() throws InterruptedException {
		
		
		driver.findElement(By.id("id_username")).sendKeys("anita1");
		driver.findElement(By.id("id_password")).sendKeys("Horse@182");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		driver.close();
	}
    public static void loginwithincorrectusername() {
    	driver.findElement(By.id("id_username")).sendKeys("sedgdg");
    	driver.findElement(By.xpath("//input[@value='Login']")).click();
    	System.out.println("incorrectusername");
    	
    }
    public static void invalidpassword() {
    	driver.findElement(By.id("id_username")).sendKeys("anita1");
		driver.findElement(By.id("id_password")).sendKeys("Horse@184");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("invalidpassword");
    	
    }
    public static void invalidusernamepassword() {
    	driver.findElement(By.id("id_username")).sendKeys("anita123");
		driver.findElement(By.id("id_password")).sendKeys("Horse@18423");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("invalid username and password");
    
}
}

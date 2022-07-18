package projectPreperations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class MouseOperations {
	   static WebDriver driver=null;
       public static void main(String[] args) {
		// TODO Auto-generated method stub
    	   BM();
    	   searchproduct();
    	  // addtocart();
	}
       	@BeforeMethod
       	public static void BM() {
       		System.setProperty("webdriver.chrome.driver","C:/Users/Nandi/eclipse-workspace/Assignments/src/test/resources/driver/chromedriver.exe");
       		driver=new ChromeDriver();
       		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       		driver.get("http://automationpractice.com/index.php");
       		driver.manage().window().maximize();
       		}
       	public static void searchproduct() {
       		Actions a=new Actions(driver);
       		a.moveToElement(driver.findElement(By.xpath("//a[@title='Women']"))).build().perform();
       		driver.findElement(By.xpath("//li[1]/a[@title='T-shirts']")).click();
       		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,0800)", "");
       		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
       		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@itemprop='name']")));
       		String dress= driver.findElement(By.xpath("//h5[@itemprop='name']")).getText();
       		System.out.println(dress);
       		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,0800)", "");
       		driver.findElement(By.id("search_query_top")).sendKeys("Faded Short Sleeve T-shirts");
       		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
       		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,0300)", "");
       		String expectedDress="Faded Short Sleeve T-shirts";
       		if(dress.equals(expectedDress)) {
       			System.out.println("pass");
       		}
       		else {
       			System.out.println("fail");
       		}
       		driver.close();
       		
       		
       		
       		
       	}
       	public static void addtocart() {
       		Actions a=new Actions(driver);
       		a.moveToElement(driver.findElement(By.xpath("//a[@title='Women']"))).build().perform();
       		driver.findElement(By.xpath("//li[1]/a[@title='T-shirts']")).click();
       		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,0800)", "");
       		a.moveToElement(driver.findElement(By.xpath("//h5[@itemprop='name']"))).build().perform();
       		driver.findElement(By.xpath("//a[@title='Add to cart']")).click();
       		WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
       		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-default button button-medium']"))).click();
       		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,0)", "");
       		String Text= driver.findElement(By.id("summary_products_quantity")).getText();
       		System.out.println(Text);
       		driver.close();
       		
       		
       		//driver.findElement(By.linkText("Faded Short Sleeve
       		
       	}
}

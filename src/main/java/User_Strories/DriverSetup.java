package User_Strories;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DriverSetup {
	
	public static WebDriver driver;
	public static WebElement element;
	@Test
    public static void main() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--disable-notifications");
	driver = new ChromeDriver(opt);
	driver.manage().window().maximize();
	driver.get("https://pratesting.cognizant.com/");
	Thread.sleep(60000);
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.className("left_menu_icon_overlay"))).build().perform();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.linkText("CFO_Onsite")).click();
	Actions act1 = new Actions(driver);
	act1.moveToElement(driver.findElement(By.id("LOCK_Execute"))).build().perform();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("LOCK_User_Stories")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("KEY_BUTTON_Add-btnIconEl")).click();
	driver.switchTo().frame("contentframe");
	driver.findElement(By.xpath("//input[@id='_Text_Check_CM_Name']")).sendKeys("hari");
	driver.findElement(By.id("DN_Description")).sendKeys("hari");
	driver.findElement(By.id("cal_CM_DUEDATE")).click();
	Select month=new Select(driver.findElement(By.className("ui-datepicker-month")));
	month.selectByVisibleText("Jun");
	Select year=new Select(driver.findElement(By.className("ui-datepicker-year")));
	year.selectByVisibleText("2021");
	driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/table/tbody/tr[3]/td[7]")).click();
	Select card=new Select(driver.findElement(By.id("AG_CARDOWNER")));
	card.selectByVisibleText("Hariharan R (909175)");
	
	
	
	
	
	
    }
}

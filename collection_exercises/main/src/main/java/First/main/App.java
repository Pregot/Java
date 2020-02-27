package First.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Hello world!
 *
 */
public class App {
	WebDriver driver = new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public static void homepage() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		goToRegisterForm(driver, js);
		registerForm(driver, js);
		accountSettings(driver, js);
	}

	public static void goToRegisterForm(WebDriver driver, JavascriptExecutor js) {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//*[@id=\"email_create\"]")).click();
//		driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("adminas354154n@gmail.com");
		driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
	}

	public static void registerForm(WebDriver driver, JavascriptExecutor js) {
		driver.get(
				"http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		js.executeScript("window.scrollBy(0,10)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement checkbox = driver.findElement(By.id("id_gender1"));
		checkbox.click();
		driver.findElement(By.id("customer_firstname")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Jonas");
		driver.findElement(By.id("customer_lastname")).click();
		driver.findElement(By.id("customer_lastname")).sendKeys("Jonaitis");
		driver.findElement(By.cssSelector("#passwd")).click();
		driver.findElement(By.cssSelector("#passwd")).sendKeys("!@$#G85");
		js.executeScript("window.scrollBy(0,25)");
		Select years = new Select(driver.findElement(By.id("years")));
		years.selectByVisibleText("-");
		years.selectByIndex(40);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByVisibleText("-");
		months.selectByIndex(7);
		Select days = new Select(driver.findElement(By.id("days")));
		days.selectByVisibleText("-");
		days.selectByValue("20");
		WebElement checkBoxForNewsLetter = driver.findElement(By.id("uniform-newsletter"));
		checkBoxForNewsLetter.click();
		WebElement checkBoxForUniform = driver.findElement(By.id("uniform-optin"));
		checkBoxForUniform.click();
		js.executeScript("window.scrollBy(0,50)");
		driver.findElement(By.id("company")).click();
		driver.findElement(By.id("company")).sendKeys("JavaPanda");
		driver.findElement(By.id("address1")).click();
		driver.findElement(By.id("address1")).sendKeys("732  Edsel Road");
		driver.findElement(By.id("address2")).click();
		driver.findElement(By.id("address2")).sendKeys("Edsel Road Flat 5");
		driver.findElement(By.id("city")).click();
		driver.findElement(By.id("city")).sendKeys("North Hollywood");
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("California");
		driver.findElement(By.id("postcode")).click();
		driver.findElement(By.id("postcode")).sendKeys("91605");
		driver.findElement(By.id("phone")).click();
		driver.findElement(By.id("other")).click();
		driver.findElement(By.id("other")).sendKeys("words");
		driver.findElement(By.id("phone")).sendKeys("8698554822");
		driver.findElement(By.id("phone_mobile")).click();
		driver.findElement(By.id("phone_mobile")).sendKeys("88463846846");
		driver.findElement(By.id("alias")).click();
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("Road Flat 5");
		driver.findElement(By.id("submitAccount")).click();
	}

	public static void accountSettings(WebDriver driver, JavascriptExecutor js) {
		driver.get("http://automationpractice.com/index.php?controller=my-account");
		js.executeScript("window.scrollBy(0,50)");
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a")).click();

	}
}

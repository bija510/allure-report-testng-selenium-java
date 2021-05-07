package demo_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({AllureListener.class})
public class RegisterTest extends BaseClass{

	public WebDriver driver;
	static String url = "http://demo.automationtesting.in/Register.html";
	
	@BeforeClass
	public void setUp() {
		BaseClass bs= new BaseClass();
		driver = bs.initialize_driver();
		driver.get(url);
	}
	
	@Test(priority = 1, description = "verify the url of the landing page")
	@Description("verify the url of the landing page") // This annotation is from Allure report
	@Epic("Registration")
	@Feature("register user")
	@Story("validate application url")
	@Step("verify landed to right application url")
	@Severity(SeverityLevel.CRITICAL)
	public void validateURL() {
		Assert.assertEquals(url, driver.getCurrentUrl());
	}
	
	
	@Test(priority = 2, description = "Verify the title of the page")
	@Description("verify the title of the landing page") // This annotation is from Allure report
	@Epic("Registration")
	@Feature("register user")
	@Story("validate application title")
	@Step("verify the title of the page")
	@Severity(SeverityLevel.MINOR)
	public void validateTitle() {
		String actualTitle = "Register";
		String expTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expTitle);
		
	}
	

	@Test(priority = 3, description = "Verify the firstName field")
	@Description("verify the first name text field") // This annotation is from Allure report
	@Epic("Registration")
	@Feature("register user")
	@Story("validate first name text box")
	@Step("verify first name text box attribute")
	@Severity(SeverityLevel.TRIVIAL)
	public void validateFirstName() {
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.sendKeys("David");
		Assert.assertEquals("David", firstName.getAttribute("value"));
	}
	
	@Test(priority = 4, description = "Verify the radio button functionality")
	@Description("Verify the radio button functionality") // This annotation is from Allure report
	@Epic("Registration")
	@Feature("register user")
	@Story("validate male radio button")
	@Step("verify male radio button selected")
	@Severity(SeverityLevel.BLOCKER)
	public void validateRadiobtnCheck() {
		WebElement maleRadioBtn = driver.findElement(By.xpath("//input[@value='Male']"));
		maleRadioBtn.click();
		Assert.assertFalse(maleRadioBtn.isSelected());
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null;
	}
	
}

package bot.conduit.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Test_01_Challenges extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	
		username  = "levancu190296" + generateFakeNumber();
	    emailAddress = "levancu" + generateFakeNumber()+ "@gmail.com";
	    validPassword = "123abc";
	    incorrectPassword = "abc123";
	    invalidEmail = "invalidemail@gmail.com";
	}	
	
	@Test
	public void User_01_Register() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToUserName(username);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(validPassword);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isMyAccountPageDisplayed());
		registerPage.clickToSettingButton();
		homePage = registerPage.clickToLogout();
	}
	
	@Test
	public void User_02_Login() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(invalidEmail);
		loginPage.inputToPasswordTextBox(incorrectPassword);
		loginPage.clickToLoginButton();
		String aaa = loginPage.getErrorMessage();
		System.out.println(aaa);
		Assert.assertEquals(loginPage.getErrorMessage(), "email or password is invalid");
	}

  
	@AfterClass	
	public void afterClass() {
		driver.quit();
	}
	
	public int generateFakeNumber() {
		Random rand = new Random();
		int number = 100000;
		return rand.nextInt(number);
	}

	//###################-START-DECLARE-######################
	private WebDriver driver;
	private String username,emailAddress,validPassword,invalidEmail,incorrectPassword;
	private RegisterPageObject registerPage ;
	private HomePageObject homePage ;
	private LoginPageObject loginPage;
	//###################-END-DECLARE-######################
	
}

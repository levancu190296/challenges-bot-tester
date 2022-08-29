package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver,LoginPageUI.EMAIL_TEXTBOX);
		sendKeytoElement(driver, LoginPageUI.EMAIL_TEXTBOX,email );
	}
	
	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
		sendKeytoElement(driver, LoginPageUI.PASSWORD_TEXTBOX,password );
		
	}
	
	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public String getErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_OR_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_OR_PASSWORD_ERROR_MESSAGE);
	}
}

// Page chỉ chưa only action của page đó
package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {

	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToUserName(String username) {
		waitForElementVisible(driver, RegisterPageUI.USER_NAME);
		sendKeytoElement(driver, RegisterPageUI.USER_NAME, username);
	}
	
	public void inputToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeytoElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}
	
	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeytoElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);		
	}
	
	public void clickToSettingButton() {
		waitForElementClickable(driver,RegisterPageUI.SETTING_BUTTON);
		clickToElement(driver,RegisterPageUI.SETTING_BUTTON);		
	}
	
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	
	public boolean isMyAccountPageDisplayed() {
	waitForElementVisible(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	return isElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
}

	public HomePageObject clickToLogout() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

}

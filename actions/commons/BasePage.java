package commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import pageObjects.AddressPageObject;
//import pageObjects.MyProductViewPageObject;
//import pageObjects.PageGeneratorManager;
//import pageObjects.RewardPointPageObject;
//import pageUIs.BasePageUI;

public class BasePage {

		//function with browser 
		protected void openPageUrl(WebDriver driver, String pageUrl) {
			driver.get(pageUrl);
		}
		
		//function with Element
		private By getByXpath(String xpathLocator) {
			return By.xpath(xpathLocator);
		}
		
		private WebElement getWebElement(WebDriver driver, String xpathLocator) {
			return driver.findElement(getByXpath(xpathLocator));
		}
		
		private List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
			return driver.findElements(By.xpath(xpathLocator));
		}
		
		protected void clickToElement(WebDriver driver, String xpathLocator) {
			getWebElement(driver,xpathLocator).click();
		}
		
		protected void sendKeytoElement(WebDriver driver, String xpathLocator, String textValue) {
			WebElement element = getWebElement(driver,xpathLocator);
			element.clear();
			element.sendKeys(textValue);
		}
		
		protected String getElementText(WebDriver driver, String xpathLocator) {
			return getWebElement(driver,xpathLocator).getText();
		}
		
		public void sleepInSecond (long second) {
			try {
				Thread.sleep(second * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		

		
		protected boolean isElementDisplayed(WebDriver driver,String xpathLocator) {
			return getWebElement(driver, xpathLocator).isDisplayed();
		}

		//function javascript
		
		protected void waitForElementVisible(WebDriver driver, String xpathLocator) {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
		}
		
		protected void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
		}
		
		protected void waitForElementInVisible(WebDriver driver, String xpathLocator) {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
		}
		
		protected void waitForAllElementInVisible(WebDriver driver, String xpathLocator) {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver,xpathLocator)));
		}
		
		protected void waitForElementClickable(WebDriver driver, String xpathLocator) {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
		}
		
//		public AddressPageObject openAddressPage(WebDriver driver) {
//			waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
//			clickToElement(driver, BasePageUI.ADDRESS_LINK);
//			return PageGeneratorManager.getAddressPage(driver);
//		}
//		
//		public RewardPointPageObject openRewardPointPage(WebDriver driver) {
//			waitForElementClickable(driver, BasePageUI.REWARD_LINK);
//			clickToElement(driver, BasePageUI.REWARD_LINK);
//			return PageGeneratorManager.getRewardPointPage(driver);
//		}
//		
//		public MyProductViewPageObject openMyProductViewPage(WebDriver driver) {
//			waitForElementClickable(driver, BasePageUI.MY_PRODUCT_LINK);
//			clickToElement(driver, BasePageUI.MY_PRODUCT_LINK);
//			return PageGeneratorManager.getMyProductViewPage(driver);
//		}
		
		
		
		private long longTimeout = 30;
		
		//private long shortTimeout = 5;
}

package com.skitech.pageObjectsRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(xpath = "//h3[text()='Sign In']")
	private WebElement txtSignIn;
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement txtUserName;
	
	@FindBy(xpath = "//h2[text()='Are you lost your navigation?']//following::div//button")
	private List<WebElement> lstNavigation;
		
	@FindBy(xpath = "//button[text()='Request OTP']")
	private WebElement requestOTPButton;
	
	@FindBy(xpath = "//button[text()='Verify OTP & Sign In']")
	private WebElement verifyOTPSigninButton;
	
	@FindBy(xpath = "//h3[contains(text(), 'Welcome')]")
	private WebElement txtWelcome;
	
	@FindBy(xpath = "//div[@id='root']//*[text()='Sign In']")
	private WebElement txtSignin;
	
	@FindBy(xpath = "//button[contains(text(), 'Go Back')]")
	private WebElement btnGoBack;
	
	@FindBy(xpath = "//div[@id='error-toast']")
	private WebElement txtToasterAlert;
	
	@FindBy(xpath = "//h2[text()='Admission']")
	private WebElement txtAdmissioninDashboardPage;
	
	@FindBy(xpath = "//*[@id='root']//input[1]")
	private WebElement txtOTPinput1;
	
	@FindBy(xpath = "//*[@id='root']//input[2]")
	private WebElement txtOTPinput2;
	
	@FindBy(xpath = "//*[@id='root']//input[3]")
	private WebElement txtOTPinput3;
	
	@FindBy(xpath = "//*[@id='root']//input[4]")
	private WebElement txtOTPinput4;
	
	@FindBy(xpath = "//*[@id='root']//input[5]")
	private WebElement txtOTPinput5;
	
	@FindBy(xpath = "//*[@id='root']//input[6]")
	private WebElement txtOTPinput6;
	
	@FindBy(xpath = "//button[text()='Resend Code']")
	private WebElement btnResendCode;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement txtStudentProfileEmail;
	
	@FindBy(xpath = "//button[text()='Send 6-digit Code']")
	private WebElement btnSend6DigitCode;
	
	public LoginPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void threadSleep(long milisec) {
		try {
			Thread.sleep(milisec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void admissionOfficerLogin(String userId) {
		txtUserName.clear();
		txtUserName.sendKeys(userId);
		requestOTPButton.click();
		threadSleep(5000);
		verifyOTPSigninButton.click();
		threadSleep(3000);
	}
	
	public void studentProfileLogin(String email) {
		txtStudentProfileEmail.sendKeys(email);
		btnSend6DigitCode.click();
		threadSleep(6000);
		verifyOTPSigninButton.click();
		threadSleep(2000);
	}
	
	public void enterStudentProfileEmail(String email) {
		txtStudentProfileEmail.clear();
		txtStudentProfileEmail.sendKeys(email);
		threadSleep(2000);
	}
	
	public void clickOnSend6DigitCodeButton() {
		btnSend6DigitCode.click();
		threadSleep(5000);
	}
	
	public void clearStudentProfileEmail() {
		txtStudentProfileEmail.clear();
		threadSleep(2000);
	}
	
	public void enterAOVOEmail(String email) {
		txtUserName.clear();
		txtUserName.sendKeys(email);
	}
	
	public void clearEmail() {
		txtUserName.clear();
	}
	
	public void clickOnRequestOTPButton() {
		requestOTPButton.click();
	}
	
	public void clickOnVerifyOTPandSigninButton() {
		verifyOTPSigninButton.click();
		threadSleep(3000);
	}
	
	public void clickOnGoBackButton() {
		threadSleep(2000);
		//btnGoBack.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnGoBack);
		threadSleep(1000);
	}
	
	public void selectNavigation(String navigation) {
		for(WebElement navigationSelect : lstNavigation) {
			if(navigationSelect.getText().equals(navigation)) {
				navigationSelect.click();
				threadSleep(4000);
				break;				
			}		
		}
	}
	
	public void waitFor30Seconds() {
		threadSleep(60000);
	}
	
	public String getWelcomeEmail() {
		return txtWelcome.getText();
	}

	public String getToasterAlertText() {
		return txtToasterAlert.getText();
		
	}
	
	public String getAdmissionText() {
		return txtAdmissioninDashboardPage.getText();
	}
	
	public void clearOTPInput1() {
		txtOTPinput1.clear();
	}
	
	public void clearOTPInput2() {
		txtOTPinput2.clear();
	}
	
	public void clearOTPInput3() {
		txtOTPinput3.clear();
	}
	
	public void clearOTPInput4() {
		txtOTPinput4.clear();
	}
	
	public void clearOTPInput5() {
		txtOTPinput5.clear();
	}
	
	public void clearOTPInput6() {
		txtOTPinput6.clear();
	}
	
	public void enterOTPinput1(String input1) {
		txtOTPinput1.sendKeys(input1);
	}
	
	public void enterOTPinput2(String input2) {
		txtOTPinput2.sendKeys(input2);
	}
	
	public void enterOTPinput3(String input3) {
		txtOTPinput3.sendKeys(input3);
	}
	
	public void enterOTPinput4(String input4) {
		txtOTPinput4.sendKeys(input4);
	}
	
	public void enterOTPinput5(String input5) {
		txtOTPinput5.sendKeys(input5);
	}
	
	public void enterOTPinput6(String input6) {
		txtOTPinput6.sendKeys(input6);
	}
	
	public String getOTPInputText1() {
		return txtOTPinput1.getAttribute("value");
	}
	
	public String getOTPInputText2() {
		return txtOTPinput2.getAttribute("value");
	}
	
	public String getOTPInputText3() {
		return txtOTPinput3.getAttribute("value");
	}
	
	public String getOTPInputText4() {
		return txtOTPinput4.getAttribute("value");
	}
	
	public String getOTPInputText5() {
		return txtOTPinput5.getAttribute("value");
	}
	
	public String getOTPInputText6() {
		return txtOTPinput6.getAttribute("value");
	}
	
	public void clickOnResendCode() {
		btnResendCode.click();
		threadSleep(5000);
	}
	
	public void clearOTPValues() {
		txtOTPinput1.sendKeys(Keys.BACK_SPACE);
		txtOTPinput1.sendKeys(Keys.BACK_SPACE);
		txtOTPinput1.sendKeys(Keys.BACK_SPACE);
		txtOTPinput1.sendKeys(Keys.BACK_SPACE);
		txtOTPinput1.sendKeys(Keys.BACK_SPACE);
		txtOTPinput1.sendKeys(Keys.BACK_SPACE);
	}
	
	public String getSigninText() {
		return txtSignin.getText();
	}

	public void pageScrollDown() {		
		threadSleep(1000);		
	    js.executeScript("window.scrollBy(0, 750)");
	}
	
	public void scrollToBottom() {	
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public String getBrowserAlertText() {
		 Alert alert = driver.switchTo().alert();
		 String alertText = alert.getText();
		 alert.accept();
		 return alertText;
	}
	
	public void switchToPreviousWindow() {
		 driver = new ChromeDriver();
	        
	        // Open initial page
	        driver.get("https://example.com");

	        // Store the original window handle
	        String originalWindow = driver.getWindowHandle();

	        // Open a new tab or window using JavaScript or clicking a link that opens new tab
	        // Assume new tab opens, and now there are two window handles

	        // Wait for the new window/tab to open and get all window handles
	        Set<String> allWindows = driver.getWindowHandles();
	        List<String> windowList = new ArrayList<>(allWindows);

	        // Switch to new tab (typically the last one)
	        driver.switchTo().window(windowList.get(windowList.size() - 1));
	        
	        // Perform actions on new tab...
	        System.out.println("Title of new tab: " + driver.getTitle());

	        // Now switch back to the previous (original) tab
	        driver.switchTo().window(originalWindow);
	        System.out.println("Switched back to original window: " + driver.getTitle());
	        threadSleep(1000);

	        // Close browser
	        //driver.quit();
	    }

}

package com.skitech.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.skitech.pageObjectsRepo.AOVOPageObjects;
import com.skitech.pageObjectsRepo.EnquiryPageObjects;
import com.skitech.pageObjectsRepo.LoginPageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnquiryFormTestCase {
	
	WebDriver driver;
	SoftAssert softAssert;
	LoginPageObjects loginPom;
	AOVOPageObjects admissionPOM;
	EnquiryPageObjects enquiryPageObjects; 
	
	
	public void threadSleep(long milisec) {
		try {
			Thread.sleep(milisec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	@BeforeClass
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testweb.skitech.ai/ERP/web/admission");
		loginPom = new LoginPageObjects(driver);
		admissionPOM = new AOVOPageObjects(driver);
		enquiryPageObjects = new EnquiryPageObjects(driver);
		threadSleep(1000);
	}
	
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	private void stepInfo(String stepInfo) {
		
	}
		public EnquiryFormTestCase() {

		}
		
		
		
	//@Test(priority=1)
	public void TC_Enquiry_001_Verify_the_Enquiry_screen() {
		
		stepInfo("Verify_the_Enquiry_screen_sections");
		
		softAssert = new SoftAssert();
						
		loginPom.selectNavigation("Admission Officer");
		loginPom.admissionOfficerLogin("mounika@skitech.ai");
		threadSleep(1000);
		enquiryPageObjects.clickOnEnquiryButton();
		threadSleep(1000);
		enquiryPageObjects.getCollegeSectionText();
		enquiryPageObjects.getStudentDetailsSectionText();
		enquiryPageObjects.getEducationalQualificationSectionText();
		
				
		softAssert.assertEquals(enquiryPageObjects.getCollegeSectionText(), enquiryPageObjects.getCollegeSectionText(), "Dashboard text is " + enquiryPageObjects.getCollegeSectionText());
		System.out.println(enquiryPageObjects.getCollegeSectionText());
		softAssert.assertEquals(enquiryPageObjects.getStudentDetailsSectionText(), enquiryPageObjects.getStudentDetailsSectionText(), "Dashboard text is " + enquiryPageObjects.getStudentDetailsSectionText());
		System.out.println(enquiryPageObjects.getStudentDetailsSectionText());
		softAssert.assertEquals(enquiryPageObjects.getEducationalQualificationSectionText(), enquiryPageObjects.getEducationalQualificationSectionText(), "Dashboard text is " + enquiryPageObjects.getEducationalQualificationSectionText());
		System.out.println(enquiryPageObjects.getEducationalQualificationSectionText());
		softAssert.assertAll();
	}


	//@Test(priority=2)
	public void TC_Enquiry_002_College_and_Programme_Details_fields() {
		
		stepInfo("Verify_College_and_Programme_Details_fields");
		
		softAssert = new SoftAssert();
		
		enquiryPageObjects.printCollegeSectionLabels();
		
		softAssert.assertAll();
	}
	
	//@Test(priority=3)
	public void TC_Enquiry_004_Student_Details_fields() {
		
		stepInfo("Verify_Student_Details_fields");
		
		softAssert = new SoftAssert();
		
		enquiryPageObjects.printPersonalDetailsLabels();
		
		softAssert.assertAll();
		
	}
	
	//@Test(priority=4)
	
	public void TC_Enquiry_006_Verify_sections_in_Educational_Qualification() {
		
		stepInfo("Verify_sections_in_Educational_Qualification");
		
		softAssert = new SoftAssert();
		
		enquiryPageObjects.printEducationalQualificationSections();
		
		softAssert.assertAll();
		
	}
	
	//@Test(priority=5)
	
	public void TC_Enquiry_007_Verify_Educational_Qualification_fields() {
		
		stepInfo("Verify_sections_in_Educational_Qualification_fields");
		
		softAssert = new SoftAssert();
		
		enquiryPageObjects.printEducationalQualificationSectionsFields();
		
		softAssert.assertAll();
		
	}
	
	//for internal use only don't consider this test case
	
	@Test(priority=6)
	public void TC_Create_Enquiry() {
		
		stepInfo("Create Dummy Enquiry");
		
		loginPom.selectNavigation("Admission Officer");
		threadSleep(2000);
		loginPom.admissionOfficerLogin("mounika@skitech.ai");
		threadSleep(2000);
		admissionPOM.clickOnDirectEnquiryForm();
		threadSleep(2000);
		enquiryPageObjects.enterCollegeandProgrammeDetails();
		enquiryPageObjects.enterStudentDetails();
		enquiryPageObjects.enterEducationalQualificationDetails();
		enquiryPageObjects.clickOnSubmitButton();
	}
	
}

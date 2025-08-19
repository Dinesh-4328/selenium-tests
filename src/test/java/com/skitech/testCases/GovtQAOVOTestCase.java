package com.skitech.testCases;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import com.byteforza.testReports.GenerateExtentReport;
import com.github.javafaker.Faker;
import com.skitech.pageObjectsRepo.AOVOPageObjects;
import com.skitech.pageObjectsRepo.EnquiryPageObjects;
import com.skitech.pageObjectsRepo.LoginPageObjects;
import com.skitech.pageObjectsRepo.StudentsProfilePOM;
import com.skitech.pageObjectsRepo.UploadFilePOM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GovtQAOVOTestCase extends BaseTest{
	

	WebDriver driver;
	SoftAssert softAssert;
	LoginPageObjects loginPom;
	AOVOPageObjects aovoPom;
	EnquiryPageObjects enquiryPageObjects;
	StudentsProfilePOM studentsProfilePOM;
	Faker fake = new Faker();
	UploadFilePOM uploadFilePOM;
	String downloadPath = "C:\\Users\\DineshM\\Downloads";
	File downloadedFile;
	int year = fake.number().numberBetween(1990, 2007);
    int month = fake.number().numberBetween(1, 12);
    int day = fake.number().numberBetween(1, Month.of(month).length(false));
    LocalDate date = LocalDate.of(year, month, day);
    String formattedDate = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	Random random = new Random();
	int randomNum = fake.number().numberBetween(100, 500);
	String  randomNumberStr = String.valueOf(randomNum);
    String validPDFFile = "D:\\Excel Upload\\Test Plan PDF Document.pdf";
    String imageFile="D:\\Excel Upload\\sample_640×426.jpeg";
	
	
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
		driver.get("http://172.21.1.248:8085/ERP_QA/admission/");
		loginPom = new LoginPageObjects(driver);
		aovoPom = new AOVOPageObjects(driver);
		enquiryPageObjects = new EnquiryPageObjects(driver);
		studentsProfilePOM = new StudentsProfilePOM(driver);
		uploadFilePOM = new UploadFilePOM(driver);

	}
	
		
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	private void stepInfo(String stepInfo) {
		//GenerateExtentReport.logInfo(stepInfo);
	}
		public GovtQAOVOTestCase() {

		}
	
		@Test(groups = {"Regression"},priority=1)
		public void TC_AOVO_005_Verify_sending_6digit_code_with_valid_email() {
			
			stepInfo("Verify_sending_6digit_code_with_valid_email");
			
			softAssert = new SoftAssert();
		
			loginPom.selectNavigation("Admission Officer");
			threadSleep(2000);
			loginPom.enterAOVOEmail("thiyagarajan@skitech.ai");
			loginPom.clickOnRequestOTPButton();
			threadSleep(6000);
			
			softAssert.assertEquals(loginPom.getWelcomeEmail(), loginPom.getWelcomeEmail(), "Welcome text is " + loginPom.getWelcomeEmail());
			System.out.println(loginPom.getWelcomeEmail());
			
			softAssert.assertAll();
		}	
		
		@Test(groups = {"Regression"},priority=2)
		public void TC_AOVO_006_Verify_sending_6digit_code_fails_for_invalid_email() {
			
			stepInfo("Verify_sending_6digit_code_fails_for_invalid_email");
			
			softAssert = new SoftAssert();
		
			loginPom.clickOnGoBackButton();
			threadSleep(1000);
			loginPom.enterAOVOEmail("premkumar@yopmail.ai");
			loginPom.clickOnRequestOTPButton();
			threadSleep(2000);
					
			softAssert.assertEquals(loginPom.getToasterAlertText(), loginPom.getToasterAlertText(), "Toaster Alert text is " + loginPom.getToasterAlertText());
			System.out.println(loginPom.getToasterAlertText());
			
			softAssert.assertAll();
		}	
		
		@Test(groups = {"Regression"},priority=3)
		public void TC_AOVO_007_Verify_AOVO_account_signin_with_valid_OTP() {
			
			stepInfo("Verify_AOVO_account_signin_with_valid_OTP");
			
			softAssert = new SoftAssert();

			threadSleep(1000);
			loginPom.admissionOfficerLogin("thiyagarajan@skitech.ai");
			
			softAssert.assertEquals(aovoPom.getProfileText(), aovoPom.getProfileText(), "Dashboard text is " + aovoPom.getProfileText());
			System.out.println(aovoPom.getProfileText());
			
			softAssert.assertAll();
		}	
		
		@Test(groups = {"Regression"},priority=4)
		public void TC_AOVO_008_Verify_AOVO_account_signin_with_invalid_OTP() {
			
			stepInfo("Verify_AOVO_account_signin_with_invalid_OTP");
			
			softAssert = new SoftAssert();
		
			aovoPom.clickOnLogoutButton();
			threadSleep(2000);
			loginPom.enterAOVOEmail("thiyagarajan@skitech.ai");
			loginPom.clickOnRequestOTPButton();
			threadSleep(6000);
			loginPom.clearOTPInput5();
			loginPom.enterOTPinput5(fake.number().digits(1));
			loginPom.clearOTPInput6();
			loginPom.enterOTPinput6(fake.number().digits(1));
			loginPom.clickOnVerifyOTPandSigninButton();
			
			softAssert.assertEquals(loginPom.getToasterAlertText(), loginPom.getToasterAlertText(), "Toaster Alert text is " + loginPom.getToasterAlertText());
			System.out.println(loginPom.getToasterAlertText());
			
			softAssert.assertAll();
		}	
		
		@Test(groups = {"Regression"},priority=5)
		public void TC_AOVO_009_Verify_AOVO_account_signin_with_expired_OTP() {
			
			stepInfo("Verify_AOVO_account_signin_with_expired_OTP");
			
			softAssert = new SoftAssert();
		
			loginPom.clickOnGoBackButton();
			loginPom.enterAOVOEmail("thiyagarajan@skitech.ai");
			loginPom.clickOnRequestOTPButton();
			threadSleep(6000);
			loginPom.waitFor30Seconds();
			loginPom.clickOnVerifyOTPandSigninButton();

			softAssert.assertEquals(loginPom.getToasterAlertText(), loginPom.getToasterAlertText(), "Toaster Alert text is " + loginPom.getToasterAlertText());
			System.out.println(loginPom.getToasterAlertText());
			
			softAssert.assertAll();
		}
		
		@Test(groups = {"Regression"},priority=6)
		public void TC_AOVO_010_Verify_Resend_Code_in_signin_screen() {
			
			stepInfo("Verify_Resend_Code_in_signin_screen");
			
			softAssert = new SoftAssert();
		
			loginPom.clickOnResendCode();
			threadSleep(3000);
			loginPom.clickOnVerifyOTPandSigninButton();
			threadSleep(2000);
			
			softAssert.assertEquals(aovoPom.getProfileText(), aovoPom.getProfileText(), "Found text is " + aovoPom.getProfileText());
			System.out.println(aovoPom.getProfileText());
			
			softAssert.assertAll();
		}	
		
		@Test(groups = {"Regression"},priority=7)
		public void TC_AOVO_011_Verify_GoBack_in_Signin_Screen() {
			
			stepInfo("Verify_GoBack_in_Signin_Screen");
			
			softAssert = new SoftAssert();
		
			aovoPom.clickOnLogoutButton();
			threadSleep(2000);
			loginPom.enterAOVOEmail("thiyagarajan@skitech.ai");
			loginPom.clickOnRequestOTPButton();
			threadSleep(6000);
			loginPom.clickOnGoBackButton();
			
			softAssert.assertEquals(loginPom.getSigninText(), loginPom.getSigninText(), "Found text is " + loginPom.getSigninText());
			System.out.println(loginPom.getSigninText());
			
			softAssert.assertAll();
		}	
		
		@Test(groups = {"Regression"},priority=8)
		public void TC_AOVO_013_Verify_After_signin_screen_menus() {
			
			stepInfo("Verify_After_signin_screen_menus");
			
			softAssert = new SoftAssert();
		
			loginPom.enterAOVOEmail("thiyagarajan@skitech.ai");
			loginPom.clickOnRequestOTPButton();
			threadSleep(6000);
			loginPom.clickOnVerifyOTPandSigninButton();
			threadSleep(2000);
			
			softAssert.assertEquals(aovoPom.getDashboardMenusText(), aovoPom.getDashboardMenusText(), "Dashboard Menu is" + aovoPom.getDashboardMenusText());
			System.out.println(aovoPom.getDashboardMenusText());		
					
			softAssert.assertAll();
		}
		
		@Test(groups = {"Regression"},priority=9)
		public void TC_AOVO_015_Verify_Search_with_valid_Mobile_No() throws IOException, InterruptedException {
			
			stepInfo("Verify_Search_with_valid_Mobile_No");
			
			softAssert = new SoftAssert();
			
			downloadedFile = uploadFilePOM.waitForDownloadToComplete(downloadPath, ".xlsx", 20);		
			aovoPom.selectStudentSearchType("Mobile Number");
			admissionNo = uploadFilePOM.getFirstAdmissionNoFromExcel(downloadedFile);
			mobileNo = uploadFilePOM.getFirstMobileNoFromExcel(downloadedFile);
			aovoPom.enterSearchByStudentValueMobileNumber(mobileNo);			
			System.out.println(aovoPom.getStudentSearchResultsValue());
			aovoPom.clickonStudentSearchResults();

			softAssert.assertEquals(aovoPom.getStudentNameinAOVOStudentDetailsScreen(),aovoPom.getStudentNameinAOVOStudentDetailsScreen(), "Enquiry ID Name is " + aovoPom.getStudentNameinAOVOStudentDetailsScreen());
			System.out.println(aovoPom.getStudentNameinAOVOStudentDetailsScreen());
			
			softAssert.assertAll();
			
			}
		
		@Test(groups = {"Regression"},priority=10)
		public void TC_AOVO_016_Verify_Search_with_invalid_Mobile_No(){
			
			stepInfo("Verify_Search_with_invalid_Mobile_No");
			
			softAssert = new SoftAssert();
		
			aovoPom.clickOnBackIconinStudentDetailsScreen();	
			aovoPom.selectStudentSearchType("Mobile Number");
			aovoPom.enterSearchByStudentValueMobileNumber("90065445879");			

			softAssert.assertEquals(aovoPom.getSearchErrorText(), aovoPom.getSearchErrorText(), "Text is " + aovoPom.getSearchErrorText());
			System.out.println(aovoPom.getSearchErrorText());
			
			softAssert.assertAll();
			
			}
		
		@Test(groups = {"Regression"},priority=11)
		public void TC_AOVO_017_Verify_Search_with_valid_admission_no(){
			
			stepInfo("Verify_Search_with_valid_admission_no");
			
			softAssert = new SoftAssert();
			
			aovoPom.selectStudentSearchType("Admission Number");
			aovoPom.enterSearchByStudentValueAdmissionNumber(admissionNo);			
			System.out.println(aovoPom.getStudentSearchResultsValue());
			aovoPom.clickonStudentSearchResults();
			
			softAssert.assertEquals(aovoPom.getStudentNameinAOVOStudentDetailsScreen(),aovoPom.getStudentNameinAOVOStudentDetailsScreen(), "Text is " + aovoPom.getStudentNameinAOVOStudentDetailsScreen());
			System.out.println(aovoPom.getStudentNameinAOVOStudentDetailsScreen());
			
			softAssert.assertAll();
		}
		
		@Test(groups = {"Regression"},priority=12)
		public void TC_AOVO_018_Verify_Search_with_invalid_admission_no(){
			
			stepInfo("Verify_Search_with_invalid_admission_no");
			
			softAssert = new SoftAssert();
			
			aovoPom.clickOnBackIconinStudentDetailsScreen();	
		//	aovoPom.selectStudentSearchType("Admission Number");
			aovoPom.enterSearchByStudentValueAdmissionNumber("iuscs(*&");			
			
			softAssert.assertEquals(aovoPom.getSearchErrorText(),aovoPom.getSearchErrorText(), "Text is " + aovoPom.getSearchErrorText());
			System.out.println(aovoPom.getSearchErrorText());
			
			softAssert.assertAll();
		}
		
		@Test(groups = {"Regression"},priority=13)
		public void TC_AOVO_018_Verify_student_details_screen_after_clicking_on_search_results(){
			
			stepInfo("Verify_student_details_screen_after_clicking_on_search_results");
			
			softAssert = new SoftAssert();
			
			aovoPom.enterSearchByStudentValueAdmissionNumber(admissionNo);
			aovoPom.clickonStudentSearchResults();
									
			softAssert.assertEquals(aovoPom.getStudentDetailsTabTexts(),aovoPom.getStudentDetailsTabTexts(), "Text is " + aovoPom.getStudentDetailsTabTexts());
			System.out.println(aovoPom.getStudentDetailsTabTexts());
			
			softAssert.assertAll();
		}
			
		@Test(groups = {"Regression"},priority=14)
		public void TC_AOVO_019_Verify_Overview_tab() {
			
			stepInfo("Verify_Overview_tab");
			
			softAssert = new SoftAssert();
									
			softAssert.assertEquals(aovoPom.getOverviewTabSections(), aovoPom.getOverviewTabSections(), "Section List Name is " + aovoPom.getOverviewTabSections());
			System.out.println(aovoPom.getOverviewTabSections());
			
			softAssert.assertAll();
		} 
		
		@Test(groups = {"Regression"},priority=15)
		public void TC_AOVO_025_Verify_Student_Information_tab() {
			
			stepInfo("Verify_Student_Information_tab");
			
			softAssert = new SoftAssert();
					
			aovoPom.clickOnStudentDetailsTab("Student information");
										
			softAssert.assertEquals(aovoPom.getStudentInformationTabSections(), aovoPom.getStudentInformationTabSections(), "Section List Name is " + aovoPom.getStudentInformationTabSections());
			System.out.println(aovoPom.getStudentInformationTabSections());
			
			softAssert.assertAll();
		} 
		
		@Test(groups = {"Regression"},priority=16)
		public void TC_AOVO_028_Verify_Mark_as_Verified_while_leaving_mandatory_field_in_Student_Information_tab(){
			
			stepInfo("Verify_Mark_as_Verified_while_leaving_mandatory_field_in_Student_Information_tab");
			
			softAssert = new SoftAssert();
					
			
			studentsProfilePOM.clearAadharNumber();
			studentsProfilePOM.clearAadharName();
			aovoPom.clickOnMarkasVerified();
										
			softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
			System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
			
			softAssert.assertAll();
		} 
		
		@Test(groups = {"Regression"},priority=17)
		public void TC_AOVO_029_Verify_Mark_as_Verified_while_in_Student_Information_tab(){
			
			stepInfo("Verify_Mark_as_Verified_in_Student_Information_tab");
			
			softAssert = new SoftAssert();
					
			driver.navigate().refresh();
			threadSleep(3000);
			aovoPom.clickOnMarkasVerified();
										
			softAssert.assertEquals(aovoPom.getVerificationDoneText(), aovoPom.getVerificationDoneText(), "Text is " + aovoPom.getVerificationDoneText());
			System.out.println(aovoPom.getVerificationDoneText());
			
			softAssert.assertAll();
		} 
		
		@Test(groups = {"Regression"},priority=18)
		public void TC_AOVO_030_Verify_Edit_Student_Information_details(){
			
			stepInfo("Verify_Edit_Student_Information_details");
			
			softAssert = new SoftAssert();
					
			aovoPom.clickOnEditDetailsButton();
			studentsProfilePOM.enterAadharNumber(fake.number().digits(12));
			studentsProfilePOM.enterAadharName(fake.name().firstName());
			studentsProfilePOM.selectBloodGroup("A+");
			studentsProfilePOM.selectNationality("Indian");
			studentsProfilePOM.selectReligion("Hindu");
			studentsProfilePOM.selectCaste("Gounder");
			studentsProfilePOM.selectMotherTongue("Tamil");
			aovoPom.clickOnSaveButton();
										
			softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Text is " + studentsProfilePOM.getSuccessToasterAlert());
			System.out.println(studentsProfilePOM.getSuccessToasterAlert());
			
			softAssert.assertAll();
			
			aovoPom.clickOnMarkasVerified();
		} 
		
		@Test(groups = {"Regression"},priority=19)
		public void TC_AOVO_031_Verify_Edit_Student_Information_details_with_invalid_data(){
			
			stepInfo("Verify_Edit_Student_Information_details_with_invalid_data");
			
			softAssert = new SoftAssert();
					
			aovoPom.clickOnEditDetailsButton();
			studentsProfilePOM.enterAadharName("(*&^(*&^76587");
										
			softAssert.assertEquals(studentsProfilePOM.getDocumentsTabMandatoryText(), studentsProfilePOM.getDocumentsTabMandatoryText(), "Text is " + studentsProfilePOM.getDocumentsTabMandatoryText());
			System.out.println(studentsProfilePOM.getDocumentsTabMandatoryText());
			
			softAssert.assertAll();
			
			driver.navigate().refresh();
		} 
		
		@Test(groups = {"Regression"},priority=20)
		public void TC_AOVO_032_Verify_Academic_History_tab(){
			
			stepInfo("Verify_Academic_History_tab");
			
			softAssert = new SoftAssert();
					
			aovoPom.clickOnStudentDetailsTab("Academic history");
							
			softAssert.assertEquals(aovoPom.getAcademicHistoryTabSections(), aovoPom.getAcademicHistoryTabSections(), "Section List Name is " + aovoPom.getAcademicHistoryTabSections());
			System.out.println(aovoPom.getAcademicHistoryTabSections());
			
			softAssert.assertAll();
		} 
		
		@Test(groups = {"Regression"},priority=21)
		public void TC_AOVO_035_Verify_Mark_as_Verified_in_Academic_History_tab_with_incompleted_data(){
			
			stepInfo("Verify_Mark_as_Verified_in_Academic_History_tab_with_incompleted_data");
			
			softAssert = new SoftAssert();
					
			studentsProfilePOM.clearSSLCRollNo();
			studentsProfilePOM.clearSSLCMarksScored();
			studentsProfilePOM.clearHSC1PermanentRegisterNo();
			studentsProfilePOM.clearHSC1MarksScored();
			studentsProfilePOM.clearHSC2PermanentRegisterNo();
			studentsProfilePOM.clearEMISNo();
			studentsProfilePOM.clearHSC2MarksScored();
			studentsProfilePOM.clearHSC2MathsMark();
			studentsProfilePOM.clearHSC2PhysicsMark();
			studentsProfilePOM.clearHSC2ChemistryMark();
			studentsProfilePOM.clearHSC2OptionalSubjectMark();
			aovoPom.clickOnMarkasVerified();
							
			softAssert.assertEquals(studentsProfilePOM.getDocumentsTabMandatoryText(), studentsProfilePOM.getDocumentsTabMandatoryText(), "Text Name is " + studentsProfilePOM.getDocumentsTabMandatoryText());
			System.out.println(studentsProfilePOM.getDocumentsTabMandatoryText());
			
			softAssert.assertAll();
		} 
		
		@Test(groups = {"Regression"},priority=22)
		public void TC_AOVO_036_Verify_Mark_as_Verified_in_Academic_History_tab(){
			
			stepInfo("Verify_Mark_as_Verified_in_Academic_History_tab");
			
			softAssert = new SoftAssert();
					
			driver.navigate().refresh();
			threadSleep(2000);
			aovoPom.clickOnMarkasVerified();			
							
			softAssert.assertEquals(aovoPom.getVerificationDoneText(), aovoPom.getVerificationDoneText(), "Text Name is " + aovoPom.getVerificationDoneText());
			System.out.println(aovoPom.getVerificationDoneText());
			
			softAssert.assertAll();
		
		} 
		
		@Test(groups = {"Regression"},priority=23)
		public void TC_AOVO_037_Verify_edit_academic_history_fields(){
			
			stepInfo("Verify_edit_academic_history_fields");
			
			softAssert = new SoftAssert();
					
			aovoPom.clickOnEditDetailsButton();
			studentsProfilePOM.enterSSLCRollNo(fake.number().digits(5));
			studentsProfilePOM.enterSSLCMarksScored(randomNumberStr);
			studentsProfilePOM.enterHSC1PermanentRegisterNo(fake.number().digits(5));
			studentsProfilePOM.selectHSC1GrouporStream("Academic (HSC)");
			studentsProfilePOM.enterHSC1MarksScored(randomNumberStr);
			studentsProfilePOM.enterHSC2PermanentRegisterNo(fake.number().digits(5));
			studentsProfilePOM.enterHSC2EMISNo(fake.number().digits(8));
			studentsProfilePOM.enterHSC2MarksScored(randomNumberStr);
			studentsProfilePOM.enterHSC2MathsMark(fake.number().digits(2));
			studentsProfilePOM.enterHSC2PhysicsMark(fake.number().digits(2));
			studentsProfilePOM.enterHSC2ChemistryMark(fake.number().digits(2));
			studentsProfilePOM.enterHSC2OptionalSubjectMark(fake.number().digits(2));
			aovoPom.clickOnSaveButton();			
							
			softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Text Name is " + studentsProfilePOM.getSuccessToasterAlert());
			System.out.println(studentsProfilePOM.getSuccessToasterAlert());
						
			softAssert.assertAll();
			
			aovoPom.clickOnMarkasVerified();
			
		} 
		
		@Test(groups = {"Regression"},priority=24)
		public void TC_AOVO_038_Verify_edit_academic_history_fields_with_invalid_data(){
			
			stepInfo("Verify_edit_academic_history_fields_with_invalid_data");
			
			softAssert = new SoftAssert();
					
			aovoPom.clickOnEditDetailsButton();
			studentsProfilePOM.enterHSC2EMISNo("isdj*&^*&^%");
			aovoPom.clickOnSaveButton();			
							
			softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Text Name is " + studentsProfilePOM.getMandatoryFieldsAlerts());
			System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
			
			softAssert.assertAll();
			
			driver.navigate().refresh();
			
		} 		
					
		@Test(groups = {"Regression"},priority=25)
		public void TC_AOVO_039_Verify_family_details_tab(){
			
			stepInfo("Verify_family_details_tab");
			
			softAssert = new SoftAssert();
					
			aovoPom.clickOnStudentDetailsTab("Family details");	
						
			softAssert.assertEquals(aovoPom.getFamilyDetailsTabSections(), aovoPom.getFamilyDetailsTabSections(), "Text Name is " + aovoPom.getFamilyDetailsTabSections());
			System.out.println(aovoPom.getFamilyDetailsTabSections());
			
			softAssert.assertAll();
			
		}
		
		@Test(groups = {"Regression"},priority=26)
		public void TC_AOVO_042_Verify_Mark_as_Verified_in_Family_Details_tab_with_incompleted_data(){
			
			stepInfo("Verify_Mark_as_Verified_in_Family_Details_tab_with_incompleted_data");
			
			softAssert = new SoftAssert();
					
			studentsProfilePOM.clearGuardianFullName();
			studentsProfilePOM.clearGuardianAadharNumber();
			studentsProfilePOM.clearGuardianMobileNumber();
			studentsProfilePOM.clearSibling1FullName();
			aovoPom.clickOnMarkasVerified();
						
			softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Text Name is " + studentsProfilePOM.getMandatoryFieldsAlerts());
			System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
			
			softAssert.assertAll();
			
		}
		
		@Test(groups = {"Regression"},priority=27)
		public void TC_AOVO_043_Verify_Mark_as_Verified_in_Family_Details_tab(){
			
			stepInfo("Verify_Mark_as_Verified_in_Family_Details_tab");
			
			softAssert = new SoftAssert();
					
			driver.navigate().refresh();
			threadSleep(2000);
			aovoPom.clickOnMarkasVerified();
						
			softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Text Name is " + studentsProfilePOM.getSuccessToasterAlert());
			System.out.println(studentsProfilePOM.getSuccessToasterAlert());
			
			softAssert.assertAll();
			
		}
		
		@Test(groups = {"Regression"},priority=28)
		public void TC_AOVO_044_Verify_edit_Family_Details(){
			
			stepInfo("Verify_edit_Family_Details");
			
			softAssert = new SoftAssert();
					
			aovoPom.clickOnEditDetailsButton();
			studentsProfilePOM.enterGuardianFullName(fake.name().fullName());
			studentsProfilePOM.enterGuardianAadharNumber(fake.number().digits(12));
			studentsProfilePOM.enterGuardianEmailid(fake.internet().emailAddress());
			studentsProfilePOM.selectSibling1College("Sri Krishna College of Technology");
			studentsProfilePOM.selectSibling1Degree("Bachelor of Technology");
			studentsProfilePOM.selectSibling1AdmissionYear("2022");
			studentsProfilePOM.enterSibling1RegisterNo(fake.number().digits(5));
			studentsProfilePOM.enterSibling1FullName(fake.name().firstName());
			studentsProfilePOM.selectSibling1Gender("Female");
			studentsProfilePOM.enterSibling1DOB(formattedDate);
			studentsProfilePOM.enterSibling1Email(fake.internet().emailAddress());
			aovoPom.clickOnSaveButton();
						
			softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Text Name is " + studentsProfilePOM.getSuccessToasterAlert());
			System.out.println(studentsProfilePOM.getSuccessToasterAlert());
			
			softAssert.assertAll();
			
			aovoPom.clickOnMarkasVerified();
			
		}
		
		@Test(groups = {"Regression"},priority=29)
		public void TC_AOVO_045_Verify_edit_family_details_fields_with_invalid_data() {
			
			stepInfo("Verify_edit_family_details_fields_with_invalid_data");
			
			softAssert = new SoftAssert();
					
			aovoPom.clickOnEditDetailsButton();
			studentsProfilePOM.enterGuardianFullName("8976*&^(*");
			studentsProfilePOM.enterGuardianAadharNumber("sfsfd(*&^*&%");
			studentsProfilePOM.enterGuardianMobileNumber("sfsfd(*&^*&%");
			studentsProfilePOM.enterGuardianEmailid("sfsfd(*&^*&%");
			studentsProfilePOM.enterSibling1RegisterNo("(*^*&(*&%&^");
			studentsProfilePOM.enterSibling1FullName(fake.name().fullName());
			studentsProfilePOM.enterSibling1MobileNo("sfsfd(*&^*&%");
			studentsProfilePOM.enterSibling1Email("sfsfd(*&^*&%");
			aovoPom.clickOnSaveButton();
						
			softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Text Name is " + studentsProfilePOM.getMandatoryFieldsAlerts());
			System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
			
			softAssert.assertAll();
			
			driver.navigate().refresh();
		}
		
				
		@Test(groups = {"Regression"}, priority=30)
		public void TC_AOVO_046_Verify_Address_Details_tab(){
			
			stepInfo("Verify_Address_Details_tab_Sections");
			
			softAssert = new SoftAssert();
					
			aovoPom.clickOnStudentDetailsTab("Address details");
							
			softAssert.assertEquals(aovoPom.getAddressDetailsTabSections(), aovoPom.getAddressDetailsTabSections(), "Section List Name is " + aovoPom.getAddressDetailsTabSections());
			System.out.println(aovoPom.getAddressDetailsTabSections());
		} 

		@Test(groups = {"Regression"}, priority=31)
		public void TC_AOVO_049_Verify_Mark_as_Verified_in_Address_Details_tab_with_incompleted(){
			
			stepInfo("Verify_Mark_as_Verified_in_Address_Details_tab_with_incompleted");
			
			softAssert = new SoftAssert();
					
			studentsProfilePOM.clearPermanentAddressLine1();
			studentsProfilePOM.clearPermanentAddressPincode();
			aovoPom.clickOnMarkasVerified();
										
			softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Section List Name is " + studentsProfilePOM.getMandatoryFieldsAlerts());
			System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
			
			softAssert.assertAll();
			
		} 
		
		@Test(groups = {"Regression"}, priority=32)
		public void TC_AOVO_050_Verify_Mark_as_Verified_in_Address_Details_tab(){
			
			stepInfo("Verify_Mark_as_Verified_in_Address_Details_tab");
			
			softAssert = new SoftAssert();
					
			driver.navigate().refresh();
			threadSleep(1000);
			aovoPom.clickOnMarkasVerified();
							
			softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Section List Name is " + studentsProfilePOM.getSuccessToasterAlert());
			System.out.println(studentsProfilePOM.getSuccessToasterAlert());
			
			softAssert.assertAll();
		} 
		
		@Test(groups = {"Regression"}, priority=33)
		public void TC_AOVO_051_Verify_edit_address_details_fields(){
			
			stepInfo("Verify_edit_address_details_fields");
			
			softAssert = new SoftAssert();
					
			aovoPom.clickOnEditDetailsButton();
			studentsProfilePOM.enterPermanentAddressLine1(fake.address().fullAddress());
			studentsProfilePOM.enterPermanentAddressPinCode("6" + fake.number().digits(5));
			aovoPom.clickOnSaveButton();
							
			softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Section List Name is " + studentsProfilePOM.getSuccessToasterAlert());
			System.out.println(studentsProfilePOM.getSuccessToasterAlert());
			
			softAssert.assertAll();
			
			aovoPom.clickOnMarkasVerified();					
		} 
		
		@Test(groups = {"Regression"}, priority=34)
		public void TC_AOVO_052_Verify_edit_address_details_fields_with_invalid_data(){
			
			stepInfo("Verify_edit_address_details_fields_with_invalid_data");
			
			softAssert = new SoftAssert();
					
			aovoPom.clickOnEditDetailsButton();
			studentsProfilePOM.enterPermanentAddressLine1("*)(&(*&");
			studentsProfilePOM.enterPermanentAddressPinCode("asd#$%");
			aovoPom.clickOnSaveButton();
							
			softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Section List Name is " + studentsProfilePOM.getMandatoryFieldsAlerts());
			System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
			
			softAssert.assertAll();
			
			driver.navigate().refresh();
		}
		
		@Test(groups = {"Regression"}, priority=35)
		public void TC_AOVO_053_Verify_Admission_Details_tab(){
			
			stepInfo("Verify_Admission_Details_tab");
			
			softAssert = new SoftAssert();
			
			aovoPom.clickOnStudentDetailsTab("Admission details");
							
			softAssert.assertEquals(aovoPom.getAdmissionDetailsTabSections(), aovoPom.getAdmissionDetailsTabSections(), "Section List Name is " + aovoPom.getAdmissionDetailsTabSections());
			System.out.println(aovoPom.getAdmissionDetailsTabSections());
			
			softAssert.assertAll();
		}
		
		@Test(groups = {"Regression"}, priority=36)
		public void TC_AOVO_056_Verify_mark_as_verified_with_incompleted_data_in_admission_details_tab(){
			
			stepInfo("Verify_mark_as_verified_with_incompleted_data_in_admission_details_tab");
			
			softAssert = new SoftAssert();
			
			studentsProfilePOM.clearFourWheelerVehicleNumber();
			studentsProfilePOM.clearFourWheelerLicenseNumber();
			aovoPom.clickOnMarkasVerified();
							
			softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Section List Name is " + studentsProfilePOM.getMandatoryFieldsAlerts());
			System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
			softAssert.assertAll();
		
		}
				
		@Test(groups = {"Regression"}, priority=37)
		public void TC_AOVO_057_Verify_Mark_as_Verified_in_Admission_Details_tab(){
			
			stepInfo("Verify_Mark_as_Verified_in_Admission_Details_tab");
			
			softAssert = new SoftAssert();
			
			driver.navigate().refresh();
			threadSleep(2000);
			aovoPom.clickOnMarkasVerified();
							
			softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Section List Name is " + studentsProfilePOM.getSuccessToasterAlert());
			System.out.println(studentsProfilePOM.getSuccessToasterAlert());
			
			softAssert.assertAll();
		}
		
		@Test(groups = {"Regression"}, priority=38)
		public void TC_AOVO_058_Verify_edit_admission_details_fields() {
			
			stepInfo("Verify_edit_admission_details_fields");
			
			softAssert = new SoftAssert();
			
			aovoPom.clickOnEditDetailsButton();
			studentsProfilePOM.enterFourWheelerLicenseNumber("TN" + fake.number().digits(10));
			aovoPom.clickOnSaveButton();
							
			softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Section List Name is " + studentsProfilePOM.getSuccessToasterAlert());
			System.out.println(studentsProfilePOM.getSuccessToasterAlert());
			
			softAssert.assertAll();
			
			aovoPom.clickOnMarkasVerified();
		}
		
		//@Test(groups = {"Regression"}, priority=39)
		public void TC_AOVO_059_Verify_edit_admission_with_invalid_data() {
			
			stepInfo("Verify_edit_admission_with_invalid_data");
			
			softAssert = new SoftAssert();
			
			aovoPom.clickOnEditDetailsButton();
			studentsProfilePOM.enterFourWheelerVehicleNumber("()*^*%&^%*");
			aovoPom.clickOnSaveButton();
							
			softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Section List Name is " + studentsProfilePOM.getMandatoryFieldsAlerts());
			System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
			
			softAssert.assertAll();
			
			driver.navigate().refresh();
		}
		
		@Test(groups = {"Regression"}, priority=40)
		public void TC_AOVO_060_Verify_document_tab_sections() {
			
			stepInfo("Verify_document_tab_sections");
			
			softAssert = new SoftAssert();
			
			aovoPom.clickOnStudentDetailsTab("Documents");
							
			softAssert.assertEquals(studentsProfilePOM.getDocumentsTabSectionText(), studentsProfilePOM.getDocumentsTabSectionText(), "Section List Name is " + studentsProfilePOM.getDocumentsTabSectionText());
			System.out.println(studentsProfilePOM.getDocumentsTabSectionText());
			
			softAssert.assertAll();
		}
		
		@Test(groups = {"Regression"}, priority=41)
		public void TC_AOVO_062_Verify_finish_verification_in_documents_tab_without_completing_the_verification(){
			
			stepInfo("Verify_finish_verification_in_documents_tab_without_completing_the_verification");
			
			softAssert = new SoftAssert();
			
			aovoPom.clickOnFinishVerification();
							
			softAssert.assertEquals(studentsProfilePOM.getDocumentsTabMandatoryText(), studentsProfilePOM.getDocumentsTabMandatoryText(), "Section List Name is " + studentsProfilePOM.getDocumentsTabMandatoryText());
			System.out.println(studentsProfilePOM.getDocumentsTabMandatoryText());
		}
		
		@Test(groups = {"Regression"}, priority=42)
		public void TC_AOVO_065_Verify_reject_all_documents_in_document_view_pop_up(){
			
			stepInfo("Verify_reject_all_documents_in_document_view_pop_up");
			
			softAssert = new SoftAssert();
			
			aovoPom.rejectAllDocuments("Blurred or unreadable document");
							
			softAssert.assertEquals(aovoPom.getDocumentUploadSuccessFailureText(), aovoPom.getDocumentUploadSuccessFailureText(), "Section List Name is " + aovoPom.getDocumentUploadSuccessFailureText());
			System.out.println(aovoPom.getDocumentUploadSuccessFailureText());
		}
		
		@Test(groups = {"Regression"}, priority=43)
		public void TC_AOVO_066_Verify_all_documents_in_document_view_pop_up() throws InterruptedException, IOException{
			
			stepInfo("Verify_all_documents_in_document_view_pop_up");
			
			softAssert = new SoftAssert();
			
			aovoPom.clickOnLogoutButton();
			driver.get("http://172.21.1.248:8085/ERP_QA/admission/");
			downloadedFile = uploadFilePOM.waitForDownloadToComplete(downloadPath, ".xlsx", 20);
			emailid = uploadFilePOM.getFirstEmailIdFromExcel(downloadedFile);
			loginPom.selectNavigation("Student Profile");
			loginPom.enterStudentProfileEmail(emailid);
			loginPom.clickOnSend6DigitCodeButton();
			loginPom.clickOnVerifyOTPandSigninButton();
			studentsProfilePOM.clickOnStudentProfileSectionTab("Documents");
			studentsProfilePOM.removeAllDocuments();
			studentsProfilePOM.uploadAllFiles(validPDFFile);	
			studentsProfilePOM.uploadPassportSizePhoto(imageFile);
			driver.get("http://172.21.1.248:8085/ERP_QA/admission/");
			loginPom.selectNavigation("Admission Officer");
			loginPom.admissionOfficerLogin("thiyagarajan@skitech.ai");
			aovoPom.selectStudentSearchType("Admission Number");
			aovoPom.enterSearchByStudentValueAdmissionNumber(admissionNo);			
			aovoPom.clickonStudentSearchResults();
			aovoPom.clickOnStudentDetailsTab("Documents");
			aovoPom.verifyAllDocuments();
							
			softAssert.assertEquals(aovoPom.getDocumentUploadSuccessFailureText(), aovoPom.getDocumentUploadSuccessFailureText(), "Text is " + aovoPom.getDocumentUploadSuccessFailureText());
			System.out.println(aovoPom.getDocumentUploadSuccessFailureText());
		}
		
		@Test(groups = {"Regression"}, priority=44)
		public void TC_AOVO_068_Verify_finish_verification_without_collecting_documents(){
			
			stepInfo("Verify_finish_verification_without_collecting_documents");
			
			softAssert = new SoftAssert();
			
			aovoPom.clickOnFinishVerification();
							
			softAssert.assertEquals(studentsProfilePOM.getDocumentsTabMandatoryText(), studentsProfilePOM.getDocumentsTabMandatoryText(), "Text is " + studentsProfilePOM.getDocumentsTabMandatoryText());
			System.out.println(studentsProfilePOM.getDocumentsTabMandatoryText());
		}
		
		@Test(groups = {"Regression"}, priority=45)
		public void TC_AOVO_069_Verify_collect_column_for_all_documents() {
			
			stepInfo("Verify_collect_column_for_all_documents");
			
			softAssert = new SoftAssert();
			
			aovoPom.clickOnCollectChkBox();
							
			softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Text is " + studentsProfilePOM.getSuccessToasterAlert());
			System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		}
		
		@Test(groups = {"Regression"}, priority=46)
		public void TC_AOVO_070_Verify_finish_verification_after_collecting_documents(){
			
			stepInfo("Verify_finish_verification_after_collecting_documents");
			
			softAssert = new SoftAssert();
			
			aovoPom.clickOnFinishVerification();
							
			softAssert.assertEquals(aovoPom.getStudentVerificationCompleted(), aovoPom.getStudentVerificationCompleted(), "Text is " + aovoPom.getStudentVerificationCompleted());
			System.out.println(aovoPom.getStudentVerificationCompleted());
		}
		
}

package com.skitech.testCases;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.skitech.pageObjectsRepo.AOVOPageObjects;
import com.skitech.pageObjectsRepo.LoginPageObjects;
import com.skitech.pageObjectsRepo.StudentsProfilePOM;
import com.skitech.pageObjectsRepo.UploadFilePOM;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GovtQLateralStudProfTestCases extends BaseTest{
	
	WebDriver driver;
	SoftAssert softAssert;
	LoginPageObjects loginPom;
	StudentsProfilePOM 	studentsProfilePOM;
	UploadFilePOM uploadFilePOM;
	AOVOPageObjects aovoPOM;
	Faker fake = new Faker();
	int year = fake.number().numberBetween(1990, 2007);
    int month = fake.number().numberBetween(1, 12);
    int day = fake.number().numberBetween(1, Month.of(month).length(false));
    LocalDate date = LocalDate.of(year, month, day);
    String formattedDate = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    String validPDFFile = "D:\\Excel Upload\\Test Plan PDF Document.pdf";
    String invalidFileType = "D:\\Excel Upload\\6 A.M Feedbacks & Issues.txt";
    String hugeFileSize = "D:\\Excel Upload\\pkpadmin,+838-4074-1-CE (4).pdf";
    String imageFile="D:\\Excel Upload\\sample_640×426.jpeg";
	String downloadPath = "C:\\Users\\DineshM\\Downloads";
	String actualTabText;
	ChromeOptions options = new ChromeOptions();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String tempId;
	Random random = new Random();
	int randomNum = fake.number().numberBetween(100, 500);
	String  randomNumberStr = String.valueOf(randomNum);
	int semMarksScored = fake.number().numberBetween(100, 700);
	String randomSemMarksScored = String.valueOf(semMarksScored);
	int overAllSemMarksScored = fake.number().numberBetween(1000, 4200);
	String randomOverAllSemMarksScored = String.valueOf(overAllSemMarksScored);
	String semTotalMarks = String.valueOf(700);
	String totalMarksOutof = String.valueOf(4200);
	
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
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://172.21.1.248:8085/ERP_QA/admission/");
		loginPom = new LoginPageObjects(driver);
		uploadFilePOM = new UploadFilePOM(driver);
		studentsProfilePOM = new StudentsProfilePOM(driver);
		aovoPOM = new AOVOPageObjects(driver);
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	private void stepInfo(String stepInfo) {
		//GenerateExtentReport.logInfo(stepInfo);
	}
	
	@Test(groups= {"Regression"},priority=1)
	
	public void TC_GQLSP_011_Verify_sending_6_digit_code_with_valid_email() throws IOException, InterruptedException{
		
		stepInfo("TC_SP_011_Verify_sending_6_digit_code_with_valid_email");
		
		softAssert = new SoftAssert();
		
		loginPom.selectNavigation("Admission Officer");
		loginPom.admissionOfficerLogin("thiyagarajan@skitech.ai");
		uploadFilePOM.selectQuota("Government quota");
		uploadFilePOM.uploadValidGovtQuotaLateralFileTemplate("Undergraduate", "Lateral Entry", "7.5% General");
		File downloadedFile = uploadFilePOM.waitForDownloadToComplete(downloadPath, ".xlsx", 20);	
		emailid = uploadFilePOM.getFirstEmailIdFromExcel(downloadedFile);
		admissionNo = uploadFilePOM.getFirstAdmissionNoFromExcel(downloadedFile);
		mobileNo = uploadFilePOM.getFirstMobileNoFromExcel(downloadedFile);
		aovoPOM.clickOnFileUploadCompletedCloseButton();
		aovoPOM.clickOnLogoutButton();
		driver.get("http://172.21.1.248:8085/ERP_QA/admission/");
		loginPom = new LoginPageObjects(driver);
		uploadFilePOM = new UploadFilePOM(driver);
		studentsProfilePOM = new StudentsProfilePOM(driver);
		loginPom.selectNavigation("Student Profile");
		loginPom.enterStudentProfileEmail(emailid);
		loginPom.clickOnSend6DigitCodeButton();
		
		softAssert.assertEquals(loginPom.getWelcomeEmail(), loginPom.getWelcomeEmail(), "Welcome text is " + loginPom.getWelcomeEmail());
		System.out.println(loginPom.getWelcomeEmail());		
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"},priority=2)
	public void TC_GQLSP_012_Verify_sending_6_digit_code_fails_if_email_is_not_recognized(){
		
		stepInfo("Verify_sending_6_digit_code_fails_if_email_is_not_recognized");
		
		softAssert = new SoftAssert();
		
		loginPom.clickOnGoBackButton();
		loginPom.enterStudentProfileEmail("prekumar@yopmail.com");
		driver.findElement(By.xpath("//button[text()='Send 6-digit Code']")).click();
		threadSleep(1000);
		
		softAssert.assertEquals(loginPom.getToasterAlertText(), loginPom.getToasterAlertText(), "Toaster text is " + loginPom.getToasterAlertText());
		System.out.println(loginPom.getToasterAlertText());	
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"},priority=3)
	public void TC_GQLSP_013_Verify_student_profile_signin_with_invalid_OTP(){
		
		stepInfo("Verify_student_profile_signin_with_invalid_OTP");
		
		softAssert = new SoftAssert();
			
		loginPom.enterStudentProfileEmail(emailid);
		loginPom.clickOnSend6DigitCodeButton();
		loginPom.clearOTPInput5();
		loginPom.enterOTPinput5(fake.number().digits(1));
		loginPom.clearOTPInput6();
		loginPom.enterOTPinput6(fake.number().digits(1));
		loginPom.clickOnVerifyOTPandSigninButton();
		
		softAssert.assertEquals(loginPom.getToasterAlertText(), loginPom.getToasterAlertText(), "Toaster Alert is " + loginPom.getToasterAlertText());
		System.out.println(loginPom.getToasterAlertText());	
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"},priority=4)
	public void TC_GQLSP_014_Verify_student_profile_account_signin_with_expired_OTP(){
		
		stepInfo("Verify_student_profile_account_signin_with_expired_OTP");
		
		softAssert = new SoftAssert();
		
		loginPom.clickOnGoBackButton();
		loginPom.enterStudentProfileEmail(emailid);
		loginPom.clickOnSend6DigitCodeButton();
		loginPom.waitFor30Seconds();
		loginPom.clickOnVerifyOTPandSigninButton();
		
		softAssert.assertEquals(loginPom.getToasterAlertText(), loginPom.getToasterAlertText(), "Toaster Alert is " + loginPom.getToasterAlertText());
		System.out.println(loginPom.getToasterAlertText());		
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=5)
	public void TC_GQLSP_015_Verify_Resend_Code_in_sign_in_screen() {
		
		stepInfo("Verify_Resend_Code_in_sign_in_screen");
		
		softAssert = new SoftAssert();
		
		loginPom.clickOnResendCode();
		
		softAssert.assertEquals(loginPom.getWelcomeEmail(), loginPom.getWelcomeEmail(), "Profile text is " + loginPom.getWelcomeEmail());
		System.out.println(loginPom.getWelcomeEmail());
		
		softAssert.assertAll();
		
		loginPom.clickOnGoBackButton();

	}
	
	@Test(groups= {"Regression"}, priority=6)
	public void TC_GQLSP_016_Verify_Go_back_in_sign_in_screen() {
		
		stepInfo("Verify_Go_back_in_sign_in_screen");
		
		softAssert = new SoftAssert();
		
		loginPom.enterStudentProfileEmail(emailid);
		loginPom.clickOnSend6DigitCodeButton();
		loginPom.clickOnGoBackButton();
		
		softAssert.assertEquals(loginPom.getSigninText(), loginPom.getSigninText(), "Text is " + loginPom.getSigninText());
		System.out.println(loginPom.getSigninText());	
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"},priority=7)	
	public void TC_GQLSP_017_Verify_student_profile_account_signin_with_valid_OTP(){
		
		stepInfo("Verify_student_profile_account_signin_with_valid_OTP");
		
		softAssert = new SoftAssert();
		
		loginPom.enterStudentProfileEmail(emailid);
		loginPom.clickOnSend6DigitCodeButton();
		loginPom.clickOnVerifyOTPandSigninButton();
		
		softAssert.assertEquals(studentsProfilePOM.getProfileName(), studentsProfilePOM.getProfileName(), "Welcome text is " + studentsProfilePOM.getProfileName());
		System.out.println(studentsProfilePOM.getProfileName());
		
		softAssert.assertAll();		
	}
	
	@Test(groups= {"Regression"}, priority=8)
	public void TC_GQLSP_018_Verify_personal_details_tab() {
		
		stepInfo("Verify_personal_details_tab");
		
		softAssert = new SoftAssert();

		
		softAssert.assertEquals(studentsProfilePOM.getStudentProfileSectionTab(), studentsProfilePOM.getStudentProfileSectionTab(), "Tab text is " + studentsProfilePOM.getStudentProfileSectionTab());
		System.out.println(studentsProfilePOM.getStudentProfileSectionTab());
		
		softAssert.assertAll();
		
	}
		
	@Test(groups= {"Regression"}, priority=9)
	public void TC_GQLSP_019_Verify_mandatory_alerts_in_add_personal_details_tab() {
		
		stepInfo("Verify_mandatory_alerts_in_add_personal_details_tab");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnStudentProfileSectionTab("Personal Details");
		studentsProfilePOM.clickOnSaveandNextButton();
	
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=10)
	public void TC_GQLSP_020_Verify_add_personal_details() {
		
		stepInfo("Verify_add_personal_details");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.enterAadharNumber(fake.number().digits(12));
		studentsProfilePOM.enterAadharName(fake.name().firstName());
		studentsProfilePOM.enterDOB(formattedDate);
		studentsProfilePOM.selectBloodGroup("B+");
		studentsProfilePOM.selectNationality("Indian");
		studentsProfilePOM.selectReligion("Hindu");
		studentsProfilePOM.selectCaste("Gangavar");
		studentsProfilePOM.selectMotherTongue("Tamil");
		studentsProfilePOM.selectPhysicallyChallenged("Yes");
		studentsProfilePOM.selectFamilyAnnualIncome("₹2,50,001 – ₹4,00,000");
		studentsProfilePOM.clickOnSaveandNextButton();
		
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=11)
	public void TC_GQLSP_021_Verify_add_personal_details_with_invalid_data() {
		
		stepInfo("Verify_add_personal_details_with_invalid_data");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.enterAadharNumber(fake.name().firstName() + "@#$");
		studentsProfilePOM.enterAadharName(fake.space().toString());
	
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=12)
	public void TC_GQLSP_025_Verify_upload_physically_challenged_and_income_certificate_with_invalid_file_types() {
		
		stepInfo("Verify_upload_physically_challenged_and_income_certificate_with_invalid_file_types");
		
		softAssert = new SoftAssert();
		
		driver.navigate().refresh();
		threadSleep(1000);
		studentsProfilePOM.selectPhysicallyChallenged("Yes");
		studentsProfilePOM.uploadPhysicallyChallengedCertificate(invalidFileType);
		studentsProfilePOM.uploadIncomeCertificate(invalidFileType);

		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=13)
	public void TC_GQLSP_027_Verify_upload_physically_challenged_income_certificate_with_file_size_more_than_5mb() {
		
		stepInfo("Verify_upload_physically_challenged_income_certificate_with_file_size_more_than_5mb");
		
		softAssert = new SoftAssert();
		
		driver.navigate().refresh();
		threadSleep(1000);
		studentsProfilePOM.uploadPhysicallyChallengedCertificate(hugeFileSize);
		studentsProfilePOM.uploadIncomeCertificate(hugeFileSize);

		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=14)
	public void TC_GQLSP_028_Verify_personal_details_go_to_home_button() {
		
		stepInfo("Verify_personal_details_go_to_home_button");
		
		softAssert = new SoftAssert();
		
		driver.navigate().refresh();
		studentsProfilePOM.clickOnGotoHomeButton();

		softAssert.assertEquals(studentsProfilePOM.getProfileName(), studentsProfilePOM.getProfileName(), "Text is " + studentsProfilePOM.getProfileName());
		System.out.println(studentsProfilePOM.getProfileName());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=15)
	public void TC_GQLSP_029_Verify_next_step_in_personal_details_tab() {
		
		stepInfo("Verify_next_step_in_personal_details_tab");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnStudentProfileSectionTab("Personal Details");
		studentsProfilePOM.clickOnNextButton();
		actualTabText = studentsProfilePOM.getMatchingTabText("Academic details");

		softAssert.assertEquals(actualTabText, "Academic details", "Tab name mismatch");
		System.out.println(actualTabText);
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=16)
	public void TC_GQLSP_030_Verify_academic_details_tab() {
		
		stepInfo("Verify_academic_details_tab");
		
		softAssert = new SoftAssert();
		
		softAssert.assertEquals(studentsProfilePOM.getAcademicDetailsSection(), studentsProfilePOM.getAcademicDetailsSection(), "Section name mismatch"+ studentsProfilePOM.getAcademicDetailsSection());
		System.out.println(studentsProfilePOM.getAcademicDetailsSection());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=17)
	public void TC_GQLSP_031_Verify_mandatory_alerts_in_add_academic_details_tab() {
		
		stepInfo("Verify_mandatory_alerts_in_add_academic_details_tab");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnSaveandNextButton();	
				
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=18)
	public void TC_GQLSP_032_Verify_add_academic_details_with_invalid_data() {
		
		stepInfo("Verify_add_academic_details_with_invalid_data");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.enterSSLCRollNo("sdkfshj*^*");
		studentsProfilePOM.enterHSC1PermanentRegisterNo("876(*&(*&%*&");
		studentsProfilePOM.enterHSC2PermanentRegisterNo("876(*&(*&%*&");
		studentsProfilePOM.enterHSC2EMISNo("uyg*&^&");
		studentsProfilePOM.enterHSC2OptionalSubjectMark("uyg*&^&");
		studentsProfilePOM.clickOnSaveandNextButton();	
				
		
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=19)
	public void TC_GQLSP_033_Verify_add_academic_details_with_10th_HSC1_Diploma() {
		
		stepInfo("Verify_add_academic_details_with_10th_HSC1_Diploma");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.selectStudiedOutsideIndia("No");
		studentsProfilePOM.selectStudiedOutsideTamilnadu("No");
		studentsProfilePOM.selectSSLCState("Tamil Nadu");
		studentsProfilePOM.selectSSLCBoardofStudy("State Board");
		studentsProfilePOM.selectSSLCDistrict("Coimbatore");
		studentsProfilePOM.selectSSLCSchoolZone("Coimbatore");
		studentsProfilePOM.selectSSLCSchoolName("Air Force School,Coimbatore");
		studentsProfilePOM.selectSSLCMediumofStudy("English");
		studentsProfilePOM.selectSSLCYearOfPassing("2023");
		studentsProfilePOM.enterSSLCRollNo(fake.number().digits(6));
		studentsProfilePOM.enterSSLCMarksScored(randomNumberStr);
		studentsProfilePOM.selectHSC1State("Tamil Nadu");
		studentsProfilePOM.selectHSC1BoardofStudy("State Board");
		studentsProfilePOM.selectHSC1District("Coimbatore");
		studentsProfilePOM.selectHSC1SchoolZone("Coimbatore");
		studentsProfilePOM.selectHSC1SchoolName("Air Force School,Coimbatore");
		studentsProfilePOM.selectHSC1MediumofStudy("English");
		studentsProfilePOM.selectHSC1YearofPassing("2024");
		studentsProfilePOM.enterHSC1PermanentRegisterNo(fake.number().digits(8));
		studentsProfilePOM.selectHSC1GrouporStream("Academic (HSC)");
		studentsProfilePOM.enterHSC1MarksScored(randomNumberStr);
		studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC2();
		studentsProfilePOM.selectDiplomaCountry("India");
		studentsProfilePOM.selectDiplomaState("Tamil Nadu");
		studentsProfilePOM.selectDiplomaCourseType("Regular");
		studentsProfilePOM.selectDiplomaBoardofStudy("DOTE");
		studentsProfilePOM.selectDiplomaCollege("R V S Polytechnic College, Coimbatore");
		studentsProfilePOM.selectDiplomaBranchorDepartment("Computer Technology");
		studentsProfilePOM.selectDiplomaMonthofPassing("April");
		studentsProfilePOM.selectDiplomaYearofPassing("2025");
		studentsProfilePOM.enterDiplomaExamRegisterNo(fake.number().digits(11));
		studentsProfilePOM.enterDiplomaUMISNo(fake.number().digits(8));
		studentsProfilePOM.enterSem1MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem2MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem3MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem4MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem5MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem6MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterMarksScoredOverallTotal(randomOverAllSemMarksScored);
		studentsProfilePOM.enterSem1TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem2TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem3TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem4TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem5TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem6TotalMarks(semTotalMarks);
		studentsProfilePOM.enterTotalMarksOverallTotal(totalMarksOutof);
		studentsProfilePOM.enterOverallPercentage(fake.number().digits(2));
		studentsProfilePOM.clickOnSaveandNextButton();
		
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=20)
	public void TC_GQLSP_034_Verify_add_academic_details_with_10th_HSC1_HSC2_Diploma() {
		
		stepInfo("Verify_add_academic_details_with_10th_HSC1_HSC2_Diploma");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnPreviousButton();
		//studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC2();
		studentsProfilePOM.selectHSC2State("Tamil Nadu");
		studentsProfilePOM.selectHSC2BoardofStudy("State Board");
		studentsProfilePOM.selectHSC2District("Coimbatore");
		studentsProfilePOM.selectHSC2SchoolZone("Coimbatore");
		studentsProfilePOM.selectHSC2SchoolName("Air Force School,Coimbatore");
		studentsProfilePOM.selectHSC2SchoolCategory("Private");
		studentsProfilePOM.selectHSC2CivicStatus("Town");
		studentsProfilePOM.selectHSC2MediumofStudy("English");
		studentsProfilePOM.selectHSC2YearofPassing("2025");
		studentsProfilePOM.enterHSC2PermanentRegisterNo(fake.number().digits(8));
		studentsProfilePOM.selectHSC2GrouporStream("Academic (HSC)");
		studentsProfilePOM.enterHSC2EMISNo(fake.number().digits(12));
		studentsProfilePOM.enterHSC2MarksScored(randomNumberStr);
		studentsProfilePOM.enterHSC2MathsMark(fake.number().digits(2));
		studentsProfilePOM.enterHSC2PhysicsMark(fake.number().digits(3));
		studentsProfilePOM.enterHSC2ChemistryMark(fake.number().digits(2));
		studentsProfilePOM.enterHSC2OptionalSubjectMark(fake.number().digits(2));
		studentsProfilePOM.clickOnSaveandNextButton();
		
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=21)
	public void TC_GQLSP_035_Verify_add_academic_details_with_10th_Diploma() {
		
		stepInfo("Verify_add_academic_details_with_10th_Diploma");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC1();
		studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC2();
		studentsProfilePOM.clickOnSaveandNextButton();
		
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=22)
	public void TC_GQLSP_036_Verify_add_academic_details_with_Diploma_Course_Type_Lateral() {
		
		stepInfo("Verify_add_academic_details_with_10th_Diploma");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC1();
		studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC2();
		studentsProfilePOM.selectDiplomaCourseType("Lateral");
		studentsProfilePOM.selectDiplomaBoardofStudy("Deemed");
		studentsProfilePOM.enterSem3MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem4MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem5MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem6MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterMarksScoredOverallTotal(randomOverAllSemMarksScored);
		studentsProfilePOM.enterSem3TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem4TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem5TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem6TotalMarks(semTotalMarks);
		studentsProfilePOM.enterTotalMarksOverallTotal(totalMarksOutof);
		studentsProfilePOM.enterOverallPercentage(fake.number().digits(2));
		studentsProfilePOM.clickOnSaveandNextButton();
		
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=23)
	public void TC_GQLSP_037_Verify_add_academic_details_with_diploma_course_type_sandwich_7_semesters() {
		
		stepInfo("Verify_add_academic_details_with_diploma_course_type_sandwich_7_semesters");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC1();
		studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC2();
		studentsProfilePOM.selectDiplomaCourseType("Sandwich (7 Semesters)");
		studentsProfilePOM.selectDiplomaBoardofStudy("AICTE");
		studentsProfilePOM.enterSem1MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem2MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem3MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem4MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem5MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem6MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem7MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterMarksScoredOverallTotal(randomOverAllSemMarksScored);
		studentsProfilePOM.enterSem1TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem2TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem3TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem4TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem5TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem6TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem7TotalMarks(semTotalMarks);
		studentsProfilePOM.enterTotalMarksOverallTotal(totalMarksOutof);
		studentsProfilePOM.enterOverallPercentage(fake.number().digits(2));
		studentsProfilePOM.clickOnSaveandNextButton();
				
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=24)
	public void TC_GQLSP_038_Verify_add_academic_details_with_diploma_course_type_sandwich_8_semesters() {
		
		stepInfo("Verify_add_academic_details_with_diploma_course_type_sandwich_8_semesters");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC1();
		studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC2();
		studentsProfilePOM.selectDiplomaCourseType("Sandwich (8 Semesters)");
		studentsProfilePOM.selectDiplomaBoardofStudy("Autonomous");
		studentsProfilePOM.enterSem1MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem2MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem3MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem4MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem5MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem6MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem7MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem8MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterMarksScoredOverallTotal(randomOverAllSemMarksScored);
		studentsProfilePOM.enterSem1TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem2TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem3TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem4TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem5TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem6TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem7TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem8TotalMarks(semTotalMarks);
		studentsProfilePOM.enterTotalMarksOverallTotal(totalMarksOutof);
		studentsProfilePOM.enterOverallPercentage(fake.number().digits(2));
		studentsProfilePOM.clickOnSaveandNextButton();
				
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=25)
	public void TC_GQLSP_039_Verify_add_academic_details_with_diploma_course_type_sandwich_lateral_7_semesters() {
		
		stepInfo("Verify_add_academic_details_with_diploma_course_type_sandwich_lateral_7_semesters");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC1();
		studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC2();
		studentsProfilePOM.selectDiplomaCourseType("Sandwich (Lateral 7 Semesters)");
		studentsProfilePOM.selectDiplomaBoardofStudy("State Technical Education Board");
		studentsProfilePOM.enterSem3MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem4MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem5MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem6MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem7MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterMarksScoredOverallTotal(randomOverAllSemMarksScored);
		studentsProfilePOM.enterSem3TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem4TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem5TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem6TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem7TotalMarks(semTotalMarks);
		studentsProfilePOM.enterTotalMarksOverallTotal(totalMarksOutof);
		studentsProfilePOM.enterOverallPercentage(fake.number().digits(2));
		studentsProfilePOM.clickOnSaveandNextButton();
				
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=26)
	public void TC_GQLSP_040_Verify_add_academic_details_with_diploma_course_type_sandwich_lateral_8_semesters() {
		
		stepInfo("Verify_add_academic_details_with_diploma_course_type_sandwich_lateral_8_semesters");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC1();
		studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC2();
		studentsProfilePOM.selectDiplomaCourseType("Sandwich (Lateral 8 Semesters)");
		studentsProfilePOM.selectDiplomaBoardofStudy("State Technical Education Board");
		studentsProfilePOM.enterSem3MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem4MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem5MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem6MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem7MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterSem8MarksScored(randomSemMarksScored);
		studentsProfilePOM.enterMarksScoredOverallTotal(randomOverAllSemMarksScored);
		studentsProfilePOM.enterSem3TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem4TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem5TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem6TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem7TotalMarks(semTotalMarks);
		studentsProfilePOM.enterSem8TotalMarks(semTotalMarks);
		studentsProfilePOM.enterTotalMarksOverallTotal(totalMarksOutof);
		studentsProfilePOM.enterOverallPercentage(fake.number().digits(2));
		studentsProfilePOM.clickOnSaveandNextButton();
				
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=27)
	public void TC_GQLSP_041_Add_academic_details_by_uploading_invalid_file_types() {
		
		stepInfo("Add_academic_details_by_uploading_invalid_file_types");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnPreviousButton();
		//studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC1();
		studentsProfilePOM.selectHSC1State("Tamil Nadu");
		studentsProfilePOM.selectHSC1BoardofStudy("State Board");
		studentsProfilePOM.selectHSC1District("Coimbatore");
		studentsProfilePOM.selectHSC1SchoolZone("Coimbatore");
		studentsProfilePOM.selectHSC1SchoolName("Air Force School,Coimbatore");
		studentsProfilePOM.selectHSC1MediumofStudy("English");
		studentsProfilePOM.selectHSC1YearofPassing("2024");
		studentsProfilePOM.enterHSC1PermanentRegisterNo(fake.number().digits(8));
		studentsProfilePOM.selectHSC1GrouporStream("Academic (HSC)");
		studentsProfilePOM.enterHSC1MarksScored(randomNumberStr);
		//studentsProfilePOM.tickChkBoxSelectifyouhavecompletedHSC2();
		studentsProfilePOM.selectHSC2State("Tamil Nadu");
		studentsProfilePOM.selectHSC2BoardofStudy("State Board");
		studentsProfilePOM.selectHSC2District("Coimbatore");
		studentsProfilePOM.selectHSC2SchoolZone("Coimbatore");
		studentsProfilePOM.selectHSC2SchoolName("Air Force School,Coimbatore");
		studentsProfilePOM.selectHSC2SchoolCategory("Private");
		studentsProfilePOM.selectHSC2CivicStatus("Town");
		studentsProfilePOM.selectHSC2MediumofStudy("English");
		studentsProfilePOM.selectHSC2YearofPassing("2025");
		studentsProfilePOM.enterHSC2PermanentRegisterNo(fake.number().digits(8));
		studentsProfilePOM.selectHSC2GrouporStream("Academic (HSC)");
		studentsProfilePOM.enterHSC2EMISNo(fake.number().digits(12));
		studentsProfilePOM.enterHSC2MarksScored(randomNumberStr);
		studentsProfilePOM.enterHSC2MathsMark(fake.number().digits(2));
		studentsProfilePOM.enterHSC2PhysicsMark(fake.number().digits(3));
		studentsProfilePOM.enterHSC2ChemistryMark(fake.number().digits(2));
		studentsProfilePOM.enterHSC2OptionalSubjectMark(fake.number().digits(2));
		studentsProfilePOM.clickOnSaveandNextButton();
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.uploadSSLCMarkSheet(invalidFileType);
		studentsProfilePOM.uploadHSC1MarkSheet(invalidFileType);
		studentsProfilePOM.uploadHSC2Marksheet(invalidFileType);
		
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
		@Test(groups= {"Regression"}, priority=28)
		public void TC_GQLSP_042_Verify_Upload_mark_sheet_document_more_than_5_mb() {
			
			stepInfo("Verify_Upload_mark_sheet_document_more_than_5_mb");
			
			softAssert = new SoftAssert();
					
			studentsProfilePOM.uploadSSLCMarkSheet(hugeFileSize);
			studentsProfilePOM.uploadHSC1MarkSheet(hugeFileSize);
			studentsProfilePOM.uploadHSC2Marksheet(hugeFileSize);
			
			softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
			System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
			
			softAssert.assertAll();
			
		}
	
	@Test(groups= {"Regression"}, priority=29)
	public void TC_GQLSP_043_Verify_academic_details_Go_to_Home() {
		
		stepInfo("Verify_academic_details_Go_to_Home");
		
		softAssert = new SoftAssert();
				
		driver.navigate().refresh();
		studentsProfilePOM.clickOnGotoHomeButton();		
		
		softAssert.assertEquals(studentsProfilePOM.getProfileName(), studentsProfilePOM.getProfileName(), "Toaster text is " + studentsProfilePOM.getProfileName());
		System.out.println(studentsProfilePOM.getProfileName());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=30)
	public void TC_GQLSP_045_Verify_family_details_tab() {
		
		stepInfo("Verify_family_details_tab");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnStudentProfileSectionTab("Family Details");	
			
		softAssert.assertEquals(studentsProfilePOM.getFamilyDetailsSectionText(), studentsProfilePOM.getFamilyDetailsSectionText(), "Toaster text is " + studentsProfilePOM.getFamilyDetailsSectionText());
		System.out.println(studentsProfilePOM.getFamilyDetailsSectionText());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=31)
	public void TC_GQLSP_046_Verify_mandatory_field_alert_in_add_family_details_tab() {
		
		stepInfo("Verify_mandatory_field_alert_in_add_family_details_tab");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnIWanttoAddGuardianDetailsCheckBox();
		studentsProfilePOM.selectDoYouHaveSiblings("Yes");
		studentsProfilePOM.selectSiblings1JoinedinthisInstitutionBefore("Yes");
		studentsProfilePOM.clickOnSaveandNextButton();
				
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
	}
	
	@Test(groups= {"Regression"}, priority=32)
	public void TC_GQLSP_047_Verify_add_family_details_with_invalid_data() {
		
		stepInfo("Verify_add_family_details_with_invalid_data");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.selectFamilyType("With Parents");
		studentsProfilePOM.enterFatherFullName(fake.number().digits(5));
		studentsProfilePOM.enterFatherAadharNumber("&^%&^siudg");
		studentsProfilePOM.enterFatherEmail("&%&^%87687ulk");
		studentsProfilePOM.enterFatherWorkPlaceorCompany("Private");
		studentsProfilePOM.enterMotherFullName("63498*&^*&");
		studentsProfilePOM.enterMotherAadharNumber("aoiua(*&*(&");
		studentsProfilePOM.enterMotherEmailid("sdlhu*(&(*&");
		studentsProfilePOM.enterGuardianFullName("*&^876876");
		studentsProfilePOM.enterGuardianAadharNumber("ijksdn**&^");
		studentsProfilePOM.enterGuardianEmailid("aiusd*&^87");
		studentsProfilePOM.enterSibling1RegisterNo("&%*&%&");
		studentsProfilePOM.enterSibling1FullName("8976987575&%&%");
		studentsProfilePOM.enterSibling1Email("8976987575&%&%");
				
			
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
			
		
	}
	
	@Test(groups= {"Regression"}, priority=33)
	public void TC_GQLSP_048_Verify_add_family_details_with_family_type_as_with_parents() {
		
		stepInfo("Verify_add_family_details_with_family_type_as_with_parents");
		
		softAssert = new SoftAssert();

		driver.navigate().refresh();
		threadSleep(3000);
		studentsProfilePOM.enterFatherFullName(fake.name().fullName());
		studentsProfilePOM.enterFatherAadharNumber(fake.number().digits(12));
		studentsProfilePOM.selectFatherResidentStatus("Resident");
		studentsProfilePOM.enterFatherMobileNumber("9"+fake.number().digits(9));
		studentsProfilePOM.enterFatherEmail(fake.internet().emailAddress());
		studentsProfilePOM.selectFatherOccupation("Self-employed");
		studentsProfilePOM.selectFatherAnnualIncome("₹6,00,001 – ₹8,00,000");
		studentsProfilePOM.enterFatherWorkPlaceorCompany(fake.company().name());
		studentsProfilePOM.enterFatherEducationalQaulification(fake.educator().toString());
		studentsProfilePOM.enterMotherFullName(fake.name().firstName());
		studentsProfilePOM.enterMotherAadharNumber(fake.number().digits(12));
		studentsProfilePOM.selectMotherResidenceStatus("Resident");
		studentsProfilePOM.enterMotherMobileNumber("9"+fake.number().digits(9));
		studentsProfilePOM.enterMotherEmailid(fake.internet().emailAddress());
		studentsProfilePOM.selectMotherOccupation("Others (Specify)");
		studentsProfilePOM.enterMotherOccupationIfOthers(fake.job().title());
		studentsProfilePOM.selectMotherAnnualIncome("₹2,00,001 – ₹2,50,000");
		studentsProfilePOM.enterMotherWorkPlaceorCompany(fake.company().name());
		studentsProfilePOM.enterMotherEducationalQualification(fake.educator().toString());
		studentsProfilePOM.clickOnSaveandNextButton();		
				
			
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=34)
	public void TC_GQLSP_049_Verify_add_family_details_with_family_type_as_single_parent_with_mother() {
		
		stepInfo("Verify_add_family_details_with_family_type_as_single_parent_with_mother");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();		
		studentsProfilePOM.selectFamilyType("Single Parent - Mother");
//		studentsProfilePOM.enterMotherFullName(fake.name().firstName());
//		studentsProfilePOM.enterMotherAadharNumber(fake.number().digits(12));
//		studentsProfilePOM.selectMotherResidenceStatus("Resident");
//		studentsProfilePOM.enterMotherMobileNumber("9"+fake.number().digits(9));
//		studentsProfilePOM.enterMotherEmailid(fake.internet().emailAddress());
//		studentsProfilePOM.selectMotherOccupation("Self-employed");
//		studentsProfilePOM.selectMotherAnnualIncome("₹2,00,001 – ₹2,50,000");
//		studentsProfilePOM.enterMotherWorkPlaceorCompany(fake.company().name());
//		studentsProfilePOM.enterMotherEducationalQualification(fake.educator().toString());
		studentsProfilePOM.clickOnSaveandNextButton();
			
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=35)
	public void TC_GQLSP_050_Verify_add_family_details_with_family_type_as_single_parent_with_father() {
		
		stepInfo("Verify_add_family_details_with_family_type_as_single_parent_with_father");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();	
		studentsProfilePOM.selectFamilyType("Single Parent - Father");
//		studentsProfilePOM.enterFatherFullName(fake.name().fullName());
//		studentsProfilePOM.enterFatherAadharNumber(fake.number().digits(12));
//		studentsProfilePOM.selectFatherResidentStatus("Resident");
//		studentsProfilePOM.enterFatherMobileNumber("9"+fake.number().digits(9));
//		studentsProfilePOM.enterFatherEmail(fake.internet().emailAddress());
//		studentsProfilePOM.selectFatherOccupation("Others (Specify)");
//		studentsProfilePOM.enterFatherOccupationifOthers(fake.job().title());
//		studentsProfilePOM.selectFatherAnnualIncome("₹6,00,001 – ₹8,00,000");
//		studentsProfilePOM.enterFatherWorkPlaceorCompany(fake.company().name());
//		studentsProfilePOM.enterFatherEducationalQaulification(fake.educator().toString());
		studentsProfilePOM.clickOnSaveandNextButton();
			
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=36)
	public void TC_GQLSP_051_Verify_add_family_details_with_family_type_as_with_guardian() {
		
		stepInfo("Verify_add_family_details_with_family_type_as_with_guardian");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();	
		studentsProfilePOM.selectFamilyType("With Guardian");
		studentsProfilePOM.enterGuardianFullName(fake.name().fullName());
		studentsProfilePOM.enterGuardianAadharNumber(fake.number().digits(12));
		studentsProfilePOM.enterGuardianMobileNumber("9" + fake.number().digits(9));
		studentsProfilePOM.selectGuardianOccupation("Private Employee");
		studentsProfilePOM.selectGuardianAnnualIncome("₹4,00,001 – ₹6,00,000");
		studentsProfilePOM.selectGuardianGender("Male");
		studentsProfilePOM.selectGuardianRelationshipWithStudent("Uncle");
		studentsProfilePOM.clickOnSaveandNextButton();
			
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	

	//@Test(groups= {"Regression"}, priority=37)
	public void TC_GQLSP_054_Verify_with_No_in_Has_any_of_your_siblings_joined_this_institution_before_fields() {
	
	stepInfo("Verify_with_No_in_Has_any_of_your_siblings_joined_this_institution_before_fields");
	
	softAssert = new SoftAssert();
	
	studentsProfilePOM.clickOnPreviousButton();
	//loginPom.pageScrollDown();
	studentsProfilePOM.selectDoYouHaveSiblings("Yes");
	studentsProfilePOM.selectSiblings1JoinedinthisInstitutionBefore("No");
	studentsProfilePOM.clickOnSaveandNextButton();
						
	softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
	System.out.println(studentsProfilePOM.getSuccessToasterAlert());
	
	softAssert.assertAll();
	
	}
	
	//@Test(groups= {"Regression"}, priority=38)
	public void TC_GQLSP_055_Verify_add_family_details_with_do_you_have_siblings_as_No() {
		
		stepInfo("Verify_add_family_details_with_do_you_have_siblings_as_No");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.selectDoYouHaveSiblings("No");
		studentsProfilePOM.clickOnSaveandNextButton();
							
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
				
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=39)
	public void TC_GQLSP_056_Verify_mandatory_fields_in_siblings() {
		
		stepInfo("Verify_mandatory_fields_in_siblings");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.selectDoYouHaveSiblings("Yes");
		studentsProfilePOM.selectSiblings1JoinedinthisInstitutionBefore("Yes");
		studentsProfilePOM.clickOnSaveandNextButton();
							
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=40)
	public void TC_GQLSP_057_Verify_add_sibling_with_invalid_data() {
		
		stepInfo("Verify_add_sibling_with_invalid_data");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.enterSibling1RegisterNo("dsdf;(*&");
		studentsProfilePOM.enterSibling1FullName("978*&^(*&");
		studentsProfilePOM.enterSibling1Email("difds(*&(*&^9876");
		studentsProfilePOM.clickOnSaveandNextButton();
							
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=41)
	public void TC_GQLSP_058_Verify_add_sibling_with_valid_data() {
		
		stepInfo("Verify_add_sibling_with_valid_data");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.selectSibling1College("Sri Krishna College of Technology");
		studentsProfilePOM.selectSibling1Degree("Bachelor of Technology");
		studentsProfilePOM.selectSibling1AdmissionYear("2020");
		studentsProfilePOM.enterSibling1RegisterNo(fake.number().digits(5));
		studentsProfilePOM.enterSibling1FullName(fake.name().fullName());
		studentsProfilePOM.selectSibling1Gender("Male");
		studentsProfilePOM.enterSibling1DOB(formattedDate);
		studentsProfilePOM.enterSibling1MobileNo("9"+fake.number().digits(9));
		studentsProfilePOM.enterSibling1Email(fake.internet().emailAddress());
		studentsProfilePOM.clickOnSaveandNextButton();
							
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=42)
	public void TC_GQLSP_059_Verify_add_another_sibling() {
		
		stepInfo("Verify_add_another_sibling");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.clickOnAddAnotherSibling();
		studentsProfilePOM.selectSiblings2JoinedinthisInstitutionBefore("Yes");
		studentsProfilePOM.selectSibling2College("Sri Krishna College of Technology");
		studentsProfilePOM.selectSibling2Degree("Bachelor of Technology");
		studentsProfilePOM.selectSibling2AdmissionYear("2020");
		studentsProfilePOM.enterSibling2RegisterNo(fake.number().digits(5));
		studentsProfilePOM.enterSibling2FullName(fake.name().fullName());
		studentsProfilePOM.selectSibling2Gender("Male");
		studentsProfilePOM.enterSibling2DOB(formattedDate);
		studentsProfilePOM.enterSibling2MobileNo("9"+fake.number().digits(9));
		studentsProfilePOM.enterSibling2Email(fake.internet().emailAddress());
		studentsProfilePOM.clickOnSaveandNextButton();
							
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=43)
	public void TC_GQLSP_061_Verify_update_siblings() {
		
		stepInfo("Verify_update_siblings");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.selectSibling2College("Sri Krishna College of Technology");
		studentsProfilePOM.selectSibling2Degree("Bachelor of Technology");
		studentsProfilePOM.selectSibling2AdmissionYear("2020");
		studentsProfilePOM.enterSibling2RegisterNo(fake.number().digits(5));
		studentsProfilePOM.enterSibling2FullName(fake.name().fullName());
		studentsProfilePOM.selectSibling2Gender("Male");
		studentsProfilePOM.enterSibling2DOB(formattedDate);
		studentsProfilePOM.enterSibling2Email(fake.internet().emailAddress());
		studentsProfilePOM.clickOnSaveandNextButton();
							
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=44)
	public void TC_GQLSP_062_Verify_remove_siblings() {
		
		stepInfo("Verify_remove_siblings");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.removeSibling2();
		studentsProfilePOM.clickOnSaveandNextButton();
							
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=45)
	public void TC_GQLSP_064_Verify_Go_To_Home_Button_in_family_details() {
		
		stepInfo("Verify_Go_To_Home_Button_in_family_details");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.clickOnGotoHomeButton();
						
		softAssert.assertEquals(studentsProfilePOM.getProfileName(), studentsProfilePOM.getProfileName(), "Toaster text is " + studentsProfilePOM.getProfileName());
		System.out.println(studentsProfilePOM.getProfileName());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=46)
	public void TC_GQLSP_065_Verify_address_details_tab() {
		
		stepInfo("Verify_address_details_tab");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnStudentProfileSectionTab("Address Details");	
						
		softAssert.assertEquals(studentsProfilePOM.getAddressDetailsSectionText(), studentsProfilePOM.getAddressDetailsSectionText(), "Toaster text is " + studentsProfilePOM.getAddressDetailsSectionText());
		System.out.println(studentsProfilePOM.getAddressDetailsSectionText());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=47)
	public void TC_GQLSP_066_Verify_mandatory_fields_in_address_details_tab() {
		
		stepInfo("Verify_mandatory_fields_in_address_details_tab");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnGuardianorPrivateAddressOption("Yes");
		studentsProfilePOM.clickOnSaveandNextButton();	
						
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
		
	@Test(groups= {"Regression"}, priority=48)
	public void TC_GQLSP_067_Verify_add_address_details_with_invalid_data() {
		
		stepInfo("Verify_add_address_details_with_invalid_data");
		
		softAssert = new SoftAssert();
		
		driver.navigate().refresh();
		threadSleep(3000);
		studentsProfilePOM.enterPermanentAddressPinCode("dsaj(*&");
		studentsProfilePOM.enterCommunicationAddressPincode("as(*&");
		studentsProfilePOM.clickOnGuardianorPrivateAddressOption("Yes");
		studentsProfilePOM.enterGuardianAddressPincode("asuhsa(*&(*");
		studentsProfilePOM.clickOnSaveandNextButton();	
						
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=49)
	public void TC_GQLSP_068_Verify_add_address_details_tab() {
		
		stepInfo("Verify_add_address_details_tab");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.selectPermanentAddressCountry("India");
		studentsProfilePOM.selectPermanentAddressState("Tamil Nadu");
		studentsProfilePOM.enterPermanentAddressLine1(fake.address().fullAddress());
		studentsProfilePOM.selectPermanentAddressCity("Coimbatore");
		studentsProfilePOM.enterPermanentAddressPinCode("6" + fake.number().digits(5));
		studentsProfilePOM.selectCommunicationAddressCountry("India");
		studentsProfilePOM.selectCommunicationAddressState("Tamil Nadu");
		studentsProfilePOM.enterCommunicationAddressLine1(fake.address().streetAddress());
		studentsProfilePOM.selectCommunicationAddressCity("Coimbatore");
		studentsProfilePOM.enterCommunicationAddressPincode("6" + fake.number().digits(5));
		studentsProfilePOM.selectGuardianAddressCountry("India");
		studentsProfilePOM.selectGuardianAddressState("Tamil Nadu");
		studentsProfilePOM.enterGuardianAddressLine1(fake.address().streetAddress());
		studentsProfilePOM.enterGuardianAddressLine2(fake.address().cityName());
		studentsProfilePOM.selectGuardianAddressCity("Coimbatore");
		studentsProfilePOM.enterGuardianAddressPincode("6" + fake.number().digits(5));
		studentsProfilePOM.clickOnSaveandNextButton();	
						
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=50)
	public void TC_GQLSP_069_Verify_Communication_address_is_same_as_permanent_address() {
		
		stepInfo("Verify_Communication_address_is_same_as_permanent_address");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.clickOnCommunicationaddressisSameAsPermanentAddress();
		studentsProfilePOM.clickOnGuardianorPrivateAddressOption("No");
		studentsProfilePOM.clickOnSaveandNextButton();
						
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=51)
	public void TC_GQLSP_070_Verify_go_to_home_in_address_details() {
		
		stepInfo("Verify_go_to_home_in_address_details");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.clickOnGotoHomeButton();
						
		softAssert.assertEquals(studentsProfilePOM.getProfileName(), studentsProfilePOM.getProfileName(), "Toaster text is " + studentsProfilePOM.getProfileName());
		System.out.println(studentsProfilePOM.getProfileName());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=52)
	public void TC_GQLSP_072_Verify_Admission_Details_tab() {
		
		stepInfo("Verify_Admission_Details_tab");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnStudentProfileSectionTab("Admission Details");	
						
		softAssert.assertEquals(studentsProfilePOM.getAdmissionDetailsSectionText(), studentsProfilePOM.getAdmissionDetailsSectionText(), "Toaster text is " + studentsProfilePOM.getAdmissionDetailsSectionText());
		System.out.println(studentsProfilePOM.getAdmissionDetailsSectionText());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=53)
	public void TC_GQLSP_073_Verify_admission_details_tab_mandatory_fields() {
		
		stepInfo("Verify_admission_details_tab_mandatory_fields");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnSaveandNextButton();
						
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();		
	}
	
	@Test(groups= {"Regression"}, priority=54)
	public void TC_GQLSP_074_Verify_add_admission_details_with_invalid_data() {
		
		stepInfo("Verify_add_admission_details_with_invalid_data");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.enterTNEAAdmissionNo("sdfsdgfdsg");	
		studentsProfilePOM.clickOnSaveandNextButton();
						
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=55)
	public void TC_GQLSP_075_Verify_add_admission_details_with_valid_data() {
		
		stepInfo("Verify_add_admission_details_with_valid_data");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.enterTNEAAdmissionNo(fake.number().digits(12));	
		studentsProfilePOM.selectScholarType("Hosteller");
		studentsProfilePOM.clickOnSaveandNextButton();
						
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
		
	@Test(groups= {"Regression"}, priority=56)
	public void TC_GQLSP_076_Verify_add_admission_details_with_dayscholar_college_transport() {
		
		stepInfo("Verify_add_admission_details_with_dayscholar_college_transport");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.selectScholarType("Day Scholar");
		studentsProfilePOM.selectDayScholarCommutePreference("College Transport");
		studentsProfilePOM.selectPickUpPoint("Sitra - Neelambur");
		studentsProfilePOM.clickOnSaveandNextButton();
							
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=57)
	public void TC_GQLSP_077_Verify_add_admission_details_with_dayscholar_for_personal_transport_for_two_wheeler() {
		
		stepInfo("Verify_add_admission_details_with_dayscholar_for_personal_transport_for_two_wheeler");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.selectDayScholarCommutePreference("Personal Transport");
		studentsProfilePOM.selectPersonalTransportVehicleType("Two Wheeler");
		studentsProfilePOM.enterTwoWheelerVehicleNumber("TN37DE1847");
		studentsProfilePOM.enterTwoWheelerLicenseNumber("TN" + fake.number().digits(10));
		studentsProfilePOM.clickOnSaveandNextButton();
							
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=58)
	public void TC_GQLSP_078_Verify_add_admission_details_with_dayscholar_for_personal_transport_for_four_wheeler() {
		
		stepInfo("Verify_add_admission_details_with_dayscholar_for_personal_transport_for_four_wheeler");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.selectPersonalTransportVehicleType("Four Wheeler");
		studentsProfilePOM.enterFourWheelerVehicleNumber("TN37DE1847");
		studentsProfilePOM.enterFourWheelerLicenseNumber("TN" + fake.number().digits(10));
		studentsProfilePOM.clickOnSaveandNextButton();
							
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=59)
	public void TC_GQLSP_079_Verify_add_admission_details_with_dayscholar_for_personal_transport_for_Pickup_and_Drop_by_Parents() {
		
		stepInfo("Verify_add_admission_details_with_dayscholar_for_personal_transport_for_Pickup_and_Drop_by_Parents");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.selectPersonalTransportVehicleType("Pickup & Drop by Parent(s)");
		studentsProfilePOM.clickOnSaveandNextButton();
							
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=60)
	public void TC_GQLSP_080_Verify_add_admission_details_with_dayscholar_public_transport() {
		
		stepInfo("Verify_add_admission_details_with_dayscholar_public_transport");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.selectDayScholarCommutePreference("Public Transport");
		studentsProfilePOM.clickOnSaveandNextButton();
							
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
		
	@Test(groups= {"Regression"}, priority=61)
	public void TC_GQLSP_081_Verify_upload_RC_and_License_for_two_wheeler_with_valid_file() {
		
		stepInfo("Verify_upload_RC_and_License_for_two_wheeler_with_valid_file");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.selectDayScholarCommutePreference("Personal Transport");
		studentsProfilePOM.selectPersonalTransportVehicleType("Two Wheeler");
		studentsProfilePOM.enterTwoWheelerVehicleNumber("TN37DE1847");
		studentsProfilePOM.enterTwoWheelerLicenseNumber("TN" + fake.number().digits(10));
		studentsProfilePOM.uploadRC(validPDFFile);
		studentsProfilePOM.uploadLicense(validPDFFile);
		studentsProfilePOM.clickOnSaveandNextButton();
							
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=62)
	public void TC_GQLSP_082_Verify_upload_RC_and_License_for_two_wheeler_with_invalid_file() {
		
		stepInfo("Verify_upload_RC_and_License_for_two_wheeler_with_invalid_file");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.uploadRC(invalidFileType);
		studentsProfilePOM.uploadLicense(invalidFileType);
							
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=63)
	public void TC_GQLSP_083_Verify_upload_RC_and_License_for_two_wheeler_with_more_than_5_mb() {
		
		stepInfo("Verify_upload_RC_and_License_for_two_wheeler_with_more_than_5_mb");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.uploadRC(hugeFileSize);
		studentsProfilePOM.uploadLicense(hugeFileSize);
							
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=64)
	public void TC_GQLSP_084_Verify_upload_RC_and_License_for_four_wheeler_with_valid_file() {
		
		stepInfo("Verify_upload_RC_and_License_for_four_wheeler_with_valid_file");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.selectPersonalTransportVehicleType("Four Wheeler");
		studentsProfilePOM.enterFourWheelerVehicleNumber("TN37DE1875");
		studentsProfilePOM.enterFourWheelerLicenseNumber("TN" + fake.number().digits(10));
		studentsProfilePOM.uploadRC(validPDFFile);
		studentsProfilePOM.uploadLicense(validPDFFile);
		studentsProfilePOM.clickOnSaveandNextButton();
							
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=65)
	public void TC_GQLSP_085_Verify_upload_RC_and_License_for_four_wheeler_with_invalid_file() {
		
		stepInfo("Verify_upload_RC_and_License_for_four_wheeler_with_invalid_file");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreviousButton();
		studentsProfilePOM.uploadRC(invalidFileType);
		studentsProfilePOM.uploadLicense(invalidFileType);
							
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=66)
	public void TC_GQLSP_086_Verify_upload_RC_and_License_for_four_wheeler_with_more_than_5_mb() {
		
		stepInfo("Verify_upload_RC_and_License_for_four_wheeler_with_more_than_5_mb");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.uploadRC(hugeFileSize);
		studentsProfilePOM.uploadLicense(hugeFileSize);
			
		softAssert.assertEquals(studentsProfilePOM.getMandatoryFieldsAlerts(), studentsProfilePOM.getMandatoryFieldsAlerts(), "Toaster text is " + studentsProfilePOM.getMandatoryFieldsAlerts());
		System.out.println(studentsProfilePOM.getMandatoryFieldsAlerts());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=67)
	public void TC_GQLSP_087_Verify_add_admission_details_with_go_to_Home() {
		
		stepInfo("Verify_add_admission_details_with_go_to_Home");
		
		softAssert = new SoftAssert();
		
		driver.navigate().refresh();
		studentsProfilePOM.clickOnGotoHomeButton();
							
		softAssert.assertEquals(studentsProfilePOM.getProfileName(), studentsProfilePOM.getProfileName(), "Toaster text is " + studentsProfilePOM.getProfileName());
		System.out.println(studentsProfilePOM.getProfileName());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=68)
	public void TC_GQLSP_089_Verify_Documents_details_tab() {
		
		stepInfo("Verify_Documents_details_tab");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnStudentProfileSectionTab("Documents");
							
		softAssert.assertEquals(studentsProfilePOM.getDocumentsTabSectionText(), studentsProfilePOM.getDocumentsTabSectionText(), "Toaster text is " + studentsProfilePOM.getDocumentsTabSectionText());
		System.out.println(studentsProfilePOM.getDocumentsTabSectionText());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=69)
	public void TC_GQLSP_092_Verify_mandatory_alerts_in_document_details_tab() {
		
		stepInfo("Verify_mandatory_alerts_in_document_details_tab");
		
		softAssert = new SoftAssert();
		
		studentsProfilePOM.clickOnPreview();
							
		softAssert.assertEquals(studentsProfilePOM.getDocumentsTabMandatoryText(), studentsProfilePOM.getDocumentsTabMandatoryText(), "Toaster text is " + studentsProfilePOM.getDocumentsTabMandatoryText());
		System.out.println(studentsProfilePOM.getDocumentsTabMandatoryText());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=70)
	public void TC_GQLSP_094_Verify_Upload_columns_by_uploading_invalid_file_type_for_all_documents_sections() {
		
		stepInfo("Verify_Upload_columns_by_uploading_invalid_file_type_for_all_documents_sections");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.uploadAllFiles(invalidFileType);	

							
		softAssert.assertEquals(studentsProfilePOM.getErrorToasterAlert(), studentsProfilePOM.getErrorToasterAlert(), "Toaster text is " + studentsProfilePOM.getErrorToasterAlert());
		System.out.println(studentsProfilePOM.getErrorToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=71)
	public void TC_GQLSP_095_Verify_Upload_columns_by_uploading_more_than_5mb() {
		
		stepInfo("Verify_Upload_columns_by_uploading_more_than_5mb");
		
		softAssert = new SoftAssert();
				
		driver.navigate().refresh();
		threadSleep(1000);
		studentsProfilePOM.uploadAllFiles(hugeFileSize);		
							
		softAssert.assertEquals(studentsProfilePOM.getErrorToasterAlert(), studentsProfilePOM.getErrorToasterAlert(), "Toaster text is " + studentsProfilePOM.getErrorToasterAlert());
		System.out.println(studentsProfilePOM.getErrorToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	
	@Test(groups= {"Regression"}, priority=72)
	public void TC_GQLSP_096_Verify_Upload_valid_file_in_all_document_sections_in_document_tab() {
		
		stepInfo("Verify_Upload_valid_file_in_all_document_sections_in_document_tab");
		
		softAssert = new SoftAssert();
				
		driver.navigate().refresh();
		threadSleep(1000);
		studentsProfilePOM.uploadAllFiles(validPDFFile);	
		studentsProfilePOM.uploadPassportSizePhoto(imageFile);
							
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=73)
	public void TC_GQLSP_097_Verify_view_all_document_sections_in_document_tab() {
		
		stepInfo("Verify_view_all_document_sections_in_document_tab");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.viewAllFiles();		
							
//		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
//		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=74)
	public void TC_GQLSP_098_Verify_remove_documents_in_document_tab() {
		
		stepInfo("Verify_remove_documents_in_document_tab");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.removeAllDocuments();	
							
		softAssert.assertEquals(studentsProfilePOM.getSuccessToasterAlert(), studentsProfilePOM.getSuccessToasterAlert(), "Toaster text is " + studentsProfilePOM.getSuccessToasterAlert());
		System.out.println(studentsProfilePOM.getSuccessToasterAlert());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=75)
	public void TC_GQLSP_099_Verify_previous_step_in_documents_tab() {
		
		stepInfo("Verify_previous_step_in_documents_tab");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnPreviousButton();	
							
		softAssert.assertEquals(studentsProfilePOM.getAddressDetailsSectionText(), studentsProfilePOM.getAddressDetailsSectionText(), "Toaster text is " + studentsProfilePOM.getAddressDetailsSectionText());
		System.out.println(studentsProfilePOM.getAddressDetailsSectionText());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=76)
	public void TC_GQLSP_0100_Verify_go_to_home_in_documents_tab() {
		
		stepInfo("Verify_go_to_home_in_documents_tab");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnNextButton();
		studentsProfilePOM.uploadAllFiles(validPDFFile);	
		studentsProfilePOM.uploadPassportSizePhoto(imageFile);
		studentsProfilePOM.clickOnGotoHomeButton();	
							
		softAssert.assertEquals(studentsProfilePOM.getProfileName(), studentsProfilePOM.getProfileName(), "Toaster text is " + studentsProfilePOM.getProfileName());
		System.out.println(studentsProfilePOM.getProfileName());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=77)	
	public void TC_GQLSP_101_Verify_preview_tab_sections() {
		
		stepInfo("Verify_preview_tab_sections");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnStudentProfileSectionTab("Documents");
		studentsProfilePOM.clickOnPreview();
									
		softAssert.assertEquals(studentsProfilePOM.getPreviewTabSectionsText(), studentsProfilePOM.getPreviewTabSectionsText(), "Toaster text is " + studentsProfilePOM.getPreviewTabSectionsText());
		System.out.println(studentsProfilePOM.getPreviewTabSectionsText());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=78)	
	public void TC_GQLSP_108_Verify_submit_button_in_preview_tab_if_leaving_mandatory_field_or_document_or_any_section() {
		
		stepInfo("Verify_submit_button_in_preview_tab_if_leaving_mandatory_field_or_document_or_any_section");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnGotoHomeButton();
		studentsProfilePOM.clickOnStudentProfileSectionTab("Documents");
		studentsProfilePOM.removeAllDocuments();
		studentsProfilePOM.clickOnTabName("Preview");
		studentsProfilePOM.clickOnSubmitbuttoninPreviewTab();
							
		softAssert.assertEquals(studentsProfilePOM.getStudentDetailsSubmissionFailedText(), studentsProfilePOM.getStudentDetailsSubmissionFailedText(), "Toaster text is " + studentsProfilePOM.getStudentDetailsSubmissionFailedText());
		System.out.println(studentsProfilePOM.getStudentDetailsSubmissionFailedText());
		
		softAssert.assertAll();
		
	}
	
	@Test(groups= {"Regression"}, priority=79)	
	public void TC_GQLSP_109_Verify_submit_button_in_preview_tab() {
		
		stepInfo("Verify_submit_button_in_preview_tab");
		
		softAssert = new SoftAssert();
				
		studentsProfilePOM.clickOnCloseButtoninSuccessFailurePopup();
		loginPom.enterStudentProfileEmail(emailid);
		loginPom.clickOnSend6DigitCodeButton();
		loginPom.clickOnVerifyOTPandSigninButton();
		studentsProfilePOM.clickOnStudentProfileSectionTab("Documents");
		studentsProfilePOM.uploadAllFiles(validPDFFile);
		studentsProfilePOM.uploadPassportSizePhoto(imageFile);
		studentsProfilePOM.clickOnTabName("Preview");
		studentsProfilePOM.clickOnSubmitbuttoninPreviewTab();
									
		softAssert.assertEquals(studentsProfilePOM.getAdmissionNo(), studentsProfilePOM.getAdmissionNo(), "Toaster text is " + studentsProfilePOM.getAdmissionNo());
		System.out.println("Admission No is" + studentsProfilePOM.getAdmissionNo());
		
		softAssert.assertAll();
		
	}

}

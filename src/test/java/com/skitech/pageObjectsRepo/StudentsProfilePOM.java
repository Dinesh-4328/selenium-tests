package com.skitech.pageObjectsRepo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StudentsProfilePOM {

	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement txtEmailId;
	
	@FindBy(xpath = "//button[text()='Send 6-digit Code']")
	private WebElement btnSend6DigitCode;
	
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
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnVerifyOTPandSignIn;
	
	@FindBy(xpath = "//button[text()='Go Back']")
	private WebElement btnGoBack;
	
	@FindBy(xpath = "//p[@class='font-bold text-md']")
	private List<WebElement> lstStudentProfileDetailsSection;
	
	@FindBy(xpath = "//p[@class='font-bold text-md']//following::button[1]")
	private List<WebElement> lstStudentProfileDetailsSectionAddEditButton;
	
	@FindBy(xpath = "//button[@class='ui-button btn text ']")
	private WebElement btnDetailsSectionsAddandEditButtons;
	
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement txtFullNamePersonalDetailsTab;
		
	@FindBy(xpath = "//span[@id='react-select-2-live-region']//following::div[1]")
	private WebElement dpdGenderPersonalDetailsTab;
	
	@FindBy(xpath = "//input[@id='react-select-2-input']")
	private WebElement txtGenderPersonalDetailsTab;
	
	@FindBy(xpath = "//input[@placeholder='Enter aadhaar number']")
	private WebElement txtAadharNumberPersonalDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-aadharName']")
	private WebElement txtAadharNamePersonalDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement txtEmailPersonalDetailsTab;
	
	@FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
	private WebElement txtMobileNumberPersonalDetailsTab;
	
	@FindBy(xpath = "//input[@name='dateOfBirth']")
	private WebElement txtDOBPersonalDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-bloodGroupId']")
	private WebElement dpdBloodGroupPersonalDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-bloodGroupId']")
	private WebElement txtBloodGroupPersonalDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-nationalityId']")
	private WebElement dpdNationalityPersonalDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-nationalityId']")
	private WebElement txtNationalityPersonalDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-religionId']")
	private WebElement dpdReligionPersonalDetailsTab;	
	
	@FindBy(xpath = "//input[@id='input-religionId']")
	private WebElement txtReligionPersonalDetailsTab;	
	
	@FindBy(xpath = "//div[@id='container-communityId']")
	private WebElement dpdCommunityPersonalDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-communityId']")
	private WebElement txtCommunityPersonalDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-casteId']")
	private WebElement dpdCastePersonalDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-casteId']")
	private WebElement txtCastePersonalDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-motherTongueId']")
	private WebElement dpdMotherTonguePersonalDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-motherTongueId']")
	private WebElement txtMotherTonguePersonalDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-motherTongueOthers']")
	private WebElement txtMotherTongueOthersPersonalDetailsTab;
	
	@FindBy(xpath = "//label[text()='Physically challenged ']//following::div[1]//span")
	private List<WebElement> lstPhysicallyChallengedPersonalDetailsTab;
	
	@FindBy(xpath = "//label[text()='If yes, upload physically challenged certificate']//following::input[1]")
	private WebElement btnUploadPhysicallyChallengedCertificatePersonalDetailsTab;
		
	@FindBy(xpath = "//div[@id='container-annualIncomeId']")
	private WebElement dpdFamilyAnnualIncomePersonalDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-annualIncomeId']")
	private WebElement txtFamilyAnnualIncomePersonalDetailsTab;
	
	@FindBy(xpath = "//label[text()='Upload income certificate']//following::input[1]")
	private WebElement btnUploadAnnualIncomeCertificatePersonalDetailsTab;
	
	@FindBy(xpath = "//button[text()='Save & Next']")
	private WebElement btnSaveandNextPersonalDetailsTab;
	
	@FindBy(xpath = "//button[text()='Go to home']")
	private WebElement btnGotoHomePersonalDetailsTab;
	
	@FindBy(xpath = "//p")
	private List<WebElement> txtMandatoryFieldsAlerts;
	
	@FindBy(xpath = "//div[@id='root']//div[@class='text-right']//div[1]")
	private WebElement txtStudentProfileName;
	
	@FindBy(xpath = "//button[text()='Continue your admission details']")
	private WebElement btnCompleteYourAdmissionDetails;
	
	@FindBy(xpath = "//button[text()='Decline My Application']")
	private WebElement btnDeclineMyApplication;
	
	@FindBy(xpath = "//div[@id='success-toast']")
	private WebElement txtTabDetailsSuccessAlert;

	@FindBy(xpath = "//div[@id='error-toast']")
    private WebElement txtErrorToasterAlert;
	
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement btnNext;
	
	@FindBy(xpath = "//button[text()='Previous']")
	private WebElement btnPrevious;
	
	@FindBy(xpath = "//*[@id='root']//div[3]//div//a")
	private List<WebElement> lstStudentDetailsTabNames;
	
	@FindBy(xpath = "//h2")
	private List<WebElement> lstAcademicDetailsTabSections; 
	
	@FindBy(xpath = "//h3[text()='Place of Schooling (KG to 12th / HSC)']//following::div[3]//label")
	private List<WebElement> lstStudiedOutsideIndia;
	
	@FindBy(xpath = "//h3[text()='Place of Schooling (KG to 12th / HSC)']//following::div[5]//label")
	private List<WebElement> lstStudiedOutsideTamilnadu;
	
	@FindBy(xpath = "//div[@id='container-formState.0.stateId']")
	private WebElement dpdSSLCStateAcademicDetailsTabSections;
	
	@FindBy(xpath = "//input[@id='input-formState.0.stateId']")
	private WebElement txtSSLCStateAcademicDetailsTabSections;

	@FindBy(xpath = "//div[@id='container-formState.0.boardOfStudyId']")
	private WebElement dpdSSLCBoardOfStudyAcademicDetailsTabSections;
	
	@FindBy(xpath = "//input[@id='input-formState.0.boardOfStudyId']")
	private WebElement txtSSLCBoardOfStudyAcademicDetailsTabSections;

	@FindBy(xpath = "//div[@id='container-formState.0.districtId']")
	private WebElement dpdSSLCDistrictAcademicDetailsTabSections; 
	
	@FindBy(xpath = "//input[@id='input-formState.0.districtId']")
	private WebElement txtSSLCDistrictAcademicDetailsTabSections; 
	
	@FindBy(xpath = "//div[@id='container-formState.0.zoneId']")
	private WebElement dpdSSLCSchoolZoneAcademicDetailsTabSections; 
	
	@FindBy(xpath = "//input[@id='input-formState.0.zoneId']")
	private WebElement txtSSLCSchoolZoneAcademicDetailsTabSections; 
	
	@FindBy(xpath = "//div[@id='container-formState.0.schoolId']")
	private WebElement dpdSSLCSchoolNameAcademicDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.0.schoolId']")
	private WebElement txtSSLCSchoolNameAcademicDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.0.mediumOfStudyId']")
	private WebElement dpdSSLCMediumofStudyAcademicDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.0.mediumOfStudyId']")
	private WebElement txtSSLCMediumofStudyAcademicDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.0.yearOfPassing']")
	private WebElement dpdSSLCYearOfPassingAcademicDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.0.yearOfPassing']")
	private WebElement txtSSLCYearOfPassingAcademicDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.0.registerNumber']")
	private WebElement txtSSLCRollNoAcademicDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.0.totalMarks']")
	private WebElement txtSSLCMarksScoredAcademicDetailsTab;

	@FindBy(xpath = "//label[text()='Upload SSLC (10th) marksheet']//following::input[1]")
	private WebElement uploadSSLCMarkSheetAcademicDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.1.stateId']")
	private WebElement dpdHSC1StateAcademicDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.1.stateId']")
	private WebElement txtHSC1StateAcademicDetailsTab;

	@FindBy(xpath = "//div[@id='container-formState.1.boardOfStudyId']")
	private WebElement dpdHSC1BoardofStudyAcademicDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.1.boardOfStudyId']")
	private WebElement txtHSC1BoardofStudyAcademicDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.1.districtId']")
	private WebElement dpdHSC1DistrictAcademicDetailsTabSections; 
	
	@FindBy(xpath = "//input[@id='input-formState.1.districtId']")
	private WebElement txtHSC1DistrictAcademicDetailsTabSections; 
	
	@FindBy(xpath = "//div[@id='container-formState.1.zoneId']")
	private WebElement dpdHSC1SchoolZoneAcademicDetailsTabSections; 
	
	@FindBy(xpath = "//input[@id='input-formState.1.zoneId']")
	private WebElement txtHSC1SchoolZoneAcademicDetailsTabSections; 
	
	@FindBy(xpath = "//div[@id='container-formState.1.schoolId']")
	private WebElement dpdHSC1SchoolNameAcademicDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.1.schoolId']")
	private WebElement txtHSC1SchoolNameAcademicDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.1.mediumOfStudyId']")
	private WebElement dpdHSC1MediumofStudyAcademicDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.1.mediumOfStudyId']")
	private WebElement txtHSC1MediumofStudyAcademicDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.1.yearOfPassing']")
	private WebElement dpdHSC1YearOfPassingAcademicDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.1.yearOfPassing']")
	private WebElement txtHSC1YearOfPassingAcademicDetailsTab;	

	@FindBy(xpath = "//input[@id='input-formState.1.registerNumber']")
	private WebElement txtHSC1PermanentRegisterNoAcademicDetailsTab;	

	@FindBy(xpath = "//div[@id='container-formState.1.groupOfStudyId']")
	private WebElement dpdHSC1GrouporStreamAcademicDetailsTab;	

	@FindBy(xpath = "//input[@id='input-formState.1.groupOfStudyId']")
	private WebElement txtHSC1GrouporStreamAcademicDetailsTab;	

	@FindBy(xpath = "//input[@id='input-formState.1.totalMarks']")
	private WebElement txtHSC1MarksScoredAcademicDetailsTab;	

	@FindBy(xpath = "//label[text()='Upload HSC (+1) marksheet']//following::input[1]")
	private WebElement uploadHSC1MarkSheetAcademicDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.2.stateId']")
	private WebElement dpdHSC2StateAcademicDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.stateId']")
	private WebElement txtHSC2StateAcademicDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.2.boardOfStudyId']")
	private WebElement dpdHSC2BoardofStudyAcademicDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.boardOfStudyId']")
	private WebElement txtHSC2BoardofStudyAcademicDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.2.districtId']")
	private WebElement dpdHSC2DistrictAcademicDetailsTabSections; 
	
	@FindBy(xpath = "//input[@id='input-formState.2.districtId']")
	private WebElement txtHSC2DistrictAcademicDetailsTabSections; 
	
	@FindBy(xpath = "//div[@id='container-formState.2.zoneId']")
	private WebElement dpdHSC2SchoolZoneAcademicDetailsTabSections; 
	
	@FindBy(xpath = "//input[@id='input-formState.2.zoneId']")
	private WebElement txtHSC2SchoolZoneAcademicDetailsTabSections; 
	
	@FindBy(xpath = "//div[@id='container-formState.2.schoolId']")
	private WebElement dpdHSC2SchoolNameAcademicDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.schoolId']")
	private WebElement txtHSC2SchoolNameAcademicDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.2.schoolCategoryId']")
	private WebElement dpdHSC2SchoolCategoryAcademicDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.schoolCategoryId']")
	private WebElement txtHSC2SchoolCategoryAcademicDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.2.civicStatusId']")
	private WebElement dpdHSC2CivicStatusAcademicDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.civicStatusId']")
	private WebElement txtHSC2CivicStatusAcademicDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.2.mediumOfStudyId']")
	private WebElement dpdHSC2MediumofStudyAcademicDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.mediumOfStudyId']")
	private WebElement txtHSC2MediumofStudyAcademicDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.2.yearOfPassing']")
	private WebElement dpdHSC2YearofPassingAcademicDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.2.yearOfPassing']")
	private WebElement txtHSC2YearofPassingAcademicDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.2.registerNumber']")
	private WebElement txtHSC2PermanentRegNoAcademicDetailsTab;

	@FindBy(xpath = "//div[@id='container-formState.2.groupOfStudyId']")
	private WebElement dpdHSC2GrouporStreamAcademicDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.2.groupOfStudyId']")
	private WebElement txtHSC2GrouporStreamAcademicDetailsTab;

	@FindBy(xpath = "//input[@name='formState.2.emisNo']")
	private WebElement txtEMIsNoAcademicDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.totalMarks']")
	private WebElement txtHSC2MarksScoredAcademicDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.2.mathsMark']")
	private WebElement txtHSC2MathsMarksAcademicDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.2.physicsMark']")
	private WebElement txtHSC2PhysicsMarksAcademicDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.2.chemistryMark']")
	private WebElement txtHSC2ChemistryMarksAcademicDetailsTab;
	
	@FindBy(xpath = "//input[@name='formState.2.optionalSubjectMark']")
	private WebElement txtOptionalSubjectMarkAcademicDetailsTab;
	
	@FindBy(xpath = "//label[text()='Upload HSC (+2) marksheet']//following::input[1]")
	private WebElement uploadHSC2MarkSheetAcademicDetailsTab;
	
	//**Lateral POM starts here
	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	private WebElement chkBoxSelectifyouhavecompletedHSC1AcademicDetailsLateral;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	private WebElement chkBoxSelectifyouhavecompletedHSC2AcademicDetailsLateral;
	
	@FindBy(xpath = "//div[@id='container-colleges.0.countryId']")
	private WebElement dpdCountryAcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.countryId']")
	private WebElement txtCountryAcademicDetailsLateral;
	
	@FindBy(xpath = "//div[@id='container-colleges.0.stateId']")
	private WebElement dpdStateAcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.stateId']")
	private WebElement txtStateAcademicDetailsLateral;
	
	@FindBy(xpath = "//div[@id='container-colleges.0.courseTypeId']")
	private WebElement dpdCourseTypeAcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.courseTypeId']")
	private WebElement txtCourseTypeAcademicDetailsLateral;

	@FindBy(xpath = "//div[@id='container-colleges.0.boardOfStudyId']")
	private WebElement dpdBoardofStudyAcademicDetailsLateral;

	@FindBy(xpath = "//input[@id='input-colleges.0.boardOfStudyId']")
	private WebElement txtBoardofStudyAcademicDetailsLateral;
	
	@FindBy(xpath = "//div[@id='container-colleges.0.collegeId']")
	private WebElement dpdCollegeAcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.collegeId']")
	private WebElement txtCollegeAcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.collegeOthers']")
	private WebElement txtIfCollegeNotListedAcademicDetailsLateral;
	
	@FindBy(xpath = "//div[@id='container-colleges.0.departmentId']")
	private WebElement dpdBranchorDepartmentAcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.departmentId']")
	private WebElement txtBranchorDepartmentAcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.departmentOthers']")
	private WebElement txtifBranchorDepartmentOthersAcademicDetailsLateral;
	
	@FindBy(xpath = "//div[@id='container-colleges.0.month']")
	private WebElement dpdMonthofPassingAcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.month']")
	private WebElement txtMonthofPassingAcademicDetailsLateral;
	
	@FindBy(xpath = "//div[@id='container-colleges.0.yearOfPassing']")
	private WebElement dpdYearofPassingAcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.yearOfPassing']")
	private WebElement txtYearofPassingAcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.registerNumber']")
	private WebElement txtExamRegisterNoAcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.umisNo']")
	private WebElement txtUMISNoAcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester1ObtainedMark']")
	private WebElement txtMarksScoredSem1AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester2ObtainedMark']")
	private WebElement txtMarksScoredSem2AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester3ObtainedMark']")
	private WebElement txtMarksScoredSem3AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester4ObtainedMark']")
	private WebElement txtMarksScoredSem4AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester5ObtainedMark']")
	private WebElement txtMarksScoredSem5AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester6ObtainedMark']")
	private WebElement txtMarksScoredSem6AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester7ObtainedMark']")
	private WebElement txtMarksScoredSem7AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester8ObtainedMark']")
	private WebElement txtMarksScoredSem8AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester9ObtainedMark']")
	private WebElement txtMarksScoredSem9AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester10ObtainedMark']")
	private WebElement txtMarksScoredSem10AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.overallScoredMarks']")
	private WebElement txtMarksScoredOverallTotalAcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester1TotalMark']")
	private WebElement txtTotalMarksSem1AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester2TotalMark']")
	private WebElement txtTotalMarksSem2AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester3TotalMark']")
	private WebElement txtTotalMarksSem3AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester4TotalMark']")
	private WebElement txtTotalMarksSem4AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester5TotalMark']")
	private WebElement txtTotalMarksSem5AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester6TotalMark']")
	private WebElement txtTotalMarksSem6AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester7TotalMark']")
	private WebElement txtTotalMarksSem7AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester8TotalMark']")
	private WebElement txtTotalMarksSem8AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester9TotalMark']")
	private WebElement txtTotalMarksSem9AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.semester10TotalMark']")
	private WebElement txtTotalMarksSem10AcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.overallTotalMarks']")
	private WebElement txtTotalMarksOverallTotalAcademicDetailsLateral;
	
	@FindBy(xpath = "//input[@id='input-colleges.0.overallPercentage']")
	private WebElement txtOverAllPercentageAcademicDetailsLateral;
	
	//** LateralPOM ends Here
			
	@FindBy(xpath = "//h2[@class='pb-4 h5 n-500']")
	private List<WebElement> txtFamilyDetailsSection;
	
	@FindBy(xpath = "//div[@id='container-familyType']")
	private WebElement dpdFamilyTypeFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-familyType']")
	private WebElement txtFamilyTypeFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.0.fullName']")
	private WebElement txtFatherFullNameFamilyDetailsTab;

	@FindBy(xpath = "(//input[contains(@placeholder,'Enter aadhaar number')])[1]")
	private WebElement txtFatherAadharNumberFamilyDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.0.residenceStatus']")
	private WebElement dpdFatherResidentStatusFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.0.residenceStatus']")
	private WebElement txtFatherResidentStatusFamilyDetailsTab;

	@FindBy(xpath = "//div[@id='container-formState.0.countryOfResidence']")
	private WebElement dpdFatherCountryofNonResidentFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.0.countryOfResidence']")
	private WebElement txtFatherCountryofNonResidentFamilyDetailsTab;

	@FindBy(xpath = "//h2[text()='Father details']//following::input[6]")
	private WebElement txtFatherMobileNumberFamilyDetailsTab;

	@FindBy(xpath = "//input[@name='formState.0.email']")
	private WebElement txtFatherEmailFamilyDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.0.occupationId']")
	private WebElement dpdFatherOccupationFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.0.occupationId']")
	private WebElement txtFatherOccupationFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.0.occupationOthers']")
	private WebElement txtFatherOccupationifOthersFamilyDetailsTab;

	@FindBy(xpath = "//div[@id='container-formState.0.incomeId']")
	private WebElement dpdFatherAnnualIncomeFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.0.incomeId']")
	private WebElement txtFatherAnnualIncomeFamilyDetailsTab;

	@FindBy(xpath = "//input[@name='formState.0.company']")
	private WebElement txtFatherWorkPlaceFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@name='formState.0.qualification']")
	private WebElement txtFatherEducationalQualificationFamilyDetailsTab;
	
	@FindBy(xpath = "//h2[normalize-space()='Father details']//following::input[11]")
	private WebElement uploadFatherAadharFamilyDetailsTab;
	
	@FindBy(xpath = "//h2[normalize-space()='Father details']//following::input[12]")
	private WebElement uploadFatherPhotoFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@name='formState.1.fullName']")
	private WebElement txtMotherFullNameFamilyDetailsTab;
	
	@FindBy(xpath = "(//input[contains(@placeholder,'Enter aadhaar number')])[2]")
	private WebElement txtMotherAadharNumberFamilyDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.1.residenceStatus']")
	private WebElement dpdMotherResidentStatusFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.1.residenceStatus']")
	private WebElement txtMotherResidentStatusFamilyDetailsTab;

	@FindBy(xpath = "//div[@id='container-formState.1.countryOfResidence']")
	private WebElement dpdMotherCountryofNonResidentFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.1.countryOfResidence']")
	private WebElement txtMotherCountryofNonResidentFamilyDetailsTab;

	@FindBy(xpath = "//h2[text()='Mother details']//following::input[6]")
	private WebElement txtMotherMobileNumberFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@name='formState.1.email']")
	private WebElement txtMotherEmailidFamilyDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.1.occupationId']")
	private WebElement dpdMotherOccupationFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.1.occupationId']")
	private WebElement txtMotherOccupationFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.1.occupationOthers']")
	private WebElement txtMotherOccupationifOthersFamilyDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.1.incomeId']")
	private WebElement dpdMotherAnnualIncomeFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.1.incomeId']")
	private WebElement txtMotherAnnualIncomeFamilyDetailsTab;

	@FindBy(xpath = "//input[@name='formState.1.company']")
	private WebElement txtMotherWorkplaceFamilyDetailsTab;

	@FindBy(xpath = "//input[@name='formState.1.qualification']")
	private WebElement txtMotherEducationalQualificationFamilyDetailsTab;
	
	@FindBy(xpath = "//h2[normalize-space()='Mother details']//following::input[13]")
	private WebElement uploadMotherAadharFamilyDetailsTab;

	@FindBy(xpath = "//h2[normalize-space()='Mother details']//following::input[13]")
	private WebElement uploadMotherPhotoFamilyDetailsTab;
	
	@FindBy(xpath = "//label[text()='I want to add guardian details']")
	private WebElement checkBoxIwanttoAddGuardianDetails;
	
	@FindBy(xpath = "//input[@id='input-formState.2.fullName']")
	private WebElement txtguardianFullNameFamilyDetailsTab;
	
	@FindBy(xpath = "//label[text()='I want to add guardian details']//following::input[2]")
	private WebElement txtGuardianAadharNumberFamilyDetailsTab;
	
	@FindBy(xpath = "//label[text()='I want to add guardian details']//following::input[3]")
	private WebElement txtGuardianMobileNumberFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.email']")
	private WebElement txtGuardianEmailidFamilyDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.2.occupationId']")
	private WebElement dpdGuardianOccupationFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.occupationId']")
	private WebElement txtGuardianOccupationFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.occupationOthers']")
	private WebElement txtGuardianOccupationifOthersFamilyDetailsTab;

	@FindBy(xpath = "//div[@id='container-formState.2.incomeId']")
	private WebElement dpdGuardianAnnualIncomeFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.incomeId']")
	private WebElement txtGuardianAnnualIncomeFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.company']")
	private WebElement txtGuardianWorkPlaceFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.qualification']")
	private WebElement txtGuardianEducationalQualificationFamilyDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.2.genderId']")
	private WebElement dpdGuardianGenderFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.genderId']")
	private WebElement txtGuardianGenderFamilyDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.2.parentGuardianRelationShip']")
	private WebElement dpdGuradianRelationshipToTheStudentFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.2.parentGuardianRelationShip']")
	private WebElement txtGuradianRelationshipToTheStudentFamilyDetailsTab;
	
	@FindBy(xpath = "//label[text()='I want to add guardian details']//following::input[16]")
	private WebElement uploadGuardianAadharFamilyDetailsTab;
	
	@FindBy(xpath = "//label[text()='I want to add guardian details']//following::input[17]")
	private WebElement uploadGuardianPhotoFamilyDetailsTab;
	
	@FindBy(xpath = "//h2[text()='Sibling details']//following::div[2]//input")
	private List<WebElement> lstDoYouHaveSiblingsFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@name='siblings.0.isStudyingAtSKI']")
	private List<WebElement> lstSibling1AnySiblingsJoinedthisInstitutionBeforeFamilyDetailsTab;
	
	@FindBy(xpath = "//button[text()='Add Another Sibling']")
	private WebElement btnAddAnotherSiblingsFamilyDetailsTab;

	@FindBy(xpath = "//div[@id='container-siblings.0.schoolOrCollege']")
	private WebElement dpdSibling1CollegeFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-siblings.0.schoolOrCollege']")
	private WebElement txtSibling1CollegeFamilyDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-siblings.0.standardOrDegree']")
	private WebElement dpdSibling1DegreeFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-siblings.0.standardOrDegree']")
	private WebElement txtSibling1DegreeFamilyDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-siblings.0.passedOutYear']")
	private WebElement dpdSibling1AdmissionYearFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-siblings.0.passedOutYear']")
	private WebElement txtSibling1AdmissionYearFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-siblings.0.registerNumber']")
	private WebElement txtSibling1RegisterNoFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-siblings.0.fullName']")
	private WebElement txtSibling1FullNameFamilyDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-siblings.0.genderId']")
	private WebElement dpdSibling1GenderFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-siblings.0.genderId']")
	private WebElement txtSibling1GenderFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-siblings.0.dateOfBirth']")
	private WebElement txtSibling1DOBFamilyDetailsTab;
	
	@FindBy(xpath = "(//input[contains(@value,'+91')])[4]")
	private WebElement txtSibling1MobileNoFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-siblings.0.emailId']")
	private WebElement txtSibling1EmailFamilyDetailsTab;
	
	@FindBy(xpath = "(//button[contains(@type,'button')][normalize-space()='Remove'])[1]")
	private WebElement btnRemoveSibling1FamilyDetailsTab;
	
	@FindBy(xpath = "//input[@name='siblings.1.isStudyingAtSKI']")
	private List<WebElement> lstSibling2AnySiblingsJoinedthisInstitutionBeforeFamilyDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-siblings.1.schoolOrCollege']")
	private WebElement dpdSibling2CollegeFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-siblings.1.schoolOrCollege']")
	private WebElement txtSibling2CollegeFamilyDetailsTab;

	@FindBy(xpath = "//div[@id='container-siblings.1.standardOrDegree']")
	private WebElement dpdSibling2DegreeFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-siblings.1.standardOrDegree']")
	private WebElement txtSibling2DegreeFamilyDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-siblings.1.passedOutYear']")
	private WebElement dpdSibling2AdmissionYearFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-siblings.1.passedOutYear']")
	private WebElement txtSibling2AdmissionYearFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-siblings.1.passedOutYear']")
	private WebElement txtSibling2RegisterNoFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-siblings.1.fullName']")
	private WebElement txtSibling2FullNameFamilyDetailsTab;

	@FindBy(xpath = "//div[@id='container-siblings.1.genderId']")
	private WebElement dpdSibling2GenderFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-siblings.1.genderId']")
	private WebElement txtSibling2GenderFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-siblings.1.dateOfBirth']")
	private WebElement txtSibling2DOBFamilyDetailsTab;
	
	@FindBy(xpath = "(//input[contains(@value,'+91')])[5]")
	private WebElement txtSibling2MobileNoFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-siblings.1.emailId']")
	private WebElement txtSibling2EmailFamilyDetailsTab;
	
	@FindBy(xpath = "(//button[contains(@type,'button')][normalize-space()='Remove'])[2]")
	private WebElement btnRemoveSibling2FamilyDetailsTab;

	@FindBy(xpath = "//input[@name='siblings.1.isStudyingAtSKI']")
	private List<WebElement> lstSibling3AnySiblingsJoinedthisInstitutionBeforeFamilyDetailsTab;

	@FindBy(xpath = "//div[@id='container-siblings.2.schoolOrCollege']")
	private WebElement dpdSibling3CollegeFamilyDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-siblings.2.schoolOrCollege']")
	private WebElement txtSibling3CollegeFamilyDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-siblings.2.standardOrDegree']")
	private WebElement dpdSibling3DegreeFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-siblings.2.standardOrDegree']")
	private WebElement txtSibling3DegreeFamilyDetailsTab;

	@FindBy(xpath = "//div[@id='container-siblings.2.passedOutYear']")
	private WebElement dpdSibling3AdmissionYearFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-siblings.2.passedOutYear']")
	private WebElement txtSibling3AdmissionYearFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-siblings.2.registerNumber']")
	private WebElement txtSibling3RegisterNoFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-siblings.2.fullName']")
	private WebElement txtSibling3FullNameFamilyDetailsTab;

	@FindBy(xpath = "//div[@id='container-siblings.2.genderId']")
	private WebElement dpdSibling3GenderFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-siblings.2.genderId']")
	private WebElement txtSibling3GenderFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-siblings.2.dateOfBirth']")
	private WebElement txtSibling3DOBFamilyDetailsTab;

	@FindBy(xpath = "(//input[contains(@value,'+91')])[6]")
	private WebElement txtSibling3MobileNoFamilyDetailsTab;

	@FindBy(xpath = "//input[@id='input-siblings.2.emailId']")
	private WebElement txtSibling3EmailFamilyDetailsTab;

	@FindBy(xpath = "(//button[contains(@type,'button')][normalize-space()='Remove'])[3]")
	private WebElement btnRemoveSibling3FamilyDetailsTab;

	@FindBy(xpath = "//button[text()='Keep Editing']")
	private WebElement btnKeepEditing;
	
	@FindBy(xpath = "//button[text()='Leave Anyway']")
	private WebElement btnLeaveAnyway;
	
	@FindBy(xpath = "//h2[@class='n-500 h5 pb-4']")
	private List<WebElement> txtAddressDetailsSections;
		
	@FindBy(xpath = "//div[@id='container-formState.0.countryId']")
	private WebElement dpdPermanentAddressCountryAddressDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.0.countryId']")
	private WebElement txtPermanentAddressCountryAddressDetailsTab;

	@FindBy(xpath = "//div[@id='container-formState.0.stateId']")
	private WebElement dpdPermanentAddressStateAddressDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.0.stateId']")
	private WebElement txtPermanentAddressStateAddressDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.0.addressLine1']")
	private WebElement txtPermanentAddressLine1AddressDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.0.addressLine2']")
	private WebElement txtPermanentAddressLine2AddressDetailsTab;

	@FindBy(xpath = "//div[@id='container-formState.0.cityId']")
	private WebElement dpdPermanentAddressCityAddressDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.0.cityId']")
	private WebElement txtPermanentAddressCityAddressDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.0.pincode']")
	private WebElement txtPermanentAddressPincodeAddressDetailsTab;

	@FindBy(xpath = "//label[text()='Communication address is same as permanent address']")
	private WebElement checkBoxCommunicationAddressisSameAsPermanentAddressDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.1.countryId']")
	private WebElement dpdCommunicationAddressCountryAddressDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.1.countryId']")
	private WebElement txtCommunicationAddressCountryAddressDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.1.stateId']")
	private WebElement dpdCommunicationAddressStateAddressDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.1.stateId']")
	private WebElement txtCommunicationAddressStateAddressDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.1.addressLine1']")
	private WebElement txtCommunicationAddressline1AddressDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.1.addressLine2']")
	private WebElement txtCommunicationAddressline2AddressDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.1.cityId']")
	private WebElement dpdCommunicationAddressCityAddressDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.1.cityId']")
	private WebElement txtCommunicationAddressCityAddressDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.1.pincode']")
	private WebElement txtCommunicationAddressPincodeAddressDetailsTab;
	
	@FindBy(xpath = "//label[text()='Are you currently staying with a guardian or in private accommodation?']//following::div[1]//label")
	private List<WebElement> radioOptionYesorNoGuardianorPrivateAddressAddressDetailsTab;

	@FindBy(xpath = "//div[@id='container-formState.2.countryId']")
	private WebElement dpdGuardianAddressCountryAddressDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.countryId']")
	private WebElement txtGuardianAddressCountryAddressDetailsTab;
	
	@FindBy(xpath = "//div[@id='container-formState.2.stateId']")
	private WebElement dpdGuardianAddressStateAddressDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.stateId']")
	private WebElement txtGuardianAddressStateAddressDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.addressLine1']")
	private WebElement txtGuardianAddressLine1AddressDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.addressLine2']")
	private WebElement txtGuardianAddressLine2AddressDetailsTab;

	@FindBy(xpath = "//div[@id='container-formState.2.cityId']")
	private WebElement dpdGuardianAddressCityAddressDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-formState.2.cityId']")
	private WebElement txtGuardianAddressCityAddressDetailsTab;

	@FindBy(xpath = "//input[@id='input-formState.2.pincode']")
	private WebElement txtGuardianAddressPincodeAddressDetailsTab;	
	
	@FindBy(xpath = "//h2")
	private List<WebElement> lstAdmissionDetailsTabSectionText;
	
	@FindBy(xpath = "//div[@id='container-modeOfPaymentId']")
	private WebElement dpdPaymentModeAdmissionDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-modeOfPaymentId']")
	private WebElement txtPaymentModeAdmissionDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-paidAmount']")
	private WebElement txtPaidAmountAdmissionDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-paymentId']")
	private WebElement txtPaymentIdAdmissionDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-paidDate']")
	private WebElement txtPaidOnAdmissionDetailsTab;
		
	@FindBy(xpath = "//label[text()='Upload consortium application']//following::input[1]")
	private WebElement uploadConsortiumApplicationAdmissionDetailsTab;
	
	@FindBy(xpath = "//input[@name='scholarTypeId']//..")
	private List<WebElement> lstScholarTypeAdmissionDetailsTab;
	
	@FindBy(xpath = "//input[@name='transportTypeId']//..")
	private List<WebElement> lstDayscholarCommutePrefAdmissionDetailsTab; 
	
	@FindBy(xpath = "//div[@id='container-pickupPoint']")
	private WebElement dpdCollegePickupPointAdmissionDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-pickupPoint']")
	private WebElement txtCollegePickupPointAdmissionDetailsTab;
	
	@FindBy(xpath = "//input[@name='vehicleTypeId']//..")
	private List<WebElement> lstPersonalTransportVehicleTypeAdmissionDetailsTab;
	
	@FindBy(xpath = "//input[@placeholder='Enter the vehicle number']")
	private WebElement txtTwoWheelerVehicleNumberAdmissionDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-TwoWheelerLicenseNumber']")
	private WebElement txtTwoWheelerLicenseNumberAdmissionDetailsTab;

	@FindBy(xpath = "//label[text()='Upload RC']//following::input[1]")
	private WebElement uploadRCAdmissionDetailsTab;
	
	@FindBy(xpath = "//label[text()='Upload License']//following::input[1]")
	private WebElement uploadLicenseAdmissionDetailsTab;
	
	@FindBy(xpath = "//input[@placeholder='Enter the vehicle number']")
	private WebElement txtFourWheelerVehicleNumberAdmissionDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-FourWheelerLicenseNumber']")
	private WebElement txtFourWheelerLicenseNumberAdmissionDetailsTab;
	
	@FindBy(xpath = "//input[@id='input-tneaAllotmentOrderNo']")
	private WebElement txtTNEAAdmissionNoAdmissionDetailsTab;
	
	@FindBy(xpath = "//div[contains(@class, 'h5')]")
	private List<WebElement> lstDocumentsTabSectionText;
	
	@FindBy(xpath = "//button[text()='Preview']")
	private WebElement btnPreviewMyApplication;
	
	@FindBy(xpath = "//td[@class='text-red-color']")
	private List<WebElement> lstDocumentsTabMandatoryAlerts;
	
	@FindBy(xpath = "//tbody//tr//td[3]//input")
	private List<WebElement> uploadAllDocuments; 
	
	@FindBy(xpath = "(//input[@accept='.jpg,.jpeg,.png'])[1]")
	private WebElement uploadPassportSizePhoto;
	
	@FindBy(xpath = "//tbody//tr//td[4]//button")
	private List<WebElement> viewAllDocuments;
	
	@FindBy(xpath = "//tbody//tr//td[5]//button")
	private List<WebElement> deleteAllDocuments;
	
	@FindBy(xpath = "//div[@class='h5']")
	private WebElement viewDocumentPopupDocumentName;
	
	@FindBy(xpath = "//*[@id='root']//div[3]/div[1]/div/div[1]/button")
	private WebElement closeButtoninDocumentPopup;
	
	@FindBy(xpath = "//h2")
	private List<WebElement> lstPreviewTabSections; 
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnSubmit;
	
	@FindBy(xpath = "//div[@class='bg-green-50 text-center py-10 rounded-t-lg']")
	private WebElement txtStudentDetailsSubmissionSuccessfull;
	
	@FindBy(xpath = "//div[@class='bg-red-50 text-center py-8 rounded-t-lg']")
	private WebElement txtStudentDetailsSubmissionFailed;
	
	@FindBy(xpath = "//button[text()='Close']")
	private WebElement btnCloseinPreviewSuccessFailurePopUp;
	
	@FindBy(xpath = "//div[@id='root']//ul//li")
	private List<WebElement> lstTabNames;
	
	@FindBy(xpath = "//div[text()='Admission no.']//following::div[1]")
	private WebElement txtAdmissionNo;
	
		
	public StudentsProfilePOM(WebDriver driver) {
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
	
	public void clearFullName() {
		txtFullNamePersonalDetailsTab.clear();
		threadSleep(2000);
	}
	
	public void enterFullName(String firstName) {
		txtFullNamePersonalDetailsTab.clear();
		txtFullNamePersonalDetailsTab.sendKeys(firstName);
	}
	
	public void clickOnGenderdropdown(String gender) {
		dpdGenderPersonalDetailsTab.click();
		txtGenderPersonalDetailsTab.sendKeys(gender + Keys.ENTER);
	}
	
	public void clearAadharNumber() {
		txtAadharNumberPersonalDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterAadharNumber(String aadharNumber) {
		txtAadharNumberPersonalDetailsTab.clear();
		txtAadharNumberPersonalDetailsTab.sendKeys(aadharNumber);;
	}
	
	public void clearAadharName() {
		txtAadharNamePersonalDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterAadharName(String aadharName) {
		txtAadharNamePersonalDetailsTab.clear();
		txtAadharNamePersonalDetailsTab.sendKeys(aadharName);
	}
	
	public void enterStudentEmail(String studentEmail) {
		txtEmailPersonalDetailsTab.clear();
		txtEmailPersonalDetailsTab.sendKeys(studentEmail);
	}
	
	public void enterMobileNumber(String mobileNumber) {
		txtMobileNumberPersonalDetailsTab.clear();
		txtMobileNumberPersonalDetailsTab.sendKeys(mobileNumber);
	}
	
	public void enterDOB(String dob) {
		txtDOBPersonalDetailsTab.clear();
		txtDOBPersonalDetailsTab.sendKeys(dob);
	}

	public void selectBloodGroup(String bloodGroup) {
		dpdBloodGroupPersonalDetailsTab.click();
		threadSleep(1000);
		txtBloodGroupPersonalDetailsTab.sendKeys(bloodGroup + Keys.ENTER);
	
	}
	
	public void selectNationality(String nationality) {
		dpdNationalityPersonalDetailsTab.click();
		txtNationalityPersonalDetailsTab.sendKeys(nationality + Keys.ENTER);
	}
	
	public void selectReligion(String religion) {
		dpdReligionPersonalDetailsTab.click();
		txtReligionPersonalDetailsTab.sendKeys(religion + Keys.ENTER);
	}
	
	public void selectCommunity(String community) {
		dpdCommunityPersonalDetailsTab.click();
		threadSleep(1000);
		txtCommunityPersonalDetailsTab.sendKeys(community + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void selectCaste(String caste) {
		dpdCastePersonalDetailsTab.click();
		threadSleep(1000);
		txtCastePersonalDetailsTab.sendKeys(caste + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void selectMotherTongue(String motherTongue) {
		dpdMotherTonguePersonalDetailsTab.click();
		threadSleep(1000);
		txtMotherTonguePersonalDetailsTab.sendKeys(motherTongue + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void enterMotherTongueIfOthers(String otherMotherTongue) {
		txtMotherTongueOthersPersonalDetailsTab.sendKeys(otherMotherTongue);
	}
	
	public void selectPhysicallyChallenged(String physicallyChallenged) {
		for(WebElement physicallyChallengedlist : lstPhysicallyChallengedPersonalDetailsTab) {
			if(physicallyChallengedlist.getText().equals(physicallyChallenged)) {
				physicallyChallengedlist.click();
				break;
			}
		}
		
	}
	
	public void uploadPhysicallyChallengedCertificate(String physicallyChallengedCertificate) {
		btnUploadPhysicallyChallengedCertificatePersonalDetailsTab.sendKeys(physicallyChallengedCertificate);
		threadSleep(2000);
	}
	
	public void selectFamilyAnnualIncome(String annualIncome) {
		dpdFamilyAnnualIncomePersonalDetailsTab.click();
		txtFamilyAnnualIncomePersonalDetailsTab.sendKeys(annualIncome + Keys.ENTER);
	}
	
	public void uploadIncomeCertificate(String incomeCertificate) {
		btnUploadAnnualIncomeCertificatePersonalDetailsTab.sendKeys(incomeCertificate);
		threadSleep(2000);
	}
	
	public void clickOnSaveandNextButton() {
		btnSaveandNextPersonalDetailsTab.click();
		threadSleep(3000);
	}
	
	public void clickOnPreviousButton() {
		btnPrevious.click();
		threadSleep(3000);
	}
	
	public void clickOnGotoHomeButton() {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		    // Wait for overlay to disappear
		    wait.until(ExpectedConditions.visibilityOf(btnGotoHomePersonalDetailsTab));
		btnGotoHomePersonalDetailsTab.click();
		threadSleep(3000);
	}
	
	public List<String> getMandatoryFieldsAlerts() {
		List<String> personalDetailsTabAlerts = new ArrayList<>();
		for (WebElement element : txtMandatoryFieldsAlerts) {
			String personalDetailsTabAlertsList = element.getText();
			personalDetailsTabAlerts.add(personalDetailsTabAlertsList);
    }
    return personalDetailsTabAlerts;	
}
	public String getProfileName() {
		return txtStudentProfileName.getText();
	}
	
	public void clickOnCompleteYourAdmissionDetails() {
		btnCompleteYourAdmissionDetails.click();
		threadSleep(2000);
	}
	
	public void clickOnDeclineMyApplicationButton() {
		btnDeclineMyApplication.click();
		threadSleep(2000);
	}
	
	public List<String> getStudentProfileSectionTab(){
		List<String> studentProfileSectionsList = new ArrayList<>();
		for(WebElement element : lstStudentProfileDetailsSection) {
			String studentDetailsSection = element.getText();
			studentProfileSectionsList.add(studentDetailsSection);
			//threadSleep(2000);		
		}
		return studentProfileSectionsList;
	}
	
	public void clickOnStudentProfileSectionTab(String sectionTabName) {
	    for (int i = 0; i < lstStudentProfileDetailsSection.size(); i++) {
	        String tabText = lstStudentProfileDetailsSection.get(i).getText().trim();

	        if (tabText.equalsIgnoreCase(sectionTabName.trim())) {
	            WebElement buttonElement = lstStudentProfileDetailsSectionAddEditButton.get(i);

	            WebDriverWait wait = new WebDriverWait(driver, 5);
	            wait.until(ExpectedConditions.elementToBeClickable(buttonElement)).click();
	            threadSleep(2000);

	            //System.out.println("Clicked Add/Edit button for tab: " + sectionTabName);
	            return;
	        }
	    }
	    //System.err.println("No matching tab found for: " + sectionTabName);
	}

	
	public String getFullName() {
		return txtFullNamePersonalDetailsTab.getText();
	}
	
	public String getSuccessToasterAlert() {
		return txtTabDetailsSuccessAlert.getText();
	}
	
	public String getErrorToasterAlert() {
		return txtErrorToasterAlert.getText();
	}
	
	public void clickOnTabName(String tabName) {
		for(WebElement tabNameList : lstStudentDetailsTabNames) {
			if(tabNameList.getText().equals(tabName)) {
				tabNameList.click();
				threadSleep(1000);
				break;				
			}
		}
	}
	
	public String getMatchingTabText(String expectedTabName) {
	    for (WebElement tab : lstStudentDetailsTabNames) {
	        String tabText = tab.getText().trim();
	        if (tabText.equalsIgnoreCase(expectedTabName)) {
	        	return tabText;
	        }    
	    }
		return null;    
	}
	
	public void clickOnNextButton() {
		btnNext.click();
		threadSleep(2000);
	}
	
	public List<String> getAcademicDetailsSection(){
		List<String> academicDetailsSectionList = new ArrayList<>();
		for(WebElement element : lstAcademicDetailsTabSections) {
			String academicDetailsSectionName = element.getText();
			academicDetailsSectionList.add(academicDetailsSectionName);
		}
		return academicDetailsSectionList;
	}
	
	public void selectStudiedOutsideIndia(String outsideIndia) {
		for(WebElement outsideIndialst : lstStudiedOutsideIndia) {
			if(outsideIndialst.getText().equals(outsideIndia)) {
				outsideIndialst.click();
				break;
			}
		}
	}
	
	public void selectStudiedOutsideTamilnadu(String outsideTamilnadu) {
		for(WebElement outsideTamilnadulst : lstStudiedOutsideTamilnadu) {
			if(outsideTamilnadulst.getText().equals(outsideTamilnadu)) {
				outsideTamilnadulst.click();
				break;
			}
		}
	}
	
	public void selectSSLCState(String sslcState) {
		dpdSSLCStateAcademicDetailsTabSections.click();
		txtSSLCStateAcademicDetailsTabSections.sendKeys(sslcState + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void selectSSLCBoardofStudy(String sslcBoardofStudy) {
		dpdSSLCBoardOfStudyAcademicDetailsTabSections.click();
		txtSSLCBoardOfStudyAcademicDetailsTabSections.sendKeys(sslcBoardofStudy + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void selectSSLCDistrict(String sslcDistrict) {
		dpdSSLCDistrictAcademicDetailsTabSections.click();
		threadSleep(1000);
		txtSSLCDistrictAcademicDetailsTabSections.sendKeys(sslcDistrict + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void selectSSLCSchoolZone(String sslcSchoolZone) {
		dpdSSLCSchoolZoneAcademicDetailsTabSections.click();
		threadSleep(1000);
		txtSSLCSchoolZoneAcademicDetailsTabSections.sendKeys(sslcSchoolZone + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void selectSSLCSchoolName(String sslcSchoolName) {
		threadSleep(1000);
		dpdSSLCSchoolNameAcademicDetailsTab.click();
		threadSleep(3000);
		txtSSLCSchoolNameAcademicDetailsTab.sendKeys(sslcSchoolName + Keys.ENTER);
	}
	
	public void selectSSLCMediumofStudy(String sslcMediumOfStudy) {
		dpdSSLCMediumofStudyAcademicDetailsTab.click();
		threadSleep(1000);
		txtSSLCMediumofStudyAcademicDetailsTab.clear();
		txtSSLCMediumofStudyAcademicDetailsTab.sendKeys(sslcMediumOfStudy + Keys.ENTER);
	}
	
	public void selectSSLCYearOfPassing(String sslcYearofPassing) {
		dpdSSLCYearOfPassingAcademicDetailsTab.click();
		txtSSLCYearOfPassingAcademicDetailsTab.sendKeys(sslcYearofPassing + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void clearSSLCRollNo() {
		txtSSLCRollNoAcademicDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterSSLCRollNo(String sslcRollNo) {
		txtSSLCRollNoAcademicDetailsTab.clear();
		txtSSLCRollNoAcademicDetailsTab.sendKeys(sslcRollNo);
	}
	
	public void clearSSLCMarksScored() {
		txtSSLCMarksScoredAcademicDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterSSLCMarksScored(String randomNum) {
		txtSSLCMarksScoredAcademicDetailsTab.clear();
		txtSSLCMarksScoredAcademicDetailsTab.sendKeys(randomNum);
	}
	
	public void uploadSSLCMarkSheet(String sslcMarkSheet) {
		uploadSSLCMarkSheetAcademicDetailsTab.sendKeys(sslcMarkSheet);
		threadSleep(2000);
	}
	
	public void selectHSC1State(String hsc1State) {
		dpdHSC1StateAcademicDetailsTab.click();
		txtHSC1StateAcademicDetailsTab.sendKeys(hsc1State + Keys.ENTER);
		threadSleep(1000);		
	}
	
	public void selectHSC1BoardofStudy(String hsc1BoardofStudy) {
		dpdHSC1BoardofStudyAcademicDetailsTab.click();
		txtHSC1BoardofStudyAcademicDetailsTab.sendKeys(hsc1BoardofStudy + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void selectHSC1District(String hsc1District) {
		dpdHSC1DistrictAcademicDetailsTabSections.click();
		threadSleep(1000);
		txtHSC1DistrictAcademicDetailsTabSections.sendKeys(hsc1District + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void selectHSC1SchoolZone(String hsc1SchoolZone) {
		dpdHSC1SchoolZoneAcademicDetailsTabSections.click();
		threadSleep(1000);
		txtHSC1SchoolZoneAcademicDetailsTabSections.sendKeys(hsc1SchoolZone + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void selectHSC1SchoolName(String hsc1SchoolName) {
		dpdHSC1SchoolNameAcademicDetailsTab.click();
		threadSleep(3000);
		txtHSC1SchoolNameAcademicDetailsTab.sendKeys(hsc1SchoolName + Keys.ENTER);
	}
	
	public void selectHSC1MediumofStudy(String hsc1MediumofStudy) {
		dpdHSC1MediumofStudyAcademicDetailsTab.click();
		threadSleep(1000);
		txtHSC1MediumofStudyAcademicDetailsTab.sendKeys(hsc1MediumofStudy + Keys.ENTER);
	}
	
	public void selectHSC1YearofPassing(String hsc1YearofPassing) {
		dpdHSC1YearOfPassingAcademicDetailsTab.click();
		txtHSC1YearOfPassingAcademicDetailsTab.sendKeys(hsc1YearofPassing + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void clearHSC1PermanentRegisterNo() {
		txtHSC1PermanentRegisterNoAcademicDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterHSC1PermanentRegisterNo(String hsc1PermanentRegisterNo) {
		txtHSC1PermanentRegisterNoAcademicDetailsTab.clear();
		txtHSC1PermanentRegisterNoAcademicDetailsTab.sendKeys(hsc1PermanentRegisterNo);
		threadSleep(1000);
	}
	
	public void selectHSC1GrouporStream(String hsc1GrouporStream) {
		dpdHSC1GrouporStreamAcademicDetailsTab.click();
		txtHSC1GrouporStreamAcademicDetailsTab.sendKeys(hsc1GrouporStream + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void clearHSC1MarksScored() {
		txtHSC1MarksScoredAcademicDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterHSC1MarksScored(String hsc1MarksScored) {
		txtHSC1MarksScoredAcademicDetailsTab.clear();
		txtHSC1MarksScoredAcademicDetailsTab.sendKeys(hsc1MarksScored);
		threadSleep(1000);
	}
	
	public void uploadHSC1MarkSheet(String hsc1MarkSheet) {
		uploadHSC1MarkSheetAcademicDetailsTab.sendKeys(hsc1MarkSheet);
	}
	
	public void selectHSC2State(String hsc2State) {
		dpdHSC2StateAcademicDetailsTab.click();
		txtHSC2StateAcademicDetailsTab.sendKeys(hsc2State + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void selectHSC2BoardofStudy(String hsc2BoardofStudy) {
		dpdHSC2BoardofStudyAcademicDetailsTab.click();
		txtHSC2BoardofStudyAcademicDetailsTab.sendKeys(hsc2BoardofStudy + Keys.ENTER);
		threadSleep(1000);		
	}
	
	public void selectHSC2District(String hsc2District) {
		dpdHSC2DistrictAcademicDetailsTabSections.click();
		threadSleep(2000);
		txtHSC2DistrictAcademicDetailsTabSections.clear();
		txtHSC2DistrictAcademicDetailsTabSections.sendKeys(hsc2District + Keys.ENTER);
	}
	
	public void selectHSC2SchoolZone(String hsc2SchoolZone) {
		dpdHSC2SchoolZoneAcademicDetailsTabSections.click();
		threadSleep(1000);
		txtHSC2SchoolZoneAcademicDetailsTabSections.clear();
		txtHSC2SchoolZoneAcademicDetailsTabSections.sendKeys(hsc2SchoolZone + Keys.ENTER);
	}
	
	public void selectHSC2SchoolName(String hsc2SchoolName) {
		dpdHSC2SchoolNameAcademicDetailsTab.click();
		threadSleep(3000);
		txtHSC2SchoolNameAcademicDetailsTab.clear();
		txtHSC2SchoolNameAcademicDetailsTab.sendKeys(hsc2SchoolName + Keys.ENTER);		
	}
	
	public void selectHSC2SchoolCategory(String hsc2SchoolCategory) {
		dpdHSC2SchoolCategoryAcademicDetailsTab.click();
		threadSleep(1000);
		txtHSC2SchoolCategoryAcademicDetailsTab.clear();
		txtHSC2SchoolCategoryAcademicDetailsTab.sendKeys(hsc2SchoolCategory + Keys.ENTER);
	}
	
	public void selectHSC2CivicStatus(String hsc2CivicStatus) {
		dpdHSC2CivicStatusAcademicDetailsTab.click();
		threadSleep(1000);
		txtHSC2CivicStatusAcademicDetailsTab.clear();
		txtHSC2CivicStatusAcademicDetailsTab.sendKeys(hsc2CivicStatus + Keys.ENTER);
	}
	
	public void selectHSC2MediumofStudy(String hsc2MediumofStudy) {
		dpdHSC2MediumofStudyAcademicDetailsTab.click();
		threadSleep(1000);
		txtHSC2MediumofStudyAcademicDetailsTab.clear();
		txtHSC2MediumofStudyAcademicDetailsTab.sendKeys(hsc2MediumofStudy + Keys.ENTER);
	}
	
	public void selectHSC2YearofPassing(String hsc2YearofPassing) {
		dpdHSC2YearofPassingAcademicDetailsTab.click();
		txtHSC2YearofPassingAcademicDetailsTab.sendKeys(hsc2YearofPassing + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void clearHSC2PermanentRegisterNo() {
		txtHSC2PermanentRegNoAcademicDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterHSC2PermanentRegisterNo(String hsc2PermanentRegNo) {
		txtHSC2PermanentRegNoAcademicDetailsTab.clear();
		txtHSC2PermanentRegNoAcademicDetailsTab.sendKeys(hsc2PermanentRegNo);
		threadSleep(1000);
	}
	
	public void selectHSC2GrouporStream(String hsc2GrouporStream) {
		dpdHSC2GrouporStreamAcademicDetailsTab.click();
		txtHSC2GrouporStreamAcademicDetailsTab.sendKeys(hsc2GrouporStream + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void clearEMISNo() {
		txtEMIsNoAcademicDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterHSC2EMISNo(String hsc2EMISNo) {
		txtEMIsNoAcademicDetailsTab.clear();
		txtEMIsNoAcademicDetailsTab.sendKeys(hsc2EMISNo);
		threadSleep(1000);
	}
	
	public void clearHSC2MarksScored() {
		txtHSC2MarksScoredAcademicDetailsTab.clear();
	}
	
	public void enterHSC2MarksScored(String hsc2MarksScored) {
		txtHSC2MarksScoredAcademicDetailsTab.clear();
		txtHSC2MarksScoredAcademicDetailsTab.sendKeys(hsc2MarksScored);
		threadSleep(1000);
	}
	
	
	public void clearHSC2MathsMark() {
		txtHSC2MathsMarksAcademicDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterHSC2MathsMark(String hsc2MathsMark) {
		txtHSC2MathsMarksAcademicDetailsTab.clear();
		txtHSC2MathsMarksAcademicDetailsTab.sendKeys(hsc2MathsMark + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void clearHSC2PhysicsMark() {
		txtHSC2PhysicsMarksAcademicDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterHSC2PhysicsMark(String hsc2PhysicsMark) {
		txtHSC2PhysicsMarksAcademicDetailsTab.clear();
		txtHSC2PhysicsMarksAcademicDetailsTab.sendKeys(hsc2PhysicsMark + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void clearHSC2ChemistryMark() {
		txtHSC2ChemistryMarksAcademicDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterHSC2ChemistryMark(String hsc2ChemistryMark) {
		txtHSC2ChemistryMarksAcademicDetailsTab.clear();
		txtHSC2ChemistryMarksAcademicDetailsTab.sendKeys(hsc2ChemistryMark + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void clearHSC2OptionalSubjectMark() {
		txtOptionalSubjectMarkAcademicDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterHSC2OptionalSubjectMark(String hsc2OptionalSubjectMark) {
		txtOptionalSubjectMarkAcademicDetailsTab.clear();
		txtOptionalSubjectMarkAcademicDetailsTab.sendKeys(hsc2OptionalSubjectMark);
		threadSleep(1000);
	}
	
	public void uploadHSC2Marksheet(String hsc2MarkSheet) {
		uploadHSC2MarkSheetAcademicDetailsTab.sendKeys(hsc2MarkSheet);
	}
	
	//** Lateral POM Method starts here
	
	public void tickChkBoxSelectifyouhavecompletedHSC1() {
		chkBoxSelectifyouhavecompletedHSC1AcademicDetailsLateral.click();
	}
	
	public void tickChkBoxSelectifyouhavecompletedHSC2() {		
		chkBoxSelectifyouhavecompletedHSC2AcademicDetailsLateral.click();
	}
	
	public void selectDiplomaCountry(String lstDiplomaCountry) {
		dpdCountryAcademicDetailsLateral.click();
		threadSleep(2000);
		txtCountryAcademicDetailsLateral.sendKeys(lstDiplomaCountry + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectDiplomaState(String lstDiplomaState) {
		dpdStateAcademicDetailsLateral.click();
		threadSleep(2000);
		txtStateAcademicDetailsLateral.sendKeys(lstDiplomaState + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectDiplomaCourseType(String lstDiplomaCourseType) {
		dpdCourseTypeAcademicDetailsLateral.click();
		threadSleep(2000);
		txtCourseTypeAcademicDetailsLateral.sendKeys(lstDiplomaCourseType + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectDiplomaBoardofStudy(String lstDiplomaBoardofStudy) {
		dpdBoardofStudyAcademicDetailsLateral.click();
		threadSleep(2000);
		txtBoardofStudyAcademicDetailsLateral.sendKeys(lstDiplomaBoardofStudy + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectDiplomaCollege(String lstDiplomaCollege) {
		dpdCollegeAcademicDetailsLateral.click();
		threadSleep(2000);
		txtCollegeAcademicDetailsLateral.sendKeys(lstDiplomaCollege + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectDiplomaBranchorDepartment(String lstDiplomaBranchorDepartment) {
		dpdBranchorDepartmentAcademicDetailsLateral.click();
		threadSleep(2000);
		txtBranchorDepartmentAcademicDetailsLateral.sendKeys(lstDiplomaBranchorDepartment + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectDiplomaMonthofPassing(String lstDiplomaMonthofPassing) {
		dpdMonthofPassingAcademicDetailsLateral.click();
		threadSleep(2000);
		txtMonthofPassingAcademicDetailsLateral.sendKeys(lstDiplomaMonthofPassing + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectDiplomaYearofPassing(String lstDiplomaYearofPassing) {
		dpdYearofPassingAcademicDetailsLateral.click();
		threadSleep(2000);
		txtYearofPassingAcademicDetailsLateral.sendKeys(lstDiplomaYearofPassing + Keys.ENTER);
		threadSleep(2000);
	}

	public void enterDiplomaExamRegisterNo(String txtDiplomaExamRegisterNo) {
		txtExamRegisterNoAcademicDetailsLateral.clear();
		txtExamRegisterNoAcademicDetailsLateral.sendKeys(txtDiplomaExamRegisterNo);
		threadSleep(1000);
	}
	
	public void enterDiplomaUMISNo(String txtDiplomaUMISNo) {
		txtUMISNoAcademicDetailsLateral.clear();
		txtUMISNoAcademicDetailsLateral.sendKeys(txtDiplomaUMISNo);
		threadSleep(1000);
	}
	
	public void enterSem1MarksScored(String txtSem1Marks) {
		txtMarksScoredSem1AcademicDetailsLateral.clear();
		txtMarksScoredSem1AcademicDetailsLateral.sendKeys(txtSem1Marks);
		threadSleep(1000);
	}
	
	public void enterSem2MarksScored(String txtSem2Marks) {
		txtMarksScoredSem2AcademicDetailsLateral.clear();
		txtMarksScoredSem2AcademicDetailsLateral.sendKeys(txtSem2Marks);
		threadSleep(1000);
	}
	
	public void enterSem3MarksScored(String txtSem3Marks) {
		txtMarksScoredSem3AcademicDetailsLateral.clear();
		txtMarksScoredSem3AcademicDetailsLateral.sendKeys(txtSem3Marks);
		threadSleep(1000);
	}
	
	public void enterSem4MarksScored(String txtSem4Marks) {
		txtMarksScoredSem4AcademicDetailsLateral.clear();
		txtMarksScoredSem4AcademicDetailsLateral.sendKeys(txtSem4Marks);
		threadSleep(1000);
	}
	
	public void enterSem5MarksScored(String txtSem5Marks) {
		txtMarksScoredSem5AcademicDetailsLateral.clear();
		txtMarksScoredSem5AcademicDetailsLateral.sendKeys(txtSem5Marks);
		threadSleep(1000);
	}
	
	public void enterSem6MarksScored(String txtSem6Marks) {
		txtMarksScoredSem6AcademicDetailsLateral.clear();
		txtMarksScoredSem6AcademicDetailsLateral.sendKeys(txtSem6Marks);
		threadSleep(1000);
	}
	
	public void enterSem7MarksScored(String txtSem7Marks) {
		txtMarksScoredSem7AcademicDetailsLateral.clear();
		txtMarksScoredSem7AcademicDetailsLateral.sendKeys(txtSem7Marks);
		threadSleep(1000);
	}
	
	public void enterSem8MarksScored(String txtSem8Marks) {
		txtMarksScoredSem8AcademicDetailsLateral.clear();
		txtMarksScoredSem8AcademicDetailsLateral.sendKeys(txtSem8Marks);
		threadSleep(1000);
	} 
	
	public void enterSem9MarksScored(String txtSem9Marks) {
		txtMarksScoredSem9AcademicDetailsLateral.clear();
		txtMarksScoredSem9AcademicDetailsLateral.sendKeys(txtSem9Marks);
		threadSleep(1000);
	} 
	
	public void enterSem10MarksScored(String txtSem10Marks) {
		txtMarksScoredSem10AcademicDetailsLateral.clear();
		txtMarksScoredSem10AcademicDetailsLateral.sendKeys(txtSem10Marks);
		threadSleep(1000);
	} 
	
	public void enterMarksScoredOverallTotal(String marksScoredOverallTotal) {
		txtMarksScoredOverallTotalAcademicDetailsLateral.clear();
		txtMarksScoredOverallTotalAcademicDetailsLateral.sendKeys(marksScoredOverallTotal);
		threadSleep(1000);
	} 
	
	public void enterSem1TotalMarks(String txtSem1TotalMarks) {
		txtTotalMarksSem1AcademicDetailsLateral.clear();
		txtTotalMarksSem1AcademicDetailsLateral.sendKeys(txtSem1TotalMarks);
		threadSleep(1000);
	} 
	
	public void enterSem2TotalMarks(String txtSem2TotalMarks) {
		txtTotalMarksSem2AcademicDetailsLateral.clear();
		txtTotalMarksSem2AcademicDetailsLateral.sendKeys(txtSem2TotalMarks);
		threadSleep(1000);
	} 
	
	public void enterSem3TotalMarks(String txtSem3TotalMarks) {
		txtTotalMarksSem3AcademicDetailsLateral.clear();
		txtTotalMarksSem3AcademicDetailsLateral.sendKeys(txtSem3TotalMarks);
		threadSleep(1000);
	}
	
	public void enterSem4TotalMarks(String txtSem4TotalMarks) {
		txtTotalMarksSem4AcademicDetailsLateral.clear();
		txtTotalMarksSem4AcademicDetailsLateral.sendKeys(txtSem4TotalMarks);
		threadSleep(1000);
	} 
	
	public void enterSem5TotalMarks(String txtSem5TotalMarks) {
		txtTotalMarksSem5AcademicDetailsLateral.clear();
		txtTotalMarksSem5AcademicDetailsLateral.sendKeys(txtSem5TotalMarks);
		threadSleep(1000);
	} 
		
	public void enterSem6TotalMarks(String txtSem6TotalMarks) {
		txtTotalMarksSem6AcademicDetailsLateral.clear();
		txtTotalMarksSem6AcademicDetailsLateral.sendKeys(txtSem6TotalMarks);
		threadSleep(1000);
	} 
	
	public void enterSem7TotalMarks(String txtSem7TotalMarks) {
		txtTotalMarksSem7AcademicDetailsLateral.clear();
		txtTotalMarksSem7AcademicDetailsLateral.sendKeys(txtSem7TotalMarks);
		threadSleep(1000);
	} 
	
	public void enterSem8TotalMarks(String txtSem8TotalMarks) {
		txtTotalMarksSem8AcademicDetailsLateral.clear();
		txtTotalMarksSem8AcademicDetailsLateral.sendKeys(txtSem8TotalMarks);
		threadSleep(1000);
	} 
	
	public void enterSem9TotalMarks(String txtSem9TotalMarks) {
		txtTotalMarksSem9AcademicDetailsLateral.clear();
		txtTotalMarksSem9AcademicDetailsLateral.sendKeys(txtSem9TotalMarks);
		threadSleep(1000);
	} 
	
	public void enterSem10TotalMarks(String txtSem10TotalMarks) {
		txtTotalMarksSem10AcademicDetailsLateral.clear();
		txtTotalMarksSem10AcademicDetailsLateral.sendKeys(txtSem10TotalMarks);
		threadSleep(1000);
	} 
	
	public void enterTotalMarksOverallTotal(String txtTotalMarksOverallTotal) {
		txtTotalMarksOverallTotalAcademicDetailsLateral.clear();
		txtTotalMarksOverallTotalAcademicDetailsLateral.sendKeys(txtTotalMarksOverallTotal);
		threadSleep(1000);
	} 
	
	public void enterOverallPercentage(String txtOverallPercentage) {
		txtOverAllPercentageAcademicDetailsLateral.clear();
		txtOverAllPercentageAcademicDetailsLateral.sendKeys(txtOverallPercentage);
		threadSleep(1000);
	} 
		
	
	//**Lateral POM Methods ends here
			
	public List<String> getFamilyDetailsSectionText() {
		List<String> familyDetailsSectionList = new ArrayList<>();
		for(WebElement element : txtFamilyDetailsSection) {
			String familyDetailsSectionName = element.getText();
			familyDetailsSectionList.add(familyDetailsSectionName);
		}
		return familyDetailsSectionList;
	}
	
	public void selectFamilyType(String familyType) {
		dpdFamilyTypeFamilyDetailsTab.click();
		txtFamilyTypeFamilyDetailsTab.sendKeys(familyType + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void enterFatherFullName(String fatherFullName) {
		txtFatherFullNameFamilyDetailsTab.clear();
		txtFatherFullNameFamilyDetailsTab.sendKeys(fatherFullName);
		threadSleep(1000);
	}
	
	public void enterFatherAadharNumber(String fatherAadharNumber) {
		txtFatherAadharNumberFamilyDetailsTab.clear();
		txtFatherAadharNumberFamilyDetailsTab.sendKeys(fatherAadharNumber);
		threadSleep(1000);
	}
	
	public void selectFatherResidentStatus(String fatherResidentStatus) {
		dpdFatherResidentStatusFamilyDetailsTab.click();
		txtFatherResidentStatusFamilyDetailsTab.sendKeys(fatherResidentStatus + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void selectFatherContryNonResident(String fatherContryNonResident) {
		dpdFatherCountryofNonResidentFamilyDetailsTab.click();
		txtFatherCountryofNonResidentFamilyDetailsTab.sendKeys(fatherContryNonResident + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void enterFatherMobileNumber(String fatherMobileNo) {
		txtFatherMobileNumberFamilyDetailsTab.clear();
		txtFatherMobileNumberFamilyDetailsTab.sendKeys(fatherMobileNo);
		threadSleep(1000);
	}
	
	public void enterFatherEmail(String fatherEmail) {
		txtFatherEmailFamilyDetailsTab.clear();
		txtFatherEmailFamilyDetailsTab.sendKeys(fatherEmail);
		threadSleep(1000);
	}
	
	public void selectFatherOccupation(String fatherOccupation) {
		dpdFatherOccupationFamilyDetailsTab.click();
		txtFatherOccupationFamilyDetailsTab.sendKeys(fatherOccupation + Keys.ENTER);
		threadSleep(1000);
	}	
	
	public void enterFatherOccupationifOthers(String fatherOccupationifOthers) {
		txtFatherOccupationifOthersFamilyDetailsTab.clear();
		txtFatherOccupationifOthersFamilyDetailsTab.sendKeys(fatherOccupationifOthers);
		threadSleep(1000);
	}	
	
	public void selectFatherAnnualIncome(String fatherAnnualIncome) {	
		dpdFatherAnnualIncomeFamilyDetailsTab.click();
		txtFatherAnnualIncomeFamilyDetailsTab.sendKeys(fatherAnnualIncome + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void enterFatherWorkPlaceorCompany(String fatherWorkplace) {
		txtFatherWorkPlaceFamilyDetailsTab.clear();
		txtFatherWorkPlaceFamilyDetailsTab.sendKeys(fatherWorkplace);
		threadSleep(1000);
	}
	
	public void enterFatherEducationalQaulification(String fatherEducationalQualification) {
		txtFatherEducationalQualificationFamilyDetailsTab.clear();
		txtFatherEducationalQualificationFamilyDetailsTab.sendKeys(fatherEducationalQualification);
		threadSleep(1000);
	}
	
	public void uploadFathersAadhar(String fathersAadhar) {
		uploadFatherAadharFamilyDetailsTab.sendKeys(fathersAadhar);
	}
	
	public void uploadFathersPhoto(String fathersPhoto) {
		uploadFatherPhotoFamilyDetailsTab.sendKeys(fathersPhoto);
	}

	public void enterMotherFullName(String motherFullName) {
		txtMotherFullNameFamilyDetailsTab.clear();
		txtMotherFullNameFamilyDetailsTab.sendKeys(motherFullName);
		threadSleep(1000);
	}
	
	public void enterMotherAadharNumber(String motherAadharNumber) {
		txtMotherAadharNumberFamilyDetailsTab.clear();
		txtMotherAadharNumberFamilyDetailsTab.sendKeys(motherAadharNumber);
		threadSleep(1000);
	}
	
	public void selectMotherResidenceStatus(String motherResidenceStatus) {
		dpdMotherResidentStatusFamilyDetailsTab.click();
		txtMotherResidentStatusFamilyDetailsTab.sendKeys(motherResidenceStatus + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectMotherCountryofNonResidence(String motherCountryofNonResidence) {
		dpdMotherCountryofNonResidentFamilyDetailsTab.click();
		txtMotherCountryofNonResidentFamilyDetailsTab.sendKeys(motherCountryofNonResidence + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void enterMotherMobileNumber(String motherMobileNumber) {
		txtMotherMobileNumberFamilyDetailsTab.clear();
		txtMotherMobileNumberFamilyDetailsTab.sendKeys(motherMobileNumber);
		threadSleep(1000);
	}
	
	public void enterMotherEmailid(String motherEmailid) {
		txtMotherEmailidFamilyDetailsTab.clear();
		txtMotherEmailidFamilyDetailsTab.sendKeys(motherEmailid);
		threadSleep(1000);
	}
	
	public void selectMotherOccupation(String motherOccupation) {
		dpdMotherOccupationFamilyDetailsTab.click();
		txtMotherOccupationFamilyDetailsTab.sendKeys(motherOccupation + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void enterMotherOccupationIfOthers(String motherOccupationOthers) {
		txtMotherOccupationifOthersFamilyDetailsTab.clear();
		txtMotherOccupationifOthersFamilyDetailsTab.sendKeys(motherOccupationOthers);
		threadSleep(1000);
	}
	
	public void selectMotherAnnualIncome(String motherAnnualIncome) {
		dpdMotherAnnualIncomeFamilyDetailsTab.click();
		txtMotherAnnualIncomeFamilyDetailsTab.sendKeys(motherAnnualIncome + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void enterMotherWorkPlaceorCompany(String motherWorkPlaceorCompany) {
		txtMotherWorkplaceFamilyDetailsTab.clear();
		txtMotherWorkplaceFamilyDetailsTab.sendKeys(motherWorkPlaceorCompany);
		threadSleep(1000);
	}
	
	public void enterMotherEducationalQualification(String motherEducationalQualification) {
		txtMotherEducationalQualificationFamilyDetailsTab.clear();
		txtMotherEducationalQualificationFamilyDetailsTab.sendKeys(motherEducationalQualification);
		threadSleep(2000);
	}
	
	public void uploadMothersAadhar(String motherAadhar) {
		uploadMotherAadharFamilyDetailsTab.sendKeys(motherAadhar);
	}
	
	public void uploadMotherPhoto(String motherPhoto) {
		uploadMotherPhotoFamilyDetailsTab.sendKeys(motherPhoto);
	}
	
	public void clickOnIWanttoAddGuardianDetailsCheckBox() {
		checkBoxIwanttoAddGuardianDetails.click();
		threadSleep(1000);
	}
	
	public void clearGuardianFullName() {
		txtguardianFullNameFamilyDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterGuardianFullName(String guradianFullName) {
		txtguardianFullNameFamilyDetailsTab.clear();
		txtguardianFullNameFamilyDetailsTab.sendKeys(guradianFullName);
		threadSleep(1000);
	}
	
	public void clearGuardianAadharNumber() {
		txtGuardianAadharNumberFamilyDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterGuardianAadharNumber(String guradianAadharNumber) {
		txtGuardianAadharNumberFamilyDetailsTab.clear();
		txtGuardianAadharNumberFamilyDetailsTab.sendKeys(guradianAadharNumber);
		threadSleep(1000);
	}
	
	public void clearGuardianMobileNumber() {
		txtGuardianMobileNumberFamilyDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterGuardianMobileNumber(String guradianMobileNumber) {
		txtGuardianMobileNumberFamilyDetailsTab.clear();
		txtGuardianMobileNumberFamilyDetailsTab.sendKeys(guradianMobileNumber);
		threadSleep(1000);
	}
	
	public void enterGuardianEmailid(String guradianEmail) {
		txtGuardianEmailidFamilyDetailsTab.clear();
		txtGuardianEmailidFamilyDetailsTab.sendKeys(guradianEmail);
		threadSleep(1000);
	}
	
	public void selectGuardianOccupation(String guradianOccupation) {
		dpdGuardianOccupationFamilyDetailsTab.click();
		txtGuardianOccupationFamilyDetailsTab.sendKeys(guradianOccupation + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void enterGuardianOccupationIfOthers(String guardianOccupationOthers) {
		txtGuardianOccupationifOthersFamilyDetailsTab.clear();
		txtGuardianOccupationifOthersFamilyDetailsTab.sendKeys(guardianOccupationOthers);
		threadSleep(1000);
	}
	
	public void selectGuardianAnnualIncome(String guradianAnnualIncome) {
		dpdGuardianAnnualIncomeFamilyDetailsTab.click();
		txtGuardianAnnualIncomeFamilyDetailsTab.sendKeys(guradianAnnualIncome + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void enterGuardianWorkplaceorCompany(String guradianWorkPlace) {
		txtGuardianWorkPlaceFamilyDetailsTab.clear();
		txtGuardianWorkPlaceFamilyDetailsTab.sendKeys(guradianWorkPlace + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void enterGuardianEducationalQualification(String guardianEducationalQualification) {
		txtGuardianEducationalQualificationFamilyDetailsTab.clear();
		txtGuardianEducationalQualificationFamilyDetailsTab.sendKeys(guardianEducationalQualification);
		threadSleep(1000);
	}
	
	public void selectGuardianGender(String guardianGender) {
		dpdGuardianGenderFamilyDetailsTab.click();
		txtGuardianGenderFamilyDetailsTab.sendKeys(guardianGender + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void selectGuardianRelationshipWithStudent(String guardianRelationship) {
		dpdGuradianRelationshipToTheStudentFamilyDetailsTab.click();
		txtGuradianRelationshipToTheStudentFamilyDetailsTab.sendKeys(guardianRelationship + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void uploadGuardianAadhar(String guardianAadhar) {
		uploadGuardianAadharFamilyDetailsTab.sendKeys(guardianAadhar);
	}
	
	public void uploadGuardianPhoto(String guardianPhoto) {
		uploadGuardianPhotoFamilyDetailsTab.sendKeys(guardianPhoto);
	}
	
	public void selectDoYouHaveSiblings(String yesOrNo) {
		for(WebElement lstDoYouhaveSiblings : lstDoYouHaveSiblingsFamilyDetailsTab) {
			if(lstDoYouhaveSiblings.getText().equals(yesOrNo));
			lstDoYouhaveSiblings.click();
			threadSleep(3000);
			break;
		}
	}
	
	public void selectSiblings1JoinedinthisInstitutionBefore(String yesOrNo) {
		for(WebElement lstSiblingsJoinedBefore : lstSibling1AnySiblingsJoinedthisInstitutionBeforeFamilyDetailsTab) {
			if(lstSiblingsJoinedBefore.getText().equals(yesOrNo));
			lstSiblingsJoinedBefore.click();
			threadSleep(3000);
			break;
		}
	}
	
	public void selectSibling1College(String sibling1College) {
		dpdSibling1CollegeFamilyDetailsTab.click();
		txtSibling1CollegeFamilyDetailsTab.sendKeys(sibling1College + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectSibling1Degree(String sibling1Degree) {
		dpdSibling1DegreeFamilyDetailsTab.click();
		txtSibling1DegreeFamilyDetailsTab.sendKeys(sibling1Degree + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectSibling1AdmissionYear(String sibling1AdmissionYear) {
		dpdSibling1AdmissionYearFamilyDetailsTab.click();
		txtSibling1AdmissionYearFamilyDetailsTab.sendKeys(sibling1AdmissionYear + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void enterSibling1RegisterNo(String sibling1RegisterNo) {
		txtSibling1RegisterNoFamilyDetailsTab.clear();
		txtSibling1RegisterNoFamilyDetailsTab.sendKeys(sibling1RegisterNo);
	}
	
	public void clearSibling1FullName() {
		txtSibling1FullNameFamilyDetailsTab.clear();
		threadSleep(2000);
	}
	
	public void enterSibling1FullName(String sibling1FullName) {
		txtSibling1FullNameFamilyDetailsTab.clear();
		txtSibling1FullNameFamilyDetailsTab.sendKeys(sibling1FullName);
		threadSleep(2000);
	}
	
	public void selectSibling1Gender(String sibling1Gender) {
		dpdSibling1GenderFamilyDetailsTab.click();
		txtSibling1GenderFamilyDetailsTab.sendKeys(sibling1Gender + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void enterSibling1DOB(String sibling1DOB) {
		txtSibling1DOBFamilyDetailsTab.clear();
		txtSibling1DOBFamilyDetailsTab.sendKeys(sibling1DOB);
		threadSleep(2000);
	}
	
	public void enterSibling1MobileNo(String sibling1MobileNo) {
		txtSibling1MobileNoFamilyDetailsTab.clear();
		txtSibling1MobileNoFamilyDetailsTab.sendKeys(sibling1MobileNo);
		threadSleep(2000);
	}
	
	public void enterSibling1Email(String sibling1Email) {
		txtSibling1EmailFamilyDetailsTab.clear();
		txtSibling1EmailFamilyDetailsTab.sendKeys(sibling1Email);
		threadSleep(2000);
	}
	
	public void selectSiblings2JoinedinthisInstitutionBefore(String yesOrNo) {
		for(WebElement lstSiblingsJoinedBefore : lstSibling2AnySiblingsJoinedthisInstitutionBeforeFamilyDetailsTab) {
			if(lstSiblingsJoinedBefore.getText().equals(yesOrNo));
			lstSiblingsJoinedBefore.click();
			threadSleep(3000);
			break;
		}
	}
	
	public void selectSibling2College(String sibling2College) {
		dpdSibling2CollegeFamilyDetailsTab.click();
		txtSibling2CollegeFamilyDetailsTab.sendKeys(sibling2College + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectSibling2Degree(String sibling2Degree) {
		dpdSibling2DegreeFamilyDetailsTab.click();
		txtSibling2DegreeFamilyDetailsTab.sendKeys(sibling2Degree + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectSibling2AdmissionYear(String sibling2AdmissionYear) {
		dpdSibling2AdmissionYearFamilyDetailsTab.click();
		txtSibling2AdmissionYearFamilyDetailsTab.sendKeys(sibling2AdmissionYear + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void enterSibling2RegisterNo(String sibling2RegisterNo) {
		txtSibling2RegisterNoFamilyDetailsTab.clear();
		txtSibling2RegisterNoFamilyDetailsTab.sendKeys(sibling2RegisterNo);
		threadSleep(2000);
	}
	
	public void enterSibling2FullName(String sibling2FullName) {
		txtSibling2FullNameFamilyDetailsTab.clear();
		txtSibling2FullNameFamilyDetailsTab.sendKeys(sibling2FullName);
		threadSleep(2000);
	}
	
	public void selectSibling2Gender(String sibling2Gender) {
		dpdSibling2GenderFamilyDetailsTab.click();
		txtSibling2GenderFamilyDetailsTab.sendKeys(sibling2Gender + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void enterSibling2DOB(String sibling2DOB) {
		txtSibling2DOBFamilyDetailsTab.clear();
		txtSibling2DOBFamilyDetailsTab.sendKeys(sibling2DOB);
		threadSleep(2000);
	}
	
	public void enterSibling2MobileNo(String sibling2MobileNo) {
		txtSibling2MobileNoFamilyDetailsTab.clear();
		txtSibling2MobileNoFamilyDetailsTab.sendKeys(sibling2MobileNo);
		threadSleep(2000);
	}
	
	public void enterSibling2Email(String sibling2Email) {
		txtSibling2EmailFamilyDetailsTab.clear();
		txtSibling2EmailFamilyDetailsTab.sendKeys(sibling2Email);
		threadSleep(2000);
	}
	
	public void selectSiblings3JoinedinthisInstitutionBefore(String yesOrNo) {
		for(WebElement lstSiblingsJoinedBefore : lstSibling3AnySiblingsJoinedthisInstitutionBeforeFamilyDetailsTab) {
			if(lstSiblingsJoinedBefore.getText().equals(yesOrNo));
			lstSiblingsJoinedBefore.click();
			threadSleep(2000);
			break;
		}
	}
	
	public void selectSibling3College(String sibling3College) {
		dpdSibling3CollegeFamilyDetailsTab.click();
		txtSibling3CollegeFamilyDetailsTab.sendKeys(sibling3College + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectSibling3Degree(String sibling3Degree) {
		dpdSibling3DegreeFamilyDetailsTab.click();
		txtSibling3DegreeFamilyDetailsTab.sendKeys(sibling3Degree + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectSibling3AdmissionYear(String sibling3AdmissionYear) {
		dpdSibling3AdmissionYearFamilyDetailsTab.click();
		txtSibling3AdmissionYearFamilyDetailsTab.sendKeys(sibling3AdmissionYear + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void enterSibling3RegisterNo(String sibling3RegisterNo) {
		txtSibling3RegisterNoFamilyDetailsTab.clear();
		txtSibling3RegisterNoFamilyDetailsTab.sendKeys(sibling3RegisterNo);
		threadSleep(2000);
	}
	
	public void enterSibling3FullName(String sibling3FullName) {
		txtSibling3FullNameFamilyDetailsTab.clear();
		txtSibling3FullNameFamilyDetailsTab.sendKeys(sibling3FullName);
		threadSleep(2000);
	}
	
	public void selectSibling3Gender(String sibling3Gender) {
		dpdSibling3GenderFamilyDetailsTab.click();
		txtSibling3GenderFamilyDetailsTab.sendKeys(sibling3Gender + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void enterSibling3DOB(String sibling3DOB) {
		txtSibling3DOBFamilyDetailsTab.clear();
		txtSibling3DOBFamilyDetailsTab.sendKeys(sibling3DOB);
		threadSleep(1000);
	}
	
	public void enterSibling3MobileNo(String sibling3MobileNo) {
		txtSibling3MobileNoFamilyDetailsTab.clear();
		txtSibling3MobileNoFamilyDetailsTab.sendKeys(sibling3MobileNo);
		threadSleep(2000);
	}
	
	public void enterSibling3Email(String sibling3Email) {
		txtSibling3EmailFamilyDetailsTab.clear();
		txtSibling3EmailFamilyDetailsTab.sendKeys(sibling3Email);
		threadSleep(2000);
	}

	
	public void clickOnAddAnotherSibling() {
		btnAddAnotherSiblingsFamilyDetailsTab.click();
		threadSleep(3000);
	}
	
	public void removeSibling1() {
		btnRemoveSibling1FamilyDetailsTab.click();
		threadSleep(2000);
	}
		
	public void removeSibling2() {
		btnRemoveSibling2FamilyDetailsTab.click();
		threadSleep(2000);
	}
	
	public void removeSibling3() {
		btnRemoveSibling3FamilyDetailsTab.click();
		threadSleep(2000);
	}
	
	public void clickOnKeepEditing() {
		btnKeepEditing.click();
		threadSleep(1000);
	}
	
	public void clickOnLeaveAnyway() {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		    // Wait for overlay to disappear
		wait.until(ExpectedConditions.visibilityOf(btnLeaveAnyway));
		btnLeaveAnyway.click();
		threadSleep(1000);
	}
	
	public List<String> getAddressDetailsSectionText(){
		List<String> addressDetailsSectionList = new ArrayList<>();
		for(WebElement element : txtAddressDetailsSections) {
			String addressDetailsSectionName = element.getText();
			addressDetailsSectionList.add(addressDetailsSectionName);
		}
		return addressDetailsSectionList;
	}
	
	public void selectPermanentAddressCountry(String permanentAddressCountry) {
		dpdPermanentAddressCountryAddressDetailsTab.click();
		txtPermanentAddressCountryAddressDetailsTab.sendKeys(permanentAddressCountry + Keys.ENTER);
		threadSleep(1000);		
	}
	
	public void selectPermanentAddressState(String permanentAddressState) {
		dpdPermanentAddressStateAddressDetailsTab.click();
		txtPermanentAddressStateAddressDetailsTab.sendKeys(permanentAddressState + Keys.ENTER);
		threadSleep(1000);		
	}
	
	public void clearPermanentAddressLine1() {
		txtPermanentAddressLine1AddressDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterPermanentAddressLine1(String permanentAddressLine1) {
		txtPermanentAddressLine1AddressDetailsTab.clear();
		txtPermanentAddressLine1AddressDetailsTab.sendKeys(permanentAddressLine1);
		threadSleep(1000);		
	}
	
	public void enterPermanentAddressLine2(String permanentAddressLine2) {
		txtPermanentAddressLine2AddressDetailsTab.clear();
		txtPermanentAddressLine2AddressDetailsTab.sendKeys(permanentAddressLine2);
		threadSleep(1000);		
	}
	
	public void selectPermanentAddressCity(String permanentAddressCity) {
		dpdPermanentAddressCityAddressDetailsTab.click();
		txtPermanentAddressCityAddressDetailsTab.sendKeys(permanentAddressCity + Keys.ENTER);
		threadSleep(1000);		
	}
	
	public void clearPermanentAddressPincode() {
		txtPermanentAddressPincodeAddressDetailsTab.clear();
		threadSleep(1000);		
	}
	
	public void enterPermanentAddressPinCode(String permanentAddressPinCode) {
		txtPermanentAddressPincodeAddressDetailsTab.clear();
		txtPermanentAddressPincodeAddressDetailsTab.sendKeys(permanentAddressPinCode);
	}
	
	public void clickOnGuardianorPrivateAddressOption(String yesOrNo) {
		for(WebElement lstYesorNo : radioOptionYesorNoGuardianorPrivateAddressAddressDetailsTab) {
			if(lstYesorNo.getText().equals(yesOrNo)) {
				lstYesorNo.click();
				threadSleep(1000);
				break;
			}
		}
	}
	
	public void clickOnCommunicationaddressisSameAsPermanentAddress() {
		checkBoxCommunicationAddressisSameAsPermanentAddressDetailsTab.click();
		threadSleep(1000);
	}
	
	public void selectCommunicationAddressCountry(String communicationAddressCountry) {
		dpdCommunicationAddressCountryAddressDetailsTab.click();
		threadSleep(1000);
		txtCommunicationAddressCountryAddressDetailsTab.clear();
		txtCommunicationAddressCountryAddressDetailsTab.sendKeys(communicationAddressCountry + Keys.ENTER);
		threadSleep(2000);
	}
	
	public void selectCommunicationAddressState(String communicationAddressState) {
		dpdCommunicationAddressStateAddressDetailsTab.click();
		threadSleep(1000);
		txtCommunicationAddressStateAddressDetailsTab.clear();
		txtCommunicationAddressStateAddressDetailsTab.sendKeys(communicationAddressState + Keys.ENTER);
	}
	
	public void enterCommunicationAddressLine1(String communicationAddressLine1) {
		txtCommunicationAddressline1AddressDetailsTab.clear();
		txtCommunicationAddressline1AddressDetailsTab.sendKeys(communicationAddressLine1);
	}
	
	public void enterCommunicationAddressLine2(String communicationAddressLine2) {
		txtCommunicationAddressline2AddressDetailsTab.clear();
		txtCommunicationAddressline2AddressDetailsTab.sendKeys(communicationAddressLine2);
	}
	
	public void selectCommunicationAddressCity(String communicationAddressCity) {
		dpdCommunicationAddressCityAddressDetailsTab.click();
		threadSleep(1000);
		txtCommunicationAddressCityAddressDetailsTab.clear();
		txtCommunicationAddressCityAddressDetailsTab.sendKeys(communicationAddressCity + Keys.ENTER);
	}
	
	public void enterCommunicationAddressPincode(String communicationAddressPincode) {
		txtCommunicationAddressPincodeAddressDetailsTab.clear();
		txtCommunicationAddressPincodeAddressDetailsTab.sendKeys(communicationAddressPincode);
	}
	
	public void selectGuardianAddressCountry(String guardianAddressCountry) {
		dpdGuardianAddressCountryAddressDetailsTab.click();
		threadSleep(1000);
		txtGuardianAddressCountryAddressDetailsTab.clear();
		txtGuardianAddressCountryAddressDetailsTab.sendKeys(guardianAddressCountry + Keys.ENTER);
	}
	
	public void selectGuardianAddressState(String guardianAddressState) {
		dpdGuardianAddressStateAddressDetailsTab.click();
		threadSleep(1000);
		txtGuardianAddressStateAddressDetailsTab.clear();
		txtGuardianAddressStateAddressDetailsTab.sendKeys(guardianAddressState + Keys.ENTER);
	}
	
	public void enterGuardianAddressLine1(String guardianAddressLine1) {
		txtGuardianAddressLine1AddressDetailsTab.clear();
		txtGuardianAddressLine1AddressDetailsTab.sendKeys(guardianAddressLine1);
	}
	
	public void enterGuardianAddressLine2(String guardianAddressLine2) {
		txtGuardianAddressLine2AddressDetailsTab.clear();
		txtGuardianAddressLine2AddressDetailsTab.sendKeys(guardianAddressLine2);
	}
	
	public void selectGuardianAddressCity(String guardianAddressCity) {
		dpdGuardianAddressCityAddressDetailsTab.click();
		threadSleep(1000);
		txtGuardianAddressCityAddressDetailsTab.clear();
		txtGuardianAddressCityAddressDetailsTab.sendKeys(guardianAddressCity + Keys.ENTER);
	}
	
	public void enterGuardianAddressPincode(String guardianAddressPincode) {
		txtGuardianAddressPincodeAddressDetailsTab.clear();
		txtGuardianAddressPincodeAddressDetailsTab.sendKeys(guardianAddressPincode);
	}
	
	public List<String> getAdmissionDetailsSectionText(){
		List<String> admissionDetailsSectionTextList = new ArrayList<>();
		for(WebElement element : lstAdmissionDetailsTabSectionText) {
			String admissionDetailsSectionName = element.getText();
			admissionDetailsSectionTextList.add(admissionDetailsSectionName);
		}
		return admissionDetailsSectionTextList;
	}
	
	public void selectPaymentMode(String paymentMode) {
		dpdPaymentModeAdmissionDetailsTab.click();
		threadSleep(1000);
		txtPaymentModeAdmissionDetailsTab.sendKeys(paymentMode + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void enterPaidAmount(String paidAmount) {
		txtPaidAmountAdmissionDetailsTab.clear();
		txtPaidAmountAdmissionDetailsTab.sendKeys(paidAmount);
		threadSleep(1000);
	}
	
	public void enterPaymentId(String paymentId) {
		txtPaymentIdAdmissionDetailsTab.clear();
		txtPaymentIdAdmissionDetailsTab.sendKeys(paymentId);
		threadSleep(1000);
	}
	
	public void enterPaidOn(String paymentOn) {
		txtPaidOnAdmissionDetailsTab.sendKeys(paymentOn);
		threadSleep(1000);		
	}
	
	public void uploadConsortiumApplication(String consortiumApplication) {
		uploadConsortiumApplicationAdmissionDetailsTab.sendKeys(consortiumApplication);
		threadSleep(1000);
	}
	
	public void selectScholarType(String scholarType) {
		for(WebElement scholarTypeList : lstScholarTypeAdmissionDetailsTab) {
			if(scholarTypeList.getText().equals(scholarType)) {
				scholarTypeList.click();
				threadSleep(1000);
				break;
			}
		}
	}
	
	public void selectPickUpPoint(String pickUpPoint) {
		dpdCollegePickupPointAdmissionDetailsTab.click();
		threadSleep(1000);
		txtCollegePickupPointAdmissionDetailsTab.clear();
		txtCollegePickupPointAdmissionDetailsTab.sendKeys(pickUpPoint + Keys.ENTER);
		
	}
	
	public void selectDayScholarCommutePreference(String dayScholarCommuteType) {
		for(WebElement dayScholarCommutePrefList : lstDayscholarCommutePrefAdmissionDetailsTab) {
			if(dayScholarCommutePrefList.getText().equals(dayScholarCommuteType)) {
				dayScholarCommutePrefList.click();
				threadSleep(1000);
				break;
			}
		}
	}
	
	public void selectPersonalTransportVehicleType(String personalTransportVehicleType) {
		for(WebElement personalTransportType : lstPersonalTransportVehicleTypeAdmissionDetailsTab) {
			if(personalTransportType.getText().equals(personalTransportVehicleType)) {
				personalTransportType.click();
				threadSleep(1000);
				break;
			}
		}
	}
	
	public void clearTwoWheelerVehicleNumber() {
		txtTwoWheelerVehicleNumberAdmissionDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterTwoWheelerVehicleNumber(String twoWheelerVehicleNumber) {
		txtTwoWheelerVehicleNumberAdmissionDetailsTab.clear();
		txtTwoWheelerVehicleNumberAdmissionDetailsTab.sendKeys(twoWheelerVehicleNumber);
	}
	
	public void clearTwoWheelerLicenseNumber() {
		txtTwoWheelerLicenseNumberAdmissionDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterTwoWheelerLicenseNumber(String twoWheelerLicenseNumber) {
		txtTwoWheelerLicenseNumberAdmissionDetailsTab.clear();
		txtTwoWheelerLicenseNumberAdmissionDetailsTab.sendKeys(twoWheelerLicenseNumber);
	}
	
	public void uploadRC(String rc) {
		uploadRCAdmissionDetailsTab.sendKeys(rc);
		threadSleep(2000);
	}
	
	public void uploadLicense(String license) {
		uploadLicenseAdmissionDetailsTab.sendKeys(license);
		threadSleep(2000);
	}
	
	public void clearFourWheelerVehicleNumber() {
		txtFourWheelerVehicleNumberAdmissionDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void clearFourWheelerLicenseNumber() {
		txtFourWheelerLicenseNumberAdmissionDetailsTab.clear();
		threadSleep(1000);
	}
		
	public void enterFourWheelerVehicleNumber(String fourWheelerVehicleNumber) {
		txtFourWheelerVehicleNumberAdmissionDetailsTab.clear();
		txtFourWheelerVehicleNumberAdmissionDetailsTab.sendKeys(fourWheelerVehicleNumber);
	}
	
	public void enterFourWheelerLicenseNumber(String fourWheelerLicenseNumber) {
		txtFourWheelerLicenseNumberAdmissionDetailsTab.clear();
		txtFourWheelerLicenseNumberAdmissionDetailsTab.sendKeys(fourWheelerLicenseNumber);
	}
	
	public void clearTNEAAdmissionNo() {
		txtTNEAAdmissionNoAdmissionDetailsTab.clear();
		threadSleep(1000);
	}
	
	public void enterTNEAAdmissionNo(String tneaAdmissionNo) {
		txtTNEAAdmissionNoAdmissionDetailsTab.clear();
		txtTNEAAdmissionNoAdmissionDetailsTab.sendKeys(tneaAdmissionNo);
	}
	
	public List<String> getDocumentsTabSectionText() {
		List<String> documentsTabSectionText = new ArrayList<>();
		for (WebElement element : lstDocumentsTabSectionText) {
			String documentsTabSectionTextList = element.getText();
			documentsTabSectionText.add(documentsTabSectionTextList);
    }
    return documentsTabSectionText;	
}
	
	public void clickOnPreview() {
		btnPreviewMyApplication.click();
		threadSleep(2000);
	}
	
	public List<String> getDocumentsTabMandatoryText() {
		List<String> documentsTabMandatoryText = new ArrayList<>();
		for (WebElement element : lstDocumentsTabMandatoryAlerts) {
			String documentsTabMandatoryTextList = element.getText();
			documentsTabMandatoryText.add(documentsTabMandatoryTextList);
    }
    return documentsTabMandatoryText;	
}
	
	public void uploadAllFiles(String documentFiles) {
		for(WebElement uploadFiles : uploadAllDocuments) {
			uploadFiles.sendKeys(documentFiles);			
			threadSleep(1000);
		}
}
	
	public void uploadPassportSizePhoto(String imageFiles) {
		uploadPassportSizePhoto.sendKeys(imageFiles);
	}
	
	public void viewAllFiles() {
		for(WebElement viewFiles : viewAllDocuments) {
			viewFiles.click();
			threadSleep(2000);
			System.out.println(viewDocumentPopupDocumentName.getText());
			closeButtoninDocumentPopup.click();
		}
	}
	
	public void removeAllDocuments() {
		for(WebElement deleteDocuments: deleteAllDocuments) {
			deleteDocuments.click();
			threadSleep(1000);
		}
	}
	
	public List<String> getPreviewTabSectionsText(){
		List<String> previewTabText = new ArrayList<>();
		for(WebElement element : lstPreviewTabSections) {
			String previewTabTextList = element.getText();
			previewTabText.add(previewTabTextList);
		}
		return previewTabText;
	}
	
	public void clickOnSubmitbuttoninPreviewTab() {
		btnSubmit.click();
		threadSleep(3000);
	}
	
	public String getStudentDetailsSubmissionSuccessText() {
		return txtStudentDetailsSubmissionSuccessfull.getText();
	}
	
	public String getStudentDetailsSubmissionFailedText() {
		return txtStudentDetailsSubmissionFailed.getText();
	}
	
	public void clickOnCloseButtoninSuccessFailurePopup() {
		btnCloseinPreviewSuccessFailurePopUp.click();
		threadSleep(1000);
	}
	
	public void clickOnTabNames(String tabName) {
		for(WebElement tabNames : lstTabNames) {
			if(tabNames.getText().equals(tabName)) {
				tabNames.click();
				break;
			}
		}
	}
	
	public String getAdmissionNo() {
		return txtAdmissionNo.getText();
	}
	
	
	
}



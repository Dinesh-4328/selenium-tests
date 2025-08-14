package com.skitech.pageObjectsRepo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.byteforza.utilities.DateUtility;
import com.github.javafaker.Faker;

public class EnquiryPageObjects {
	
	WebDriver driver;
	Faker fake = new Faker();
	DateUtils date = new DateUtils();
	DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	EnquiryPageObjects enquiryPageObjects;
	Random rand = new Random();
	int randomNumber = 100 + rand.nextInt(401); 
	int randomCutOffMarks = 100 + rand.nextInt(201);
	
	
	
	@FindBy(xpath = "//button[text()='Enquiry Form']")
	private WebElement enquiryFormBtn;
	
	@FindBy(xpath = "//div[@id='react-select-2-placeholder']")
	private WebElement admissionQuotaDPD;
	
	@FindBy(xpath = "//div[text()='Management']")
	private WebElement lstAdmissionQuota;

	@FindBy(xpath = "//div[@id='react-select-3-placeholder']")
	private WebElement admissionTypeDPD;
	
	@FindBy(xpath = "//div[text()='New Admission']")
	private WebElement lstAdmissionType;
	
	@FindBy(xpath = "//div[@id='react-select-4-placeholder']")
	private WebElement programmeTypeDPD;
	
	@FindBy(xpath = "//div[text()='Undergraduate(UG)']")
	private WebElement lstProgrammeType;
	
	@FindBy(xpath = "//div[@id='react-select-5-placeholder']")
	private WebElement degreeDPD;
	
	@FindBy(xpath = "//div[text()='B.E']")
	private WebElement lstDegree;
	
	@FindBy(xpath = "//div[@id='react-select-6-placeholder']")
	private WebElement departmentDPD;
	
	@FindBy(xpath = "//div[text()='Computer Science and Engineering']")
	private WebElement lstDepartment;
	
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement txtLastName;
	
	@FindBy(xpath = "//input[@name='dob']")
	private WebElement dob;
	
	@FindBy(xpath = "//div[@id='react-select-7-placeholder']")
	private WebElement genderDPD;
	
	@FindBy(xpath = "//div[text()='Male']")
	private WebElement lstGender;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement txtEmail;
	
	@FindBy(xpath = "//input[@class='PhoneInputInput']")
	private WebElement txtMobileNumber;
	
	@FindBy(xpath = "//input[@name='guardianname']")
	private WebElement txtFather_GuardianName;
	
	@FindBy(xpath = "//label[text()='Father / Guardian Mobile Number']//following::div[1]//input")
	private WebElement txtFather_GuardianMobileNumber;
	
	@FindBy(xpath = "//label[text()='Father / Guardian Occupation']//following::div[1]//input")
	private WebElement txtFather_GuardianMobileOccupation;
	
	@FindBy(xpath = "//div[@id='react-select-8-placeholder']")
	private WebElement annualIncomeDPD;
	
	@FindBy(xpath = "//div[text()='₹0 - ₹20,000']")
	private WebElement lstAnnualIncome;
	
	@FindBy(xpath = "//label[text()='Address Line1']//following::div[1]//input")
	private WebElement txtAddressLine1;
	
	@FindBy(xpath = "//label[text()='Address Line2']//following::div[1]//input")
	private WebElement txtAddressLine2;
	
	@FindBy(xpath = "//div[@id='react-select-9-placeholder']")
	private WebElement countryDPD;
	
	@FindBy(xpath = "//div[text()='India']")
	private WebElement lstCountry;
	
	@FindBy(xpath = "//div[@id='react-select-10-placeholder']")
	private WebElement stateDPD;
	
	@FindBy(xpath = "//div[text()='Tamil Nadu']")
	private WebElement lstState;
	
	@FindBy(xpath = "//div[@id='react-select-11-placeholder']")
	private WebElement cityDPD;
	
	@FindBy(xpath = "//div[text()='Coimbatore']")
	private WebElement lstCity;
	
	@FindBy(xpath = "//label[text()='Pin Code']//following::div[1]//input")
	private WebElement txtPincode;
	
	@FindBy(xpath = "//label[text()='Community ']//following::div[1]//label")
	private List<WebElement> lstCommunity;
	
	@FindBy(xpath = "//label[text()='Scholar Type ']//following::div[1]//label")
	private List<WebElement> lstScholarType;
	
	@FindBy(xpath = "//div[@id='react-select-12-placeholder']")
	private WebElement sslcBoardOfStudyDPD;
	
	@FindBy(xpath = "//h3[text()='SSLC / 10TH STANDARD']//following::div[text()='State Board']")
	private WebElement lstSSLCBoardofStudy;
	
	@FindBy(xpath = "//h3[text()='SSLC / 10TH STANDARD']//following::input[4]")
	private WebElement txtSSLCTotalMarks;
	
	@FindBy(xpath = "//h3[text()='SSLC / 10TH STANDARD']//following::input[5]")
	private WebElement txtSSLCPercentage;
	
	@FindBy(xpath = "//div[@id='react-select-13-placeholder']")
	private WebElement sslcYearOfPassingDPD;
	
	@FindBy(xpath = "//h3[text()='SSLC / 10TH STANDARD']//following::div[text()='2023']")
	private WebElement lstSSLCYearOfPassing;
	
	@FindBy(xpath = "//div[@id='react-select-14-placeholder']")
	private WebElement hsc11thBoardofStudyDPD;
	
	@FindBy(xpath = "//h3[text()='HSC (+1) / 11TH STANDARD']//following::div[text()='State Board']")
	private WebElement lstHSC11thBoardofStudy;
	
	@FindBy(xpath = "//div[@id='react-select-15-placeholder']")
	private WebElement hsc11thGroupDPD;
	
	@FindBy(xpath = "//h3[text()='HSC (+1) / 11TH STANDARD']//following::div[text()='Science']")
	private WebElement lstHSC11thGroup;
	
	@FindBy(xpath = "//div[@id='react-select-16-placeholder']")
	private WebElement hsc11thYearOfPassingDPD;
	
	@FindBy(xpath = "//h3[text()='HSC (+1) / 11TH STANDARD']//following::div[text()='2024']")
	private WebElement lstHSC11thYearOfPassing;
	
	@FindBy(xpath = "//h3[text()='HSC (+1) / 11TH STANDARD']//following::input[@name='hscTotalMarks']")
	private WebElement txtHSC11thTotalMarks;
	
	@FindBy(xpath = "//h3[text()='HSC (+1) / 11TH STANDARD']//following::input[@name='hscPercentage']")
	private WebElement txtHSC11thPercentage;
	
	@FindBy(xpath = "//h3[text()='HSC (+1) / 11TH STANDARD']//following::input[@name='hscRegisterNo']")
	private WebElement txtHSC11thRegisterNo;
	
	@FindBy(xpath = "//h3[text()='HSC (+1) / 11TH STANDARD']//following::input[@name='physicsMarks']")
	private WebElement txtHSC11thPhysicsMarks;
	
	@FindBy(xpath = "//h3[text()='HSC (+1) / 11TH STANDARD']//following::input[@name='chemistryMarks']")
	private WebElement txtHSC11thChemistryMarks;
	
	@FindBy(xpath = "//h3[text()='HSC (+1) / 11TH STANDARD']//following::input[@name='mathsMarks']")
	private WebElement txtHSC11thMathsMarks;
	
	@FindBy(xpath = "//h3[text()='HSC (+1) / 11TH STANDARD']//following::input[@name='cutoffMarks']")
	private WebElement txtHSC11thCutOffMarks;
	
	@FindBy(xpath = "//div[@id='react-select-17-placeholder']")
	private WebElement txtHSC12thBoardOfStudy;
	
	@FindBy(xpath = "//h3[text()='HSC (+2) / 12TH STANDARD']//following::div[text()='State Board']")
	private WebElement lstHSC12thBoardOfStudy;
	
	@FindBy(xpath = "//div[@id='react-select-18-placeholder']")
	private WebElement hsc12thGroupDPD;
	
	@FindBy(xpath = "//h3[text()='HSC (+2) / 12TH STANDARD']//following::div[text()='Science']")
	private WebElement lstHSC12thGroup;
	
	@FindBy(xpath = "//div[@id='react-select-19-placeholder']")
	private WebElement hsc12thYearOfPassingDPD;
	
	@FindBy(xpath = "//h3[text()='HSC (+2) / 12TH STANDARD']//following::div[text()='2025']")
	private WebElement lstHSC12thYearOfPassing;
	
	@FindBy(xpath = "//h3[text()='HSC (+2) / 12TH STANDARD']//following::input[@name='hsc2TotalMarks']")
	private WebElement txtHSC12thTotalMarks;
	
	@FindBy(xpath = "//h3[text()='HSC (+2) / 12TH STANDARD']//following::input[@name='hsc2Percentage']")
	private WebElement txtHSC12thPercentage;
	
	@FindBy(xpath = "//h3[text()='HSC (+2) / 12TH STANDARD']//following::input[@name='hsc2RegisterNo']")
	private WebElement txtHSC12thRegisterNo;
	
	@FindBy(xpath = "//h3[text()='HSC (+2) / 12TH STANDARD']//following::input[@name='physics2Marks']")
	private WebElement txtHSC12thPhysicsMarks;
	
	@FindBy(xpath = "//h3[text()='HSC (+2) / 12TH STANDARD']//following::input[@name='chemistry2Marks']")
	private WebElement txtHSC12thChemistryMarks;
	
	@FindBy(xpath = "//h3[text()='HSC (+2) / 12TH STANDARD']//following::input[@name='maths2Marks']")
	private WebElement txtHSC12thMathsMarks;
	
	@FindBy(xpath = "//h3[text()='HSC (+2) / 12TH STANDARD']//following::input[@name='cutoff2Marks']")
	private WebElement txtHSC12thCutOffMarks;
	
	@FindBy(xpath = "//div[4]/button[1]")
	private WebElement submitButton;
	
	@FindBy(xpath = "//div[4]/button[2]")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//h2[text()='College & Programme Details']")
	private WebElement txtCollegeSection;
	
	@FindBy(xpath = "//h2[text()='Student Details']")
	private WebElement txtStudentSection;
	
	@FindBy(xpath = "//h2[text()='Educational Qualification']")
	private WebElement txtEducationalQualificationSection;
	
	@FindBy(xpath = "//h2[text()='College & Programme Details']//following::div[1]//label")
	private List<WebElement> lstCollegeSectionFields;
	
	@FindBy(xpath = "//h2[text()='College & Programme Details']//following::div[1]//label")
	private List<WebElement> lstPersonalDetailSectionFields;
	
	@FindBy(xpath = "//h2[text()='Educational Qualification']//following::h3")
	private List<WebElement> lstEducationalQualificationSections;
	
	@FindBy(xpath = "//h2[text()='Educational Qualification']//following::label")
	private List<WebElement> lstEducationalQualificationSectionsFields;
		
	public EnquiryPageObjects(WebDriver driver) {
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
	
	public void selectCommunity(String community) {
		for(WebElement communityLst : lstCommunity) {
			if(communityLst.getText().equals(community)) {
				communityLst.click();
				break;
			}
		}
	}
	
	public void selectScholarType(String scholarType) {
		for(WebElement scholarList : lstScholarType) {
			if(scholarList.getText().equals(scholarType)) {
				scholarList.click();
				break;
			}
		}
	}
	
	public void clickOnEnquiryButton() {
		enquiryFormBtn.click();
	}
	
	public void enterCollegeandProgrammeDetails() {
		
//		enquiryFormBtn.click();
//		threadSleep(1000);
		admissionQuotaDPD.click();
		lstAdmissionQuota.click();
		admissionTypeDPD.click();
		lstAdmissionType.click();
		programmeTypeDPD.click();
		lstProgrammeType.click();
		degreeDPD.click();
		lstDegree.click();
		departmentDPD.click();
		lstDepartment.click();
	}
	
	public void enterStudentDetails() {
		
		enquiryPageObjects = new EnquiryPageObjects(driver);
		
		txtFirstName.sendKeys(fake.name().firstName());
		txtLastName.sendKeys(fake.name().lastName());
		dob.sendKeys(LocalDate.now().minusDays(6500).format(FORMATTER));
		genderDPD.click();
		lstGender.click();
		txtEmail.sendKeys(fake.name().firstName() + "@yopmail.com");
		txtMobileNumber.sendKeys("9" + fake.number().digits(9));
		txtFather_GuardianName.sendKeys(fake.name().firstName());
		txtFather_GuardianMobileNumber.sendKeys("9" + fake.number().digits(9));
		txtFather_GuardianMobileOccupation.sendKeys("Business");
		annualIncomeDPD.click();
		lstAnnualIncome.click();
		txtAddressLine1.sendKeys(fake.address().streetAddress());
		txtAddressLine2.sendKeys(fake.address().cityName());
		countryDPD.click();
		lstCountry.click();
		stateDPD.click();
		lstState.click();
		cityDPD.click();
		lstCity.click();
		txtPincode.sendKeys("6" + fake.number().digits(5));		
		enquiryPageObjects.selectCommunity("BCM");
		enquiryPageObjects.selectScholarType("Day Scholar");
	}
	
	public void enterEducationalQualificationDetails() {
		sslcBoardOfStudyDPD.click();
		lstSSLCBoardofStudy.click();
	    txtSSLCTotalMarks.sendKeys(String.valueOf(randomNumber));
	    txtSSLCPercentage.sendKeys(fake.number().digits(2));
	    sslcYearOfPassingDPD.click();
	    lstSSLCYearOfPassing.click();
	    hsc11thBoardofStudyDPD.click();
	    lstHSC11thBoardofStudy.click();
	    hsc11thGroupDPD.click();
	    lstHSC11thGroup.click();
	    hsc11thYearOfPassingDPD.click();
	    lstHSC11thYearOfPassing.click();
	    txtHSC11thTotalMarks.sendKeys(String.valueOf(randomNumber));
	    txtHSC11thPercentage.sendKeys(fake.number().digits(2));
	    txtHSC11thRegisterNo.sendKeys(fake.number().digits(6));
	    txtHSC11thPhysicsMarks.sendKeys(fake.number().digits(2));
	    txtHSC11thChemistryMarks.sendKeys(fake.number().digits(2));
	    txtHSC11thMathsMarks.sendKeys(fake.number().digits(2));
	    txtHSC11thCutOffMarks.sendKeys(String.valueOf(randomCutOffMarks));
	    txtHSC12thBoardOfStudy.click();
	    lstHSC12thBoardOfStudy.click();
	    hsc12thGroupDPD.click();
	    lstHSC12thGroup.click();
	    hsc12thYearOfPassingDPD.click();
	    lstHSC12thYearOfPassing.click();
	    txtHSC12thTotalMarks.sendKeys(String.valueOf(randomNumber));
	    txtHSC12thPercentage.sendKeys(fake.number().digits(2));
	    txtHSC12thRegisterNo.sendKeys(fake.number().digits(6));
	    txtHSC12thPhysicsMarks.sendKeys(fake.number().digits(2));
	    txtHSC12thChemistryMarks.sendKeys(fake.number().digits(2));
	    txtHSC12thMathsMarks.sendKeys(fake.number().digits(2));
	    txtHSC12thCutOffMarks.sendKeys(String.valueOf(randomCutOffMarks));
	}
	
	public void clickOnSubmitButton() {
		submitButton.click();
	}
	
	public void clickOnCancelButton() {
		cancelButton.click();
	}
	
	public void enterEnquiryForm() {
		enquiryPageObjects = new EnquiryPageObjects(driver);
		enquiryPageObjects.enterCollegeandProgrammeDetails();
		enquiryPageObjects.enterStudentDetails();
		enquiryPageObjects.enterEducationalQualificationDetails();
		enquiryPageObjects.clickOnSubmitButton();	 
		threadSleep(3000);
	}
	
	public String getCollegeSectionText() {
		return txtCollegeSection.getText();
	}
	
	public String getStudentDetailsSectionText() {
		return txtStudentSection.getText();
	}
	
	public String getEducationalQualificationSectionText() {
		return txtEducationalQualificationSection.getText();
	}
	
	public void printCollegeSectionLabels() {
        for (WebElement label : lstCollegeSectionFields) {
            System.out.println("College Section Fields " + label.getText());
        }
    }
	
	public void printPersonalDetailsLabels() {
        for (WebElement label : lstPersonalDetailSectionFields) {
            System.out.println("Personal Details Section Fields " + label.getText());
        }
    }
	
	public void printEducationalQualificationSections() {
        for (WebElement label : lstEducationalQualificationSections) {
            System.out.println("Educational Qualification Sections " + label.getText());
        }
    }
	
	public void printEducationalQualificationSectionsFields() {
        for (WebElement label : lstEducationalQualificationSectionsFields) {
            System.out.println("Educational Qualification Section Fields " + label.getText());
        }
    }
	
	
	
}

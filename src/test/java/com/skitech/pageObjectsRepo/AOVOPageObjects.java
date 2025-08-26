package com.skitech.pageObjectsRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AOVOPageObjects {

		WebDriver driver;
		
		@FindBy(xpath = "//h2[text()='Search by Student']//following::div[1]//label//span")
		private List<WebElement> lstSearchByStudent;
			
		@FindBy(xpath = "(//div[@class='flex flex-col mt-1 w-full md:w-[435px] bg-light-purple-color rounded p-2 justify-center cursor-pointer hover:shadow-md'])[1]")
		private WebElement searchResults;
		
		@FindBy(xpath = "//div[@id='error-toast']")
		private WebElement txtErrorSearchResults;
		
		@FindBy(xpath = "//span[@class='absolute inset-y-0 right-2 flex items-center cursor-pointer text-black']//*[name()='svg']")
		private WebElement txtStudentSearchIcon;
		
		@FindBy(xpath = "//ul//li//button")
		private List<WebElement> studentProfileTabList;
		
		@FindBy(xpath = "//input[@name='firstName']")
		private WebElement studentFirstName;
		
		@FindBy(xpath = "//input[@name='lastName']")
		private WebElement txtLastName;
		
		@FindBy(xpath = "//input[@name='phonenumber']")
		private WebElement txtPhoneNumber;
		
		@FindBy(xpath = "//input[@name='aadhaarName']")
		private WebElement txtAadharName;
		
		@FindBy(xpath = "//input[@name='email']")
		private WebElement txtEmail;
		
		@FindBy(xpath = "//*[@id='root']/div/nav/div[2]/div[2]//button")
		private WebElement btnProfileList;	
		
		@FindBy(xpath = "//button[text()='Close']")
		private WebElement btnFileUploadCompletedClose;	
			
		@FindBy(xpath = "//div[@class='hidden sm:block text-white c1']")
		private WebElement txtProfile;
		
		@FindBy(xpath = "//button[text()='Logout']")
		private WebElement btnLogout;
		
		@FindBy(xpath = "//*[@id='root']/div/div[1]//div//span")
		private List<WebElement> lstDashboardMenus;
		
		@FindBy(xpath = "//div[@class='PhoneInputCountry']//following::input[1]")
		private WebElement txtSearchbyStudentMobileNumber;
		
		@FindBy(xpath = "//input[@value='enquiryid']//following::input[2]")
		private WebElement txtSearchbyStudentAdmissionNo;
		
		@FindBy(xpath = "//input[@value='registerno']//following::input[1]")
		private WebElement txtSearchbyStudentRegisterNo;
		
		@FindBy(xpath = "//img[@alt='Back']")
		private WebElement backIconinStudentDetailsScreen;
		
		@FindBy(xpath = "//*[@id='root']//h2")
		private WebElement txtStudentNameinAOVOStudentDetails;
				
		@FindBy(xpath = "//h2[text()='Add Students Manually']//following::button[1]")
		private WebElement btnDirectForm;
		
		@FindBy(xpath = "//*[@id='root']//h2//following::div[2]//ul//li")
		private List<WebElement> lstStudentDetailsTab;
		
		@FindBy(xpath = "//h3")
		private List<WebElement> lstOverViewTabSection;
		
		@FindBy(xpath = "//div[@class='flex flex-col']//h2")
		private List<WebElement> lstStudentInformationTabSections; 
		
		@FindBy(xpath = "//div[@class='flex flex-col']//h2")
		private List<WebElement> lstAcademicHistoryTabSections;
		
		@FindBy(xpath = "//h2[@class='pb-4 h5 n-500']")
		private List<WebElement> lstFamilyDetailsTabSections;
		
		@FindBy(xpath = "//h2[@class='n-500 h5 pb-4']")
		private List<WebElement> lstAddressDetailsTabSections;

		@FindBy(xpath = "//h2[@class='h5 n-500 pb-4']")
		private List<WebElement> lstAdmissionDetailsTabSections;

		@FindBy(xpath = "//div[@class='form-heading pb-4']")
		private List<WebElement> lstDocumentsTabSections;

		@FindBy(xpath = "//button[text()='Mark as Verified']")
		private WebElement btnMarkasVerified;
		
		@FindBy(xpath = "//button[text()='Verification done']")
		private WebElement btnVerificationDone;
	
		@FindBy(xpath = "//button[text()='Verify']")
		private WebElement btnVerifyinViewDocumentPopup;
		
		@FindBy(xpath = "//button[text()='Reject']")
		private WebElement btnRejectinViewDocumentPopup;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[1]")
		private WebElement chkBoxOriginalDocumentsCollectedinViewDocumentPopup;
		
		@FindBy(xpath = "//button[text()='Previous']")
		private WebElement btnPreviousinViewDocumentPopup;
		
		@FindBy(xpath = "//button[text()='Next']")
		private WebElement btnNextinViewDocumentPopup;

		@FindBy(xpath = "//button[text()='Verified']")
		private WebElement btnVerifiedinViewDocumentPopup;

		@FindBy(xpath = "//div[@id='success-toast']")
		private WebElement txtDocumentUpdatedSuccessfullyinViewDocumentPopup;
		
		@FindBy(xpath = "//button[text()='Submit']")
		private WebElement btnSubmitinViewDocumentPopup;

		@FindBy(xpath = "//div[@id='container-reason']")
		private WebElement dpdRejectReasoninViewDocumentPopup;

		@FindBy(xpath = "//input[@id='input-reason']")
		private WebElement txtRejectReasoninViewDocumentPopup;
		
		@FindBy(xpath = "//button[@class='absolute1 top-3 right-4 text-gray-500 text-xl']")
		private WebElement btnCloseinViewDocumentPopup;

		@FindBy(xpath = "//button[text()='Finish Verification']")
		private WebElement btnFinishVerification;

		@FindBy(xpath = "//button[text()='Save']")
		private WebElement btnSave;
		
		@FindBy(xpath = "//button[text()='Cancel']")
		private WebElement btnCancel;
		
		@FindBy(xpath = "//td[4]//button")
		private List<WebElement> lstDocumentViewPopup;
		
		@FindBy(xpath = "//td[5]//input")
		private List<WebElement> lstChkBoxCollect;
		
		@FindBy(xpath = "//p[1]")
		private WebElement txtStudentVerificationCompletedPopup;
		
		@FindBy(xpath = "//button[text()='Edit Details']")
		private WebElement btnEditDetails;
				
		public AOVOPageObjects(WebDriver driver) {
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
		
		public void selectStudentSearchType(String type) {
			for(WebElement searchStudent : lstSearchByStudent ) {
				if(searchStudent.getText().equals(type)) {
					searchStudent.click();
					threadSleep(1000);
					break;				
				}
				
			}
		}
			
		public void clickonStudentSearchResults() {
			searchResults.click();
			threadSleep(3000);
		}
		
		public void clickOnStudentSearchIcon() {
			txtStudentSearchIcon.click();
			threadSleep(2000);
		}
		
		public void clickOnStudentProfileTab(String tabName) {
			for(WebElement tabList : studentProfileTabList) {
				if(tabList.getText().equals(tabName)) {
					tabList.click();
					break;
				}
			}	
		}
		
		public void enterFirstName(String firstName) {
			studentFirstName.sendKeys(firstName);
		}
		
		public void clickOnProfileButton() {
			btnProfileList.click();
		}
		
		public void clickOnFileUploadCompletedCloseButton() {
			btnFileUploadCompletedClose.click();
			
		}
		
		public void clickOnLogoutButton() {
			btnProfileList.click();
			threadSleep(1000);
			btnLogout.click();				
		}
		
		
		public List<String> getDashboardMenusText(){
			List<String> dashboardMenusText = new ArrayList<>();
			for(WebElement element : lstDashboardMenus) {
				String dashboardMenusTextList = element.getText();
				dashboardMenusText.add(dashboardMenusTextList);
			}
			return dashboardMenusText;
		}
		
		public void clickOnDashboardMenus(String dashBoardMenu) {
			for(WebElement dashboardmnulst : lstDashboardMenus) {
				if(dashboardmnulst.getText().equals(dashBoardMenu)) {
					dashboardmnulst.click();
				}
			}
		}
		
		public void enterSearchByStudentValueMobileNumber(String searchByStudentMobileNumber) {
			txtSearchbyStudentMobileNumber.clear();
			txtSearchbyStudentMobileNumber.sendKeys(searchByStudentMobileNumber + Keys.ENTER);
			threadSleep(3000);			
		}
		
		public void enterSearchByStudentValueAdmissionNumber(String searchByStudentAdmissionNumber) {
			txtSearchbyStudentAdmissionNo.clear();
			txtSearchbyStudentAdmissionNo.sendKeys(searchByStudentAdmissionNumber + Keys.ENTER);
			threadSleep(3000);	
		}
		
		public void enterSearchByStudentValueRegisterNumber(String searchByStudentRegisterNumber) {
			txtSearchbyStudentRegisterNo.clear();
			txtSearchbyStudentRegisterNo.sendKeys(searchByStudentRegisterNumber + Keys.ENTER);
			threadSleep(3000);
		}
		
		public String getStudentNameinAOVOStudentDetailsScreen() {
			return txtStudentNameinAOVOStudentDetails.getText();
		}
		
		public void clickOnDirectEnquiryForm() {
			btnDirectForm.click();
		}
		
		public void clickOnBackIconinStudentDetailsScreen() {
			backIconinStudentDetailsScreen.click();
			threadSleep(3000);
		}
		
		public String getStudentSearchResultsValue() {
			return searchResults.getText();
		}
		
		public List<String> getStudentDetailsTabTexts() {
		    List<String> studentDetailsTexts = new ArrayList<>();
		    for (WebElement element : lstStudentDetailsTab) {
		        String studentTabList = element.getText();
		            studentDetailsTexts.add(studentTabList);
		    }
		    return studentDetailsTexts;
		
		}
		
		public void clickOnStudentDetailsTab(String studentDetailsTabName) {
			for(WebElement studentDetailsTabNameList : lstStudentDetailsTab) {
				if(studentDetailsTabNameList.getText().equals(studentDetailsTabName)) {
					studentDetailsTabNameList.click();
					threadSleep(3000);
					break;
				}
			}
		}
		
		public List<String> getOverviewTabSections() {
		    List<String> overViewTabSectionsTexts = new ArrayList<>();
		    for (WebElement element : lstOverViewTabSection) {
		        String overviewTabSectionList = element.getText();
		        overViewTabSectionsTexts.add(overviewTabSectionList);
		    }
		    return overViewTabSectionsTexts;	
		}
		
		public List<String> getStudentInformationTabSections() {
		    List<String> studentInformationSectionsTabTexts = new ArrayList<>();
		    for (WebElement element : lstStudentInformationTabSections) {
		        String overviewTabSectionList = element.getText();
		        studentInformationSectionsTabTexts.add(overviewTabSectionList);
		    }
		    return studentInformationSectionsTabTexts;	
		}
		
		public List<String> getAcademicHistoryTabSections() {
		    List<String> academicHistoryTabSectionsTexts = new ArrayList<>();
		    for (WebElement element : lstAcademicHistoryTabSections) {
		        String academicHistoryTabSectionList = element.getText();
		        academicHistoryTabSectionsTexts.add(academicHistoryTabSectionList);
		    }
		    return academicHistoryTabSectionsTexts;	
		}
		
		public List<String> getFamilyDetailsTabSections() {
		    List<String> familyDetailsTabSectionsTexts = new ArrayList<>();
		    for (WebElement element : lstFamilyDetailsTabSections) {
		        String familyDetailsTabSectionList = element.getText();
		        familyDetailsTabSectionsTexts.add(familyDetailsTabSectionList);
		    }
		    return familyDetailsTabSectionsTexts;	
		}
		
		public List<String> getAddressDetailsTabSections() {
			List<String> addressDetailsTabSectionsTexts = new ArrayList<>();
			for (WebElement element : lstAddressDetailsTabSections) {
				String addressDetailsTabSectionList = element.getText();
				addressDetailsTabSectionsTexts.add(addressDetailsTabSectionList);
	    }
	    return addressDetailsTabSectionsTexts;	
	}

		public List<String> getAdmissionDetailsTabSections() {
			List<String> admissionDetailsTabSectionsTexts = new ArrayList<>();
			for (WebElement element : lstAdmissionDetailsTabSections) {
				String admissionDetailsTabSectionList = element.getText();
				admissionDetailsTabSectionsTexts.add(admissionDetailsTabSectionList);
	    }
	    return admissionDetailsTabSectionsTexts;	
	}

		public List<String> getDocumentsTabSections() {
			List<String> documentsTabSectionsTexts = new ArrayList<>();
			for (WebElement element : lstDocumentsTabSections) {
				String documentsTabSectionList = element.getText();
				documentsTabSectionsTexts.add(documentsTabSectionList);
	    }
	    return documentsTabSectionsTexts;	
	}
		
		public String getSearchErrorText() {
			return txtErrorSearchResults.getText();
		}
		
		public void clickOnMarkasVerified() {
			btnMarkasVerified.click();
			threadSleep(3000);
		}
		
		public void clickOnEditDetailsButton() {
			btnEditDetails.click();
			threadSleep(3000);
		}	
		
		public String getVerificationDoneText() {
			return btnVerificationDone.getText();
		}
		
		public void clickOnSaveButton() {
			btnSave.click();
			threadSleep(1000);
		}
		
		public void clickOnCancelButton() {
			btnCancel.click();
		}
		
		public void clickOnVerifyButtoninViewDocumentPopUp() {
			btnVerifyinViewDocumentPopup.click();
			threadSleep(2000);
		}
		
		public void clickOnRejectButtoninViewDocumentPopUp() {
			btnRejectinViewDocumentPopup.click();
			threadSleep(2000);
		}
		
		public void selectRejectReasoninViewDocumentPopUp(String rejectReason) {
			dpdRejectReasoninViewDocumentPopup.click();
			txtRejectReasoninViewDocumentPopup.sendKeys(rejectReason + Keys.ENTER);
			threadSleep(2000);
		}
		
		public void clickOnOriginalDocumentCollectedinViewDocumentPopUp() {
			chkBoxOriginalDocumentsCollectedinViewDocumentPopup.click();
			threadSleep(1000);			
		}
		
		public void clickOnPreviousButtoninViewDocumentPopUp() {
			btnPreviousinViewDocumentPopup.click();
			threadSleep(1000);			
		}
		
		public void clickOnNextButtoninViewDocumentPopUp() {
			btnNextinViewDocumentPopup.click();
			threadSleep(1000);			
		}
		
		public void clickOnSubmitButtoninViewDocumentPopUp() {
			btnNextinViewDocumentPopup.click();
			threadSleep(1000);			
		}
		
		public String getDocumentVerifiedText() {
			return btnVerifiedinViewDocumentPopup.getText();
		}
		
		public String getDocumentUploadSuccessFailureText() {
			return txtDocumentUpdatedSuccessfullyinViewDocumentPopup.getText();			
		}
		
		public void clickOnCloseIconinViewDocumentPopup() {
			btnCloseinViewDocumentPopup.click();
		}
		
		public void clickOnCollectChkBox() {
			for(WebElement collectChkBox : lstChkBoxCollect) {
				collectChkBox.click();
				threadSleep(3000);
			}
		}
		
		public void verifyAllDocuments() {
			for(WebElement viewDocument : lstDocumentViewPopup) {
				viewDocument.click();
				threadSleep(1000);
				btnVerifyinViewDocumentPopup.click();
				threadSleep(1000);
				btnVerifiedinViewDocumentPopup.getText();
				threadSleep(1000);
				btnCloseinViewDocumentPopup.click();
			}
		}
		
		public void rejectAllDocuments(String rejectReason) {
			for(WebElement rejectDocuments : lstDocumentViewPopup) {
				rejectDocuments.click();
				threadSleep(1000);
				btnRejectinViewDocumentPopup.click();
				threadSleep(1000);
				dpdRejectReasoninViewDocumentPopup.click();
				threadSleep(1000);
				txtRejectReasoninViewDocumentPopup.sendKeys(rejectReason + Keys.ENTER);
				threadSleep(1000);
				btnSubmitinViewDocumentPopup.click();
				threadSleep(2000);
				btnCloseinViewDocumentPopup.click();
				
			}
		}
				
		public void clickOnFinishVerification() {
			btnFinishVerification.click();
			threadSleep(3000);
		}		
		
		public String getStudentVerificationCompleted() {
			return txtStudentVerificationCompletedPopup.getText();
		}
		
		public String getProfileText() {
			return txtProfile.getText();
			
		}
}
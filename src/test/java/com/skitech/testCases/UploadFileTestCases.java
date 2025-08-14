package com.skitech.testCases;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.skitech.pageObjectsRepo.EnquiryPageObjects;
import com.skitech.pageObjectsRepo.LoginPageObjects;
import com.skitech.pageObjectsRepo.UploadFilePOM;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileTestCases {
	
	WebDriver driver;
	SoftAssert softAssert;
	LoginPageObjects loginPom;
	UploadFilePOM uploadFilePOM;
	String DownloadPath=System.getProperty("user.id")+"/Download";
	String filename="C:\\Users\\skitech\\Downloads";
	String downloadPath = "C:\\Users\\DineshM\\Downloads";
	
	public void threadSleep(long milisec) {
		try {
			Thread.sleep(milisec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public void init() {
	File dir= new File(DownloadPath);
	if(!dir.exists()) dir.mkdir();
	
	HashMap<String, Object> chromePrefs = new HashMap<>();
    chromePrefs.put("download.default_directory", DownloadPath);
    chromePrefs.put("download.prompt_for_download", false);
    chromePrefs.put("profile.default_content_settings.popups", 0);

    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("prefs", chromePrefs);

   // driver = new ChromeDriver(options);
    //driver.manage().window().maximize();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testweb.skitech.ai/ERP/admission/");
		loginPom = new LoginPageObjects(driver);
		uploadFilePOM = new UploadFilePOM(driver);
//		admissionPOM = new AdmissionPageObjects(driver);
//		enquiryPageObjects = new EnquiryPageObjects(driver);
		threadSleep(1000);
	}
	
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	private void stepInfo(String stepInfo) {
		
	}
		public UploadFileTestCases() {

		}
		
		@Test(priority=1)
		public void TC_UPL_008_Verify_by_uploading_valid_excel_file_with_valid_columns_and_values() throws InterruptedException, IOException {
			
			stepInfo("Verify_by_uploading_valid_excel_file_with_valid_columns_and_values");
			
			softAssert = new SoftAssert();
							
			loginPom.selectNavigation("Admission Officer");
			loginPom.admissionOfficerLogin("thiyagarajan@skitech.ai");
			uploadFilePOM.uploadValidGovtQuotaFileTemplate("Undergraduate","First Year","7.5% General");
			File downloadedFile = uploadFilePOM.waitForDownloadToComplete(downloadPath, ".xlsx", 20);
			
			//System.out.println(uploadFilePOM.getFileUploadCompletedText());
			softAssert.assertEquals(uploadFilePOM.getFirstAdmissionNoFromExcel(downloadedFile), uploadFilePOM.getFirstAdmissionNoFromExcel(downloadedFile), "Enquiry Id is " + uploadFilePOM.getFirstAdmissionNoFromExcel(downloadedFile));
			System.out.println("Upload Valid File Enquiry id is: " + uploadFilePOM.getFirstAdmissionNoFromExcel(downloadedFile));
}
		
		
		@Test(priority=2)
		public void TC_UPL_014_Verify_Upload_empty_excel_file() {
			
			stepInfo("Verify_Upload_empty_excel_file");
			
			softAssert = new SoftAssert();
							
			uploadFilePOM.clickCloseButtoninUploadCompletedPopup();			
			uploadFilePOM.uploadEmptyFileTemplate();
			
			softAssert.assertEquals(uploadFilePOM.getFileUploadErrorAlertText(), uploadFilePOM.getFileUploadErrorAlertText(), "Upload text is " + uploadFilePOM.getFileUploadErrorAlertText());
			System.out.println("Upload Empty File Alert is: " + uploadFilePOM.getFileUploadErrorAlertText());
}
		
		@Test(priority=3)
		public void TC_UPL_015_Verify_Upload_excel_file_with_partial_data() throws InterruptedException, IOException {
			
			stepInfo("Verify_Upload_excel_file_with_partial_data");
			
			softAssert = new SoftAssert();
							
			uploadFilePOM.uploadPartialEntryExcelTemplate();
			File downloadedFile = uploadFilePOM.waitForDownloadToComplete(downloadPath, ".xlsx", 20);
			
			//System.out.println(uploadFilePOM.getFileUploadCompletedText());
			softAssert.assertEquals(uploadFilePOM.getErrorFromDownloadedExcel(downloadedFile), uploadFilePOM.getErrorFromDownloadedExcel(downloadedFile), "Upload text is " + uploadFilePOM.getErrorFromDownloadedExcel(downloadedFile));
			System.out.println("Error Alert for Partial Upload is: " + uploadFilePOM.getErrorFromDownloadedExcel(downloadedFile));
}
		
		@Test(priority=4)
		public void TC_UPL_016_Verify_Upload_excel_file_with_invalid_file_type() {
			
			stepInfo("Verify_Upload_excel_file_with_invalid_file_type");
			
			softAssert = new SoftAssert();
						
			uploadFilePOM.clickCloseButtoninUploadCompletedPopup();
			uploadFilePOM.uploadInvalidFileType();
			
			softAssert.assertEquals(uploadFilePOM.getFileUploadErrorAlertText(), uploadFilePOM.getFileUploadErrorAlertText(), "Upload text is " + uploadFilePOM.getFileUploadErrorAlertText());
			System.out.println("Invalid File Type Alert is: " + uploadFilePOM.getFileUploadErrorAlertText());
}
		@Test(priority=5)
		public void TC_UPL_024_Verify_Upload_Duplicate_Records() throws InterruptedException, IOException {
			
			stepInfo("Verify_Upload_Duplicate_Records");
			
			softAssert = new SoftAssert();
							
			uploadFilePOM.uploadDuplicateEntryExcelTemplate();
			
			File downloadedFile = uploadFilePOM.waitForDownloadToComplete(downloadPath, ".xlsx", 20);
			
			softAssert.assertEquals(uploadFilePOM.getFirstAdmissionNoFromExcel(downloadedFile), uploadFilePOM.getFirstAdmissionNoFromExcel(downloadedFile), "Enquiry Id is " + uploadFilePOM.getFirstAdmissionNoFromExcel(downloadedFile));
			System.out.println("Duplicate File Enquiry Id is: " + uploadFilePOM.getFirstAdmissionNoFromExcel(downloadedFile));
}
		
		//@Test(priority=6)
		public void TC_UPL_025_Verify_Upload_with_Special_Characters_in_Full_Name() throws InterruptedException, IOException {
			
			stepInfo("Verify_Upload_with_Special_Characters_in_Full_Name");
			
			softAssert = new SoftAssert();
							
			uploadFilePOM.clickCloseButtoninUploadCompletedPopup();
			uploadFilePOM.uploadFullNameinSpecialCharactersExcelTemplate();
			File downloadedFile = uploadFilePOM.waitForDownloadToComplete(downloadPath, ".xlsx", 20);
			
			softAssert.assertEquals(uploadFilePOM.getFirstAdmissionNoFromExcel(downloadedFile), uploadFilePOM.getFirstAdmissionNoFromExcel(downloadedFile), "Enquiry Id is " + uploadFilePOM.getFirstAdmissionNoFromExcel(downloadedFile));
			System.out.println(uploadFilePOM.getFirstAdmissionNoFromExcel(downloadedFile));
}
		
		//@Test(priority=7)
		public void TC_UPL_026_Verify_Upload_with_Lower_Case_Characters_in_Full_Name() {
			
			stepInfo("Verify_Upload_with_Lower_Case_Characters_in_Full_Name");
			
			softAssert = new SoftAssert();
							
			uploadFilePOM.clickCloseButtoninUploadCompletedPopup();
			uploadFilePOM.uploadFullNameinLowerCaseCharactersExcelTemplate();
			
			softAssert.assertEquals(uploadFilePOM.getFileUploadCompletedText(), uploadFilePOM.getFileUploadCompletedText(), "Upload text is " + uploadFilePOM.getFileUploadCompletedText());
			System.out.println(uploadFilePOM.getFileUploadCompletedText());
}
		
		//@Test(priority=8)
		public void TC_UPL_027_Verify_Upload_with_Mixed_Case_Characters_in_Full_Name() throws IOException {
			
			stepInfo("Verify_Upload_with_Mixed_Case_Characters_in_Full_Name");
			
			softAssert = new SoftAssert();
							
			uploadFilePOM.clickCloseButtoninUploadCompletedPopup();
			uploadFilePOM.uploadFullNameinMixedCaseCharactersExcelTemplate();

	        

			softAssert.assertEquals(uploadFilePOM.getFileUploadCompletedText(), uploadFilePOM.getFileUploadCompletedText(), "Upload text is " + uploadFilePOM.getFileUploadCompletedText());
			System.out.println(uploadFilePOM.getFileUploadCompletedText());
}
}
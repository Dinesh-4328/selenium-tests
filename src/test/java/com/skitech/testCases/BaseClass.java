package com.skitech.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.skitech.pageObjectsRepo.AOVOPageObjects;
import com.skitech.pageObjectsRepo.LoginPageObjects;
import com.skitech.pageObjectsRepo.StudentsProfilePOM;
import com.skitech.pageObjectsRepo.UploadFilePOM;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	  WebDriver driver;
	     LoginPageObjects loginPom;
	     UploadFilePOM uploadFilePOM;
	     StudentsProfilePOM studentsProfilePOM;
	     AOVOPageObjects aovoPOM;
	     String mobileNo;
	     String emailid;
	     String admissionNo;
	     ChromeOptions options = new ChromeOptions();
	    

	   // @BeforeClass
	      //public void init() {
	       // WebDriverManager.chromedriver().setup();

	        // ✅ Initialize ChromeOptions
	        
//	        options.addArguments("--remote-allow-origins=*"); 
//	        options.addArguments("--start-maximized");       

//	        driver = new ChromeDriver(options);
//	        driver.manage().window().maximize();
//	        driver.get("http://172.21.1.248:8085/ERP_QA/admission/");
//	        threadSleep(3000);
//	        // Initialize POM classes
////	        loginPom = new LoginPageObjects(driver);
////	        uploadFilePOM = new UploadFilePOM(driver);
////	        studentsProfilePOM = new StudentsProfilePOM(driver);
////	        aovoPOM = new AOVOPageObjects(driver);
//	    }

		private void threadSleep(int i) {
			// TODO Auto-generated method stub
			
		}

//	    @AfterClass
//	    public void tearDown() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
//	    }
}


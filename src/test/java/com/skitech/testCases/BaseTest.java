package com.skitech.testCases;

import org.testng.annotations.BeforeClass;

public class BaseTest {
	
    protected String mobileNo;
    protected String emailid;
    protected String admissionNo;
    
    @BeforeClass
    public void generateTestData() {

    	mobileNo = "";
        emailid = "";
        admissionNo = "";
    }

}

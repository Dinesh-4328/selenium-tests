package com.skitech.pageObjectsRepo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

public class UploadFilePOM {
	
	WebDriver driver;
	Faker fake = new Faker();
		
	@FindBy(xpath = "//input[@type='file']")
	private WebElement btnUploadFile;
	
	@FindBy(xpath = "//button[text()='Confirm & upload File']")
	private WebElement btnConfirmandUploadFile;
	
	@FindBy(xpath = "//h2[text()='Add students by template']//following::div[1]//label//div")
	private List<WebElement> lstQuota;
	
	@FindBy(xpath = "//label[text()='Programme']//following::div[1]")
	private WebElement dpdProgramme;
	
	@FindBy(xpath = "//label[text()='Programme']//following::div[5]//input")
	private WebElement txtProgramme;
	
	@FindBy(xpath = "//label[text()='Admission type']//following::div[1]")
	private WebElement dpdAdmissionType;
	
	@FindBy(xpath = "//label[text()='Admission type']//following::div[5]//input[1]")
	private WebElement txtAdmissionType;
	
	@FindBy(xpath = "(//div[@id='container-undefined'])[3]")
	private WebElement dpdTNEACategory;
		
	@FindBy(xpath = "(//input[@id='input-undefined'])[4]")
	private WebElement txtTNEACategory;

	@FindBy(xpath = "//div[@class='inline-block align-bottom bg-white rounded-lg text-left overflow-hidden shadow-xl transform transition-all sm:my-8 sm:align-middle sm:max-w-lg sm:w-full pt-6 px-4']")
	private WebElement popUpFileUploadCompleted;
	
	@FindBy(xpath = "//button[normalize-space()='Close']")
	private WebElement btnClose;
	
	@FindBy(xpath = "//div[@class='text-red-500 text-s break-all']")
	private WebElement txtFileUploadErrorAlert;
		
	@FindBy(xpath = "//div[text()='Invalid file type. Please upload an Excel file (.xlsx, .xls)']")
	private WebElement txtInvalidFileType;
	
	
    String validFileGovtQuotaTemplatePath = "D:\\Excel Upload\\GovtQuota.xls";
    String validFileGovtQuotaLateralTemplatePath = "D:\\Excel Upload\\GovtQuotaLateral.xls";
	String invalidFileTemplatePath = "D:\\Excel Upload\\Invalid File Template.xlsx";
	String invalidFileType = "D:\\Excel Upload\\6 A.M Feedbacks & Issues.txt";
	String emptyFileTemplatePath = "D:\\Excel Upload\\ERP-Upload-File-Template - Empty.xlsx";
	String partialFileTemplatePath = "D:\\Excel Upload\\ERP-Upload-File-Template - Partial Entry.xlsx";
	String duplicateFileTemplatePath = "D:\\Excel Upload\\ERP-Upload-File-Template - Duplicate.xlsx";
	String specialCharactersFileTemplatePath = "D:\\Excel Upload\\ERP-Upload-File-Template - Special Characters.xlsx";
	String lowerCaseFileTemplatePath = "D:\\Excel Upload\\ERP-Upload-File-Template - Lower Case.xlsx";
	String mixedCaseFileTemplatePath = "D:\\Excel Upload\\ERP-Upload-File-Template - Mixed Case.xlsx";
	String validManagementQuotaTemplatePath = "D:\\Excel Upload\\ManagementQuota.xlsx";
	
	
	
	public UploadFilePOM(WebDriver driver) {
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
	
	public void selectQuota(String quota) {
		for(WebElement quotaList : lstQuota) {
			if(quotaList.getText().equals(quota)) {
				quotaList.click();
				threadSleep(1000);
				break;
			}
		}
	}
	
	public void selectProgramme(String programme) {
		dpdProgramme.click();
		threadSleep(1000);
		txtProgramme.sendKeys(programme + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void selectAdmissionType(String admissionType) {
		dpdAdmissionType.click();
		threadSleep(1000);
		dpdAdmissionType.sendKeys(admissionType + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void selectTNEACategory(String tneaCategory) {
		dpdTNEACategory.click();
		threadSleep(1000);
		txtTNEACategory.sendKeys(tneaCategory + Keys.ENTER);
		threadSleep(1000);
	}
	
	public void uploadValidManagementQuotaFileTemplate(String programme, String admissionType) throws IOException{

		updateFirstRowWithRandomData(validManagementQuotaTemplatePath);	
		dpdProgramme.click();
		txtProgramme.sendKeys(programme + Keys.ENTER);
		threadSleep(1000);
		dpdAdmissionType.click();
		txtAdmissionType.sendKeys(admissionType + Keys.ENTER);
		threadSleep(1000);
	    btnUploadFile.sendKeys(validManagementQuotaTemplatePath);
	    btnConfirmandUploadFile.click();
	    threadSleep(5000);
	}
	
	public void uploadValidGovtQuotaFileTemplate(String programme, String admissionType, String tneaCategory) throws IOException {

		updateFirstRowWithRandomData(validFileGovtQuotaTemplatePath);
		dpdProgramme.click();
		txtProgramme.sendKeys(programme + Keys.ENTER);
		threadSleep(1000);
		dpdAdmissionType.click();
		txtAdmissionType.sendKeys(admissionType + Keys.ENTER);
		threadSleep(1000);
		dpdTNEACategory.click();
		txtTNEACategory.sendKeys(tneaCategory + Keys.ENTER);
		threadSleep(1000);
	    btnUploadFile.sendKeys(validFileGovtQuotaTemplatePath);
	    btnConfirmandUploadFile.click();
	    threadSleep(5000);
	}
	
	public void uploadValidGovtQuotaLateralFileTemplate(String programme, String admissionType, String tneaCategory) throws IOException {

		updateFirstRowWithRandomData(validFileGovtQuotaLateralTemplatePath);
		dpdProgramme.click();
		txtProgramme.sendKeys(programme + Keys.ENTER);
		dpdAdmissionType.click();
		txtAdmissionType.sendKeys(admissionType + Keys.ENTER);
		threadSleep(1000);
		dpdTNEACategory.click();
		txtTNEACategory.sendKeys(tneaCategory + Keys.ENTER);
		threadSleep(1000);
	    btnUploadFile.sendKeys(validFileGovtQuotaLateralTemplatePath);
	    btnConfirmandUploadFile.click();
	    threadSleep(5000);
	}
	
	public void uploadInvalidFileType() {
		btnUploadFile.sendKeys(invalidFileType);
		btnConfirmandUploadFile.click();
		threadSleep(3000);
	}
	
	public void uploadEmptyFileTemplate() {
		btnUploadFile.sendKeys(emptyFileTemplatePath);
		btnConfirmandUploadFile.click();
		threadSleep(3000);
	}
	
	public void uploadPartialEntryExcelTemplate() {
		btnUploadFile.sendKeys(partialFileTemplatePath);
		btnConfirmandUploadFile.click();
		threadSleep(3000);
	}
	
	public void uploadDuplicateEntryExcelTemplate() {
		btnUploadFile.sendKeys(duplicateFileTemplatePath);
		btnConfirmandUploadFile.click();
		threadSleep(2000);
	}
	
	public void uploadFullNameinSpecialCharactersExcelTemplate() {
		btnUploadFile.sendKeys(specialCharactersFileTemplatePath);
		btnConfirmandUploadFile.click();
		threadSleep(2000);
	}
	
	public void uploadFullNameinLowerCaseCharactersExcelTemplate() {
		btnUploadFile.sendKeys(lowerCaseFileTemplatePath);
		btnConfirmandUploadFile.click();
		threadSleep(2000);
	}
	
	public void uploadFullNameinMixedCaseCharactersExcelTemplate() {
		btnUploadFile.sendKeys(mixedCaseFileTemplatePath);
		btnConfirmandUploadFile.click();
		threadSleep(2000);
	}
	
	public String getFileUploadCompletedText()	{
		return popUpFileUploadCompleted.getText();
		
	}
	
	public void clickCloseButtoninUploadCompletedPopup() {
		btnClose.click();
		threadSleep(2000);
	}
	
	public String getFileUploadErrorAlertText() {
		return txtFileUploadErrorAlert.getText();
	}
	
	public File waitForDownloadToComplete(String folderPath, String extension, int timeoutSeconds) throws InterruptedException {
        File dir = new File(folderPath);
        File latestFile = null;
        int waited = 0;
        while (waited < timeoutSeconds) {
            File[] files = dir.listFiles((d, name) -> name.toLowerCase().endsWith(extension));
            if (files != null && files.length > 0) {
                latestFile = files[0];
                for (File f : files) {
                    if (f.lastModified() > latestFile.lastModified()) {
                        latestFile = f;
                    }
                }
                if (latestFile.exists()) {
                    return latestFile;
                }
            }
            Thread.sleep(1000);
            waited++;
        }
        return null;
    }
	
	 public void readDownloadedExcelFileandEnterEnquiryId(File file) throws IOException {
		 FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0); 

			DataFormatter formatter = new DataFormatter();

			int enqIdColIndex = -1;
			int errorColIndex = -1;

			System.out.println("\n Extracted Column Values:\n");

			XSSFRow headerRow = sheet.getRow(0);
			for (Cell cell : headerRow) {
			    String header = formatter.formatCellValue(cell).trim();
			    if (header.equalsIgnoreCase("Enq id *")) {
			        enqIdColIndex = cell.getColumnIndex();
			    } else if (header.equalsIgnoreCase("Error")) {
			        errorColIndex = cell.getColumnIndex();
			    }
			}

			if (enqIdColIndex == -1 && errorColIndex == -1) {
			    System.out.println("❌ Columns 'Enq id *' and 'Error' not found!");
			    workbook.close();
			    fis.close();
			    return;
			} 

			List<String> enqIdList = new ArrayList<>();

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			    XSSFRow row = sheet.getRow(i);
			    if (row == null) continue;

			    if (enqIdColIndex != -1) {
			        Cell enqCell = row.getCell(enqIdColIndex);
			        String enqValue = formatter.formatCellValue(enqCell);
			        if (!enqValue.isEmpty()) {
			            enqIdList.add(enqValue);
			            System.out.println("Enq id *: " + enqValue);
			        }
			    }

			    if (errorColIndex != -1) {
			        Cell errorCell = row.getCell(errorColIndex);
			        String errorValue = formatter.formatCellValue(errorCell);
			        if (!errorValue.isEmpty()) {
			            System.out.println("Error: " + errorValue);
			        }
			    }
			}

			workbook.close();
			fis.close();


			if (!enqIdList.isEmpty()) {
			    String firstEnqId = enqIdList.get(0);
			
			    driver.findElement(By.xpath("//h2[text()='Search by Student']//following::input[5]")).sendKeys(firstEnqId);
			    threadSleep(3000);
			}
}
	 
	 
	 public String getFirstAdmissionNoFromExcel(File file) throws IOException {
		    FileInputStream fis = new FileInputStream(file);
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    DataFormatter formatter = new DataFormatter();
		    int admissionNoColIndex = -1;
		    String admissionNoValue = "";

		    // Identify the column index for "Enq id *"
		    XSSFRow headerRow = sheet.getRow(0);
		    for (Cell cell : headerRow) {
		        String header = formatter.formatCellValue(cell).trim();
		        if (header.equalsIgnoreCase("Admission No *")) {
		        	admissionNoColIndex = cell.getColumnIndex();
		            break;
		        }
		    }

		    // Extract the first non-empty Enq id *
		    if (admissionNoColIndex != -1) {
		        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		            XSSFRow row = sheet.getRow(i);
		            if (row == null) continue;

		            Cell admissionNoCell = row.getCell(admissionNoColIndex);
		            admissionNoValue = formatter.formatCellValue(admissionNoCell).trim();

		            if (!admissionNoValue.isEmpty()) {
		                //System.out.println("First Enq id *: " + enqIdValue);
		                break;
		            }
		        }
		    } else {
		        System.out.println("❌ Column 'Admission No' not found!");
		    }

		    workbook.close();
		    fis.close();

		    admissionNoValue = admissionNoValue.replaceFirst("^25CET", "").trim();
		    
		    return admissionNoValue;
		}
	 
	 public String getFirstEmailIdFromExcel(File file) throws IOException {
		    FileInputStream fis = new FileInputStream(file);
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    DataFormatter formatter = new DataFormatter();
		    int emailIdColIndex = -1;
		    String emailIdValue = "";

		    // Identify the column index for "Enq id *"
		    XSSFRow headerRow = sheet.getRow(0);
		    for (Cell cell : headerRow) {
		        String header = formatter.formatCellValue(cell).trim();
		        if (header.equalsIgnoreCase("Email id *")) {
		            emailIdColIndex = cell.getColumnIndex();
		            break;
		        }
		    }

		    // Extract the first non-empty Enq id *
		    if (emailIdColIndex != -1) {
		        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		            XSSFRow row = sheet.getRow(i);
		            if (row == null) continue;

		            Cell enqCell = row.getCell(emailIdColIndex);
		            emailIdValue = formatter.formatCellValue(enqCell).trim();

		            if (!emailIdValue.isEmpty()) {
		                //System.out.println("First Enq id *: " + enqIdValue);
		                break;
		            }
		        }
		    } else {
		        System.out.println("❌ Column 'Enq id *' not found!");
		    }

		    workbook.close();
		    fis.close();

		    return emailIdValue;
		}

	 public String getFirstMobileNoFromExcel(File file) throws IOException {
		    FileInputStream fis = new FileInputStream(file);
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    DataFormatter formatter = new DataFormatter();
		    int mobileNoColIndex = -1;
		    String mobileNoValue = "";

		    // Identify the column index for "Mobile number *"
		    XSSFRow headerRow = sheet.getRow(0);
		    for (Cell cell : headerRow) {
		        String header = formatter.formatCellValue(cell).trim();
		        if (header.equalsIgnoreCase("Mobile number *")) {
		            mobileNoColIndex = cell.getColumnIndex();
		            break;
		        }
		    }

		    // Extract the first non-empty mobile number
		    if (mobileNoColIndex != -1) {
		        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		            XSSFRow row = sheet.getRow(i);
		            if (row == null) continue;

		            Cell mobileNoCell = row.getCell(mobileNoColIndex);
		            mobileNoValue = formatter.formatCellValue(mobileNoCell).trim();

		            if (!mobileNoValue.isEmpty()) {
		                // Remove +91 if present
		                if (mobileNoValue.startsWith("+91")) {
		                    mobileNoValue = mobileNoValue.replaceFirst("^\\+91", "").trim();
		                }
		                break;
		            }
		        }
		    } else {
		        System.out.println("❌ Column 'Mobile number *' not found!");
		    }

		    workbook.close();
		    fis.close();

		    return mobileNoValue;
		}
	 
	 public String getErrorFromDownloadedExcel(File file) throws IOException {
		    FileInputStream fis = new FileInputStream(file);
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    DataFormatter formatter = new DataFormatter();

		    int errorColIndex = -1;
		    String errorValue = "";

		    XSSFRow headerRow = sheet.getRow(0);
		    for (Cell cell : headerRow) {
		        String header = formatter.formatCellValue(cell).trim();
		        if (header.equalsIgnoreCase("Error")) {
		            errorColIndex = cell.getColumnIndex();
		            break;
		        }
		    }

		    if (errorColIndex == -1) {
		        System.out.println("❌ Column 'Error' not found!");
		    } else {
		        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		            XSSFRow row = sheet.getRow(i);
		            if (row == null) continue;

		            Cell errorCell = row.getCell(errorColIndex);
		            errorValue = formatter.formatCellValue(errorCell);
		            if (!errorValue.isEmpty()) {
		                //System.out.println("Extracted Error: " + errorValue);
		                break; // Only return first non-empty error
		            }
		        }
		    }

		    workbook.close();
		    fis.close();
		    
		    return errorValue;
		}
	 
	 private void updateFirstRowWithRandomData(String filePath) throws IOException {
		    FileInputStream fis = new FileInputStream(filePath);
		    Workbook workbook;
		    //XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    
		    
		    if (filePath.toLowerCase().endsWith(".xlsx")) {
		        workbook = new XSSFWorkbook(fis); // For .xlsx
		    } else if (filePath.toLowerCase().endsWith(".xls")) {
		        workbook = new HSSFWorkbook(fis); // For .xls
		    } else {
		        fis.close();
		        throw new IllegalArgumentException("Unsupported Excel file format: " + filePath);
		    }
		    
		    Sheet sheet = workbook.getSheetAt(0);
		    DataFormatter formatter = new DataFormatter();

		    int nameColIndex = -1;
		    int emailColIndex = -1;
		    int mobileColIndex = -1;
		    int consortiumColIndex = -1;

		    // Step 1: Find column indexes
		    Row headerRow = sheet.getRow(0);
		    for (Cell cell : headerRow) {
		        String header = formatter.formatCellValue(cell).trim();
		        if (header.equalsIgnoreCase("Name") || header.equalsIgnoreCase("Full Name as per 10th marksheet *")) {
		            nameColIndex = cell.getColumnIndex();
		        } else if (header.equalsIgnoreCase("Email") || header.equalsIgnoreCase("Email id *")) {
		            emailColIndex = cell.getColumnIndex();
		        } else if (header.equalsIgnoreCase("Mobile") || header.equalsIgnoreCase("Mobile number *")) {
		            mobileColIndex = cell.getColumnIndex();
		        } else if (header.equalsIgnoreCase("Consortium No. *")) {
		        	consortiumColIndex = cell.getColumnIndex();
		        }
		    }

		    if (nameColIndex == -1 && emailColIndex == -1 && mobileColIndex == -1 && consortiumColIndex == -1) {
		        //System.out.println("❌ 'Name', 'Email', or 'Mobile' column not found in Excel!");
		        workbook.close();
		        fis.close();
		        return;
		    }

		    // Step 2: Update only the first data row (row index 1)
		    Faker faker = new Faker();
		    Row row = sheet.getRow(1);
		    if (row == null) {
		        row = sheet.createRow(1);
		    }

		    if (nameColIndex != -1) {
		        Cell nameCell = row.getCell(nameColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		        nameCell.setCellValue(faker.name().fullName());
		    }

		    if (emailColIndex != -1) {
		        Cell emailCell = row.getCell(emailColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		        emailCell.setCellValue(faker.internet().emailAddress());
		    }

		    if (mobileColIndex != -1) {
		        Cell mobileCell = row.getCell(mobileColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		        mobileCell.setCellValue(generateRandomIndianMobileNumber());
		    }
		    
		    if (consortiumColIndex != -1) {
		        Cell consortiumCell = row.getCell(consortiumColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		        consortiumCell.setCellValue(faker.number().digits(6));
		    }

		    // Step 3: Save the changes
		    fis.close(); // Close input stream before writing
		    FileOutputStream fos = new FileOutputStream(filePath);
		    workbook.write(fos);
		    workbook.close();
		    fos.close();

		    //System.out.println("✅ First row updated with random name, email, and mobile number.");
		}
	 		private String generateRandomIndianMobileNumber() {
		    Random rand = new Random();
		    int[] starts = {7, 8, 9};
		    return starts[rand.nextInt(3)] + String.format("%09d", rand.nextInt(1000000000));
		}

}

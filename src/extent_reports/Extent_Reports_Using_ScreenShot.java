package extent_reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extent_Reports_Using_ScreenShot {

	public static void main(String[] args) throws Exception 
	{
		
		WebDriver driver;
		String driver_path="Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driver_path);
		driver=new ChromeDriver();
		driver.get("http://facebook.com");
		
		
		//Create Extent Report
		String Filepath="Reports\\Report7.html";
		ExtentReports logger=new ExtentReports(Filepath, true);
		System.out.println("Reporter file created");
			
			ExtentTest test1=logger.startTest("Tc001_loginvalid");
			
				//Capture screen using webdriver scripting
				String screen1_path="C:\\Users\\Administrator\\git\\05th_Dec_10AM_2019\\Project_177\\screens\\Screen1.png";
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File(screen1_path));
				
				//Attach screen to extent report file.
				test1.log(LogStatus.INFO, "Screen Captured"+test1.addScreenCapture(screen1_path));;
			
			//Flush all runtime test reports to HTML file
			logger.endTest(test1);
			
		
		//flush all reports to file..		
		logger.flush();

	}

}

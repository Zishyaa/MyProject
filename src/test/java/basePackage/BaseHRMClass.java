package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseHRMClass {
	// prop- reference variable for frreading the properties from config.properties
	public static Properties prop = new Properties();
	public static WebDriver driver;

//Step:1- baseclass - to read the properties of config.properties
//FileInputStream- this is a class which has methods to read the properties of any file, 
//this is used to read the properties of any file. 

	public BaseHRMClass() {
		try {
			FileInputStream file = new FileInputStream(
					"C:\\Users\\Owner\\eclipse-workspace\\HRManagement\\src\\test\\java\\environmentvariables\\Config.properties");
			try {
				prop.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	// step:2- keep the common commands that we will be using in all the child
	// classses.

	public static void initiation() {
		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		}
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
		
			driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
		}
	
	public static void screenshots(String fileName) {
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\Owner\\eclipse-workspace1\\HRManagementTest\\src\\test\\java\\screenshot\\ScreenShot"+fileName+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}






package Base;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import UtilityClass.ReportsUtility;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseClass
{
	public ReportsUtility ExtentManager =new ReportsUtility();
	 public WebDriver driver=null;
	 public ReportsUtility ru = new ReportsUtility();
		public static String driverPath = "./Drivers/chromedriver.exe";
		public static String driverPathIE = "./BrowserDrivers/IEDriverServer.exe";
//	    public static ExtentTest scenarioDef;
//	    public static ExtentTest features;     
	    public static String reportLocation = "./Reports/";
	    public ExtentReports extent =ru.getInstance();
		public ExtentTest test;

		public WebDriver getDriver()    
		{
			return driver;
		}

		public void setDriver(String browserType, String appURL) 
		
		{
			if(browserType.equals("chrome"))
				driver = initChromeDriver(appURL);
			else if (browserType.equals("IE"))
				driver = initInternetExplorerDriver(appURL);
			else if (browserType.equals("firefox"))
				driver = initInternetExplorerDriver(appURL);
			else
			{
				System.out.println("browser : " + browserType
						+ " is invalid, Launching Firefox as browser of choice..");
				driver = initFirefoxDriver(appURL);
			}
//			switch (browserType) {
//			case "chrome":
//				driver = initChromeDriver(appURL);
//				break;
//			case "IE":
//				driver = initInternetExplorerDriver(appURL);
//				break;
//			case "firefox":
//				driver = initFirefoxDriver(appURL);
//				break;
//			default:
//				System.out.println("browser : " + browserType
//						+ " is invalid, Launching Firefox as browser of choice..");
//				driver = initFirefoxDriver(appURL);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			}
		}
		private static WebDriver initChromeDriver(String appURL) {
			System.out.println("Launching google chrome with new profile..");
			System.setProperty("webdriver.chrome.driver", driverPath);
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.navigate().to(appURL);
			
			return driver;
		}
		private static WebDriver initInternetExplorerDriver(String appURL) {
			System.out.println("Launching Internet Explorer with new profile..");
			System.setProperty("webdriver.ie.driver", driverPathIE);
			WebDriver driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.navigate().to(appURL);
			return driver;
		}

		private static WebDriver initFirefoxDriver(String appURL) {
			System.out.println("Launching Firefox browser..");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.navigate().to(appURL);
			return driver;
		}

//		@Before
//		public void initializeTestBaseSetup(String browserType, String appURL) 
		{
//			try 
//			{
//				setDriver(browserType, appURL);
//
//			} 
//			catch (Exception e)
//			{
//				System.out.println("Error....." + e.getStackTrace());
//			}

		}
		
//		@After
//		public void tearDown() 
//		{
//			//driver.quit();
//			extent.endTest(test);
//			extent.flush();
//		}
}

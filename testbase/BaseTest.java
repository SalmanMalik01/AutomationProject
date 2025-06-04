package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	public static WebDriver driver;

	public Properties p;
	public Logger logger;

	@BeforeClass(groups = {"sanity","regretion","master","functional"})
	@Parameters({"browser","os"})
	
	public void setup(String br,String os) throws IOException {


		//log4j
		
		
		logger=LogManager.getLogger(this.getClass());
		
		//cogfin.properties 

		FileReader file =new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);



		switch(br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver(); break;
		case "edge" :driver=new EdgeDriver(); break;
		case "firefox" :driver=new FirefoxDriver(); break;
		default: System.out.println("Invalid browser.."); return;
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appUrl"));

	}

	@AfterClass(groups = {"sanity","regretion","master","functional"})
	public void tearDown() {
		driver.quit();

	}

	public String randomString() {
		@SuppressWarnings("deprecation")
		String generatedString= RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {
		@SuppressWarnings("deprecation")
		String generatedNumber= RandomStringUtils.randomNumeric(5);
		return generatedNumber;
	}

	public String randomAlphaNumebric() {
		@SuppressWarnings("deprecation")
		String generatedNumber= RandomStringUtils.randomNumeric(5);
		@SuppressWarnings("deprecation")
		String generatedString= RandomStringUtils.randomAlphabetic(5);
		return (generatedString+generatedNumber);
	}
	
	// for screenshots
	
	public String captureScreen(String tname) {
		
		String timeStamp= new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File sourcefile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname + "_" +timeStamp +".png";
		File targetFile=new File(targetFilePath);
		
		sourcefile.renameTo(targetFile);
		return targetFilePath;
	}
	
}

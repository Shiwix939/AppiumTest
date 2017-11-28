package test.java.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Random;

public class MainSettings {
    public AppiumDriver<WebElement> driver;

    @Before
    public void setUp() throws Exception {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/apps/");
        File app = new File(appDir.getCanonicalPath(), "Financius.v0.18.2.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "4TE0216902022189"); // device UID from adb
		capabilities.setCapability("platformVersion", "7.0"); // android version
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.code44.finance"); // package name
		capabilities.setCapability("appWaitActivity", "com.code44.finance.*"); // default activity
		capabilities.setCapability("noReset", "true"); 
		capabilities.setCapability("fullReset", "false"); 
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }      
    }
    
    public void WaitFor(String element){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(element)));
    }
    
    public String GenerateRandomString(int lenght){
    	String randomString = RandomStringUtils.randomAlphanumeric(lenght).toUpperCase();
    	return randomString;
	}
    
	public void ClickElement(String element)
	{
		WebElement elementButton = driver.findElement(By.xpath(element));
		elementButton.click();
	}
	
	public void SaveButton() {
		WebElement saveButton = driver.findElement(By.id("com.code44.finance:id/saveButton"));
		saveButton.click();	
	}
	
    public void MenuOverviewButton(){
    	WebElement menuButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Otwórz lokalizację\"]"));
    	menuButton.click();
    	WaitFor("//*/android.widget.ListView");    	
    }

//    public MobileElement scrollTo(String text){
//        return (MobileElement) driver.findElement(MobileBy.
//                AndroidUIAutomator("new UiScrollable(new UiSelector()"
//                        + ".scrollable(true)).scrollIntoView(resourceId(\"android:id/list\")).scrollIntoView("
//                        + "new UiSelector().text(\""+text+"\"))"));
//    }

}

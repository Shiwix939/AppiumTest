package test.java.appium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;


public class BasicFunctionality extends MainSettings{
	

	@Before
	public void testCaseSetup()throws Exception {
		
	}
	
    @Test
    public void MenuOverviewButton(){
    	WebElement menuButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Otwórz lokalizację\"]"));
    	menuButton.click();
    	WaitFor("//*/android.widget.ListView");    	
    }
    
    @Test
    public void OpenOverview(){
    	MenuOverviewButton();
    	WebElement overViewButton = driver.findElement(By.xpath(("//*[@text=\"Podgląd\"]")));
	    overViewButton.click();
	    //temporary until I won't find out the solution
	    WaitFor("//*[@text=\"listopad\"]");
    }
    
    @Test
    public void OpenAccountsView() {
    	MenuOverviewButton();
    	WebElement accountsButton = driver.findElement(By.xpath("//*/android.widget.LinearLayout[2]"));
    	accountsButton.click(); 
    	WaitFor("//*[@text=\"0.00 zł\"]");
    }   
    
    @Test
    public void OpenTransactionsView(){
    	MenuOverviewButton();
    	WebElement transactionsButton = driver.findElement(By.xpath("//*[@text=\"Transakcje\"]"));
    	transactionsButton.click();
    	WaitFor("//*[@text=\"Transakcje\"]");
    }
    
    @Test
    public void OpenReportsView(){
    	MenuOverviewButton();
    	WebElement reportsButton = driver.findElement(By.xpath("//*[@text=\"Zestawienia\"]"));
    	reportsButton.click();
    }

        

}

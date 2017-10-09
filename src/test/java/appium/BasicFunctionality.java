package test.java.appium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class BasicFunctionality extends MainSettings{
	

	@Before
	public void testCaseSetup()throws Exception {
		// Some before tests actions
	}
	
    @Test
    public void MenuOverviewB(){
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	WebElement menuButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Otwórz lokalizację\"]"));
    	menuButton.click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("listView")));
    	WebElement overViewButton = driver.findElement(By.xpath(("//*[@text=\"Podgląd\"]")));
    	overViewButton.click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("overviewGraphContainer")));
    	menuButton.click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("listView")));
    	WebElement accountsButton = driver.findElement(By.xpath("//*/android.widget.LinearLayout[2]"));
    	accountsButton.click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("balanceContainerView")));
    	menuButton.click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("listView")));
    	WebElement transactionsButton = driver.findElement(By.xpath("//*/android.widget.LinearLayout[3]"));
    	transactionsButton.click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text=\"Transakcje\"]")));
    	menuButton.click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("listView")));
    	WebElement reportsButton = driver.findElement(By.xpath("//*/android.widget.LinearLayout[3]"));
    	reportsButton.click();
    	
    }
    
//    @Test
//    public void OpenOverView(){
//    	WebDriverWait wait = new WebDriverWait(driver, 10);
//    	WebElement menuButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Otwórz lokalizację\"]"));
//    	WebElement overViewButton = driver.findElement(By.xpath(("//*[@text=\"Podgląd\"]")));
//    	menuButton.click();
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("listView")));
//    	overViewButton.click();
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("overviewGraphContainer")));
//    }
//    @Test
//    public void OverViewAccounts() {
//    	WebDriverWait wait = new WebDriverWait(driver, 10);
//    	WebElement menuButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Otwórz lokalizację\"]"));
//    	WebElement accountsButton = driver.findElement(By.xpath("//*[@text=\"Konta\"]"));
//    	menuButton.click();   
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("listView")));
//    	accountsButton.click();
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("balanceContainerView")));
//    	
//    }   

        

}

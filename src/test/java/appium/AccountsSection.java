//TODO make each test strongly independent!
//change for loop to foreach(if possible) 
package test.java.appium;

import java.awt.Dimension;
import java.awt.MenuBar;

import javax.naming.directory.DirContext;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.html5.AddApplicationCache;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;

import junit.framework.Assert;

public class AccountsSection extends MainSettings{
	String nameofAccount1 = GenerateRandomString(5);
	String nameofAccount2 = GenerateRandomString(5);
	
	@Test 
	public void test_01_CreateAccounts(){
		ClickElement("//android.widget.ImageButton[@content-desc=\"Otwórz lokalizację\"]");
		WaitFor("//*/android.widget.ListView"); 
		ClickElement("//*/android.widget.LinearLayout[2]/android.widget.TextView");
		WebElement addAccountButton = driver.findElement(By.id("com.code44.finance:id/action_new"));
		addAccountButton.click();
		WaitFor("//*[@text=\"Nazwa\"]");
		WebElement accountNameInput = driver.findElement(By.id("com.code44.finance:id/titleEditText"));
		accountNameInput.sendKeys(nameofAccount1);
		SaveButton();
		WaitFor("//*[@text=\""+nameofAccount1+"\"]");
		addAccountButton.click();
		accountNameInput.sendKeys(nameofAccount2);
		WebElement currencyButton = driver.findElement(By.id("com.code44.finance:id/currencyButton"));
		currencyButton.click();
		WebElement chooseCurrencyButton = driver.findElement(By.xpath("//*[@text=\"EUR\"]"));
		chooseCurrencyButton.click();
		SaveButton();
		WaitFor("//*[@text=\""+nameofAccount2+"\"]");
	}
	@Test
	public void test_02_ChangeSettingsOfAccount(){
		WebElement accountsWidgetClick = driver.findElement(By.id("com.code44.finance:id/accounts"));
		accountsWidgetClick.click();
		WebElement accountClick = driver.findElement(By.xpath("//*/android.widget.LinearLayout[1]"));
		accountClick.click();
		WebElement editButton = driver.findElement(By.id("com.code44.finance:id/action_edit"));
		editButton.click();
		WebElement currencyButton = driver.findElement(By.id("com.code44.finance:id/currencyButton"));
		currencyButton.click();
		WebElement chooseCurrencyButton = driver.findElement(By.xpath("//*[@text=\"USD\"]"));
		chooseCurrencyButton.click();
		SaveButton();
	}
	
	@Test
	public void test_03_DeleteAccounts(){
		WebElement accountsWidgetClick = driver.findElement(By.id("com.code44.finance:id/accounts"));
		accountsWidgetClick.click();
		for(int i=0;i<2; i++){
			WebElement account1Get = driver.findElement(By.id("com.code44.finance:id/titleTextView"));
			String accountName1 = account1Get.getText();
			ClickElement("//*[@text=\""+accountName1+"\"]");
			WaitFor("//*[@text=\"0.00 zł\"]");
			ClickElement("//android.widget.ImageView[@content-desc=\"Więcej opcji\"]");
			ClickElement("//*[@text=\"Usuń\"]");
			WaitFor("/hierarchy/android.widget.FrameLayout");
			ClickElement("//*/android.widget.Button[2]");		
		}

	}
}

package test.java.appium;

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

public class AccountsSection extends BasicFunctionality{
	
	@Test 
	public void CreateAccounts(){
		MenuOverviewButton();
		OpenAccountsView();
		WebElement addAccountButton = driver.findElement(By.id("com.code44.finance:id/action_new"));
		addAccountButton.click();
		WaitFor("//*[@text=\"Nazwa\"]");
		String nameofAccount1 = GenerateRandomString(5);
		String nameofAccount2 = GenerateRandomString(5);
		WebElement accountNameInput = driver.findElement(By.id("com.code44.finance:id/titleEditText"));
		accountNameInput.sendKeys(nameofAccount1);
		SaveButton();
		WaitFor(nameofAccount1);
		addAccountButton.click();
		accountNameInput.sendKeys(nameofAccount2);
		WebElement currencyButton = driver.findElement(By.id("com.code44.finance:id/currencyButton"));
		WebElement chooseCurrencyButton = driver.findElement(By.xpath("//*[@text=\"EUR\"]"));
		chooseCurrencyButton.click();
		SaveButton();
		WaitFor(nameofAccount2);
	}
	@Test
	public void ChangeSettingsOfAccount(){
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
		WaitFor("//*[@text=\"USD\"]");
	}
}

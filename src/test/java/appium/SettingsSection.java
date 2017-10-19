package test.java.appium;

import java.nio.charset.Charset;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import junit.framework.Assert;

public class SettingsSection extends BasicFunctionality {
	
	@Before
	public void testCaseSetup()throws Exception {
	}
	
	
	@SuppressWarnings("deprecation")
	
	public void SettingsButton(){
		WebElement settingsButton = driver.findElement(By.xpath("//*[@text=\"Ustawienia\"]"));
		settingsButton.click();
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
	
	@Test
	public void ChangeCurrencies(){
		MenuOverviewButton();
		SettingsButton();
		WaitFor("//*[@text=\"Waluty\"]");
		ClickElement("//*[@text=\"Waluty\"]");
		WaitFor("//*[@text=\"PLN\"]");
		ClickElement("//*[@text=\"USD\"]");
		WebElement editButton = driver.findElement(By.id("com.code44.finance:id/action_edit"));
		editButton.click();
		WebElement changeSymbolPosition = driver.findElement(By.id("com.code44.finance:id/symbolPositionButton"));
			for(int i=0; i<2; i++)
			{
				changeSymbolPosition.click();
			}
		SaveButton();
		String newSymbolPosition = "USD 1,000.00";
		WebElement stringFormat = driver.findElement(By.id("com.code44.finance:id/formatTextView"));
		String newFormatToCompare = stringFormat.getText();
		Assert.assertEquals(newSymbolPosition,newFormatToCompare);
		
	}
	
	@Test
	public void ChangeCategories(){
		MenuOverviewButton();
		SettingsButton();
		WaitFor("//*[@text=\"Kategorie\"]");
		ClickElement("//*[@text=\"Kategorie\"]");
		WaitFor("//*[@text=\"Jedzenie\"]");
		ClickElement("//*[@text=\"Jedzenie\"]");
		WebElement editButton = driver.findElement(By.id("com.code44.finance:id/action_edit"));
		editButton.click();
		WebElement editCategory = driver.findElement(By.id("com.code44.finance:id/titleEditText"));
		editCategory.clear();
		String newCategory = "Food";
		editCategory.sendKeys(newCategory);
		SaveButton();
	    WebElement checkCategory = driver.findElement(By.id("com.code44.finance:id/titleTextView"));
		String newCategoryToCompare = checkCategory.getText();
		Assert.assertEquals(newCategory,newCategoryToCompare);
	}
	
	@Test
	public void ChangeTags(){
		MenuOverviewButton();
		SettingsButton();
		WaitFor("//*[@text=\"Tagi\"]");
		WebElement addTagButton = driver.findElement(By.id("com.code44.finance:id/addImageButton"));
		addTagButton.click();
		WebElement addTagText = driver.findElement(By.id("com.code44.finance:id/titleEditText"));
		addTagText.click();
		String randomTagName = GenerateRandomString(5);
		addTagText.sendKeys(randomTagName);	
		SaveButton();
		WebElement titleTextView = driver.findElement(By.id("com.code44.finance:id/titleTextView"));
		String checkTagTitle = titleTextView.getText();
		Assert.assertEquals(randomTagName, checkTagTitle);	
	}
	
	@Test
	public void ChangePeriod(){
	MenuOverviewButton();
	SettingsButton();
	WaitFor("//*[@text=\"Okres czasu\"]");
	ClickElement("//*[@text=\"Okres czasu\"]");
	WaitFor("//*/android.widget.RadioButton");
	WebElement checkPeriod = driver.findElement(By.xpath("//*[@text=\"Rok\"]"));
	checkPeriod.click();
		
	}
	
	@Test
	public void OpenSecurity(){
		MenuOverviewButton();
		SettingsButton();
		WaitFor("//*[@text=\"Bezpieczeństwo\"]");
		ClickElement("//*[@text=\"Bezpieczeństwo\"]");
	}
	
	@Test
	public void OpenYourData(){
		MenuOverviewButton();
		SettingsButton();
		WaitFor("//*[@text=\"Twoje dane\"]");
		ClickElement("//*[@text=\"Twoje dane\"]");	
	}

	@Test
	public void OpenAboutMe(){
		MenuOverviewButton();
		SettingsButton();
		WaitFor("//*[@text=\"O aplikacji\"]");
		ClickElement("//*[@text=\"O aplikacji\"]");
		
	}

}
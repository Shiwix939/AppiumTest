package test.java.appium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class SettingsSection extends BasicFunctionality {
	
	@Before
	public void testCaseSetup()throws Exception {
		// Some before tests actions
	}
	
	@SuppressWarnings("deprecation")
	
	@Test
	public void ChangeCurrencies(){
		MenuOverviewButton();
		WebElement settingsButton = driver.findElement(By.xpath("//*[@text=\"Ustawienia\"]"));
		settingsButton.click();
		WaitFor("//*[@text=\"Waluty\"]");
		WebElement currenciesButton = driver.findElement(By.xpath("//*[@text=\"Waluty\"]"));
		currenciesButton.click();
		WaitFor("//*[@text=\"PLN\"]");
		WebElement changeDolarCurrencies = driver.findElement(By.xpath("//*[@text=\"USD\"]"));
		changeDolarCurrencies.click();
		WebElement editButton = driver.findElement(By.id("com.code44.finance:id/action_edit"));
		editButton.click();
		WebElement changeSymbolPosition = driver.findElement(By.id("com.code44.finance:id/symbolPositionButton"));
			for(int i=0; i<2; i++)
			{
				changeSymbolPosition.click();
			}
		WebElement saveButton = driver.findElement(By.id("com.code44.finance:id/saveButton"));
		saveButton.click();
		String newSymbolPosition = "USD 1,000.00";
		WebElement stringFormat = driver.findElement(By.id("com.code44.finance:id/formatTextView"));
		String newFormatToCompare = stringFormat.getText();
		Assert.assertEquals(newSymbolPosition,newFormatToCompare);
		
	}
	
	
//	@Test
//	public void ChangeCategories(){
//		
//	}
//	
//	@Test
//	public void ChangeTags(){
//		
//	}
//	
//	@Test
//	public void ChangePeriod(){
//		
//	}
//	
//	@Test
//	public void OpenSecurity(){
//		
//	}
//	
//	@Test
//	public void OpenYourData(){
//		
//	}
//	
//	@Test
//	public void OpenAboutMe(){
//		
//	}

}
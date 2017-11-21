package test.java.appium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TrasactionsSection extends MainSettings {
	String nameofAccount1 = "TestAccount";
	@Test
	public void test_01_AddAccount() {
		ClickElement("//android.widget.ImageButton[@content-desc=\"Otwórz lokalizację\"]");
		WaitFor("//*/android.widget.ListView"); 
		ClickElement("//*/android.widget.LinearLayout[2]/android.widget.TextView");
		WebElement addAccountButton = driver.findElement(By.id("com.code44.finance:id/action_new"));
		addAccountButton.click();
		WaitFor("//*[@text=\"Nazwa\"]");
		WebElement accountNameInput = driver.findElement(By.id("com.code44.finance:id/titleEditText"));
		accountNameInput.sendKeys(nameofAccount1);
		SaveButton();
		}
	
	@Test
	public void test_02_AddTrasactions(){
		MenuOverviewButton();
		WebElement transactionsButton = driver.findElement(By.xpath("//*[@text=\"Transakcje\"]"));
    	transactionsButton.click();
    	WaitFor("//*[@text=\"Transakcje\"]");
    	for(int i=0;i<=2;i++){
	    	ClickElement("//android.widget.TextView[@content-desc=\"Stwórz\"]");
	    	ClickElement("//*[@text=\"7\"]");
	    	ClickElement("//*[@text=\"0\"]");
	    	ClickElement("//*[@text=\"=\"]");
	    	if(i == 0){
		    	WebElement accountFromButton = driver.findElement(By.id("com.code44.finance:id/accountFromButton"));
		    	accountFromButton.click();	    	
	    	}
	    	else if (i == 1){
	    		ClickElement("//android.widget.ImageView[@content-desc=\"Typ transakcji\"]");
	    		WebElement accountToButton = driver.findElement(By.id("com.code44.finance:id/accountToButton"));
		    	accountToButton.click();	
			}
	    	else {
	    		ClickElement("//android.widget.ImageView[@content-desc=\"Typ transakcji\"]");
	    		ClickElement("//android.widget.ImageView[@content-desc=\"Typ transakcji\"]");
	    		WebElement accountFromButton = driver.findElement(By.id("com.code44.finance:id/accountFromButton"));
		    	accountFromButton.click();
		    	WaitFor("//*[@text=\"do\"]");
	    		WebElement accountToButton = driver.findElement(By.id("com.code44.finance:id/accountToButton"));
		    	accountToButton.click();
			}
	    	ClickElement("//*[@text=\""+nameofAccount1+"\"]");
	    	SaveButton();
    	}

	}

}

//TODO make each test strongly independent!
//change for loop to foreach(if possible) 
package test.java.appium;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TrasactionsSection extends MainSettings {
	String nameofAccount1 = "TestAccount";
	
	@Test
	public void test_01_AddAccount(){
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
	    	//TODO change to random numbers 
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
		    	ClickElement("//*[@text=\""+nameofAccount1+"\"]");
		    	WaitFor("//*[@text=\"do\"]");
	    		WebElement accountToButton = driver.findElement(By.id("com.code44.finance:id/accountToButton"));
		    	accountToButton.click();
			}
	    	ClickElement("//*[@text=\""+nameofAccount1+"\"]");
	    	SaveButton();
    	}
	}
	
	@Test
	public void test_03_ChangeTransactions(){
		MenuOverviewButton();
		WebElement transactionsButton = driver.findElement(By.xpath("//*[@text=\"Transakcje\"]"));
    	transactionsButton.click();
    	WaitFor("//*[@text=\"Transakcje\"]");
    	ClickElement("//*[@text=\"Przelew\"]");
    	WebElement editButton = driver.findElement(By.id("com.code44.finance:id/action_edit"));
		editButton.click();
		WebElement makeNoteText = driver.findElement(By.id("com.code44.finance:id/noteAutoCompleteTextView"));
		String newNote = GenerateRandomString(7);
		makeNoteText.sendKeys(newNote);
		SaveButton();
		WebElement checkNoteLabel = driver.findElement(By.id("com.code44.finance:id/noteTextView"));
		String checkNote = checkNoteLabel.getText();
		Assert.assertEquals(newNote, checkNote);	
	}
	
	@Test
	public void test_04_DeleteTransactions(){
		MenuOverviewButton();
		WebElement transactionsButton = driver.findElement(By.xpath("//*[@text=\"Transakcje\"]"));
    	transactionsButton.click();
		for(int i=0;i<=2; i++){
			WebElement transactionGet = driver.findElement(By.id("com.code44.finance:id/titleTextView"));
			String trasactionName = transactionGet.getText();
			ClickElement("//*[@text=\""+trasactionName+"\"]");
			WaitFor("//*[@text=\"Transakcja\"]");
			ClickElement("//android.widget.ImageView[@content-desc=\"Więcej opcji\"]");
			ClickElement("//*[@text=\"Usuń\"]");
			WaitFor("/hierarchy/android.widget.FrameLayout");
			ClickElement("//*/android.widget.Button[2]");		
		}
	}
}

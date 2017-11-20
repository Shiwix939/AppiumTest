package test.java.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TrasactionsSection extends MainSettings {
	
	public void addAccount() {
		String nameofAccount1 = GenerateRandomString(5);
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

}

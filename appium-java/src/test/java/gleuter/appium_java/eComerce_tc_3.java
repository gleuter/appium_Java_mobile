package gleuter.appium_java;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eComerce_tc_3 extends BaseTest{
	
	@Test
	public void FillForm() throws InterruptedException {
		// tagName[@attibute= 'value']
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Gleuter Pereira");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		List<WebElement> productPrices =  driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		
		int count = productPrices.size();
		double totalsum =0 ;
		
		for (int i =0 ;i < count; i ++) {
		String amountSting  = productPrices.get(i).getText();
		Double price =getFormatteAmount(amountSting);
		totalsum = totalsum +price ;
		}
		
		String displaySum  = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double dislayFormattedSum = getFormatteAmount(displaySum);
		Assert.assertEquals(totalsum, dislayFormattedSum);
		
			WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
			longPressAction(ele);
			
			driver.findElement(By.id("android:id/button1")).click();
			driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

			Thread.sleep(3000);
	
	
	}

}

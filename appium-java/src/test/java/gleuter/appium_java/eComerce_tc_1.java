package gleuter.appium_java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eComerce_tc_1 extends BaseTest{
	
	@Test
	public void FillForm() throws InterruptedException {
		// tagName[@attibute= 'value']
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Gleuter Pereira");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		String toastMessage =  driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		
		Assert.assertEquals(toastMessage ,"Please enter your name");
		
		WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastPageProduct ,"Air Jordan 4 Retro");
		
	}

}

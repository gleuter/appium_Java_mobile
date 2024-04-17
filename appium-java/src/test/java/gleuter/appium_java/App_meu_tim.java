package gleuter.appium_java;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class App_meu_tim extends BaseTest {
	
	@Test
	public void App_meu_timTest() throws MalformedURLException, URISyntaxException, InterruptedException{
		
		scrollToEndAction();
		driver.findElement(By.id("br.com.timbrasil.meutim:id/first_access_permission_button")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Meu TIM")).click();
		
		
		driver.findElement(By.id("com.android.settings:id/entity_header_content")).click();
		
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
//		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
//		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
//		
//		  ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent" ,"br.com.timbrasil.meutim/com.accenture.meutim.activities.LoginActivity"));
		
		
		driver.findElement(By.id("br.com.timbrasil.meutim:id/login")).sendKeys("21981012364986308454")	;
		
		driver.findElement(By.id("br.com.timbrasil.meutim:id/password")).sendKeys("0000");
	
		
		driver.findElement(By.id("br.com.timbrasil.meutim:id/sign_in_button")).click();
		
		
		driver.findElement(By.xpath("//android.widget.CheckBox")).click();
		driver.findElement(By.id("br.com.timbrasil.meutim:id/terms_of_use_button_continue")).click();
		
		
		driver.findElement(By.id("br.com.timbrasil.meutim:id/img_close")).click();
		driver.findElement(By.xpath("//android.widget.Button")).click();
		
}


}

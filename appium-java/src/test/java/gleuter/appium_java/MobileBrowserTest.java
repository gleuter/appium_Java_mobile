package gleuter.appium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MobileBrowserTest extends BrowserBaseTest{
	@Test
	public void browserTest() {
		
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name(("q"))).sendKeys("rahul shetty academy");
		driver.findElement(By.name(("q"))).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
	}

}

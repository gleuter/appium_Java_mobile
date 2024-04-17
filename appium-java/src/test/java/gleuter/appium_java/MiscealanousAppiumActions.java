package gleuter.appium_java;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscealanousAppiumActions extends BaseTest {
	
	@Test
	public void Miscellanous() throws MalformedURLException, URISyntaxException, InterruptedException{
		
		//https://support.testsigma.com/support/solutions/articles/32000019977-how-to-find-app-package-and-app-activity-of-your-android-app
		//adb devices 
		//adb shell dumpsys window | find "mCurrentFocus"
		
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent" ,"io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

		//Rottation 
		DeviceRotation landscap = new DeviceRotation(0,0,90);
		driver.rotate(landscap);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		//Area de transferencia 
		driver.setClipboardText("Rahul Wifi"); 
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
}
}

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCalc {
    AndroidDriver driver;

    @BeforeMethod
    public void openApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("version", "8.0");
        capabilities.setCapability("deviceName", "YomnaEmulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("orientation", "PORTRAIT");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


    }

    //58+12-21*19
    @Test
    public void calculateEquationOne() {
        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();

        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();

        driver.findElement(By.id("com.android.calculator2:id/op_sub")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();

        driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();

        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
        // System.out.println(driver.findElement(By.id("com.android.calculator2:id/formula")).getText());
        Assert.assertEquals("-329",driver.findElement(By.id("com.android.calculator2:id/formula")).getText());

    }

    //12+22/2-2
    @Test
    public void calculateEquationSecond() {
        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();

        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();

        driver.findElement(By.id("com.android.calculator2:id/op_div")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();

        driver.findElement(By.id("com.android.calculator2:id/op_sub")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();


        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

        Assert.assertEquals("21",driver.findElement(By.id("com.android.calculator2:id/formula")).getText());

    }
}

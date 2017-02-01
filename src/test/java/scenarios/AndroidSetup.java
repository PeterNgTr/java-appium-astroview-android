package scenarios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testobject.appium.testng.AppiumDriverProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * Created by thanhnguyen on 1/31/17.
 */
public class AndroidSetup implements AppiumDriverProvider {

    protected AndroidDriver driver;

    @Override
    public AppiumDriver getAppiumDriver() {
        return this.driver;
    }

    protected void prepareAndroidForAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        URL serverAddress;
        String localApp = "astroview.apk";
        String userDir = System.getProperty("user.dir");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        String appPath = Paths.get(userDir, localApp).toAbsolutePath().toString();
        capabilities.setCapability("app", appPath);
        serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(serverAddress, capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}

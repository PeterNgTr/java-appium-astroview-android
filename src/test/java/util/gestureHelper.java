package util;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;

/**
 * Created by thanhnguyen on 2/1/17.
 */
public class gestureHelper {

    protected AndroidDriver driver;

    public gestureHelper(AndroidDriver driver){
        this.driver = driver;
    }

    public void scrollUp() {
        Dimension dimensions = driver.manage().window().getSize();
        Double screenHeightStart = dimensions.getHeight() * 0.5;
        int scrollStart = screenHeightStart.intValue();
        Double screenHeightEnd = dimensions.getHeight() * 0.1;
        int scrollEnd = screenHeightEnd.intValue();
        driver.swipe(0,scrollStart,0,scrollEnd,2000);
    }

    public void pressBackButton(){
        driver.navigate().back();
    }
}

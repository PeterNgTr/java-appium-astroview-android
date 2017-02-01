package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by thanhnguyen on 2/1/17.
 */
public class ShowDetailsPage extends BasePage {

    By showShortDesc = By.id("com.astro.astroview:id/tv_show_short_desc");
    By fabMore = By.id("com.astro.astroview:id/fab_more");
    By reminder = By.id("com.astro.astroview:id/img_reminder_action");
    By reminderPopup = By.id("android:id/message");
    By closePopup = By.id("android:id/button1");
    By favorite = By.id("com.astro.astroview:id/img_favourite_action");
    By closeFabMore = By.id("com.astro.astroview:id/img_close_action");
    By showTitle = By.id("com.astro.astroview:id/tv_show_details_title");

    public ShowDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void pageLoad() {
        pageLoaded(showShortDesc);
    }

    public String getShowTitle(){
        return getTextElement(showTitle);
    }

    public int countSynopsisText() {
        return getTextElement(showShortDesc).length();
    }

    public void tapFabMore() {
        findAndClickElement(fabMore, 0);
    }

    public void tapReminder() {
        findAndClickElement(reminder, 0);
    }

    public boolean reminderPopupAppear(){
        return isElementDisplayed(reminderPopup);
    }

    public void closePopup(){
        findAndClickElement(closePopup, 0);
    }

    public void addFavorite() throws InterruptedException {
        findAndClickElement(favorite, 0);
        Thread.sleep(1000);
        findAndClickElement(closeFabMore, 0);
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by thanhnguyen on 1/31/17.
 */
public class HomePage extends BasePage {

    By mustWatchItem2 = By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.astro.astroview:id/rv_listing']/android.widget.FrameLayout");
    By favTab = By.xpath("//android.widget.TextView[@text='Favourites']");
    By showTitle = By.id("com.astro.astroview:id/tv_show_title");
    By channelShow = By.id("com.astro.astroview:id/img_channel_show");
    By emptyFav = By.id("com.astro.astroview:id/tv_favourite_empty_title");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void pageLoaded(){
        pageLoaded(mustWatchItem2);
    }

    public void clickMustWatchItem(){
        findAndClickElement(mustWatchItem2, 1);
    }

    public void clickFavoritesTab(){
        findAndClickElement(favTab, 0);
    }

    public String getShowTitle(){
        return getTextElement(showTitle);
    }

    public void openChannelShow(int index){
        findAndClickElement(channelShow, index);
    }

    public boolean emptyFavorite(){
        return isElementDisplayed(emptyFav);
    }

}

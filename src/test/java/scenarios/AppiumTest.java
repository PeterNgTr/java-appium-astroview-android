package scenarios;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ShowDetailsPage;
import util.gestureHelper;


/**
 * Created by thanhnguyen on 1/31/17.
 */
public class AppiumTest extends AndroidSetup {

    HomePage homePage;
    ShowDetailsPage showDetailsPage;
    String showTitle;

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
        initPages();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    public void initPages() {
        homePage = new HomePage(driver);
        showDetailsPage = new ShowDetailsPage(driver);
    }

    @Test
    public void countSynopsisText() {
        homePage.pageLoaded();
        new gestureHelper(driver).scrollUp();
        homePage.clickMustWatchItem();

        showDetailsPage.pageLoad();
        showTitle = showDetailsPage.getShowTitle();
        int countCharacter = showDetailsPage.countSynopsisText();
        Assert.assertTrue(countCharacter > 50);
    }

    @Test(priority = 1)
    public void setReminder(){
        showDetailsPage.tapFabMore();
        showDetailsPage.tapReminder();
        Assert.assertTrue(showDetailsPage.reminderPopupAppear());
    }

    @Test(priority = 2)
    public void addFavorite() throws InterruptedException {
        showDetailsPage.closePopup();
        showDetailsPage.addFavorite();
        new gestureHelper(driver).pressBackButton();
        homePage.pageLoaded();
        homePage.clickFavoritesTab();
        new gestureHelper(driver).scrollUp();
        Assert.assertTrue(homePage.getShowTitle().equals(showTitle));

    }

    @Test(priority = 3)
    public void removeFavorite() throws InterruptedException{
        homePage.openChannelShow(0);
        showDetailsPage.pageLoad();
        showDetailsPage.tapFabMore();
        showDetailsPage.addFavorite();
        new gestureHelper(driver).pressBackButton();
        homePage.pageLoaded();
        homePage.clickFavoritesTab();
        Assert.assertTrue(homePage.emptyFavorite());
    }
}

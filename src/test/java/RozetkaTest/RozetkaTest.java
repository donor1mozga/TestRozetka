package RozetkaTest;

import Rozetka.pages.MainPage;
import Rozetka.pages.PhonePage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Rozetka.BaseValue.mainUrl;
import static Rozetka.CommonMethods.openPage;

public class RozetkaTest {
    private MainPage MainPage = new MainPage();

    @Test
    @Description(value = "Check sorting items by prices")
    public void checkSortingItems() throws IOException {
        openPage(mainUrl);
        new MainPage().
                choosePhoneTVElectronicsCategory().
                choosePhoneList().
                selectHighToLowPrice().
                writeProductsToFile();
        Assert.assertTrue(new PhonePage().checkPricesSorting());


    }
}

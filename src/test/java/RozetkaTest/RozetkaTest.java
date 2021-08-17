package RozetkaTest;

import Rozetka.pages.MainPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static Rozetka.BaseValue.mainUrl;
import static Rozetka.CommonMethods.openPage;

public class RozetkaTest {
    private MainPage MainPage = new MainPage();

    @Test
    @Description(value = "Check sorting items by prices")
    public void checkSortingItems() {
        openPage(mainUrl);
        new MainPage().
                choosePhoneTVElectronicsCategory().
                choosePhoneList().
                selectHighToLowPrice().
                selectedPromotion();


    }
}

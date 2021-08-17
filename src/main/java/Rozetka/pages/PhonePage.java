package Rozetka.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PhonePage {
    private final SelenideElement sortingField = $x("//select[contains(@class,'ng-valid')]");
    private final SelenideElement allProducts = $x("//div[@class='catalog']");
    private final ElementsCollection priceProducts = $$x("//span[contains(@class,'goods-tile__label') and contains(text(),\" Акция \")]/ancestor::div[@class='goods-tile ng-star-inserted']//span[@class='goods-tile__price-value']");
    private final ElementsCollection titleProducts = $$x("//span[contains(@class,'goods-tile__label') and contains(text(),\" Акция \")]/ancestor::div[@class='goods-tile ng-star-inserted']//span[@class='goods-tile__title']");
    private final ElementsCollection pagination = $$x("//a[contains(@class,'pagination__link_state_active')]");

    @Step("Select sort high to low price")
    public PhonePage selectHighToLowPrice () {
        allProducts.shouldBe(Condition.visible);
        sortingField.selectOptionByValue("2: expensive");
        return this;
    }

    public PhonePage selectedPromotion() {

        Map<String, String> phoneList = new LinkedHashMap<>();
        for (int i = 1; i < 4; i++) {
//            if (i == 0) {
//                addPhoneToMap(phoneList,titleProducts, priceProducts );
//            }
            addPhoneToMap(phoneList,titleProducts, priceProducts);
            pagination.get(i).scrollIntoView(false).click();

        }
        return this;
    }

    @Step("Write title and price to file")
    public PhonePage writeToFile(Map<String, String> titleOfMap, String pathToFile) {

        File myFile = new File(pathToFile);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true));
            for (Map.Entry<String, String> entry : titleOfMap.entrySet())
                writer.write(entry.getKey() + " --- " + entry.getValue() + "\r\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Map<String, String> addPhoneToMap(Map<String, String> productOfMap, ElementsCollection NameProduct, ElementsCollection priceOfProduct) {
        if (NameProduct.size() > 0) {
            for (int j = 0; j < NameProduct.size(); j++) {
                productOfMap.put(NameProduct.get(j).getText(), priceOfProduct.get(j).getText());
            }
        }

        for (Map.Entry<String, String> ag : productOfMap.entrySet()) {
            System.out.print( ag.getKey() + " - " +  ag.getValue()+ "\r\n");
        }

        return productOfMap;
    }


}

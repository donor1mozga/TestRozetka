package Rozetka.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PhonePage {
    private final SelenideElement sortingField = $x("//select[contains(@class,'ng-valid')]");
    private final SelenideElement allProducts = $x("//div[@class='catalog']");
    private final ElementsCollection priceProducts = $$x("//span[contains(@class,'goods-tile__label') and contains(text(),\" Акция \")]/ancestor::div[@class='goods-tile ng-star-inserted']//span[@class='goods-tile__price-value']");
    private final ElementsCollection titleProducts = $$x("//span[contains(@class,'goods-tile__label') and contains(text(),\" Акция \")]/ancestor::div[@class='goods-tile ng-star-inserted']//span[@class='goods-tile__title']");
    private final SelenideElement pagination = $x("//a[contains(@class,'button_color_gray')][2]");
    private final ElementsCollection pricesOfProducts = $$x("//span[@class='goods-tile__price-value']");
    Map<String, String> phoneList = new LinkedHashMap<>();
    List<Integer> priceList = new ArrayList<>();

    @Step("Select sort high to low price")
    public PhonePage selectHighToLowPrice() {
        allProducts.shouldBe(Condition.visible);
        sortingField.selectOptionByValue("2: expensive");
        initializationOfMap();
        return this;
    }

    @Step("Fill collections by values")
    public PhonePage initializationOfMap() {

        for (int i = 1; i <=3; i++) {
            if (i == 1) {
                for (int j = 0; j < pricesOfProducts.size(); j++) {
                    priceList.add(Integer.parseInt(pricesOfProducts.get(j).getText().replaceAll("\\s", "")));
                }
            }
            addPhoneToMap(phoneList, titleProducts, priceProducts);
            pagination.scrollIntoView(false).click();
        }
        return this;
    }

    @Step("Write title and price to file")
    public PhonePage writeProductsToFile() throws IOException {

        File myFile = new File("C://autodoc//result.txt");

        BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true));
        for (Map.Entry<String, String> entry : phoneList.entrySet())
            writer.write(entry.getKey() + " --- " + entry.getValue() + "\r\n");
        writer.close();

        return this;
    }

    private Map<String, String> addPhoneToMap(Map<String, String> productOfMap, ElementsCollection NameProduct, ElementsCollection priceOfProduct) {
        if (NameProduct.size() > 0) {
            for (int j = 0; j < NameProduct.size(); j++) {
                productOfMap.put(NameProduct.get(j).getText(), priceOfProduct.get(j).getText());
            }
        }

        return productOfMap;
    }

    private List<Integer> getExpectedSortedPrices(List<Integer> pricesList) {
        List<Integer> expectedSortedPrices = new ArrayList<>(pricesList);
        Collections.sort(expectedSortedPrices);
        Collections.reverse(expectedSortedPrices);
        return expectedSortedPrices;
    }

    @Step("Check prices sorting")
    public boolean checkPricesSorting() {
        boolean label = priceList.equals(getExpectedSortedPrices(priceList)) ? true : false;

        return label;
    }

}

package com.selenium.test.pages;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.webtestsbase.BasePage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by PLARPUR on 2017-05-20.
 */
public class LandingPage  extends BasePage{
    public LandingPage( ) {
        super(true); //wywołuje konstruktor z klasy nadrzędnej BasePage, jako argument przyjmuje boolean
    } //to ekstenduje po klasie BasePage, rozszerza tą klasę poprzez dziecziczenie wszystkie metody public oraz protected z BasePage będą tutaj dostępne (private nie),
    //to co abstract trzeba będize zaimplementować tutaj

    //klasa Base Page daje dla każdej klasy swoje możliwości openPage (wie jak otowrzyć)  oraz isPageOpened (wie jak sprawdzić że jest otwarta)
    @Override
    protected void openPage() {
    WebDriverFactory.getDriver().get(TestsConfig.getBaseURL());

    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.getDriver().getTitle().equals("Your Store");
    }

    public ProductsInCategoryListPage goToProductLIst(String category, String subcategory) {
        Actions action = new Actions(getDriver());

        action
                .moveToElement(getDriver()
                    .findElement(By
                            .linkText(category)))
                .moveToElement(getDriver()
                    .findElement(By
                            .partialLinkText(subcategory)))
                .click()
                .build()
                .perform();
        return new ProductsInCategoryListPage();  //dobre praktyki pisania PO aby zwracało odpowiednie PO
    }
}

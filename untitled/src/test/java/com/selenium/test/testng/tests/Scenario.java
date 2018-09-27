package com.selenium.test.testng.tests;

import com.selenium.test.pages.LandingPage;
import com.selenium.test.pages.ProductsInCategoryListPage;
import com.selenium.test.testng.listeners.ScreenShotOnFailListener;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by PLARPUR on 2017-05-20.
 */
@Listeners({ScreenShotOnFailListener.class})
public class Scenario {

    //private final String BASE_URL = "http://sklep-testowy.pl";
    private  static final String CATEGORY = "Akcesoria";
    private static final  String SUBCATEGORY = "Monitory";
    private static final  String ITEM = "Samsung SyncMaster 941BW";

    @BeforeTest
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    } //tutaj jest uruchamiana przeglądarka

    @Test
    public void shouldPlaceNewOrderWithoutRegistration() {
        new LandingPage()
                .goToProductLIst(CATEGORY, SUBCATEGORY)   //goToProductList zwraca nam ProductsCategoryListPage czyli nowy Page Object i nie trzeba dawać
                // new ProductsInCategoryListPage().addIteToCart(ITEM); tylko od razu nas tutaj przenosi

                .addItemToCart(ITEM)
                .showCartItemList()
                .checkoutPage();

        assertTrue(true);

    }


    @AfterTest
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }
}

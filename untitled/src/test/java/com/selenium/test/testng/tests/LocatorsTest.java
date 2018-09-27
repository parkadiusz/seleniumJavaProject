package com.selenium.test.testng.tests;

import com.selenium.test.testng.listeners.ScreenShotOnFailListener;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;



@Listeners({ScreenShotOnFailListener.class})
public class LocatorsTest {

    @BeforeTest
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    } //tutaj jest uruchamiana przeglądarka


    @Test
    public void testFillGoogleForm() {
        WebDriverFactory.getDriver().get("http://www.sklep-testowy.pl"); //metoda get umożiiwia zaladowanie strony

        //By.id()
        System.out.println("Text from element found by 'id' :"+ WebDriverFactory.getDriver().findElement(By.id("top")).getText()+"\n");  //lokalizacja elementu

        //By.name()
        System.out.println("Text from element found by 'name' :"+ WebDriverFactory.getDriver().findElement(By.name("search")).getAttribute("placeholder") +"\n");

        //By.linkText()

       WebDriverFactory.getDriver().findElement(By.linkText("Akcesoria")).click(); //to nie jest dobra praktyka bo jak będzie inny język to nie kliknie

        //By.partialLinkText()

        System.out.println("URL of link under 'Monitory': " + WebDriverFactory.getDriver().findElement(By.partialLinkText("Monitory")).getAttribute("href") +"\n");  //tutaj pobiera adres URL do monitory bezpośrednio za pomocą href

        //By.className()
        WebDriverFactory.getDriver().findElement(By.className("form-control")).sendKeys("iPhone");

        //By.cssSekector
        WebDriverFactory.getDriver().findElement(By.cssSelector("div #search button")).click();

        //By.tagName
        System.out.println("Image found by its 'tagName " + WebDriverFactory.getDriver().findElement(By.tagName("img")).getAttribute("src") +"\n");

        //By.xpath
        System.out.println("Image found by its 'tagName " + WebDriverFactory.getDriver().findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[1]/a/img")).getAttribute("src") +"\n");

        //By.linkText
        WebDriverFactory.getDriver().findElement(By.linkText("Aparaty fotograficzne")).click();

        //Nested elements
        WebElement productContainer = WebDriverFactory.getDriver().findElement(By.className("product-thumb"));
        System.out.println("Text in container: " + productContainer.getText() + "\n");
        //WebElement linkToProduct = productContainer.findElement(By.)
    }


    @AfterTest
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }

}

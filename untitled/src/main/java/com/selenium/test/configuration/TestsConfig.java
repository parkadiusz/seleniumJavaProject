package com.selenium.test.configuration;

import com.selenium.test.configuration.properties.PropertiesLoader;
import com.selenium.test.configuration.properties.Property;
import com.selenium.test.configuration.properties.PropertyFile;
import com.selenium.test.webtestsbase.Browser;

/**
 * Created by Sidelnikov Mikhail on 18.09.14.
 * Class for base tests properties - urls for test, browser name and version
 */
@PropertyFile("config.properties")
public class TestsConfig {

    private static TestsConfig config;

    public static TestsConfig getConfig() {
        if (config == null) {
            config = new TestsConfig();
        }
        return config;
    }

    public TestsConfig() {
        PropertiesLoader.populate(this);
    }

    @Property("browser.name")
    private String browser = "firefox";

    @Property("browser.version")
    private String version = "";

    @Property("base.url")   //najpierw jest zdefiniowany w property, a tutaj też po to aby było zabezpieczenie
    private static String baseURL = "http://sklep-testowy.pl";


    /**
     * getting browser object
     * @return browser object
     */
    public Browser getBrowser() {
        Browser browserForTests = Browser.getByName(browser);
        if (browserForTests != null) {
            return browserForTests;
        } else {
            throw new IllegalStateException("Browser name '" + browser + "' is not valid");
        }


    }

    public static String getBaseURL() {   //można było tam wyżej dać public ale dobre praktyki mówią aby dawać je później jako public aby nikt nie zmienił
       return baseURL;    //tutaj udostępnie URL dla innych klas, gdyby było private była by tylko dostępna tutaj
    }
    /**
     * getting browser version
     * @return browser version
     */
    public String getBrowserVersion() {
        return version;
    }


}

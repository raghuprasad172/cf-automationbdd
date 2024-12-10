package com.cfspl.nbfc.pages.generics;

import org.openqa.selenium.WebDriver;

/**
 * @author Raghu Prasad
 */
public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }

}

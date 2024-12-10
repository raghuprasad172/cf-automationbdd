package com.cfspl.nbfc.apphooks;

import com.cfspl.nbfc.factory.DriverFactory;
import com.cfspl.nbfc.util.ScreenShotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Raghu Prasad
 */
public class ApplicationHooks {


    private WebDriver driver;
    private DriverFactory driverFactory;

    @Before(order = 0)
    public void launchBrowser() {
        driverFactory = new DriverFactory();
        driver = driverFactory.init();
    }
    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            String screenShotName = scenario.getName().replaceAll("", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",screenShotName);
        }
    }



}

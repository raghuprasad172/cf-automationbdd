package com.cfspl.nbfc.util;


import com.cfspl.nbfc.factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.text.SimpleDateFormat;

public class ScreenShotUtil extends DriverFactory {

    /**
     * This method is used to take screenshot of the current webpage
     * @param testMethodName
     * @return
     */
    public static String takePageScreenShot(String testMethodName) {
        String dateName = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        String destination = System.getProperty("user.dir") + "/screenshots/" + testMethodName + "_" + dateName + ".png";
        try {
            TakesScreenshot screenShot = (TakesScreenshot) driver;
            org.apache.commons.io.FileUtils.copyFile(screenShot.getScreenshotAs(OutputType.FILE), new File(destination));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return destination;
    }
}

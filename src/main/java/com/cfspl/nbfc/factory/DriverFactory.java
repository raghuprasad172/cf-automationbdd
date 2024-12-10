package com.cfspl.nbfc.factory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cfspl.nbfc.constants.IConstants;
import com.cfspl.nbfc.listeners.WebEventLogListener;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

/**
 * @author Raghu Prasad
 */
public class DriverFactory {

    public static WebDriver driver;
    public static Properties properties;
    public static DesiredCapabilities capabilities;
    public static String platformName;
    public static String browserName;
    public static String browserVersion;
    public static String deviceName;
    public static String deviceVersion;
    public static String testURL;
    public static String hubURL;
    public static WebDriverListener listener;

    public static Wait<WebDriver> wait;
    public static Logger log = LogManager.getLogger();
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public DriverFactory() {
        try {
            FileInputStream fileInputStream = new FileInputStream(IConstants.envConfigFilePath);
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * this method will invoke the browser
     * @return driver
     */
    public WebDriver init() {
        try {
            platformName = properties.getProperty(IConstants.platformName);
            browserName = properties.getProperty(IConstants.browserName);
            browserVersion = properties.getProperty(IConstants.browserVersion);
            testURL = properties.getProperty(IConstants.testURL);
            hubURL = properties.getProperty(IConstants.hubURL);
            deviceName = properties.getProperty(IConstants.deviceName);
            deviceVersion = properties.getProperty(IConstants.deviceVersion);
            if (platformName.equalsIgnoreCase("Windows 11")) {
                if (browserName.equalsIgnoreCase("chrome") && browserVersion.equalsIgnoreCase("stable")) {
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
                    capabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
                    driver = new RemoteWebDriver(new URL(properties.getProperty(IConstants.hubURL)), capabilities);
                    driverThreadLocal.set(driver);
                    listener = new WebEventLogListener();
                    driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.EXPLICIT_WAIT));
                    log.atInfo().log(browserName + " browser launched");
                    getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IConstants.PAGE_LOAD_TIMEOUT));
                    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.IMPLICIT_WAIT));
                    getDriver().manage().window().maximize();
                    log.atInfo().log(browserName + " maximized");
                } else if (browserName.equalsIgnoreCase("firefox") && browserVersion.equalsIgnoreCase("stable")) {
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
                    capabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
                    driver = new RemoteWebDriver(new URL(properties.getProperty(IConstants.hubURL)), capabilities);
                    driverThreadLocal.set(driver);
                    listener = new WebEventLogListener();
                    driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.EXPLICIT_WAIT));
                    log.atInfo().log(browserName + " browser launched");
                    getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IConstants.PAGE_LOAD_TIMEOUT));
                    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.IMPLICIT_WAIT));
                    getDriver().manage().window().maximize();
                    log.atInfo().log(browserName + " maximized");
                } else if (browserName.equalsIgnoreCase("MicrosoftEdge") && browserVersion.equalsIgnoreCase("stable")) {
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
                    capabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
                    driver = new RemoteWebDriver(new URL(properties.getProperty(IConstants.hubURL)), capabilities);
                    driverThreadLocal.set(driver);
                    listener = new WebEventLogListener();
                    driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.EXPLICIT_WAIT));
                    log.atInfo().log(browserName + " browser launched");
                    getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IConstants.PAGE_LOAD_TIMEOUT));
                    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.IMPLICIT_WAIT));
                    getDriver().manage().window().maximize();
                    log.atInfo().log(browserName + " maximized");
                }
            } else if (platformName.equalsIgnoreCase("mac")) {
                if (browserName.equalsIgnoreCase("chrome") && browserVersion.equalsIgnoreCase("stable")) {
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
                    capabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
                    driver = new RemoteWebDriver(new URL(properties.getProperty(IConstants.hubURL)), capabilities);
                    driverThreadLocal.set(driver);
                    listener = new WebEventLogListener();
                    driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.EXPLICIT_WAIT));
                    log.atInfo().log(browserName + " browser launched");
                    getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IConstants.PAGE_LOAD_TIMEOUT));
                    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.IMPLICIT_WAIT));
                    getDriver().manage().window().maximize();
                    log.atInfo().log(browserName + " maximized");
                } else if (browserName.equalsIgnoreCase("firefox") && browserVersion.equalsIgnoreCase("stable")) {
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
                    capabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
                    driver = new RemoteWebDriver(new URL(properties.getProperty(IConstants.hubURL)), capabilities);
                    driverThreadLocal.set(driver);
                    listener = new WebEventLogListener();
                    driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.EXPLICIT_WAIT));
                    log.atInfo().log(browserName + " browser launched");
                    getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IConstants.PAGE_LOAD_TIMEOUT));
                    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.IMPLICIT_WAIT));
                    getDriver().manage().window().maximize();
                    log.atInfo().log(browserName + " maximized");
                } else if (browserName.equalsIgnoreCase("MicrosoftEdge") && browserVersion.equalsIgnoreCase("stable")) {
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
                    capabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
                    driver = new RemoteWebDriver(new URL(properties.getProperty(IConstants.hubURL)), capabilities);
                    driverThreadLocal.set(driver);
                    listener = new WebEventLogListener();
                    driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.EXPLICIT_WAIT));
                    log.atInfo().log(browserName + " browser launched");
                    getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IConstants.PAGE_LOAD_TIMEOUT));
                    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.IMPLICIT_WAIT));
                    getDriver().manage().window().maximize();
                    log.atInfo().log(browserName + " maximized");
                }
            } else if (platformName.equalsIgnoreCase("android")) {
                if (deviceName.equalsIgnoreCase("Galaxy_Nexus_API_31") && deviceVersion.equalsIgnoreCase("12")) {
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
                    capabilities.setCapability("appium:deviceName", deviceName);
                    capabilities.setCapability("appium:platformVersion", deviceVersion);
                    driver = new AndroidDriver(new URL(properties.getProperty(IConstants.hubURL)), capabilities);
                    driverThreadLocal.set(driver);
                    listener = new WebEventLogListener();
                    driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.EXPLICIT_WAIT));
                    log.atInfo().log(deviceName + " app launched");
                    getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IConstants.PAGE_LOAD_TIMEOUT));
                    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.IMPLICIT_WAIT));

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDriver();
    }

    public void quit() {
        try {
            driver.quit();
            log.atInfo().log(browserName + " browser closed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * this is used to get the driver with ThreadLocal
     *
     * @return
     */
    public static synchronized WebDriver getDriver() {
        return driverThreadLocal.get();
    }


}

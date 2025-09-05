package org.example;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.devtools.v102.page.Page.captureScreenshot;

public class BaseTest {

    WebDriver webDriver;
    private String browserName = "chrome";

    @BeforeTest


    public void setUp() {

        if ("chrome".equalsIgnoreCase(browserName)) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-notifications");
            options.addArguments("disable-popup-blocking");
            options.addArguments("start-maximized");
            options.addArguments("--remote-allow-origins=*");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            webDriver = new ChromeDriver(options);
            webDriver.manage().deleteAllCookies();
            webDriver.manage().window().maximize();
            webDriver.navigate().to("https://useinsider.com/");


        } else if ("safari".equalsIgnoreCase(browserName)) {
            SafariOptions options = new SafariOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            webDriver = new SafariDriver(options);
            webDriver.manage().deleteAllCookies();
            webDriver.manage().window().maximize();
            webDriver.navigate().to("https://useinsider.com/");
            webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);


        }
    }


    @AfterTest
    public void tearDown() {
        System.out.println("Test Is Over ");
       // webDriver.quit();
    }

    @AfterMethod
    public void screenshotCapture(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
             {
                if (result.getStatus() == ITestResult.FAILURE) {
                    try {
                        TakesScreenshot screenshot = (TakesScreenshot) webDriver;
                        File source = screenshot.getScreenshotAs(OutputType.FILE);
                        FileHandler.copy(source, new File("screenshots/" + result.getName() + ".png"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

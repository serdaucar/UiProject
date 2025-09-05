package org.example.helper;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class BasePage {
    protected static WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void sendKeys(By by, CharSequence text) {
        WebElement element = findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }

    public void clickElement(By by) {
        WebElement element = findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }


    /* public void hoverElement(By by){
         wait.until(ExpectedConditions.visibilityOfElementLocated(by));
         getActions().moveToElement(findElement(by)).build().perform();
     }
     public Actions getActions(){
         return new Actions(driver);
     }
     */
    protected void assertTextEquals(By by, String expectedText) {
        String actualText = getText(by);
        Assert.assertEquals(actualText, expectedText);
    }

    public void assertElementIsDisplayed(By by) {
        Assert.assertTrue(findElement(by).isDisplayed());
    }

    public void assertUrl(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedUrl));
    }

    public String getText(By byElement) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byElement)).getText();
    }

    public WebElement findElementWithLinkText(String linkText) {
        return findElement(By.linkText(linkText));
    }

    public void isDisplayedAndEnable(String element1) {
        WebElement element = findElementWithLinkText(element1);
        if (element.isDisplayed() && element.isEnabled()) {
            System.out.println("The button is visible and clickable.");
        } else {
            System.out.println("The button is either not visible or not clickable.");
        }

    }

    public static void staticWait(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (Exception e) {
        }
    }

    public String getAttributeFor(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by)).getAttribute("title");
    }

    public void scrollToElement(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void assertElementTextContains(WebElement element, String expectedText1, String expectedText2) {
        Assert.assertTrue(element.getText().contains(expectedText1) || element.getText().contains(expectedText2));
    }
    public static void assertElementText(WebElement element, String expectedText) {
        Assert.assertEquals(element.getText(), expectedText);
    }

    public static void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    public void switchToWindow() {
        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            if (!currentWindow.equals(window)) {
                driver.switchTo().window(window);
            }
        }
    }
    public static void closeTheTab() {
        driver.close();
    }

    public static void goBackToMainTab() {
        ArrayList<String> mainTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(mainTab.get(0));
    }
}

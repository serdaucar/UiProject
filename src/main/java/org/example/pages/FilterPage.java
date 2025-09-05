package org.example.pages;

import org.example.helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class FilterPage extends BasePage {

    public FilterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By cookie = By.cssSelector("a[id='wt-cli-accept-all-btn']");
    private By filterLocation = By.id("select2-filter-by-location-container");
    private By filterForDepartment = By.cssSelector("span[title='Quality Assurance']");
    private By getFilterForDepartmentIfNeeded = By.id("select2-filter-by-department-container");
    private By selectQaIfNeeded = By.xpath("//li[contains(@id, 'Quality Assurance')]");
    private By totalAmountOfJobQuantity = By.id("deneme");
    private By specificLocationIstanbul = By.xpath("//li[contains(@id, 'Istanbul, Turkey')]");

    public String expectedURL = "https://jobs.lever.co/useinsider";

    public void clickFilterToOpenToLocation() {
        clickElement(cookie);
        clickElement(filterLocation);
        staticWait(2);
        clickElement(specificLocationIstanbul);

    }

    public void clickFilterToOpenToDepertmant() {
        String jobTitle = getAttributeFor(filterForDepartment);
        if (jobTitle.equalsIgnoreCase("Quality Assurance")) {
            System.out.println("The Title Which Is You Already Looking For Is Selected");
        } else {
            clickElement(getFilterForDepartmentIfNeeded);
            staticWait(2);
            clickElement(selectQaIfNeeded);
        }
    }

    public void checkPositionsOnPage(String positionTitle, String shortPosition, String positionDepartment, String positionLocation) {
        staticWait(2);
        String s = getText(totalAmountOfJobQuantity);
        //  System.out.println(s); check is it okey or not

        scrollToElement(totalAmountOfJobQuantity);
        staticWait(2);
        int totalPositions = Integer.parseInt(getText(totalAmountOfJobQuantity));

        for (int i = 1; i <= totalPositions; i++) {
            assertElementTextContains(findElement(By.xpath("(//p[contains(@class, 'position-title')])[" + i + "]")), positionTitle, shortPosition);
            assertElementText(findElement(By.xpath("(//span[contains(@class, 'position-department')])[" + i + "]")), positionDepartment);
            assertElementText(findElement(By.xpath("(//div[contains(@class, 'position-location')])[" + i + "]")), positionLocation);
        }
    }

    public void verifyApplyNowButtonNavigation() {
        int totalResult = Integer.parseInt(getText(totalAmountOfJobQuantity));
        for (int i = 1; i <= totalResult; i++) {
            WebElement element12 = driver.findElement(By.xpath("(//a[text()= 'View Role'])[" + i + "]"));
            staticWait(2);
            jsClick(element12);
            switchToWindow();
            assertUrl(expectedURL);
            closeTheTab();
            goBackToMainTab();

        }
    }

 // check the elements
}

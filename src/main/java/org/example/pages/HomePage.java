package org.example.pages;

import org.example.helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By homePageTitleText = By.cssSelector("div[class='slide-text']>span>b");
    private By companyButton = By.xpath("(//a[@id='navbarDropdownMenuLink'])[5]");

    private By careersButton = By.xpath("(//a[@class='dropdown-sub'])[18]");

    public String expectedTextOfHomePage = "Insider named a Leader in the 2023 Gartner® Magic Quadrant™ for Personalization Engines";


   /* public String getTextOfHomePage() {
        String actualText = getText(homePageTitleText);
        return actualText;
    }*/

    public void clickCompanyButton() {
        clickElement(companyButton);
    }

    public void clickCareersButton() {
        clickElement(careersButton);
    }

    public void checkTitleOfHomePage(){
        assertTextEquals(homePageTitleText,expectedTextOfHomePage);

    }


}

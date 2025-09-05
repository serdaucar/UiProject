package org.example.pages;

import org.example.helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {

    public CareersPage(WebDriver driver) {
        super(driver);
        this.driver =driver;
    }
    public String expectedCareersPageUrl = "https://useinsider.com/careers/";
    public String expectedTextTeams = "Find your calling";
    public String expectedTextOurLocation = "Our Locations";
    public String expectedInfoTextOfLocation = "25 offices across 5 continents, home to 600+ Insiders";
    public String expectedLifeAtInsiderTitle = "Life at Insider";
    public String getExpectedLifeAtInsiderText = "We’re here to grow and drive growth—as none of us did before." +
            " Together, we’re building a culture that inspires us to create our life’s work—and creates a bold(er) impact. " +
            "We know that we’re smarter as a group than we are alone. Become one of us if you dare to play bigger.";

    private By actualTextOfTeams = By.cssSelector("div[class='col-12 mb-xl-5 py-xl-4 py-2 text-center']>h3");
    private By actualTextOfOurLocations = By.cssSelector("div[class='col-12 col-md-6']>h3");

    private By actualInfoTextOfLocation = By.cssSelector("p[class='mt-5 mb-0 mt-lg-0 mx-auto pl-0']");

    private By teamsBlock = By.id("career-find-our-calling");
    private By locationBlock = By.id("career-our-location");
    private By lifeAtInsiderBlock = By.xpath("//section[@data-id='a8e7b90']");
    private By actualLifeAtInsiderTitle = By.xpath("(//h2[@class='elementor-heading-title elementor-size-default'])[2]");
    private By actualLifeAtInsiderText= By.xpath("(//div[@class='elementor-widget-container'])[14]/p");

    public void checkUrlOfCareersPage(){
        assertUrl(expectedCareersPageUrl);
    }


    public void checkTeamsBlockOnPage(){
        assertElementIsDisplayed(teamsBlock);
        assertTextEquals(actualTextOfTeams,expectedTextTeams);
        findElementWithLinkText("See all teams");
        isDisplayedAndEnable("See all teams");

    }
    public void checkTextOfOurLocations(){
        assertElementIsDisplayed(locationBlock);
        assertTextEquals(actualTextOfOurLocations,expectedTextOurLocation);
        assertTextEquals(actualInfoTextOfLocation,expectedInfoTextOfLocation);
    }

    public void checkLifeAtInsiderBlock() {
        assertElementIsDisplayed(lifeAtInsiderBlock);
        assertTextEquals(actualLifeAtInsiderTitle,expectedLifeAtInsiderTitle);
        assertTextEquals(actualLifeAtInsiderText,getExpectedLifeAtInsiderText );
    }

    public void navitageRequestedPage(){
        navigateTo("https://useinsider.com/careers/quality-assurance/");
    }


   /* public String getCareersPageUrl(){
        String currentCareersUrl = driver.getCurrentUrl();
        return currentCareersUrl;
    }*/
   /* public String getTextOfTeams(){
        String actualTextForTeams = getText(textOfTeams);
        return actualTextForTeams;
    }*/
}





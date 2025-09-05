package org.example;

import org.example.pages.CareersPage;
import org.example.pages.FilterPage;
import org.example.pages.HomePage;
import org.example.pages.QualityAssurancePage;
import org.testng.annotations.Test;

public class TestCase extends BaseTest {


    @Test(priority = 0)
    public void homePageTests() {
        HomePage homePage = new HomePage(webDriver);
        homePage.checkTitleOfHomePage();
        homePage.clickCompanyButton();
        homePage.clickCareersButton();
    }

    @Test(priority = 1)
    public void careersPageTests() {
        CareersPage careersPage = new CareersPage(webDriver);
        careersPage.checkUrlOfCareersPage();
        careersPage.checkTeamsBlockOnPage();
        careersPage.checkTextOfOurLocations();
        careersPage.checkLifeAtInsiderBlock();
        careersPage.navitageRequestedPage();
    }

    @Test(priority = 2)
    public void qualityAssurancePageTests(){
        QualityAssurancePage qualityAssurancePage = new QualityAssurancePage(webDriver);
        qualityAssurancePage.clickSeeAllButton();
    }
    @Test(priority = 3)
    public void filterPageTests(){
        FilterPage filterPage = new FilterPage(webDriver);
        filterPage.clickFilterToOpenToLocation();
        filterPage.clickFilterToOpenToDepertmant();
        filterPage.checkPositionsOnPage("Quality Assurance", "QA", "Quality Assurance", "Istanbul, Turkey");
        filterPage.verifyApplyNowButtonNavigation();
    }

}

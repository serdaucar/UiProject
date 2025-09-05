package org.example.pages;

import org.example.helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QualityAssurancePage extends BasePage {
    public QualityAssurancePage(WebDriver driver) {
        super(driver);
        this.driver= driver;
    }

    private By seeAllQaJobsButton = By.cssSelector("a[href='https://useinsider.com/careers/open-positions/?department=qualityassurance']");
    public void clickSeeAllButton(){
        clickElement(seeAllQaJobsButton);
    }
}

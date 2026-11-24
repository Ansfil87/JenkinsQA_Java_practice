package school.redrover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FolderConfigurationPage extends BasePage{

    private final By submitButton = By.name("Submit");

    public FolderConfigurationPage(WebDriver driver)  {
        super(driver);
    }

    public FolderStatusPage clickSave() {
        getWait5().until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        getWait5().until(ExpectedConditions.not(ExpectedConditions.urlContains("/configure")));

        return new FolderStatusPage(getDriver());
    }
}

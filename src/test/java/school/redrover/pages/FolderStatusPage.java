package school.redrover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FolderStatusPage extends BasePage{

    public FolderStatusPage(WebDriver driver) {
        super(driver);
    }

    public String getHeading() {
        return getDriver().findElement(By.tagName("h1")).getText();
    }

    public String getDescription() {
        return getDriver().findElement(By.id("view-message")).getText();
    }

    public FolderConfigurationPage clickConfigure() {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/configure')]"))).click();

        return new FolderConfigurationPage(getDriver());
    }
}

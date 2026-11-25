package school.redrover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FolderConfigurationPage extends BasePage {

    private final By submitButton = By.name("Submit");
    private final By displayField = By.xpath("//input[@name='_.displayNameOrNull']");
    private final By descriptionField = By.xpath("//textarea[@name='_.description']");
    private final By applyButton = By.name("Apply");
    private final By notificationBar = By.id("notification-bar");

    public FolderConfigurationPage(WebDriver driver) {
        super(driver);
    }

    public FolderStatusPage clickSave() {
        getWait5().until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        getWait5().until(ExpectedConditions.not(ExpectedConditions.urlContains("/configure")));

        return new FolderStatusPage(getDriver());
    }

    public FolderConfigurationPage sendDisplayName(String displayName) {
        getDriver().findElement(displayField).sendKeys(displayName);

        return this;
    }

    public FolderConfigurationPage sendDescription(String description) {
        WebElement field = getDriver().findElement(descriptionField);
        field.clear();
        field.sendKeys(description);

        return this;
    }

    public FolderConfigurationPage clickApply() {
        getDriver().findElement(applyButton).click();

        return this;
    }

    public String getNotificationText() {
        return getWait5().until(ExpectedConditions.visibilityOfElementLocated(notificationBar)).getText();
    }


}

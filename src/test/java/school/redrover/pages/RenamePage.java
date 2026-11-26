package school.redrover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RenamePage extends BasePage{

    private final By renameField = By.name("newName");
    private final By renameButton = By.name("Submit");

    public RenamePage(WebDriver driver) {
        super(driver);
    }

public RenamePage clearAndSendName(String rename) {
        WebElement field = getDriver().findElement(renameField);
        field.clear();
        field.sendKeys(rename);

        return this;
}

public FolderStatusPage clickButtonRename() {
    getDriver().findElement(renameButton).click();
    getWait5().until(ExpectedConditions.not(ExpectedConditions.urlContains("confirm-rename")));

    return new FolderStatusPage(getDriver());
}


}

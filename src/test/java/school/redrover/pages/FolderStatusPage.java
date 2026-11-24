package school.redrover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}

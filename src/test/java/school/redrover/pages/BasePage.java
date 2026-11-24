package school.redrover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class BasePage extends BaseModel {

    private final By jenkinsLogo = By.xpath("//a[@class='app-jenkins-logo']");

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        getDriver().findElement(jenkinsLogo).click();

        return new HomePage(getDriver());
    }
}


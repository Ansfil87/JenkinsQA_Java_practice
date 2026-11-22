package school.redrover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class BasePage extends BaseModel {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        getDriver().findElement(By.xpath("//a[@class='app-jenkins-logo']")).click();

        return new HomePage(getDriver());
    }
}


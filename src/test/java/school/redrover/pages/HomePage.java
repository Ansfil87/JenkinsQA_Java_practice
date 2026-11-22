package school.redrover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public NewItemPage clickNewItem() {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//span[normalize-space()='New Item']]"))).click();

        return new NewItemPage(getDriver());
    }

    public List<String> getItemNames() {
        return getDriver().findElements(By.cssSelector(".jenkins-table__link > span:first-child"))
                .stream()
                .map(WebElement::getText)
                .toList();
    }
}

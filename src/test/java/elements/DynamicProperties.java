package elements;

import data.Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by Lera on 13.06.2022
 */
public class DynamicProperties extends Options {
    //private WebDriver driver;
    private WebDriverWait wait;

    private By enableButton=By.xpath("//button[@id='enableAfter']");
    private By colorChangeButton=By.xpath("//button[@id='colorChange']");
    private By visibleButton=By.xpath("//button[@id='visibleAfter']");

    private static Color RED_COLOR  = Color.fromString("rgba(220, 53, 69, 1)");

    public WebElement getEnableButton() {
        return $(enableButton);
    }

    public WebElement getColorChangeButton() {
        return $(colorChangeButton);
    }

    public WebElement getVisibleButton() {
        return $(visibleButton);
    }

    public DynamicProperties clickEnable(){
        WebElement enableBut=$(enableButton);
        wait=new WebDriverWait(getWebDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(enableBut));
        enableBut.click();
        return this;
    }
        public Boolean changeColor(){
        WebElement colorChangeBut=$(colorChangeButton);
        if (getColorChangeButton().getCssValue("color").equals(RED_COLOR.asRgba())) {
            return true;
        }
        return false;
    }
    public Boolean clickColorChangeButton(){
        wait=new WebDriverWait(getWebDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.attributeToBe(getColorChangeButton(),"color", RED_COLOR.asRgba()));
        $(colorChangeButton).click();
        return true;
    }
    public Boolean clickVisible(){
        WebElement visibleBut=$(visibleButton);
        wait=new WebDriverWait(getWebDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(visibleBut));
        visibleBut.click();
        return true;
    }
}

package alertsFrameWindows;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import data.Options;
import data.RandomDataGenerator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by Lera on 17.06.2022
 */
public class Alerts extends Options {
    private WebDriverWait wait;
    private String NAME=RandomDataGenerator.getRandomName();

    private By clickButton=By.xpath("//button[@id='alertButton']");
    private By clickAfterSeconds=By.xpath("//button[@id='timerAlertButton']");
    private By clickConfirmBox=By.xpath("//button[@id='confirmButton']");
    private By clickPromptBox=By.xpath("//button[@id='promtButton']");
    private By resultConfirm=By.xpath("//span[@id='confirmResult']");
    private By resultPrompt=By.xpath("//span[@id='promptResult']");


    public String getNAME() {
        return NAME;
    }

    public Alerts clickButtonAlert(){
        $(clickButton).click();
        switchTo().alert().accept();
        return this;
    }

    public String clickAfterSeconds(){
        String alertText="";
        Alert alert;
        try {
             $(clickAfterSeconds).click();
            Thread.sleep(6000);
            getWebDriver().switchTo().alert().accept();
        } catch (UnhandledAlertException | InterruptedException f) {
            alert = getWebDriver().switchTo().alert();
            alertText = alert.getText();
            System.out.println("Alert data: " + alertText);
            alert.accept();
        }
        return alertText;
    }

    public Alerts clickConfirm(){
        $(clickConfirmBox).click();
        switchTo().alert().accept();
        return this;
    }

    public Alerts clickPrompt(){
        $(clickPromptBox).click();
        try {
            Thread.sleep(2000);
            switchTo().alert().sendKeys(NAME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switchTo().alert().accept();
        return this;
    }

    public String getResultConfirm(){
        return $(resultConfirm).getText();
    }

    public String getResultPrompt(){
        return $(resultPrompt).getText();
    }


}

package alertsFrameWindows;

import com.codeborne.selenide.Selenide;
import data.Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class BrowserWindows extends Options {
   // private WebDriver driver;

    private By newTab=By.xpath("//button[@id='tabButton']");
    private By newWindow=By.xpath("//button[@id='windowButton']");
    private By newWindowMessage=By.xpath("//button[@id='messageWindowButton']");
    private By getTextMessage=By.xpath("//body/text()");
    private By allWindowButton=By.xpath("//div[@id='browserWindows']//button");


    public void clickNewTab(){
        $(newTab).click();
    }

    public void clickNewWindow(){
        $(newWindow).click();
    }

    public void clickNewWindowMessage(){
        $(newWindowMessage).click();
    }
    public Integer countWindows(){
        Set<String> handles= getWebDriver().getWindowHandles();
        return handles.size();
    }
    public String checkWindowsOrTab(){
        String originalHandle=getWebDriver().getWindowHandle();
        for (String windowHandle:
                getWebDriver().getWindowHandles()) {
            if (!originalHandle.equals(windowHandle)){
                getWebDriver().switchTo().window(windowHandle);
                System.out.println(getWebDriver().getCurrentUrl());
            }
        }
        return getWebDriver().getCurrentUrl();
    }


}

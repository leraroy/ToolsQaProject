package alertsFrameWindows;

import data.Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Lera on 18.06.2022
 */
public class ModalDialogs extends Options {
    private WebDriver driver;

    private By smallModal=By.xpath("//button[@id='showSmallModal']");
    private By largeModal=By.xpath("//button[@id='showLargeModal']");
    private By textModal=By.xpath("//div[@class='modal-body']");
    private By closeSmallButton=By.xpath("//button[@id='closeSmallModal']");
    private By closeLargeButton=By.xpath("//button[@id='closeLargeModal']");


    public ModalDialogs clickSmallModal(){
        $(smallModal).click();
        return this;
    }

    public ModalDialogs clickLargeModal(){
        $(largeModal).click();
        return this;
    }

    public String getTextSmallModal(){
        String result=null;
        try {
            Thread.sleep(5000);
            result=$(textModal).getText();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void getTextLargeModal() {
        WebElement text=$(textModal);
        textIntoFile("src/main/resources/actual.txt", text);
    }

    public ModalDialogs closeSmallModal(){
        $(closeSmallButton).click();
        return this;
    }

    public ModalDialogs closeLargeModal(){
        $(closeLargeButton).click();
        return this;
    }
}

package elements;

import com.codeborne.selenide.Selenide;
import data.Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;


public class Buttons extends Options {
   // private WebDriver driver;

    private By doubleClick=By.xpath("//*[@id='doubleClickBtn']");
    private By rightClick=By.xpath("//*[@id='rightClickBtn']");
    private By clickMe=By.xpath("//*[text()='Click Me']");
    private By textDoubleClick=By.xpath("//*[contains(text(), 'double click')]");
    private By textRightClick=By.xpath("//*[contains(text(), 'right click')]");
    private By textClickMe=By.xpath("//*[contains(text(), 'dynamic click')]");


    public Buttons clickDoubleClick(){
        Selenide.actions().doubleClick($(doubleClick)).build().perform();
        return this;
    }

    public Buttons clickRightClick(){
        Selenide.actions().contextClick($(rightClick)).build().perform();
        return this;
    }

    public Buttons clickMe(){
        $(clickMe).click();
        return this;
    }

    public String getMessageDoubleClick(){
        return $(textDoubleClick).getText();
    }

    public String getMessageRightClick(){
        return $(textRightClick).getText();
    }

    public String getMessageClickMe(){
        return $(textClickMe).getText();
    }
}

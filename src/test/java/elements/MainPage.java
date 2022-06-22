package elements;

import data.Options;
import elements.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Lera on 05.06.2022
 */
public class MainPage extends Options {
    //private WebDriver driver;

    private By elements= By.xpath("//h5[text()='Elements']");
    private By forms=By.xpath("//h5[text()='Forms']");
    private By alertsFrame =By.xpath("//*[starts-with(h5,'Alerts')]");
    private By widgets=By.xpath("//h5[text()='Widgets']");
    private By interactions=By.xpath("//h5[text()='Interactions']");
    private By bookStore=By.xpath("//*[starts-with(h5,'Book')]");


    public Elements clickElements(){
        $(elements).click();
        return new Elements();
    }


}

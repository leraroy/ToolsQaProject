package elements;

import data.Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Lera on 07.06.2022
 */
public class RadioButton extends Options {
    //private WebDriver driver;

    private By yesButt=By.xpath("//label[@for='yesRadio']");
    private By impressiveBut=By.xpath("//label[@for='impressiveRadio']");
    private By noBut=By.xpath("//label[@for='noRadio']");
    private By textSelected=By.xpath("//p[@class='mt-3']");


    public RadioButton clickYes(){
        $(yesButt).click();
        return this;
    }

    public RadioButton clickNo(){
        $(noBut).click();
        return this;
    }

    public Boolean clickNoIsSelected(){
        return $(noBut).isSelected();
    }

    public RadioButton clickImpressive(){
        $(impressiveBut).click();
        return this;
    }

    public String getTextResult(){
        System.out.println($(textSelected).getText());
        return $(textSelected).getText();
    }

}

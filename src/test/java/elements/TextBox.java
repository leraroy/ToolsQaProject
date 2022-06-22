package elements;

import data.Options;
import data.RandomDataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


/**
 * Created by Lera on 03.06.2022
 */
public class TextBox extends Options {
    //private WebDriver driver;

    private static String NAME = RandomDataGenerator.getRandomName();
    private static String EMAIL = RandomDataGenerator.getRandomEmail();
    private static String CURRENT_ADDRESS = RandomDataGenerator.getRandomAddress();
    private static String PERMANENT_ADDRESS = RandomDataGenerator.getRandomAddress();

    private By fullName = By.xpath("//input[@id='userName']");
    private By email = By.xpath("//input[@id='userEmail']");
    private By currentAddress = By.xpath("//textarea[@id='currentAddress']");
    private By permanentAddress = By.xpath("//textarea[@id='permanentAddress']");
    private By submit = By.xpath("//button[@id='submit']");
    private By output = By.xpath("//div[@id='output']//p");
    private By errorField=By.xpath("//input[contains(@class,'field-error')]");


    public String getNAME() {
        return NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getCurrentAddress() {
        return CURRENT_ADDRESS;
    }

    public String getPermanentAddress() {
        return PERMANENT_ADDRESS;
    }


    public TextBox enterName() {
        $(fullName).sendKeys(NAME);
        return this;
    }

    public TextBox enterEmail() {
        $(email).sendKeys(EMAIL);
        return this;
    }

    public TextBox enterCurrentAddress() {
        $(currentAddress).sendKeys(CURRENT_ADDRESS);
        return this;
    }

    public TextBox enterPermanentAddress() {
        $(permanentAddress).sendKeys(PERMANENT_ADDRESS);
        return this;
    }

    public TextBox scrollToSubmit() {
        $(submit).scrollTo();
        return this;
    }

    public TextBox clickSubmit() {
        $(submit).click();
        return this;
    }
    public String emailFieldError(){
        WebElement emailField=$(email);
        String color=null;
        try {
            Thread.sleep(200);
            color= emailField.getCssValue("border-top-color");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Border color: "+color);
        System.out.println(Color.fromString("red"));
        return color;
    }

    public TextBox fillTextBox() {
        enterName();
        enterEmail();
        enterPermanentAddress();
        enterCurrentAddress();
        scrollToSubmit();
        clickSubmit();
        return this;
    }

    public TextBox failFillTextBox(){
        $(fullName).sendKeys("!");
        $(email).sendKeys( "!");
        $(currentAddress).sendKeys("!");
        $(permanentAddress).sendKeys("!");
        scrollToSubmit();
        clickSubmit();
        return this;
    }

    public boolean outputIsDisplayed(){
       return $(output).isDisplayed();
    }

    public List<String> outputTextBox() {
        List<WebElement> outputs = getWebDriver().findElements(output);
        List<String> result=new ArrayList<>();
        if (outputs.size() == 4) System.out.println("It's OK");
        for (int i=0; i< outputs.size(); i++){
            System.out.println(outputs.get(i).getText());
            System.out.println();
            String[] subStr1;
            String delimeter = ":";
            subStr1 = (outputs.get(i).getText().split(delimeter));
            for (int j=1; j<subStr1.length; j++) {
                result.add(subStr1[j]);
            }
        }
        for (String str:
             result) {
            System.out.println(str);
        }
        return result;
    }
}
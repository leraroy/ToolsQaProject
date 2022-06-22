package BookStoreApplication.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class RegisterPage {
    //private WebDriver driver;
    private final Color INVALID_FIELD = Color.fromString("#dc3545");
    private Actions actions;

    private By firstName = By.xpath("//input[@id='firstname']");
    private By lastName = By.xpath("//input[@id='lastname']");
    private By userName = By.xpath("//input[@id='userName']");
    private By password = By.xpath("//input[@id='password']");
    private By reCaptcha = By.xpath("//div[@class='recaptcha-checkbox-border']");
    private By registerBtn = By.xpath("//button[@id='register']");
    private By backToLogin = By.xpath("//button[@id='gotologin']");

    public RegisterPage typeFirstName(String firstname) {
        $(firstName).sendKeys(firstname);
        return this;
    }

    public RegisterPage typeLastName(String lastname) {
        $(lastName).sendKeys(lastname);
        return this;
    }

    public RegisterPage typeUserName(String username) {
        $(userName).sendKeys(username);
        return this;
    }

    public RegisterPage typePassword(String password) {
        $(this.password).scrollTo();
        $(this.password).sendKeys(password);
        return this;
    }

    public void clickReCaptcha() {
            new WebDriverWait(getWebDriver(), Duration.ofSeconds(10)).until(
                    ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                            By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")
                    ));

            new WebDriverWait(getWebDriver(), Duration.ofSeconds(20)).until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector("div.recaptcha-checkbox-checkmark")
                    )
            ).click();
    }

    public RegisterPage clickRegisterBtn() {
        $(registerBtn).click();
        return new RegisterPage();
    }
    public RegisterPage fillInAccount(String firstname, String lastname, String username, String password){
        this.typeFirstName(firstname);
        System.out.println("FirsName");
        this.typeLastName(lastname);
        System.out.println("LastName");
        this.typeUserName(username);
        System.out.println("UserName");
        this.typePassword(password);
        System.out.println("Password");
        try {
            Thread.sleep(1000);
            this.clickReCaptcha();
            System.out.println("reCaptcha");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.clickRegisterBtn();
        return new RegisterPage();
    }

    public LoginPage clickBackToLogin() {
        $(backToLogin).click();
        return new LoginPage();
    }

    public boolean checkInvalidField() {
        List<By> elements = List.of(new By[]{
                firstName, lastName, userName, password
        });
        for (By el : elements) {
            String color = $(el).getCssValue("border-color");
            if (color.equals(INVALID_FIELD.asHex())) {
                return true;
            }
        }
        return false;
    }
}


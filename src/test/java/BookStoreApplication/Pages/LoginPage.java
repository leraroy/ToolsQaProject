package BookStoreApplication.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Lera on 23.02.2022
 */
public class LoginPage {
   // private WebDriver driver;

    private By username=By.xpath("//input[@id='userName']");
    private By password=By.xpath("//input[@id='password']");
    private By loginBtn=By.xpath("//button[@id='login']");
    private By newUser=By.xpath("//button[@id='newUser']");

    public LoginPage typeUsername(String username){
        $(this.username).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){
        $(this.password).sendKeys(password);
        return this;
    }

    public void clickLogin(){
        $(loginBtn).click();
    }

    public void clickNewUser(){
        $(newUser).click();
    }

}

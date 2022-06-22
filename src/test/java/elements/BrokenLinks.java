package elements;

import data.Options;
import io.opentelemetry.api.trace.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by Lera on 12.06.2022
 */
public class BrokenLinks extends Options {
    //private WebDriver driver;

    private By validImage = By.xpath("//p[text()='Valid image']/following-sibling::img[1]");
    private By brokenImage = By.xpath("//p[text()='Broken image']/following-sibling::img");
    private By validLink = By.xpath("//a[contains(text(), 'Valid Link')]");
    private By brokenLink = By.xpath("//a[contains(text(), 'Broken Link')]");

    public BrokenLinks() {
        open("https://demoqa.com/broken");
    }

    public BrokenLinks clickBrokenLink(){
        $(brokenLink).scrollTo();
        $(brokenLink).click();
        return this;
    }

    public BrokenLinks getBrokenImage() {
        WebElement brokenImg = $(brokenImage);
        brokenImg.getAttribute("naturalWidth").equals(0);
        System.out.println(brokenImg.getAttribute("outerHTML") + " is broken.");
        return this;
    }

    public BrokenLinks getValidImage() {
        WebElement brokenImg = $(validImage);
        brokenImg.getAttribute("naturalWidth");
        System.out.println(brokenImg.getAttribute("outerHTML") + " is valid.");
        return this;
    }
    public MainPage getValidLink(){
        $(validLink).click();
        return new MainPage();
    }
    public String getHomeUrl(){
        String currentUrl=null;
        for (String handle:
                getWebDriver().getWindowHandles()) {
            switchTo().window(handle);
            currentUrl= getWebDriver().getCurrentUrl();
        }
        return currentUrl;
    }
    public void verifyLinks(String linkUrl) {
        try {
            URL url=new URL(linkUrl);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(4000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode()>=400){
                System.out.println(linkUrl+" "+httpURLConnection.getResponseMessage()+" is a broken link");
            }else {
                System.out.println(linkUrl+" "+httpURLConnection.getResponseMessage()+" is a valid link");

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public int getAllValidImage() {
        Integer iValidImageCount = 0;

        try {
            List<WebElement> image_list = getWebDriver().findElements(By.tagName("img"));

            System.out.println("The page under test has " + image_list.size() + " images");
            for (WebElement img : image_list) {
                if (img.getAttribute("naturalWidth").equals("0")) {
                    continue;
                }else {
                    System.out.println(img.getAttribute("outerHTML") + " is valid.");
                    iValidImageCount++;
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The page has " + iValidImageCount + " valid images");
        return iValidImageCount;
    }

    public int getAllBrokenImage() {
        Integer iBrokenImageCount = 0;

        try {
            List<WebElement> image_list = getWebDriver().findElements(By.tagName("img"));

            System.out.println("The page under test has " + image_list.size() + " images");
            for (WebElement img : image_list) {
                if (img.getAttribute("naturalWidth").equals("0")) {

                    System.out.println(img.getAttribute("outerHTML") + " is broken.");
                    iBrokenImageCount++;
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The page has " + iBrokenImageCount + " broken images");
        return iBrokenImageCount;
    }
}

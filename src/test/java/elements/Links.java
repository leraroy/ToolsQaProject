package elements;

import com.codeborne.selenide.Selenide;
import data.Options;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class Links extends Options {
   // private WebDriver driver;

    private By homeFirst=By.xpath("//a[@id='simpleLink']");
    private By homeSecond=By.xpath("//a[@id='dynamicLink']");

    private By allLinks=By.xpath("//div[@id='linkWrapper']//a");
    private By created =By.xpath("//a[@id='created']");
    private By noContent=By.xpath("//a[@id='no-content']");
    private By moved=By.xpath("//a[@id='moved']");
    private By badRequest=By.xpath("//a[@id='bad-request']");
    private By unauthorized=By.xpath("//a[@id='unauthorized']");
    private By forbidden=By.xpath("//a[@id='forbidden']");
    private By notFound=By.xpath("//a[@id='invalid-url']");
    private By linkResponse=By.xpath("//p[@id='linkResponse']");


    public Links clickCreated(){
        $(created).click();
        return this;
    }
    public Links clickNoContent(){
        $(noContent).click();
        return this;
    }
    public Links clickMoved(){
        $(moved).click();
        return this;
    }
    public Links clickBadRequest(){
        $(badRequest).click();
        return this;
    }
    public Links clickUnauthorized(){
        $(unauthorized).click();
        return this;
    }
    public Links clickForbidden(){
        $(forbidden).scrollTo();
        $(forbidden).click();
        return this;
    }
    public Links clickNotFound(){
        $(notFound).scrollTo();
        $(notFound).click();
        return this;
    }
    public String getTextResponse(){
        return $(linkResponse).getText();
    }
    public Boolean clickableLinksApi(){
        List<WebElement> elements=getWebDriver().findElements(allLinks);
        elements.remove(0);
        elements.remove(0);
        int i=0;
        for (WebElement element:
                elements) {
            $(element).scrollTo();
            System.out.println(element.getText());
            element.click();
            i++;
        }
        if (i==7){
            return true;
        }
        return false;
    }
    public String getHomeUrl(){
        String currentUrl=null;
        for (String handle:
                getWebDriver().getWindowHandles()) {
            getWebDriver().switchTo().window(handle);
            currentUrl= getWebDriver().getCurrentUrl();
        }
        return currentUrl;
    }
    public MainPage clickHomeFirst(){
        $(homeFirst).click();
        return new MainPage();
    }
    public MainPage clickHomeSecond(){
        $(homeSecond).click();
        return new MainPage();
    }

    public int getStatus(String BASE_URL, String URI){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.get(URI);
        return response.getStatusCode();
    }

    public String getTextByStatus(String status){
        String startText="Link has responded with staus ";
        String endText=" and status text ";
        String res = null;

        switch (status){
            case("Created"):
                res= startText+"201"+endText+"Created";
                break;
            case("No Content"):
                res=startText+"204"+endText+"No Content";
                break;
            case("Moved"):
                res=startText+"301"+endText+"Moved Permanently";
                break;
            case("Bad Request"):
                res=startText+"400"+endText+"Bad Request";
                break;
            case("Unauthorized"):
                res=startText+"401"+endText+"Unauthorized";
                break;
            case("Forbidden"):
                res=startText+"403"+endText+"Forbidden";
                break;
            case("Not Found"):
                res=startText+"404"+endText+"Not Found";
                break;
            default:
                break;
        }
        return res;
    }

}

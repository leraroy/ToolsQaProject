package widgets;

import data.Options;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Accordian extends Options {
//    private WebDriver driver;

    private By whatIs=By.xpath("//div[@id='section1Heading']");
    private By where=By.xpath("//div[@id='section2Heading']");
    private By why=By.xpath("//div[@id='section3Heading']");
    private By textWhat=By.xpath("//div[@id='section1Content']/p");
    private By textWhere=By.xpath("//div[@id='section2Content']/p");
    private By textWhy=By.xpath("//div[@id='section3Content']/p");


    public Accordian() {
        open("https://demoqa.com/accordian");
    }

    public Accordian clickWhatIs(){
        //clickElement(whatIs);
        $(whatIs).click();
        return this;
    }

    public Accordian clickWhere(){
        //clickElement(where);
        $(where).click();
        return this;
    }

    public Accordian clickWhy(){
        //clickElement(why);
        $(why).click();
        return this;
    }

    public void getTextWhatIsToFile(){
        WebElement text=$(textWhat);
        textIntoFile("src/main/resources/actual.txt", text);
    }

    public void getTextWhereToFile(){
        WebElement text=$(textWhere);
        textIntoFile("src/main/resources/actual.txt", text);
    }

    public void getTextWhyToFile(){
        WebElement text=$(textWhy);
        textIntoFile("src/main/resources/actual.txt", text);
    }

}

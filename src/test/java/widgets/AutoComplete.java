package widgets;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class AutoComplete {
    private WebDriver driver;

    private By multipleColor=By.xpath("//input[@id='autoCompleteMultipleInput']");
    private By singleColor=By.xpath("//input[@id='autoCompleteSingleInput']");
    private By resultMultiply=By.xpath("(//div[contains(@class,'value-container')])[1]");
    private By resultSingle=By.xpath("(//div[contains(@class,'value-container')])[2]");


    public AutoComplete(WebDriver driver){
        //open("https://demoqa.com/auto-complete");
        this.driver=driver;
    }

    public AutoComplete typeMultipleColor(String letter){
        driver.findElement(multipleColor).sendKeys(letter);
        return this;
    }

    public AutoComplete typeSingleColor(String letter){
        driver.findElement(singleColor).sendKeys(letter);
        return this;
    }
    public String getTextResultSingle(){
        List<WebElement>elements=driver.findElements(resultSingle);
        List<String> text=new ArrayList<>();
        for (WebElement el:
                elements) {
            text.add(el.getText());
            System.out.println(el.getText());
        }
        return String.join("",text);
    }
    public String getTextResultMultiply(){
        List<WebElement>elements=driver.findElements(resultMultiply);
        List<String> text=new ArrayList<>();
        for (WebElement el:
             elements) {
            text.add(el.getText());
            System.out.println(el.getText());
        }
        return String.join("",text);
    }

    public String autoSuggestText(){
        List<WebElement>elements=driver.findElements(By.xpath("//div[contains(@class,'option')]"));
        List<String> text=new ArrayList<>();
        for (WebElement el:
                elements) {
            text.add(el.getText());
            System.out.println(el.getText());
        }
        return String.join("\n",text);
    }

    public List<WebElement> autoSuggest(){
        List<WebElement> elements=driver.findElements(By.xpath("//div[contains(@class,'option')]"));
        for (WebElement el:
             elements) {
            System.out.println(el.getText());
        }
        return elements;
    }
    public void clickColorsMultiple(String letter){
        List<WebElement> elements=autoSuggest();
        System.out.println("elements length "+elements.size());
        int i=0;
        while (i<elements.size()) {
            driver.findElement(By.xpath("//div[@id='react-select-2-option-"+i+"']")).click();
            i++;
            if (i==elements.size()){
                break;
            }
            typeMultipleColor(letter);
        }
    }

    public void clickColor(String color){
        List<WebElement> elements=driver.findElements(By.xpath("//div[contains(@class,'option')]"));
        System.out.println(elements.size());
        for (WebElement el : elements){
            System.out.println("Values are = " + el.getText());
            System.out.println();
            if (el.getText().equalsIgnoreCase(color))
            {
                el.click();
                break;
            }

        }
    }


}

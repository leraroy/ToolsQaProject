package data;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

/**
 * Created by Lera on 05.06.2022
 */
public class Options{
    /*private static WebDriver driver;
    private static WebDriverWait wait;

    public  void clickElement(By by){
        driver.findElement(by).click();
    }
    public  void enter(By by, String str){
        driver.findElement(by).sendKeys(str);
    }
    public void enterKeys(By by){
        driver.findElement(by).sendKeys(Keys.ENTER);
    }
    public  boolean elementIsSelected(By by){
       return driver.findElement(by).isSelected();
    }
    public  WebElement findElement(By by){
      return  driver.findElement(by);
    }
    public  String getTextElement(By by){
        return driver.findElement(by).getText();
    }

    public void waitVisibleOf(WebElement element){
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(by));
    } public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

     */
    public  boolean isEqual(File firstFile, File secondFile)
    {
        try {
            return FileUtils.contentEquals(firstFile, secondFile);
        } catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public void textIntoFile(String PATH, WebElement element ){
        String result = null;

        try (FileWriter writer = new FileWriter(PATH)) {
            new FileOutputStream(PATH).close();
            Thread.sleep(5000);
            result = element.getText();
            for (int i = 0; i < result.length(); i++)
                writer.write(result.charAt(i));
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}

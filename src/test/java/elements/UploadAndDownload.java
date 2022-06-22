package elements;

import data.Options;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class UploadAndDownload extends Options{
    private WebDriver driver;
    private WebDriverWait wait;
    private final static String PATH_DIR="C:\\Users\\Lera\\Downloads\\";
    private final static String PATH="C:\\Users\\Lera\\Downloads\\sampleFile.jpeg";

    private By downloadButton=By.xpath("//a[@id='downloadButton']");
    private By uploadFile=By.xpath("//input[@type='file']");
    private By textPath=By.xpath("//p[@id='uploadedFilePath']");

    public String getPath(){
        return PATH;
    }
    public String getPathDIR(){
        return PATH_DIR;
    }

    public UploadAndDownload(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();
    }

    public  UploadAndDownload downloadFile(){
        driver.findElement(downloadButton).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public double sizeDownloadDirectory(){
        return new File(PATH_DIR).length();
    }
    public double sizeDownloadFile(){
        return new File(PATH).length();
    }
    public UploadAndDownload uploadFile(){
        driver.findElement(uploadFile).sendKeys(PATH);
        return this;
    }
    public WebElement textPath(){
        return driver.findElement(textPath);
    }
    public String getTextPath(){
        return textPath().getText();
    }
    public UploadAndDownload deleteFile(){
        new File(PATH).delete();
        return this;
    }
}

package Tests.elements;

import com.codeborne.selenide.Selenide;
import elements.UploadAndDownload;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Lera on 13.06.2022
 */
public class UploadAndDownloadTest {
     UploadAndDownload uploadAndDownload=new UploadAndDownload();
    private final static String BASE_URL="https://demoqa.com/";
    private File dir;
    private File file;

    @Test
    public void checkDownloadFile(){
        uploadAndDownload.downloadFile();
        dir=new File(uploadAndDownload.getPathDIR());
        file=new File(uploadAndDownload.getPath());
        try {
            Thread.sleep(2000);
            System.out.println(file.getName());
            System.out.println(file.getAbsolutePath());
            Assert.assertTrue(file.exists());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkUploadFile(){
        uploadAndDownload.uploadFile();
        System.out.println(uploadAndDownload.getTextPath());
        Assert.assertTrue(uploadAndDownload.textPath().isDisplayed());
    }
   @Test
    public void checkDeletedFile(){
        File file =new File(uploadAndDownload.getPath());
        System.out.println(file.getName());
        uploadAndDownload.deleteFile();
        Assert.assertTrue(!file.exists());
    }

    @After
    public void tearDown(){
        try {
            Thread.sleep(2000);
            Selenide.closeWebDriver();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class MyAssert {

    private WebDriver driver;

    public MyAssert(WebDriver driver){
        this.driver = driver;
    }

    public void assertEquals(String actual, String expected, String message){
        if (!actual.contentEquals(expected)){
            try {
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFile, new File(srcFile.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Assert.assertEquals(actual, expected, message);
    }

    public void assertTrue(Boolean condition, String message){
        if (!condition){
            try {
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFile, new File(srcFile.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Assert.assertTrue(condition, message);
    }
}

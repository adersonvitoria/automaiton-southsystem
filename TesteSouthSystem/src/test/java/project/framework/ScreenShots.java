package project.framework;

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShots {
    public static String capture(WebDriver driver) {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "./reports/screenshots/" + source.getName();
        return saveImageFile(source, path);
    }

    private static String saveImageFile(File source, String path) {
        try {
            FileUtils.copyFile(source, new File(path));
        } catch(IOException ex) {
            Reports.log(Status.WARNING, "Capture error: " + ex.getMessage());
        }
        return path.replace("./reports/", "");
    }
}

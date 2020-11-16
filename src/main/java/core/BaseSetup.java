package core;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSetup {
    public static WebDriver driver = null;

    public void openBrowser() throws Exception {
        String chromeDriverPath = System.getProperty("user.dir") + "//src//test//resources//lib//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);

    }
    public void testSetup() throws Exception {

      Properties  config = new Properties();
      FileInputStream property = new FileInputStream(
                System.getProperty("user.dir") + "//src//main//resources//config//config.properties");
        config.load(property);
        String baseUrl = config.getProperty("baseUrl");
        System.out.println(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    public static void generateCucumberReport() {
        File reportOutputDirectory = new File("target");
        ArrayList<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber.json");

        String projectName = "sample_report";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addClassifications("Platform", System.getProperty("os.name"));
        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("Branch", "release/1.0");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        openBrowser();
        testSetup();
    }
   @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            String method = result.getName();

                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\screenshots\\";
                    File  destFile = new File((String) reportDirectory+ method +"_" + formater.format(calendar.getTime()) + ".png");
                    FileUtils.copyFile(scrFile, destFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


    @AfterSuite(alwaysRun=true)
    public void generateHTMLReports() {
        generateCucumberReport();
    }

    @AfterSuite(alwaysRun = true)
    public void quit() throws IOException, InterruptedException {
        driver.quit();
    }

}

package stepdef;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.PropertyReader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Hooks {

    private static ExtentReports extentReport;
    public static ExtentTest extentTest;
    private static ExtentSparkReporter sparkReporter;

    @Before
    public void setUp(Scenario scenario) {
        if (extentReport == null) {
            extentReport = generateExtentReport("API_Test_Execution_Report");
        }
        
        extentTest = extentReport.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            extentTest.fail("Scenario failed");
        } else {
            extentTest.pass("Scenario passed");
        }
        if (extentReport != null) {
            extentReport.flush();
        }
    }

    private static ExtentReports generateExtentReport(String reportName) {
        ExtentReports report = new ExtentReports();

        // Get the current timestamp for the report name
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata"); // IST timezone
        dateFormat.setTimeZone(istTimeZone);
        String timestamp = dateFormat.format(new Date());

        // Specify the report folder and filename
        String reportFolder = PropertyReader.loadProperties().getProperty("ExtentReportPath");
        String reportFilePath = reportFolder + reportName + "_" + timestamp + ".html";
        System.out.println("* Extent Report: " + reportFilePath);

        sparkReporter = new ExtentSparkReporter(reportFilePath);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("API Test Execution Status Report");
        sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

        report.attachReporter(sparkReporter);

        return report;
    }
}

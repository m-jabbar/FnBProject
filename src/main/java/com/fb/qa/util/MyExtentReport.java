package com.fb.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtentReport {

    public static ExtentReports generateExtentReport() {
        ExtentReports extentReport = new ExtentReports();
        File extentReportFile = new File(System.getProperty("user.dir") + "/test-output/ExtentReports/extentreport.html");
        ExtentSparkReporter spark = new ExtentSparkReporter(extentReportFile);
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("F&B Test Automation Result Report");
        spark.config().setDocumentTitle("FnB Test Automation Report");
        spark.config().setTimeStampFormat("dd-MM-yyyy hh-mm-ss");
        extentReport.attachReporter(spark);

        Properties configProp = new Properties();
        File configPropFile = new File(System.getProperty("user.dir") + "/src/main/java/com/fb/qa/config/config.properties");
        try {
            FileInputStream fisConfigProp = new FileInputStream(configPropFile);
            configProp.load(fisConfigProp);
            fisConfigProp.close();

            extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
            extentReport.setSystemInfo("Browser name", configProp.getProperty("browser"));
            extentReport.setSystemInfo("User Email", configProp.getProperty("username"));
            extentReport.setSystemInfo("Password", configProp.getProperty("password"));
            extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
            extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
            extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));

        } catch (Throwable e) {
            e.printStackTrace();
        }

        return extentReport;
    }
}

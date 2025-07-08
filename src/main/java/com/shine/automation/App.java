package com.shine.automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;
import java.time.Duration;

public class App {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        try {
            driver.get("https://www.shine.com/");
            log("Page Title: " + driver.getTitle());
            log("URL: " + driver.getCurrentUrl());

            driver.findElement(By.linkText("Login")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("id_email_login")).sendKeys("your-email@example.com");
            driver.findElement(By.id("id_password")).sendKeys("your-password");
            driver.findElement(By.xpath("//button[text()='Login']")).click();
            Thread.sleep(3000);
            takeScreenshot("1_Login_Success.png");

            assert driver.getCurrentUrl().contains("shine.com") : "Login failed or incorrect page.";

            // Search Job
            driver.findElement(By.id("id_q")).sendKeys("Software Tester");
            driver.findElement(By.id("id_loc")).sendKeys("Hyderabad");
            driver.findElement(By.id("id_exp")).sendKeys("2");
            driver.findElement(By.xpath("//button[contains(text(),'Search Jobs')]")).click();
            Thread.sleep(3000);
            takeScreenshot("2_Job_Search_Results.png");

            assert driver.getPageSource().contains("Software") : "Job search results not loaded.";

            WebElement secondJob = driver.findElements(By.cssSelector(".job_listing")).get(1);
            secondJob.click();
            Thread.sleep(3000);

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            takeScreenshot("3_Second_Job_Selected.png");

            String jobTitle = driver.findElement(By.tagName("h1")).getText();
            String company = driver.findElement(By.cssSelector(".job_title_comp_name")).getText();
            log("Job Title: " + jobTitle);
            log("Company: " + company);

            WebElement applyBtn = driver.findElement(By.xpath("//button[contains(text(),'Apply')]"));
            applyBtn.click();
            Thread.sleep(3000);
            takeScreenshot("4_Job_Applied.png");

            WebElement successMsg = driver.findElement(By.xpath("//span[contains(text(),'applied') or contains(text(),'already') or contains(text(),'submitted')]"));
            log("Confirmation Message: " + successMsg.getText());

            assert successMsg.getText().toLowerCase().contains("applied") : "Application might have failed.";
        } catch (Exception e) {
            log("Exception occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public static void takeScreenshot(String filename) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotsDir = new File("screenshots");
        if (!screenshotsDir.exists()) {
            screenshotsDir.mkdir();
        }
        FileHandler.copy(src, new File(screenshotsDir, filename));
    }

    public static void log(String message) throws IOException {
        System.out.println(message);
        FileWriter writer = new FileWriter("shine-log.txt", true);
        writer.write(message + "\n");
        writer.close();
    }
}

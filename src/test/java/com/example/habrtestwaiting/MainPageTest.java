package com.example.habrtestwaiting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class MainPageTest {
    private WebDriver driver;
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void enable(){
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
        WebElement disableButton = driver.findElement(By.cssSelector("#enableAfter"));
        wait.until(ExpectedConditions.elementToBeClickable(disableButton));
        assertTrue(disableButton.isDisplayed()," Кнопка не видна ");
    }
    @Test
    public void after() {
        By visibleAfter = By.cssSelector("#visibleAfter");
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(visibleAfter));
        WebElement visibleAfterButton = driver.findElement(visibleAfter);
        assertTrue(visibleAfterButton.isDisplayed()," Кнопка не видна ");
    }
}




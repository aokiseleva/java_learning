package ru.stqa.payment;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
//import org.apache.commons.io.FileUtils;

public class Auth {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

 /* @BeforeSuite
  static void setupClass() {
    WebDriverManager.chromedriver().setup();
  } */

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/Users/aosoboleva/ChromeDriver/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testAuth() throws Exception {
    driver.get("https://develop.payment.ewt.mts.ru/");
    driver.findElement(By.linkText("Войти")).click();
    driver.get("https://sso-test.mtsbank.ru/login/mtsmoney/auth/");
    driver.findElement(By.id("phone")).click();
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("9216462723");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.id("otp")).clear();
    driver.findElement(By.id("otp")).sendKeys("1234");
    driver.findElement(By.xpath("//div[@id='__next']/div/div[3]/div/div/div/div/div/div/div/div[3]/div/div[2]/div/div/div/div/div/div/b")).click();
    driver.findElement(By.name("loanPurpose")).click();
    driver.findElement(By.xpath("//div[@id='creditForm']/div[2]/form/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/div/div")).click();
    driver.findElement(By.name("monthIncome")).click();
    driver.findElement(By.name("monthIncome")).clear();
    driver.findElement(By.name("monthIncome")).sendKeys("1 ₽");
    driver.findElement(By.xpath("//div[@id='creditForm']/div[2]/form/button/div/div/div")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

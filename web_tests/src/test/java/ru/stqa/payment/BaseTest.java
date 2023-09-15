package ru.stqa.payment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
  protected WebDriver driver;
  private JavascriptExecutor js;

  @BeforeMethod
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/Users/aosoboleva/ChromeDriver/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
    auth(new User("9216462723", "1234"));
  }

  private void auth(User user) {
    driver.get("https://test.payment.ewt.mts.ru/");
    driver.findElement(By.linkText("Войти")).click();
    driver.get("https://sso-test.mtsbank.ru/login/mtsmoney/auth/");
    driver.findElement(By.id("phone")).click();
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys(user.phoneNumber());
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.id("otp")).clear();
    driver.findElement(By.id("otp")).sendKeys(user.enterCode());
    driver.findElement(By.xpath("//div[@id='__next']/div/div[3]/div/div/div/div/div/div/div/div[3]/div/div[2]/div/div/div/div/div/div/b")).click();
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.findElement(By.xpath("//div[@id='__next']/div/div[2]/div/div/div/div[2]/a")).click();
    driver.quit();
  }
}

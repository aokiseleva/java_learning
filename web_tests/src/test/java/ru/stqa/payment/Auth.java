package ru.stqa.payment;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.apache.commons.io.FileUtils;

public class Auth extends BaseTest {

  @Test
  public void testAuth() throws Exception {
    driver.findElement(By.name("loanPurpose")).click();
    driver.findElement(By.xpath("//div[@id='creditForm']/div[2]/form/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/div/div")).click();
    driver.findElement(By.name("monthIncome")).click();
    driver.findElement(By.name("monthIncome")).clear();
    driver.findElement(By.name("monthIncome")).sendKeys("50000 ₽");
    driver.findElement(By.xpath("//div[@id='creditForm']/div[2]/form/button/div/div/div")).click();
  }

}


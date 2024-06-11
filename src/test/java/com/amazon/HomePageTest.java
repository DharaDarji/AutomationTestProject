package com.amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {

	public WebDriver driver;

	@BeforeMethod
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

		driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
	}

	@Test
	public void goToHomePageTest() {

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

		searchBox.sendKeys("Laptop");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='laptop table']")))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//span[contains(text(),'Amazon Basics Engineered Wood Foldable Laptop Table with Cup Holder, Tablet Groove and Mini Drawer (Black)')]")))
				.click();

	}

	@AfterMethod
	public void afterTest() {

		driver.quit();
	}

}

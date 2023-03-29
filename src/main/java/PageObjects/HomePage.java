package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helpers.ExtentReportManager;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//div[@class='country-current']")
	@CacheLookup
	WebElement selectedCountryButton;

	@FindBy(xpath = "//div[@class='country-select']")
	@CacheLookup
	WebElement countrySelectPopup;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(30), Duration.ofMillis(200));
	}

	public void selectCountry(String countryName) {
		if (!selectedCountryButton.findElement(By.xpath("//span[@id='country-name']")).getText()
				.contains(countryName)) {
			wait.until(ExpectedConditions.elementToBeClickable(selectedCountryButton)).click();
			wait.until(ExpectedConditions.visibilityOf(countrySelectPopup));
			WebElement country = driver.findElement(
					By.xpath("//span[contains(@id,'contry-lable')][contains(text(),'" + countryName + "')]"));
			country.click();
			wait.until(ExpectedConditions.invisibilityOf(countrySelectPopup));
		}
		ExtentReportManager.info("Country: " + countryName + " is selected.");
	}

	public String getPlanPrice(String planName) {
		WebElement planPrice = driver.findElement(By.xpath("//div[@class='price'][contains(@id,'" + planName + "')]"));
		return planPrice.findElement(By.xpath("./b")).getText();
	}

	public String getPlanCurrency(String planName) {
		WebElement planPrice = driver.findElement(By.xpath("//div[@class='price'][contains(@id,'" + planName + "')]"));
		return planPrice.findElement(By.xpath("./i")).getText();
	}

}
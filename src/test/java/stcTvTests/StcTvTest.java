package stcTvTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowserManager.BrowserLauncher;
import DataProviders.StcTvDataProvider;
import Helpers.ExtentReportManager;
import PageObjects.HomePage;
import enums.PlanEnums;

/**
 *
 * @author FatmaSaid
 *
 **/

public class StcTvTest {
	@Test(enabled = true, dataProvider = "stcTvDataProvider", dataProviderClass = StcTvDataProvider.class)
	public void stcTvTestCase(String countryName, String litePrice, String classicPrice, String premiumPrice,
			String currency) throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		WebDriver driver = BrowserLauncher.startBrowser("firefox", "https://subscribe.stctv.com/sa-en?");
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ExtentReportManager.createTest("STC TV Test case - Assertion for country (" + countryName
				+ ") to have correct type, price and currency");
		homePage.selectCountry(countryName);
		softAssert.assertTrue(homePage.getPlanPrice(PlanEnums.LITE.englishName).equals(litePrice));
		softAssert.assertTrue(homePage.getPlanCurrency(PlanEnums.LITE.englishName).contains(currency));
		softAssert.assertTrue(homePage.getPlanPrice(PlanEnums.CLASSIC.englishName).equals(classicPrice));
		softAssert.assertTrue(homePage.getPlanCurrency(PlanEnums.CLASSIC.englishName).contains(currency));
		softAssert.assertTrue(homePage.getPlanPrice(PlanEnums.PREMIUM.englishName).equals(premiumPrice));
		softAssert.assertTrue(homePage.getPlanCurrency(PlanEnums.PREMIUM.englishName).contains(currency));
		driver.quit();
		softAssert.assertAll();
		ExtentReportManager.pass("Price and currency are as expected.");
	}

}

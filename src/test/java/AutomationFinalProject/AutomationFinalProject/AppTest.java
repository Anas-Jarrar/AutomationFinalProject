package AutomationFinalProject.AutomationFinalProject;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest extends TestData {

	@BeforeTest
	public void MySetup() {
		Setup();
	}

	@Test(priority = 1, enabled = false)
	public void CheckWebsiteLanguage(String ExpectedLanguage) {
		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("Lang");
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);

	}

	@Test(priority = 2, enabled = false)
	public void CheckCurrency() {
		// we can use cssSelector also
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3, enabled = false)
	public void CheckContactNumber() {
		String ActulContacteNum = driver.findElement(By.linkText("+966554400000")).getText();
		Assert.assertEquals(ActulContacteNum, ExpectedContacteNum);
	}

	@Test(priority = 4, enabled = false)
	public void CheckQitafLogo() {
		WebElement TheFotter = driver.findElement(By.tagName("footer"));
		boolean ActualLogoDisplayed = TheFotter.findElement(By.cssSelector(".sc-ekulBa.iOOTo"))
				.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();
		Assert.assertEquals(ActualLogoDisplayed, true);

	}

	@Test(priority = 5, enabled = false)
	public void StaysTabIsNotSelectedByDefault() throws InterruptedException {
		Thread.sleep(2000);
		String currentURL = driver.getCurrentUrl();
		boolean isHotelsSelected = currentURL.contains("hotels-home");
		Assert.assertFalse(isHotelsSelected);
	}

	@Test(priority = 6, enabled = false)
	public void WelcomPageTapSelectedCheck() {
		WebElement StayTap = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualValue = StayTap.getDomAttribute("aria-selected");
		Assert.assertEquals(ActualValue, ExpectedValue);
	}

	@Test(priority = 7, enabled = false)
	public void DepartureDateCheck() {
		WebElement DepartureDateField = driver.findElement(By.cssSelector(".sc-bYnzgO.sc-cPuPxo.jNskcH"));
		String ActualDepartureDay = DepartureDateField.findElement(By.cssSelector(".sc-dXfzlN.iPVuSG")).getText();
		String ActualDepartureMonth = DepartureDateField.findElement(By.cssSelector(".sc-eSePXt.ljMnJa")).getText();
		Assert.assertEquals(ActualDepartureDay, FormatedTomorrowDate);
		Assert.assertEquals(ActualDepartureMonth.toUpperCase(), TomorrowDate.getMonth().toString());
	}

	@Test(priority = 8, enabled = false)
	public void ReturnDateCheck() {
		WebElement ReturnDateField = driver.findElement(By.cssSelector(".sc-bYnzgO.sc-hvvHee.aiGEY"));
		String ActualReturnDay = ReturnDateField.findElement(By.cssSelector(".sc-dXfzlN.iPVuSG")).getText();
		String ActualReturnMonth = ReturnDateField.findElement(By.cssSelector(".sc-eSePXt.ljMnJa")).getText();
		Assert.assertEquals(ActualReturnDay, FormatedAfterTomorrowDate);
		Assert.assertEquals(ActualReturnMonth.toUpperCase(), AfterTomorrowDate.getMonth().toString());
	}

	@Test(priority = 9, enabled = true)
	public void ChangeWebsiteLanguage() {
		driver.get(Websites[Index]);
		String CurrentUrl = driver.getCurrentUrl();
		if (CurrentUrl.contains("en")) {
			CheckWebsiteLanguage("en");
		} else {
			CheckWebsiteLanguage("ar");
		}

	}

	@Test(priority = 10)
	public void RandomSelectCity() {
		WebElement StaysButton = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		StaysButton.click();
		String CurrentUrl = driver.getCurrentUrl();
		WebElement SearchBar = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));
		if (CurrentUrl.contains("en")) {
			SearchBar.sendKeys(EnCities[RandomEnCityIndex]);
		} else {
			SearchBar.sendKeys(ArCities[RandomArCityIndex]);
		}

	}

	@Test(priority = 11)
	public void RandomSelectRooms() {
		WebElement ReservationRoomSelect = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));
		Select Myselect = new Select(ReservationRoomSelect);
		Myselect.selectByValue(Values[RoomsRandomValue]);
		driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk")).click();
	}

	@Test(priority = 12)
	public void CheckTheResultsIsRetrived() throws InterruptedException {
		Thread.sleep(10000);
		String CurrentUrl = driver.getCurrentUrl();
		String Results = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']")).getText();
		if (CurrentUrl.contains("en")) {
			Assert.assertEquals(Results.contains("found"), true);
		} else {
			Assert.assertEquals(Results.contains("إقامة"), true);
		}
	}

	@AfterTest
	public void MyAfterTest() {

	}

}

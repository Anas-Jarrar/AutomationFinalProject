package AutomationFinalProject.AutomationFinalProject;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest extends TestData {

	@BeforeTest
	public void MySetup() {
		Setup();
	}
	
	@Test(priority = 1, enabled = true)
	public void TestHomePageLanguage() {
		CheckWebsiteLanguage("en");
	}

	@Test(priority = 2, enabled = true)
	public void CheckCurrency() {
		// we can use cssSelector also
		String ActualCurrency = driver.findElement(By.cssSelector(".__ds__comp.undefined.MuiBox-root.alm-desktop-qioz0f"))
				.getText();
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3, enabled = true)
	public void CheckContactNumber() {
		String ActulContacteNum = driver.findElement(By.cssSelector(".__ds__comp.undefined.MuiBox-root.alm-desktop-h0bow9")).getText();
		Assert.assertEquals(ActulContacteNum, ExpectedContacteNum);
	}

	@Test(priority = 4, enabled = true)
	public void CheckQitafLogo() {
		WebElement TheFotter = driver.findElement(By.tagName("footer"));
		boolean ActualLogoDisplayed = TheFotter.findElement(By.cssSelector(".alm-desktop-1mqexmc-acceptedCards"))
				.findElement(By.xpath("//img[@alt='qitaf']")).isDisplayed();
		Assert.assertEquals(ActualLogoDisplayed, true);

	}

	@Test(priority = 5, enabled = true)
	public void HotelTabIsNotSelected1() throws InterruptedException {
		Thread.sleep(2000);
		String currentURL = driver.getCurrentUrl();
		boolean isHotelsSelected = currentURL.contains("hotels-home");
		Assert.assertFalse(isHotelsSelected);
	}

	@Test(priority = 6, enabled = true)
	public void HotelTabIsNotSelected() {
		WebElement StayTap = driver.findElement(By.id("tab-hotels"));
		String ActualValue = StayTap.getDomAttribute("aria-selected");
		Assert.assertEquals(ActualValue, ExpectedValue);
	}

	@Test(priority = 7, enabled = true)
	public void DepartureDateCheck() {
		WebElement DepartureDateField = driver.findElement(By.id("testIdPickerPrefix__DatePicker__DepartureDate"));
		String ActualDepartureDate = DepartureDateField.getDomAttribute("value");
		String ActualDepartureDay=ActualDepartureDate.split(",")[1].trim().split(" ")[0];
		Assert.assertEquals(ActualDepartureDay, FormatedTomorrowDate);
	}

	@Test(priority = 8, enabled = true)
	public void ReturnDateCheck() {
		WebElement ReturnDateField = driver.findElement(By.id("testIdPickerPrefix__DatePicker__ArrivalDate"));
		String ActualReturnDate = ReturnDateField.getDomAttribute("value");
		String ActualReturnDay=ActualReturnDate.split(",")[1].trim().split(" ")[0];		
		Assert.assertEquals(ActualReturnDay, FormatedAfterTomorrowDate);
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

	@Test(priority = 10,enabled=true)
	public void RandomSelectCity() {
		WebElement StaysButton = driver.findElement(By.id("tab-hotels"));
		StaysButton.click();
		String CurrentUrl = driver.getCurrentUrl();
		WebElement SearchBar = driver.findElement(By.id("DesktopSearchWidget_Destination_InputField_Test_Id"));
		if (CurrentUrl.contains("en")) {
			SearchBar.sendKeys(EnCities[RandomEnCityIndex]);
		} else {
			SearchBar.sendKeys(ArCities[RandomArCityIndex]);
		}
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mui-4"))).click();
//		driver.findElement(By.id("mui-4")).click();
	}
	@Test(priority=11,enabled=true)
	public void WaitLoadingBar() throws InterruptedException {
		Thread.sleep(20000);
		String FoundWord=driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']")).getText();
		String CurrentUrl=driver.getCurrentUrl();
		if(driver.getCurrentUrl().contains("en")) {
			Assert.assertEquals(FoundWord.contains("found"), true);
		}
		else
		{
			Assert.assertEquals(FoundWord.contains("إقامة"), true);

		}		
	}

	
	@AfterTest
	public void MyAfterTest() {

	}

}

package AutomationFinalProject.AutomationFinalProject;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

	String TheWebSite = "https://www.almosafer.com/en";
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void MySetup() {
		driver.manage().window().maximize();
		driver.get(TheWebSite);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement CountryButton = driver
				.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary"));
		CountryButton.click();
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
		String ExpectedCurrency = "SAR";
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);

	}

	@Test(priority = 3, enabled = false)
	public void CheckContactNumber() {
		String ActulContacteNum = driver.findElement(By.linkText("+966554400000")).getText();
		String ExpectedContacteNum = "+966554400000";
		Assert.assertEquals(ActulContacteNum, ExpectedContacteNum);

	}

	@Test(priority = 4, enabled = false)
	public void CheckQitafLogo() {
//		boolean ActualLogo=driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();

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
		String ExpectedValue = "false";
		Assert.assertEquals(ActualValue, ExpectedValue);

	}

	@Test(priority = 7,enabled=false)
	public void DepartureDateCheck() {

		LocalDate TomorrowDate = LocalDate.now().plusDays(1);
		WebElement DepartureDateField = driver.findElement(By.cssSelector(".sc-bYnzgO.sc-cPuPxo.jNskcH"));
		String ActualDepartureDay = DepartureDateField.findElement(By.cssSelector(".sc-dXfzlN.iPVuSG")).getText();
		String ActualDepartureMonth = DepartureDateField.findElement(By.cssSelector(".sc-eSePXt.ljMnJa")).getText();
		String FormatedTomorrowDate=String.format("%02d", TomorrowDate.getDayOfMonth());
		Assert.assertEquals(ActualDepartureDay, FormatedTomorrowDate);
		Assert.assertEquals(ActualDepartureMonth.toUpperCase(), TomorrowDate.getMonth().toString());
	}

	@Test(priority = 8,enabled=false)
	public void ReturnDateCheck() {

		LocalDate AfterTomorrowDate = LocalDate.now().plusDays(2);
		WebElement ReturnDateField = driver.findElement(By.cssSelector(".sc-bYnzgO.sc-hvvHee.aiGEY"));
		String ActualReturnDay = ReturnDateField.findElement(By.cssSelector(".sc-dXfzlN.iPVuSG")).getText();
		String ActualReturnMonth = ReturnDateField.findElement(By.cssSelector(".sc-eSePXt.ljMnJa")).getText();
		String FormatedAfterTomorrowDate=String.format("%02d", AfterTomorrowDate.getDayOfMonth());
		Assert.assertEquals(ActualReturnDay, FormatedAfterTomorrowDate);
		Assert.assertEquals(ActualReturnMonth.toUpperCase(), AfterTomorrowDate.getMonth().toString());

	}
	@Test (priority=9,invocationCount = 5)
	public void ChangeWebsiteLanguage() {
		
		String [] Websites= {"https://www.almosafer.com/en","https://www.almosafer.com/ar"};
		Random rand=new Random();
		int Index=rand.nextInt(Websites.length);
		driver.get(Websites[Index]);		
		String CurrentUrl=driver.getCurrentUrl();
		if(CurrentUrl.contains("en")) {
			CheckWebsiteLanguage("en");
		}
		else {
			CheckWebsiteLanguage("ar");
		}
		
	}

	@AfterTest
	public void MyAfterTest() {

	}

}

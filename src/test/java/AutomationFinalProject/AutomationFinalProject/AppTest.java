package AutomationFinalProject.AutomationFinalProject;

import java.time.Duration;

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

	@Test(priority = 1)
	public void CheckWebsiteLanguage() {
		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("Lang");
		String ExpectedLanguage = "en";
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);

	}

	@Test(priority = 2)
	public void CheckCurrency() {
		// we can use cssSelector also
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();
		String ExpectedCurrency = "SAR";
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);

	}

	@Test(priority = 3)
	public void CheckContactNumber () {
		String ActulContacteNum=driver.findElement(By.linkText("+966554400000")).getText();
		String ExpectedContacteNum="+966554400000";
		Assert.assertEquals(ActulContacteNum,ExpectedContacteNum);
		
	}
	
	@Test(priority = 4)
	public void CheckQitafLogo () {
		boolean ActualLogo=driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();
		Assert.assertEquals(ActualLogo, true);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterTest
	public void MyAfterTest() {

	}

}

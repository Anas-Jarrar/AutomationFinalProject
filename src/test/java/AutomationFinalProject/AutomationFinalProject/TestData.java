package AutomationFinalProject.AutomationFinalProject;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestData {

	String TheWebSite = "https://www.almosafer.com/en";
	WebDriver driver = new ChromeDriver();
	
	String ExpectedCurrency = "SAR";//Test(2)
	
	String ExpectedContacteNum = "+966554400000";//Test(3)
	
	String ExpectedValue = "false";//Test(6)
	

	LocalDate TomorrowDate = LocalDate.now().plusDays(1);//Test(7)
	String FormatedTomorrowDate = String.format("%02d", TomorrowDate.getDayOfMonth());//Test(7)
	
	LocalDate AfterTomorrowDate = LocalDate.now().plusDays(2);//Test(8)
	String FormatedAfterTomorrowDate = String.format("%02d", AfterTomorrowDate.getDayOfMonth());//Test(8)
	
	String[] Websites = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };//Test(9)
	Random rand = new Random();//Test(9)
	int Index = rand.nextInt(Websites.length);//Test(9)
	
	String[] EnCities = { "Dubai", "Jeddah", "Riyadh" };//Test(10)
	int RandomEnCityIndex = rand.nextInt(EnCities.length);//Test(10)
	String[] ArCities = { "جدة", "دبي" };//Test(10)
	int RandomArCityIndex = rand.nextInt(ArCities.length);//Test(10)
	
	public void CheckWebsiteLanguage(String ExpectedLanguage) {
	    String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
	    Assert.assertEquals(ActualLanguage, ExpectedLanguage);
	}


	public void Setup() {
		driver.manage().window().maximize();
		driver.get(TheWebSite);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement CountryButton = driver
				.findElement(By.id("mui-2"));
		CountryButton.click();
	}
	
	
	
	
	
	
	
	
	
	

}

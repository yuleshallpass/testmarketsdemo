package scisTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketsTest{
	  private WebDriver driver;

	    @BeforeTest
	    public void setUp() {
	        // Set the path to your ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	       // driver.manage().window().maximize();
	    }

	    @Test(priority = 1)
	    public void navigateToMarketsCom() {
	        driver.get("https://www.markets.com/?override=1");
	    }

	    @Test(priority = 2)
	    public void navigateToPlatform() {
	        WebElement tradingMenu = driver.findElement(By.linkText("Trading"));
	        WebElement platformSubMenu = driver.findElement(By.linkText("Platform"));
	        tradingMenu.click();
	        platformSubMenu.click();
	    }

	    @Test(priority = 3)
	    public void fillCreateAccountForm() {
	        WebElement emailField = driver.findElement(By.id("email")); // Replace with actual email field ID
	        WebElement passwordField = driver.findElement(By.id("password")); // Replace with actual password field ID
	        WebElement agreeCheckBox = driver.findElement(By.id("checkbox")); // Replace with actual password field ID
	        WebElement submitButton = driver.findElement(By.id("submit")); // Replace with actual submit button ID

	        // Generate a random email with "test_" prefix
	        String randomEmail = "test_" + System.currentTimeMillis() + "@test.com";

	        emailField.sendKeys(randomEmail);
	        passwordField.sendKeys("Test123!");
	        agreeCheckBox.click();
	        submitButton.click();
	    }

	    @Test(priority = 4)
	    public void verifyOnboardingFlow() {
	        // You can implement verification logic here, e.g., check for elements on the onboarding flow page
	        // Use assertions to verify the expected behavior
	        // For example:
	        WebElement onboardingPageElement = driver.findElement(By.className("form-input-wrapper country-selector")); // Replace with actual element
	        Assert.assertTrue(onboardingPageElement.isDisplayed(), "Onboarding page is displayed");
	    }

	    @Test(priority = 5)
	    public void changeCountryAndContinue() {
	        // Implement logic to change the country to France and click Continue
	        // Use appropriate element locators and interactions
	    	WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"inner-wrap\"]/div[1]/div/section/article/div/div/div/div/div[2]/button")); // Replace with actual submit button ID
	    	Select drpCountry = new Select(driver.findElement(By.name("country")));
	    	drpCountry.selectByVisibleText("France");
	    	continueButton.click();
	    	 
	    }
	    
	    @Test(priority = 6)
	    public void tradingExperience() {
	        // Implement logic to select the trading experience
	        // Use appropriate element locators and interactions
	    	WebElement tradingExperience = driver.findElement(By.id("otherInput")); // Replace with actual submit button ID
	    	tradingExperience.click();
	    	 WebElement frequencyPage = driver.findElement(By.xpath("//*[contains(text(), 'Your frequency of trading in the last 2 years:')]")); // Replace with actual element
		     Assert.assertTrue(frequencyPage.isDisplayed(), "Your frequency of trading in the last 2 years:");
	    }

	    @Test(priority = 7)
	    public void changeLanguage() {
	        // Implement logic to change the language to Français
	        // Use appropriate element locators and interactions
	    	
	    	 try {
	             // Locate the language dropdown
	             WebElement languageDropdown = driver.findElement(By.id("languageDropdown")); // Replace with the actual ID

	             // Create a Select object for the dropdown
	             Select selectLanguage = new Select(languageDropdown);

	             // Select a language by its visible text
	             selectLanguage.selectByVisibleText("Français"); // Replace with the language you want

	             // Optionally, wait for the page to reload or for language-specific content to load
	             WebDriverWait wait = new WebDriverWait(driver, 10);
	             wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Quotidien')]")));
	    	 
	    } finally {
            // Close the WebDriver
            driver.quit();
        }
	    }
	    

	    @Test(priority = 8)
	    public void chooseAnswerAndVerify() {
	        // Implement logic to choose "Quotidien" and verify the next step is loaded
	        // Use appropriate element locators and interactions
	    	WebElement chooseAnswer = driver.findElement(By.id("Quotidien")); // Replace with actual submit button ID
	    	chooseAnswer.click();
	    	 WebElement quotidien = driver.findElement(By.xpath("//h1[contains(text(),'Quotidien')]")); // Replace with actual element
		     Assert.assertTrue(quotidien.isDisplayed(), "Quotidien");
	    }

	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
	}
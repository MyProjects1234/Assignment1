package StepDef;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Runner.TestRunner;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import manager.PageObjectManager;
import pages.AmazonPages;
import pages.FlipkartPages;

public class priceComp extends TestRunner{

	WebDriver driver;
	PageObjectManager pageObjectManager = new PageObjectManager(driver);
	AmazonPages amazonPages = pageObjectManager.getamazonPages();
	FlipkartPages flipkartPages = pageObjectManager.getflipkartPages();
	
	@Given("User opens browser")
	public void user_opens_browser() throws Exception {
		amazonPages.openBrowser();
	}

	@Given("navigates to amazon")
	public void navigates_to_amazon() throws Exception {
		amazonPages.navigateToAmazon();
	}

	@When("page is loaded, searches for iPhone XR 64GB Yellow in amazon")
	public void page_is_loaded_search_for_iPhone_XR_64GB_Yellow_in_amazon() {
		amazonPages.searchIphoneXR();
	}


	@When("Gets the price of the selected iPhone")
	public void gets_the_price_of_the_selected_iPhone() {
		amazonPages.priceAmazon();
		amazonPages.quit();
		
	}

	@Then("navigates to flipkart")
	public void navigates_to_https_www_flipkart_com() throws InterruptedException {
		flipkartPages.openBrowser();
		flipkartPages.navigateToFlipkart();
	}
	
	@When("page is loaded, searches for iPhone XR 64GB Yellow in flipkart")
	public void page_is_loaded_search_for_iPhone_XR_64GB_Yellow_in_flipkart() {
	  flipkartPages.searchIphone();
	  flipkartPages.iphonePrice();
	}
	
	@When("find which website has lesser value")
	public void compares_the_price_on_both_the_website() {
		//flipkartPages.checkPrice();
	}

	
	
}

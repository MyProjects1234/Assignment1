package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Runner.TestRunner;
import manager.PageObjectManager;

public class FlipkartPages extends TestRunner {
	PageObjectManager pageObjectManager = new PageObjectManager(driver);
	AmazonPages amazonPages = pageObjectManager.getamazonPages();
	
	@FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']")
	private WebElement button_close;

	// button[@class='_2AkmmA _29YdH8']

	public FlipkartPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C://eclipse-workspace//PriceCompare//resources//chromedriver.exe");
		driver = new ChromeDriver();
		maximizeWindow();
	}

	public void navigateToFlipkart() {
		String Url = "https://www.flipkart.com/";
		driver.get(Url);
		// button_close.click();
		
	}
	
	public void searchIphone(){
		WebElement button = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		jseClick(button);
		WebElement search = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		jseClick(search);
		search.sendKeys("iPhone XR (64GB) - Yellow");
		WebElement btn_search = driver.findElement(By.xpath("//button[@type='submit']"));
		jseClick(btn_search);
	}
	
	public void iphonePrice(){
		driver.get("https://www.flipkart.com/apple-iphone-xr-yellow-64-gb/p/itmf9z7z76tayfaq?pid=MOBF9Z7ZUGQ6YDBH&lid=LSTMOBF9Z7ZUGQ6YDBHINMIO2&marketplace=FLIPKART&srno=s_1_1&otracker=search&otracker1=search&fm=SEARCH&iid=03ee5fee-65bc-4d53-ac1b-65ea32c7ae60.MOBF9Z7ZUGQ6YDBH.SEARCH&ppt=sp&ppn=sp&ssid=g0nhx0zmjk0000001584878110336&qH=570eff84298e3b99");
		
		WebElement priceFlipkart = driver.findElement(By.xpath("//div[@class='_1vC4OE _3qQ9m1']"));
		String price = priceFlipkart.getText();
		String actual=price.substring(1, 7);
		System.out.println("iPhone XR 64GB Yellow price in flipkart: "+actual);
	}
	
	public void quit() {
		//driver.quit();
	}

	public void jseClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

}

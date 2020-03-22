package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Runner.TestRunner;

public class AmazonPages extends TestRunner {

	public AmazonPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement txtbx_Searchhhh;

	@FindBy(how = How.XPATH, using = "//input[@class='nav-input'][@type='submit']")
	private WebElement btn_Searchhhh;

	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C://eclipse-workspace//PriceCompare//resources//chromedriver.exe");
		driver = new ChromeDriver();
		maximizeWindow();

	}

	public void navigateToAmazon() {
		String Url = "https://www.amazon.in";
		driver.get(Url);
	}

	public void searchIphoneXR() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.getElementById('twotabsearchtextbox').click();");

		WebElement txtboxSearch = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		jseClick(txtboxSearch);
		txtboxSearch.sendKeys("iPhone XR (64GB) - Yellow");

		WebElement btn_Search = driver.findElement(By.xpath("//input[@class='nav-input'][@type='submit']"));
		jseClick(btn_Search);
	}
	
	public void priceAmazon()
	{
		driver.get("https://www.amazon.in/Apple-iPhone-XR-64GB-Yellow/dp/B07JH6RSC6/ref=sr_1_1?dchild=1&keywords=iPhone+XR+%2864GB%29+-+Yellow&qid=1584883838&sr=8-1");
		WebElement iphoneXRPrice = driver.findElement(By.xpath("//span[@id='priceblock_ourprice']"));
		String PriceInAmazon = iphoneXRPrice.getText();
		String actualPrice=PriceInAmazon.substring(1, 10);
		System.out.println("iPhone XR 64GB - Yellow Price :" + actualPrice);
		 
	}
	
	public void quit() {
		//driver.quit();
	}

	// JavaScriptExecutor implementation
	public void jseClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

}

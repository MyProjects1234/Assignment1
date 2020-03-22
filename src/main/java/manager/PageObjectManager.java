package manager;

import org.openqa.selenium.WebDriver;

import pages.AmazonPages;
import pages.FlipkartPages;

public class PageObjectManager {
	private WebDriver driver;
	
	private AmazonPages amazonPages;
	private FlipkartPages flipkartPages;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public AmazonPages getamazonPages() {
		if (amazonPages == null) {
			amazonPages = new AmazonPages(driver);
		}
		return amazonPages;
	}
	
	public FlipkartPages getflipkartPages() {
		if (flipkartPages == null) {
			flipkartPages = new FlipkartPages(driver);
		}
		return flipkartPages;
	}
}

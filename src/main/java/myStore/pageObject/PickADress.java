package myStore.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PickADress {

	public static String URL_DRESS1 = "http://automationpractice.com/index.php?id_product=5&controller=product";
	public static String URL_DRESS2 = "http://automationpractice.com/index.php?controller=order";
	public static By haljina = By.cssSelector(
			"#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default");

	public static void pickADress(WebDriver driver) {
		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys("2");
		Select size = new Select(driver.findElement(By.id("group_1")));
		size.selectByVisibleText("M");
		driver.findElement(
				By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button"))
				.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.navigate().to("http://automationpractice.com/index.php?controller=order");
		
	}
}

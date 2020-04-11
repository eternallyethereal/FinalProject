package myStore.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class clickSummerDresses extends Homepage {
	
	public static void clickSummerDresses(WebDriver driver) {
		Actions akcija = new Actions(driver);
		driver.get("http://automationpractice.com/index.php");
		WebElement dress = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a"));
		akcija.moveToElement(dress).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a")).click();
	}
}
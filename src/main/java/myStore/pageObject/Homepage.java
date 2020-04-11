package myStore.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Homepage {
	
	public static String HOME_URL = "http://automationpractice.com/index.php";
	public static By woman = By.linkText("woman");
	public static By summerDresses = By.linkText("Summer Dresses");
	
	public static void clickWomenDresses(WebDriver driver) {
		Actions akcija = new Actions(driver);
		WebElement women = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a"));
		akcija.moveToElement(women).perform();
		driver.findElement(By.linkText("Summer Dresses")).click();
	}
}
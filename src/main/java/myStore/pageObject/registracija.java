package myStore.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class registracija {

	public static void reg(WebDriver driver) {
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]")).click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("bcfghg6jhl5g78hjfg6.miliceviccc092@gmail.com");
		driver.findElement(By.xpath("//*[@id='SubmitCreate']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.xpath("//*[@id='customer_firstname']")).sendKeys("Toma");
		driver.findElement(By.xpath("//*[@id='customer_lastname']")).sendKeys("Zdravkovic");

		driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("12345");


		driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("m, 36254, nnn");
		Select cntr = new Select(driver.findElement(By.id("id_country")));
		Select state = new Select(driver.findElement(By.id("id_state")));

		cntr.selectByVisibleText("United States");
		state.selectByVisibleText("California");
		driver.findElement(By.id("city")).sendKeys("San Diego");
		driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("36284");
		driver.findElement(By.xpath("//*[@id='other']")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id='phone_mobile']")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id='alias']")).sendKeys("MMNN");
		driver.findElement(By.xpath("//*[@id='submitAccount']")).click();
	}
	
}
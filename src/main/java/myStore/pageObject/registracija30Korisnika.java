package myStore.pageObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registracija30Korisnika {

	public static void clickSign(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
	}
	
	public static XSSFSheet citanjeExcel() throws IOException {
		FileInputStream fis = new FileInputStream("Book1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		return sh;
	}
	
	public static void resetToHomeExcel(WebDriver driver) {
		driver.navigate().to(Homepage.HOME_URL);
	}
	
	public static void pushRegister(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id='SubmitCreate']")).click();
	}
	
	public static void deregister(WebDriver driver) {
		driver.findElement(By.className("logout")).click();
	}
}
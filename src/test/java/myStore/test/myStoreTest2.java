package myStore.test;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import myStore.pageObject.Homepage;
import myStore.pageObject.PickADress;
import myStore.pageObject.clickSummerDresses;
import myStore.pageObject.registracija30Korisnika;

public class myStoreTest2 {

	public class myToursTest {
		WebDriver driver;// sad je dostupan svakoj anotaciji iako je definisan u @BeforeClass
		Actions akcija;
		SoftAssert sa;

		@BeforeClass
		public void beforeClass() {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		@Test(priority = 1)
		public void testWomenDresses() {
			SoftAssert sa = new SoftAssert();
			driver.get(Homepage.HOME_URL);
			Homepage.clickWomenDresses(driver);
			String actual = driver.getCurrentUrl();
			String expected = "http://automationpractice.com/index.php?id_category=11&controller=category";
			sa.assertEquals(actual, expected);
			sa.assertAll();

		}
		}
	}
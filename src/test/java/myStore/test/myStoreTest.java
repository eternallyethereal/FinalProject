package myStore.test;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.util.XMLHelper;
import javax.xml.parsers.DocumentBuilder;
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

public class myStoreTest {

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

		@Test(priority = 2)
		public void testSummerDresses() {
			driver.get(Homepage.HOME_URL);
			clickSummerDresses.clickSummerDresses(driver);
			String actual = driver.getCurrentUrl();
			String expected = "http://automationpractice.com/index.php?id_category=11&controller=category";
			sa.assertEquals(actual, expected);
			sa.assertAll();
		}
		
		@Test(priority=3)
		public void jednaki() {
			driver.get(Homepage.HOME_URL);
			Homepage.clickWomenDresses(driver);
			String actual = driver.getCurrentUrl();
			driver.navigate().to(Homepage.HOME_URL);
			clickSummerDresses.clickSummerDresses(driver);
			String actual2 = driver.getCurrentUrl();
			Assert.assertEquals(actual, actual2);
		}

		@Test(priority = 4)
		public void testHaljine() {
			driver.get(PickADress.URL_DRESS1);
			PickADress.pickADress(driver);
			String sss = driver.findElement(By.xpath("//*[@id='product_5_23_0_0']/td[2]/small[2]/a")).getText();
			String qt = driver.findElement(By.xpath("//*[@id='product_5_23_0_0']/td[5]/input[1]"))
					.getAttribute("value");
			Assert.assertEquals(qt, "2");
			String total = sss + qt;
			Assert.assertEquals(total, "Color : Yellow, Size : M2");
		}

		@Test(priority = 5)
		public void registracija() {
			driver.get(PickADress.URL_DRESS1);
			PickADress.pickADress(driver);
			myStore.pageObject.registracija.reg(driver);
			Assert.assertTrue(driver.findElement(By.className("logout")).isDisplayed());
			driver.findElement(By.className("logout")).click();
		}

		@Test(priority = 6)
		public void registracija30() throws IOException {
			XSSFSheet sh = registracija30Korisnika.citanjeExcel();
			SoftAssert sa = new SoftAssert();
			for (int i = 0; i < 30; i++) {
				driver.get(Homepage.HOME_URL);
				registracija30Korisnika.clickSign(driver);
				Row row = sh.getRow(i);
				String cell = row.getCell(0).toString();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys(cell);
				registracija30Korisnika.pushRegister(driver);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cell = row.getCell(1).toString();
				driver.findElement(By.id("id_gender1")).click();
				driver.findElement(By.xpath("//*[@id='customer_firstname']")).sendKeys(cell);
				driver.findElement(By.xpath("//*[@id='customer_lastname']")).sendKeys(row.getCell(2).toString());

				driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys(row.getCell(3).toString());

				driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(row.getCell(4).toString());
				Select cntr = new Select(driver.findElement(By.id("id_country")));
				Select state = new Select(driver.findElement(By.id("id_state")));

				cntr.selectByVisibleText("United States");
				state.selectByVisibleText("California");
				driver.findElement(By.id("city")).sendKeys(row.getCell(5).toString());
				driver.findElement(By.xpath("//*[@id='postcode']")).clear();
				driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("12345");
				driver.findElement(By.xpath("//*[@id='other']")).sendKeys(row.getCell(7).toString());
				driver.findElement(By.xpath("//*[@id='phone_mobile']")).clear();
				driver.findElement(By.xpath("//*[@id='phone_mobile']")).sendKeys(row.getCell(8).toString());
				driver.findElement(By.xpath("//*[@id='alias']")).sendKeys(row.getCell(9).toString());
				driver.findElement(By.xpath("//*[@id='submitAccount']")).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				sa.assertTrue(driver.findElement(By.className("logout")).isDisplayed());
				driver.findElement(By.className("logout")).click();
			}
			sa.assertAll();
		}
		@Test(priority = 7)
		public void test30() throws IOException {
			XSSFSheet sh = registracija30Korisnika.citanjeExcel();
			SoftAssert sa = new SoftAssert();
			for (int i = 0; i < 30; i++) {
				driver.get(Homepage.HOME_URL);
				registracija30Korisnika.clickSign(driver);
				Row row = sh.getRow(i);
				String cell = row.getCell(0).toString();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				driver.findElement(By.xpath("//*[@id='email']")).sendKeys(cell);
				String cell1 = row.getCell(3).toString();
				driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys(cell1);
				driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
				sa.assertTrue(driver.findElement(By.className("logout")).isDisplayed());
				driver.findElement(By.className("logout")).click();
			}
			sa.assertAll();
		}
	}
}
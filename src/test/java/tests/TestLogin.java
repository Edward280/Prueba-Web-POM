package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;

public class TestLogin {

	WebDriver driver;
	String PATH_DRIVER = "./src/test/resources/driver/chromedriver.exe";
	String TYPE_DRIVER = "webdriver.chrome.driver";
	String URL = "https://stream3.mexiserver.com:2199/login/index.php";
	LoginPage login;
	HomePage home;
	@Before
	public void setUp() {
		System.setProperty(TYPE_DRIVER, PATH_DRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		login = new LoginPage(driver);
	}
	@Test
	public void testLoginExitoso() {
		login.iniciarSesion("demo","demo");
		home = new HomePage(driver);
		Assert.assertEquals("Información de cuenta", home.getMensajeExito());
	}
	
	@Test
	public void testLoginFallido() {
		login.iniciarSesion("demoxd", "demo");
		Assert.assertTrue(login.getMensajeError().contains("Invalid username or password"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

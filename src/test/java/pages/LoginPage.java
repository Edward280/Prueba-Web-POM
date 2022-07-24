package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private By txtUser = By.name("username");
	private By txtPass = By.name("password");
	private By btnLogin = By.name("login");
	private By  txtMensajeError = By.id("loginerror");
	/*private By  txtMensajeError = By.xpath("//div");*/
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void iniciarSesion(String user, String pass) {
		driver.findElement(txtUser).sendKeys(user);
		driver.findElement(txtPass).sendKeys(pass);
		driver.findElement(btnLogin).click();
	}
	
	public String getMensajeError() {
		return driver.findElement(txtMensajeError).getText();
	}
}

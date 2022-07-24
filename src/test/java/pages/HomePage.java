package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private By txtMensajeExito = By.xpath("//h1");
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getMensajeExito() {
		return driver.findElement(txtMensajeExito).getText();
	}
}

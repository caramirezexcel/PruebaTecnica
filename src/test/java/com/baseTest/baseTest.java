package com.baseTest;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class baseTest{

	private WebDriver driver;
	
	//Método Selenium
	public baseTest(WebDriver driver) {
		this.driver = driver;
	}
	
	//Método de configuración Chrome
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		return driver;
	}
		
	//busqueda de elemento por localizador
	public WebElement BusquedaElemento(By locator) {
		return driver.findElement(locator);
	}
	
	//Método de escritura
	public void Escribir(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	//Método  click
	public void DarClic(By locator) {
		driver.findElement(locator).click();
	}
	
	//Método de teclado
	public void DarEnter(By locator) {
		driver.findElement(locator).sendKeys(Keys.ENTER);
		}
	
		
	//Método de elemento presente en el sitio 
	public Boolean EstaPresente(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}
		catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	//Método Scroll (JavaScript)
	public void HacerScroll(WebDriver driver,By locator) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(locator);
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}
}

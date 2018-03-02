package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage abre(){
		driver.get("http://sahitest.com/demo/training/login.htm");
		return this;
	}

	public LoginPage logar(String user, String pass) {
		driver.findElement(By.name("user")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pass);
		return this;
	}

	public BookPage submeteFormulario() {
		driver.findElement(By.cssSelector(".button")).click();
		return new BookPage(driver);
	}

	public LoginPage submeteLoginInvalido() {
		driver.findElement(By.cssSelector(".button")).click();
		return this;
	}

	public String getMensagemErro() {
		return driver.findElement(By.cssSelector("#errorMessage")).getText();
		
	}
	
	

}

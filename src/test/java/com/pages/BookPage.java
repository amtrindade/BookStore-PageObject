package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookPage {
	private WebDriver driver;

	public BookPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public Boolean usuarioLogado(){
		return driver.findElement(By.cssSelector("#available>h2")).isDisplayed();
	}

}

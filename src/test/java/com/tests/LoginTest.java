package com.tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.BookPage;
import com.pages.LoginPage;

public class LoginTest {
	public WebDriver driver;
	private LoginPage login;
	private BookPage bookPage;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "f://Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testLoginValido() {
		login = new LoginPage(driver);
		bookPage = login.abre()
				.logar("test", "secret")
				.submeteFormulario();
		assertTrue(bookPage.usuarioLogado());
	}
	
	@Test
	public void testLoginInvalido() {
		login = new LoginPage(driver);
		login.abre().logar("test", "abc");
		login.submeteLoginInvalido();
		assertEquals("Invalid username or password", 
				login.getMensagemErro());
	}

}

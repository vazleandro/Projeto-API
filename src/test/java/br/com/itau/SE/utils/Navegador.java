package br.com.itau.SE.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navegador {

	public static WebDriver abreNavegador(String url) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lesivaz\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();

		navegador.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		navegador.get(url);
		navegador.manage().window().maximize();

		return navegador;
	}
	
}

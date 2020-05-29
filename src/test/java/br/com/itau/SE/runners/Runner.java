package br.com.itau.SE.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import br.com.itau.SE.utils.Navegador;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

/* @RunWith(Cucumber.class)
@CucumberOptions(

		features = "classpath:features", tags = {"@mensagemCockpit"}, //{ "@mensagemCockpit, @piloto" },
		glue = "br.com.itau.SE.steps",
		plugin = {
				"pretty", "html:target/report-html",
				"json:target/cucumber-reports/cucumber.json" },
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = true)
*/
public class Runner {

	private static final String URL_GIDEP = "http://scit022cto/GIDEP/TRANSACOES/default.asp";
	public static WebDriver navegador;

	@BeforeClass
	public static void abreNavegador() {

		navegador = Navegador.abreNavegador(URL_GIDEP);
	}

	@AfterClass
	public static void closeNavegador() {
		navegador.close();
		navegador.quit();

	}
	
}
package br.com.itau.SE.steps;

import static br.com.itau.SE.runners.Runner.navegador;

import java.io.File;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;

import br.com.itau.SE.evidencias.Screenshot;
import br.com.itau.SE.properties.Propriedades;
import br.com.itau.SE.utils.Trancode;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;

public class CEFESQD15_62 {

	String transacao, passoExecutado, mensagemRetornada, racf, senha, screenshotArquivo;
	Properties prop;
	File DIRETORIO,DIRETORIO_ERRO; 
	
	Propriedades config = new Propriedades();
	Trancode trancode  = new Trancode();
	Screenshot screen = new Screenshot();

	
	@Dado("^que o usuario informe o nome da transacao a ser executado$")
	public void queOUsuarioInformeONomeDaTransacaoASerExecutado() throws Throwable {

		prop = config.getProp();
		transacao = prop.getProperty("prop.transacao");
		
    	navegador.findElement(By.xpath("//body[@class='Principal']//td[@title='Selecione o ambiente para teste']//input[@value='IMST']"))
				.click();

	}

	@Dado("^informe a comunicacao \"([^\"]*)\"$")
	public void informe_a_comunicacao(String comunicacao) throws Throwable {

		Select selecao = new Select(navegador.findElement(By.xpath("//body[@class='Principal']//select[@name='cboComunicacao']")));
		selecao.selectByVisibleText(comunicacao);

	}

	@Dado("^informe sua racf e senha$")
	public void informeSuaRacfESenha() throws Throwable {

		racf = prop.getProperty("prop.racf");
		senha = prop.getProperty("prop.senha");

		navegador.findElement(By.xpath("//body[@class='Principal']//input[@name='txtUsuario']")).sendKeys(racf);
		navegador.findElement(By.xpath("//body[@class='Principal']//input[@name='txtSenha']")).sendKeys(senha);
	}

	@Dado("^que eu informe o passo a ser executado \"([^\"]*)\"$")
	public void que_eu_informe_o_passo_a_ser_executado(String sequenciaExecucao) throws Throwable {

		passoExecutado = sequenciaExecucao;

	}

	@Quando("^utilizar os parametros Agencia \"([^\"]*)\" Conta \"([^\"]*)\" Dac \"([^\"]*)\" produto \"([^\"]*)\" segmento \"([^\"]*)\" canal \"([^\"]*)\"$")
	public void utilizar_os_parametros_Agencia_Conta_Dac_produto_segmento_canal(String agencia, String conta,
			String dac, String produto, String segmento, String canal) throws Throwable {

		trancode.geraTrancodePiloto(transacao, passoExecutado, agencia, conta, dac, produto, segmento, canal);

	}

	@Quando("^realizar a consulta ao Seven$")
	public void realizar_a_consulta_ao_Seven() throws Throwable {

		navegador.findElement(By.xpath("//body[@class='Principal']//input[@type='submit']")).click();

		navegador.findElement(By.xpath("//body[@class='Principal']//input[@name='txtUsuario']")).clear();
		navegador.findElement(By.xpath("//body[@class='Principal']//input[@name='txtSenha']")).clear();
	}

	@Entao("^a resposta tera a seguinte mensagem \"([^\"]*)\" para o cenario \"([^\"]*)\"$")
	public void aRespostaTeraASeguinteMensagemParaOCenario(String mensagemEsperada, String sequencia) throws Throwable {

		mensagemRetornada = navegador
				.findElement(
						By.xpath("//body[@class='Principal']//div[@class='BordaSimples']//textarea[@class='Terminal']"))
				.getText();

		Assert.assertEquals(mensagemEsperada.trim(), mensagemRetornada.trim());
		
/*		
    	Boolean isSuccess = mensagemEsperada.trim().equals(mensagemRetornada.trim());
		
		if (isSuccess) {

			DIRETORIO = aplicacao.criaDiretorio(true);
			screenshotArquivo = DIRETORIO + "/" + "cenario" + sequencia + ".png";

			Screenshot.tirar(navegador, screenshotArquivo);
			Assert.assertTrue(isSuccess);

		} else {

			DIRETORIO_ERRO = aplicacao.criaDiretorio(false);
			screenshotArquivo = DIRETORIO_ERRO + "/" + "cenario" + sequencia + ".png";

			Screenshot.tirar(navegador, screenshotArquivo);
			Assert.assertTrue(isSuccess);

		}
*/
	}

	
//	@After
//	public void tearDown(Scenario scenario) {
//		final byte[] screenshot = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.BYTES);
//
//		scenario.embed(screenshot, "image/png");
//
//	}

}

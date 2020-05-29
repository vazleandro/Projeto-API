package br.com.itau.SE.utils;

import static br.com.itau.SE.runners.Runner.navegador;

import org.openqa.selenium.By;

public class Trancode {

	public void geraTrancodePiloto(String transacao, String passoExecutado, String agencia, String conta, String dac,
			String produto, String segmento, String canal) {

		String trancode;

		if (agencia.isEmpty()) {
			agencia = "    ";
		}

		if (conta.isEmpty()) {
			conta = "       ";
		}

		if (dac.isEmpty()) {
			dac = " ";
		}

		if (produto.isEmpty()) {
			produto = "         ";
		}

		if (segmento.isEmpty()) {
			segmento = " ";
		}

		trancode = transacao + "  " + passoExecutado + " " + agencia + conta + dac + produto + segmento + canal;

		navegador.findElement(By.xpath("//body[@class='Principal']//textarea[@name='txtTrancode']")).clear();
		navegador.findElement(By.xpath("//body[@class='Principal']//textarea[@name='txtTrancode']")).sendKeys(trancode);

	}

}

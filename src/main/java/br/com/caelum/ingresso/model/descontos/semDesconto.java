package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class semDesconto implements Desconto{
	
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal;
	}

}

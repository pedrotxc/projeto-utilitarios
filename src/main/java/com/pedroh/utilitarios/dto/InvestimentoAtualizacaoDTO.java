package com.pedroh.utilitarios.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvestimentoAtualizacaoDTO(
		String nomeTitulo,
		String tipoInvestimento,
		BigDecimal valorAplicado,
		LocalDate dataOperacao) {

}

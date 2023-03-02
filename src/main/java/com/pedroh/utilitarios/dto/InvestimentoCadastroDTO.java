package com.pedroh.utilitarios.dto; 

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.pedroh.utilitarios.model.enums.TipoInvestimento;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record InvestimentoCadastroDTO(
		@NotNull
		String nomeTitulo,
		@NotNull
		@Enumerated(EnumType.STRING)
		TipoInvestimento tipoInvestimento,
		@NotNull
		BigDecimal valorInvestido,
		@NotNull
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		LocalDate dataOperacao) {

}

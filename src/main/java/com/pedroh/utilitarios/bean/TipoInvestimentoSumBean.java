package com.pedroh.utilitarios.bean;

import java.math.BigDecimal;

import com.pedroh.utilitarios.model.enums.TipoInvestimento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoInvestimentoSumBean {

	private TipoInvestimento tipoInvestimento;
	private BigDecimal valorInvestido;

}

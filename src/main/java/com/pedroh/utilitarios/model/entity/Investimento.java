package com.pedroh.utilitarios.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.pedroh.utilitarios.dto.InvestimentoCadastroDTO;
import com.pedroh.utilitarios.model.enums.TipoInvestimento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Investimentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Investimento {

	public Investimento(InvestimentoCadastroDTO dados) {
		this.nomeTitulo = dados.nomeTitulo();
		this.tipoInvestimento = dados.tipoInvestimento();
		this.valorInvestido = dados.valorInvestido();
		this.dataOperacao = dados.dataOperacao();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome_titulo")
	private String nomeTitulo;
	@Column(name = "tipo_investimento")
	@Enumerated(EnumType.STRING)
	private TipoInvestimento tipoInvestimento;
	@Column(name = "valor_investido")
	private BigDecimal valorInvestido;
	@Column(name = "data_operacao")
	private LocalDate dataOperacao;
}

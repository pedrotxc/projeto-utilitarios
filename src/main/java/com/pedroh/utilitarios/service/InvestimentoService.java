package com.pedroh.utilitarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedroh.utilitarios.bean.TipoInvestimentoSumBean;
import com.pedroh.utilitarios.model.entity.Investimento;
import com.pedroh.utilitarios.model.enums.TipoInvestimento;
import com.pedroh.utilitarios.repository.InvestimentoRepository;

@Service
public class InvestimentoService {

	@Autowired
	private InvestimentoRepository repository;

	public List<TipoInvestimentoSumBean> getInvestimentoPeloTipo() {
		return repository.groupAndSumByField();
	}

	public void salvarInvestimento(Investimento investimento) {
		repository.save(investimento);
	}

	public Investimento buscarPeloId(Long id) {
		return repository.getReferenceById(id);
	}

	public List<Investimento> buscarInvestimentoPeloTipo(TipoInvestimento tipoInvestimento) {
		return repository.findAllByTipoInvestimento(tipoInvestimento);
	}
	
}

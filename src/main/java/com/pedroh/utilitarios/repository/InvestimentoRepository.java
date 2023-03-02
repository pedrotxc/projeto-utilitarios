package com.pedroh.utilitarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pedroh.utilitarios.bean.TipoInvestimentoSumBean;
import com.pedroh.utilitarios.model.entity.Investimento;
import com.pedroh.utilitarios.model.enums.TipoInvestimento;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {

	@Query("SELECT new com.pedroh.utilitarios.bean.TipoInvestimentoSumBean(i.tipoInvestimento, SUM(i.valorInvestido)) FROM Investimento i GROUP BY i.tipoInvestimento")
	List<TipoInvestimentoSumBean> groupAndSumByField();

	List<Investimento> findAllByTipoInvestimento(TipoInvestimento tipoInvestimento);
	
}

package com.pedroh.utilitarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pedroh.utilitarios.bean.TipoInvestimentoSumBean;
import com.pedroh.utilitarios.dto.InvestimentoCadastroDTO;
import com.pedroh.utilitarios.model.entity.Investimento;
import com.pedroh.utilitarios.model.enums.TipoInvestimento;
import com.pedroh.utilitarios.service.InvestimentoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/investimento")
public class InvestimentoController {

	@Autowired
	private InvestimentoService investimentoService;

	@GetMapping("/cadastrarInvestimento")
	public String formCadastrarInvestimento() {
		return "investimento/formCadastrarInvestimento";
	}

	@PostMapping("/cadastrarInvestimento")
	@Transactional
	public String registraInvestimento(@ModelAttribute @Valid InvestimentoCadastroDTO dados) {
		investimentoService.salvarInvestimento(new Investimento(dados));
		return "redirect:/investimento/cadastrarInvestimento";
	}

	@GetMapping("/listarInvestimentos")
	public ModelAndView listarInvestimentos() {
		ModelAndView mv = new ModelAndView("investimento/listarInvestimentos");
		List<TipoInvestimentoSumBean> investimentos = investimentoService.getInvestimentoPeloTipo();
		mv.addObject("investimentos", investimentos);
		return mv;
	}

	@GetMapping("/detalhesInvestimento/{tipoInvestimento}")
	public ModelAndView detalhesInvestimento(@PathVariable("tipoInvestimento") TipoInvestimento tipoInvestimento) {
		List<Investimento> investimento = investimentoService.buscarInvestimentoPeloTipo(tipoInvestimento);
		ModelAndView mv = new ModelAndView("investimento/detalhesInvestimento");
		mv.addObject("investimento", investimento);
		return mv;
	}

//	@PutMapping("/AlteraInvestimento")
//	@Transactional
//	public void alteraInvestimento(@RequestBody @Valid InvestimentoAtualizacaoDTO dados) {
//		var investimento = repository.getReferenceById(dados.id());
//		investimento.atualizar(dados);
//	}

//	@DeleteMapping("/DeletaInvestimento/{id}")
//	@Transactional
//	public void deletaInvestimento(@PathVariable Long id) {
//		var medico = repository.getReferenceById(id);
//		repository.delete(medico);
//	}
}

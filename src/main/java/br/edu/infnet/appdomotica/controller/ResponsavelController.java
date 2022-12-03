package br.edu.infnet.appdomotica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.domain.Responsavel;
import br.edu.infnet.appdomotica.model.service.MoradorService;
import br.edu.infnet.appdomotica.model.service.ResponsavelService;

@Controller
public class ResponsavelController {
	
	@Autowired
	private ResponsavelService responsavelService;
	
	@Autowired
	private MoradorService moradorService;
	
	private String mensagem;
	
	@GetMapping(value = "/responsavel/lista")
	public String telaLista(Model model, @SessionAttribute("user") Morador user) {
		
		model.addAttribute("listagem", responsavelService.obterLista(user));
		
		model.addAttribute("mensagem", mensagem);
		
		return "responsavel/lista";
	}

	@GetMapping(value = "/responsavel")
	public String telaCadastro() {
		return "responsavel/cadastro";
	}

	@PostMapping(value = "/responsavel/incluir")
	public String incluir(Responsavel responsavel, @SessionAttribute(name = "user") Morador morador) {

		responsavel.setMorador(morador);
		
		responsavelService.incluir(responsavel);
		
		mensagem = "Inclusão do responsável " + responsavel.getLogin() + " foi realizada com sucesso!";

		return "redirect:/responsavel/lista";
	}
	
	@GetMapping(value = "/responsavel/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		try {
			responsavelService.excluir(id);
			
			mensagem = "Exclusão do responsável de id " + id + " foi realizada com sucesso!";
		} catch (Exception e) {
			mensagem = "Não foi possível realizar a exclusão do responsável de id: " + id;
		}
		
		return "redirect:/responsavel/lista";
	}
}

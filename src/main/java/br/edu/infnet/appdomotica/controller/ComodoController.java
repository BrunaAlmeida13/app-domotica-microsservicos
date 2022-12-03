package br.edu.infnet.appdomotica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appdomotica.model.domain.Comodo;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.service.AparelhoService;
import br.edu.infnet.appdomotica.model.service.ComodoService;
import br.edu.infnet.appdomotica.model.service.ResponsavelService;

@Controller
@Order(6)
public class ComodoController {

	@Autowired
	private ComodoService comodoService;
	
	@Autowired
	private ResponsavelService responsavelService;
	
	@Autowired
	private AparelhoService aparelhoService;
	
	private String mensagem;
	
	@GetMapping(value = "/comodo/lista")
	public String telaLista(Model model, @SessionAttribute("user") Morador user) {
		
		model.addAttribute("listagem", comodoService.obterLista(user));
		
		model.addAttribute("mensagem", mensagem);
		
		return "comodo/lista";
	}
	
	@GetMapping(value = "/comodo")
	public String telaCadastro(Model model, @SessionAttribute("user") Morador user) {
		
		model.addAttribute("aparelhos", aparelhoService.obterLista(user));
		model.addAttribute("responsaveis", responsavelService.obterLista(user));
		
		return "comodo/cadastro";
	}

	@PostMapping(value = "/comodo/incluir")
	public String incluir(Comodo comodo, @SessionAttribute("user") Morador user) {

		comodo.setMorador(user);
		comodoService.incluir(comodo);
		
		mensagem = "Inclusão do cômodo " + comodo.getNome() + " foi realizada com sucesso!";

		return "redirect:/comodo/lista";
	}
	
	@GetMapping(value = "/comodo/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		try {
			comodoService.excluir(id);
			mensagem = "Exclusão do cômodo de id " + id + " foi realizada com sucesso!";
		} catch (Exception e) {
			mensagem = "Não foi possível realizar a exclusão do cômodo de id: " + id;
		}
		
		return "redirect:/comodo/lista";
	}
}

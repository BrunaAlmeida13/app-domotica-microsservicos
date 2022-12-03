package br.edu.infnet.appdomotica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.service.MoradorService;

@Controller
public class MoradorController {

	@Autowired
	private MoradorService moradorService;
	
	@GetMapping(value = "/morador/lista")
	public String telaLista(Model model) {

		model.addAttribute("listagem", moradorService.obterLista());

		return "morador/lista";
	}

	@GetMapping(value = "/morador")
	public String telaCadastro() {
		return "morador/cadastro";
	}

	@PostMapping(value = "/morador/incluir")
	public String incluir(Morador morador) {

		moradorService.incluir(morador);

		return "redirect:/";
	}

	@GetMapping(value = "/morador/{email}/excluir")
	public String excluir(@PathVariable String email) {

		moradorService.excluir(email);

		return "redirect:/morador/lista";
	}
}

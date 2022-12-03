package br.edu.infnet.appdomotica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appdomotica.model.domain.Luz;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.service.LuzService;

@Controller
public class LuzController {

	@Autowired
	private LuzService luzService;	
	
	private String mensagem;
	
	@GetMapping(value = "/luz/lista")
	public String telaLista(Model model, @SessionAttribute("user") Morador user) {

		model.addAttribute("listagem", luzService.obterLista(user));

		model.addAttribute("mensagem", mensagem);
		
		return "luz/lista";
	}

	@GetMapping(value = "/luz")
	public String telaCadastro() {
		return "luz/cadastro";
	}

	@PostMapping(value = "/luz/incluir")
	public String incluir(Luz luz, @SessionAttribute("user") Morador user) {
		luz.setMorador(user);
		
		luzService.incluir(luz);
		
		mensagem = "Inclusão da luz " + luz.getNome() + " foi realizada com sucesso!";

		return "redirect:/luz/lista";
	}

	@GetMapping(value = "/luz/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		try {
			luzService.excluir(id);
			mensagem = "Exclusão da luz de id " + id + " foi realizada com sucesso!";
		} catch (Exception e) {
			mensagem = "Não foi possível realizar a exclusão da luz de id: " + id;
		}

		return "redirect:/luz/lista";
	}

}

package br.edu.infnet.appdomotica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appdomotica.model.domain.ArCondicionado;
import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.service.ArCondicionadoService;

@Controller
public class ArCondicionadoController {

	@Autowired
	private ArCondicionadoService arCondicionadoService;

	private String mensagem;
	
	@GetMapping(value = "/arcondicionado/lista")
	public String telaLista(Model model, @SessionAttribute("user") Morador user) {

		model.addAttribute("listagem", arCondicionadoService.obterLista(user));

		model.addAttribute("mensagem", mensagem);
		
		return "arcondicionado/lista";
	}

	@GetMapping(value = "/arcondicionado")
	public String telaCadastro() {
		return "arcondicionado/cadastro";
	}

	@PostMapping(value = "/arcondicionado/incluir")
	public String incluir(ArCondicionado arCondicionado, @SessionAttribute("user") Morador user) {
		arCondicionado.setMorador(user);

		arCondicionadoService.incluir(arCondicionado);
		
		mensagem = "Inclusão do A.C. " + arCondicionado.getNome() + " foi realizada com sucesso!";

		return "redirect:/arcondicionado/lista";
	}

	@GetMapping(value = "/arcondicionado/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		try {
			arCondicionadoService.excluir(id);
			mensagem = "Exclusão do A.C. de id " + id + " foi realizada com sucesso!";
		} catch (Exception e) {
			mensagem = "Não foi possível realizar a exclusão do A.C. de id: " + id;
		}

		return "redirect:/arcondicionado/lista";
	}
}

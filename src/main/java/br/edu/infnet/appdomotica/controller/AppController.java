package br.edu.infnet.appdomotica.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.appdomotica.model.domain.Morador;
import br.edu.infnet.appdomotica.model.service.AppService;
import br.edu.infnet.appdomotica.model.service.MoradorService;

@Controller
@SessionAttributes(names = "user")
public class AppController {
	
	@Autowired
	private MoradorService moradorService;
	
	@Autowired
	private AppService appService;
	
	@GetMapping(value = "/")
	public String telaHome(Model model) {
		
		model.addAttribute("projeto", appService.obterProjeto());
		
		return "home";
	}
	
	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		
		Morador morador = moradorService.validar(email, senha);
		
		if(morador != null) {
			
			model.addAttribute("user", morador.getId());
			
			return "home";
		}	
		
		return "login";
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		
		status.setComplete();
		
		session.removeAttribute("user");
		
		return "redirect:/";
	}
}

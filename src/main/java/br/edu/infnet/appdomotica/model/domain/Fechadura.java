package br.edu.infnet.appdomotica.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.appdomotica.model.exceptions.TamanhoMaximoSenhaException;

@Entity
@Table(name = "TFechadura")
public class Fechadura extends Aparelho {
	private String senha;
	private boolean trancada;
	private boolean alarme;

	@Override
	public void impressao() {
		System.out.println("#Fechadura");
		System.out.println(this);
	}

	@Override
	public long quantidadeHorasAgendada() throws TamanhoMaximoSenhaException {
		int tamanhoMax = 4;
		int tamanhoSenha = this.senha.length();

		if (tamanhoSenha > tamanhoMax) {
			throw new TamanhoMaximoSenhaException("Senha não pode ter mais que 5 caracteres.");
		}

		long hours = 0;
		if (getTimerFim() == null || getTimerInicio() == null) {
			System.out.println("Função horario de funcionamento desligado");
		} else {
			hours = getTimerFim().getHour() - getTimerInicio().getHour();
		}
		return hours;
	}

	@Override
	public void status() {
		if (this.trancada == true)
			super.setStatus("Trancada");
		else
			super.setStatus("Destrancada");
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isTrancada() {
		return trancada;
	}

	public void setTrancada(boolean trancada) {
		this.trancada = trancada;
	}

	public boolean isAlarme() {
		return alarme;
	}

	public void setAlarme(boolean alarme) {
		if (this.trancada == true)
			this.alarme = alarme;
		else
			this.alarme = false;
	}

	@Override
	public String toString() {
		return "Fechadura [" + super.toString() + "Senha: " + this.senha + "; Trancada: " + this.trancada + "; Alarme: "
				+ this.alarme + "]\n";
	}

}

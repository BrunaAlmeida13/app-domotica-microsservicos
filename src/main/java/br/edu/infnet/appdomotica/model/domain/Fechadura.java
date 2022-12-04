package br.edu.infnet.appdomotica.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.appdomotica.model.exceptions.TamanhoMaximoSenhaException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "fechadura")
@Getter
@Setter
@ToString
public class Fechadura extends Aparelho {
	private String senha;
	private boolean trancada;
	private boolean alarme;

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

	public void setAlarme(boolean alarme) {
		if (this.trancada == true)
			this.alarme = alarme;
		else
			this.alarme = false;
	}

}

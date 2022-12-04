package br.edu.infnet.appdomotica.model.domain;

import br.edu.infnet.appdomotica.model.exceptions.TamanhoMaximoSenhaException;
import br.edu.infnet.appdomotica.model.exceptions.TemperaturaNaoPodeSerMuitoBaixa;
import br.edu.infnet.appdomotica.model.exceptions.VolumeSomInvalidoException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "aparelho")
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Aparelho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String status;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime timerInicio = LocalDateTime.now();
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime timerFim = LocalDateTime.now();

	@ManyToOne(targetEntity = Comodo.class)
	@JoinColumn(name = "idComodo")
	private Comodo comodo;

	@ManyToOne
	@JoinColumn(name = "idMorador")
	private Morador morador;

	public abstract long quantidadeHorasAgendada()
			throws VolumeSomInvalidoException, TamanhoMaximoSenhaException, TemperaturaNaoPodeSerMuitoBaixa;

	public abstract void status();

	public void timerInicioConversao(String timerString) {
		LocalDateTime timerInicio = LocalDateTime.parse(timerString);
		this.setTimerInicio(timerInicio);
	}

	public void timerFimConversao(String timerString) {
		LocalDateTime timerFim = LocalDateTime.parse(timerString);
		this.setTimerInicio(timerFim);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aparelho other = (Aparelho) obj;
		return Objects.equals(nome, other.nome);
	}

}

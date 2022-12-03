package br.edu.infnet.appdomotica.model.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.infnet.appdomotica.interfaces.IPrinter;
import br.edu.infnet.appdomotica.model.exceptions.TamanhoMaximoSenhaException;
import br.edu.infnet.appdomotica.model.exceptions.TemperaturaNaoPodeSerMuitoBaixa;
import br.edu.infnet.appdomotica.model.exceptions.VolumeSomInvalidoException;

@Entity
@Table(name = "TAparelho")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Aparelho implements IPrinter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String status;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime timerInicio = LocalDateTime.now();
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime timerFim = LocalDateTime.now();

	@ManyToMany(mappedBy = "listaAparelhos")
	private List<Comodo> comodos;

	@ManyToOne
	@JoinColumn(name = "idMorador")
	private Morador morador;

	public abstract long quantidadeHorasAgendada()
			throws VolumeSomInvalidoException, TamanhoMaximoSenhaException, TemperaturaNaoPodeSerMuitoBaixa;

	public abstract void status();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getTimerInicio() {
		return timerInicio;
	}

	public void setTimerInicio(LocalDateTime timerInicio) {
		this.timerInicio = timerInicio;
	}

	public LocalDateTime getTimerFim() {
		return timerFim;
	}

	public void setTimerFim(LocalDateTime timerFim) {
		this.timerFim = timerFim;
	}

	public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
	}

	public List<Comodo> getComodos() {
		return comodos;
	}

	public void setComodos(List<Comodo> comodos) {
		this.comodos = comodos;
	}

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

	@Override
	public String toString() {
		return "Nome: " + this.nome + ", Status: " + this.status + ", Timer Inicio: " + this.timerInicio
				+ ", Timer Fim: " + this.timerFim + "; ";
	}
}

package br.edu.infnet.appdomotica.model.domain;

import br.edu.infnet.appdomotica.model.exceptions.TemperaturaNaoPodeSerMuitoBaixa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "arcondicionado")
@Getter
@Setter
@ToString
public class ArCondicionado extends Aparelho {

    private double temperatura;
    private boolean ventilacao;
    private boolean power;

    @Override
    public long quantidadeHorasAgendada() throws TemperaturaNaoPodeSerMuitoBaixa {

        if (this.getTemperatura() < 10) {
            this.setTemperatura(10);
            throw new TemperaturaNaoPodeSerMuitoBaixa(
                    "Temperatura não aceita! Temperatura abaixo de 10 pode congelar o A.C.");
        }

        long hours = 1;
        if (getTimerFim() == null || getTimerInicio() == null) {
            System.out.println("Função horario de funcionamento para no mínimo 1h");
        } else {
            hours = getTimerFim().getHour() - getTimerInicio().getHour();
        }
        return hours;
    }

    @Override
    public void status() {
        if (this.power == true)
            super.setStatus("On");
        else
            super.setStatus("Off");
    }
}

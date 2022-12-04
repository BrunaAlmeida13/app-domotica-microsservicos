package br.edu.infnet.appdomotica.model.domain;

import br.edu.infnet.appdomotica.model.exceptions.VolumeSomInvalidoException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "luz")
@Getter
@Setter
@ToString(callSuper = true)
public class Luz extends Aparelho {
    private String cor;
    private int intensidade;
    private int volumeSom;
    private boolean power;

    @Override
    public long quantidadeHorasAgendada() throws VolumeSomInvalidoException {

        if (this.getVolumeSom() < 0 || this.getVolumeSom() > 100) {
            throw new VolumeSomInvalidoException(
                    "Volume: " + this.getVolumeSom() + ". O volume não pode ser menor que 0 ou maior que 100!");
        }

        long hours = 0;
        if (getTimerFim() == null || getTimerInicio() == null) {
            System.out.println("Função horario de funcionamento desligado");
        } else {
            hours = getTimerFim().getHour() - getTimerInicio().getHour();
            boolean tempoMaximo = hours >= 11;
            if (tempoMaximo) {
                this.power = false;
                this.volumeSom = 0;
                this.setStatus("Off");
            }
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

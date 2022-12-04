package br.edu.infnet.appdomotica.model.domain;

import br.edu.infnet.appdomotica.model.exceptions.CpfInvalidoException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "responsavel")
@Getter
@Setter
@ToString
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;
    private String senha;
    private String cpf;
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "idMorador")
    private Morador morador;

    public Responsavel() {

    }

    public Responsavel(String login, String senha, String cpf, String telefone) throws CpfInvalidoException {
        if (cpf == null)
            throw new CpfInvalidoException("Não é possível aceitar CPF nulo.");
        if (cpf.isEmpty())
            throw new CpfInvalidoException("Não é póssível aceitar CPF sem preenchimento");
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
    }
}

package br.edu.infnet.appdomotica.model.domain;

import br.edu.infnet.appdomotica.model.exceptions.ComodoSemAparelhosException;
import br.edu.infnet.appdomotica.model.exceptions.ResponsavelNuloException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "comodo")
@Getter
@Setter
@ToString
public class Comodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipo;
    private String nome;

    @OneToMany(mappedBy = "comodo", fetch = FetchType.LAZY)
    private Set<Aparelho> listaAparelhos;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idResponsavel")
    private Responsavel responsavel;

    @ManyToOne
    @JoinColumn(name = "idMorador")
    private Morador morador;

    public Comodo() {
    }

    public Comodo(Responsavel responsavel, Set<Aparelho> listaAparelhos)
            throws ResponsavelNuloException, ComodoSemAparelhosException {

        if (responsavel == null) {
            throw new ResponsavelNuloException("Não tem como controlar os aparelhos de um cômodo sem um responsável.");
        }

        /*
         * if (listaAparelhos == null) { throw new
         * ComodoSemAparelhosException("Não tem como controlar um cômodo sem uma listagem de aparelhos."
         * ); }
         *
         * if (listaAparelhos.size() < 1) { throw new
         * ComodoSemAparelhosException("Não tem como controlar um cômodo sem aparelhos."
         * ); }
         */

        this.responsavel = responsavel;
        this.listaAparelhos = listaAparelhos;
    }

}

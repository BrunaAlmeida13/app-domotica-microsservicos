package br.edu.infnet.appdomotica.model.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "morador")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String senha;

    @OneToMany
    @JoinColumn(name = "idMorador")
    private List<Responsavel> responsaveis;

    @OneToMany
    @JoinColumn(name = "idMorador")
    private List<Aparelho> aparelhos;

    @OneToMany
    @JoinColumn(name = "idMorador")
    private List<Comodo> comodos;

}

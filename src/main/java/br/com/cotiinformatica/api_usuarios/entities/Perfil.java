package br.com.cotiinformatica.api_usuarios.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PERFIL")
public class Perfil {

    @Id
    @Column(name = "ID_PERFIL")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NOME", length = 50, nullable=false, unique=true)
    private String nome;

    @OneToMany(mappedBy = "perfil")
    private List<Usuario> usuarios;
}

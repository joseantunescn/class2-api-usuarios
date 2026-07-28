package br.com.cotiinformatica.api_usuarios.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 50, nullable=false, unique=false )
    private String nome;

    @Column(name = "email", length = 100, nullable=false, unique=true)
    private String email;

    @Column(name = "senha", length = 255, nullable=false)
    private String senha;

    @Column(name = "data_hora_cadastro", nullable=false)
    private LocalDateTime dataHoraCadastro;

    @ManyToOne
    @JoinColumn(name = "perfil_id", nullable=false)
    private Perfil perfil;

}

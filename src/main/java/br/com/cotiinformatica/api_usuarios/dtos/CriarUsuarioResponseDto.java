package br.com.cotiinformatica.api_usuarios.dtos;

import java.time.LocalDateTime;

public record CriarUsuarioResponseDto(

    String mensagen,
    Integer idUsuario,
    String nome,
    String email,
    String perfil,
    LocalDateTime dataHoraCadastro

) {
}

package br.com.cotiinformatica.api_usuarios.services;

import br.com.cotiinformatica.api_usuarios.dtos.AutenticarUsuarioRequestDto;
import br.com.cotiinformatica.api_usuarios.dtos.AutenticarUsuarioResponseDto;
import br.com.cotiinformatica.api_usuarios.dtos.CriarUsuarioRequestDto;
import br.com.cotiinformatica.api_usuarios.dtos.CriarUsuarioResponseDto;
import br.com.cotiinformatica.api_usuarios.entities.Usuario;
import br.com.cotiinformatica.api_usuarios.repositories.PerfilRepository;
import br.com.cotiinformatica.api_usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public CriarUsuarioResponseDto criarUsuario (CriarUsuarioRequestDto request) throws Exception {

        var usuario = new Usuario();

        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(request.senha());
        usuario.setDataHoraCadastro(LocalDateTime.now());
        // todo define user profile

        return null;
    }

    public AutenticarUsuarioResponseDto autenticarUsuario (AutenticarUsuarioRequestDto request) throws Exception{
        // Lógica para autenticar um usuário
        return null;
    }




}





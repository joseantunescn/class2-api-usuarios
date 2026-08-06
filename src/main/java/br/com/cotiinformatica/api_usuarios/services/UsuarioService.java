package br.com.cotiinformatica.api_usuarios.services;

import br.com.cotiinformatica.api_usuarios.components.CryptoComponent;
import br.com.cotiinformatica.api_usuarios.dtos.AutenticarUsuarioRequestDto;
import br.com.cotiinformatica.api_usuarios.dtos.AutenticarUsuarioResponseDto;
import br.com.cotiinformatica.api_usuarios.dtos.CriarUsuarioRequestDto;
import br.com.cotiinformatica.api_usuarios.dtos.CriarUsuarioResponseDto;
import br.com.cotiinformatica.api_usuarios.entities.Perfil;
import br.com.cotiinformatica.api_usuarios.entities.Usuario;
import br.com.cotiinformatica.api_usuarios.exceptions.EmailJaCadastradoException;
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

    @Autowired
    private CryptoComponent cryptoComponent;

    public CriarUsuarioResponseDto criarUsuario (CriarUsuarioRequestDto request) throws Exception {

        // checking if email already exists
        if(usuarioRepository.existsByEmail((request.email()))){
            throw new EmailJaCadastradoException("Email já cadastrado: " + request.email());
        }


        // creating user
        var usuario = new Usuario();

        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(cryptoComponent.cipherSHA256(request.senha()));
        usuario.setDataHoraCadastro(LocalDateTime.now());

        // checking if the "Operador" profile exists, if not, create it
        var perfil = perfilRepository.findByNome("Operador");
        if(perfil == null){
            perfil = new Perfil();
            perfil.setNome("Operador");

            perfilRepository.save(perfil);
        }

        usuario.setPerfil(perfil);

        usuarioRepository.save(usuario);

        return new CriarUsuarioResponseDto(
                "Usuário criado com sucesso!",
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                perfil.getNome(),
                LocalDateTime.now()
        );
    }

    public AutenticarUsuarioResponseDto autenticarUsuario (AutenticarUsuarioRequestDto request) throws Exception{
        // Lógica para autenticar um usuário
        return null;
    }




}





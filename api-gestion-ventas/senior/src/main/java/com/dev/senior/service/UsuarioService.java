package com.dev.senior.service;

import com.dev.senior.repository.UsuarioRepository;
import com.dev.senior.model.*;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service 
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario guardar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public void eliminar(Long id){
        usuarioRepository.deleteById(id);
    }

}

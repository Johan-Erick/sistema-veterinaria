package com.vetexpert.sistema_veterinaria.auth.service.impl;

import com.vetexpert.sistema_veterinaria.auth.model.Usuario;
import com.vetexpert.sistema_veterinaria.auth.repository.UsuarioRepository;
import com.vetexpert.sistema_veterinaria.auth.service.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Implementación del servicio de Autenticación.
 * Maneja la lógica de inicio de sesión.
 * NOTA: En el futuro, migrar a Spring Security con BCryptPasswordEncoder.
 */
@Service
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> autenticar(String username, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
        if (usuario.isPresent() && usuario.get().getPassword().equals(password)) {
            return usuario;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public boolean existePorUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }
}

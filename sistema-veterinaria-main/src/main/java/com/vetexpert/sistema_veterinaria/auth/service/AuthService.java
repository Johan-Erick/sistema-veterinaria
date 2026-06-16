package com.vetexpert.sistema_veterinaria.auth.service;

import com.vetexpert.sistema_veterinaria.auth.model.Usuario;

import java.util.Optional;

/**
 * Interfaz del servicio de Autenticación.
 * Define el contrato para las operaciones de login.
 * Preparada para migración futura a Spring Security + JWT.
 */
public interface AuthService {

    /**
     * Autentica un usuario por username y password.
     * @return Optional con el usuario si las credenciales son correctas, vacío en caso contrario.
     */
    Optional<Usuario> autenticar(String username, String password);

    /**
     * Busca un usuario por su nombre de usuario.
     */
    Optional<Usuario> buscarPorUsername(String username);

    /**
     * Verifica si existe un usuario con el nombre de usuario dado.
     */
    boolean existePorUsername(String username);
}

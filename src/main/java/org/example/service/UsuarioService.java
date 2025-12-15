package org.example.service;

import org.example.repository.AutorRepository;
import org.example.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }
}

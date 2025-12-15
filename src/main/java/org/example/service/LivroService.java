package org.example.service;

import org.example.model.Livro;
import org.example.repository.AutorRepository;
import org.example.repository.LivroRepository;

public class LivroService {

    private LivroRepository repo;

    public LivroService(LivroRepository repo) {
        this.repo = repo;
    }

    public boolean create(Livro livro){
        return repo.create(livro);
    }
}

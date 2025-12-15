package org.example.repository.interfaces;

import org.example.model.Livro;

import java.util.List;
import java.util.Optional;

public interface ILivroRepository {

    boolean create(Livro livro);
    boolean update(int id, Livro livroAtualizado);
    boolean delete(int id);
    List<Livro> findAll();
    Livro findByIsbn(String isbn);
    Optional<Livro> findById(int id);
}

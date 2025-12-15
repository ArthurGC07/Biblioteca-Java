package org.example.repository.interfaces;

import org.example.model.Autor;
import org.example.model.Livro;

import java.util.List;
import java.util.Optional;

public interface IAutorRepository {

    boolean create(String nome);
    boolean update(int id, String nome);
    boolean delete(int id);
    List<Autor> findAll();
    public Autor findByNome(String nome);
    Optional<Autor> findById(int id);
}

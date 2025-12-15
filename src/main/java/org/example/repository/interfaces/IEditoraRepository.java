package org.example.repository.interfaces;

import org.example.model.Editora;

import java.util.List;
import java.util.Optional;

public interface IEditoraRepository {
    boolean create(String nome, String endereco, Integer anoFundacao);
    boolean update(int id, String nome, String endereco, Integer anoFundacao);
    boolean delete(int id);
    List<Editora> findAll();
    Editora findByNome(String nome);
    Optional<Editora> findById(int id);
}

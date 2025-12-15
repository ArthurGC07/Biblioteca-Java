package org.example.repository.interfaces;

import org.example.model.Emprestimo;

import java.util.List;
import java.util.Optional;

public interface IEmprestimoRepository {
    boolean create(Emprestimo emprestimo);
    boolean update(int id, Emprestimo emprestimoAtualizado);
    boolean delete(int id);
    List<Emprestimo> findAll();
    String findByTituloLivro(String tituloLivro);
    Optional<Emprestimo> findById(int id);
}

package org.example.repository.interfaces;

import org.example.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepository {

    boolean create(Usuario usuario);
    boolean update(int id, Usuario usuarioAtualizado);
    boolean delete(int id);
    List<Usuario> findAll();
    Usuario findByEmail(String email);
    Optional<Usuario> findById(int id);
}

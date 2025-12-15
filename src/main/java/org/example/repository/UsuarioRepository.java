package org.example.repository;

import org.example.database.Database;
import org.example.model.Usuario;
import org.example.repository.interfaces.IUsuarioRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository implements IUsuarioRepository {

    private Database db;

    public UsuarioRepository(Database db) {
        this.db = db;
    }

    public boolean create(Usuario usuario) {
        try {
            HashMap<Integer, Usuario> map = db.getTbUsuario();
            map.put(db.createNewId(map), usuario);
            return true;

        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update(int id, Usuario usuarioAtualizado) {
        try {
            HashMap<Integer, Usuario> map = db.getTbUsuario();

            if (!map.containsKey(id)) {
                return false;
            }

            map.put(id, usuarioAtualizado); // replace
            return true;

        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            HashMap<Integer, Usuario> map = db.getTbUsuario();

            if (!map.containsKey(id)) {
                return false;
            }

            map.remove(id);
            return true;

        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Usuario> findAll() {
        return new ArrayList<>(db.getTbUsuario().values());
    }

    public Usuario findByEmail(String email) {
        for (Usuario usuario : db.getTbUsuario().values()) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public Optional<Usuario> findById(int id) {
        return Optional.ofNullable(db.getTbUsuario().get(id));
    }
}

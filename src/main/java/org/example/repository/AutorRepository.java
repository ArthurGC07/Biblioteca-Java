package org.example.repository;

import org.example.database.Database;
import org.example.model.Autor;
import org.example.repository.interfaces.IAutorRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class AutorRepository implements IAutorRepository {

    private Database db;

    public AutorRepository(Database db) {
        this.db = db;
    }

    public boolean create(String nome) {
        try {
            HashMap<Integer, Autor> map = db.getTbAutor();
            map.put(db.createNewId(map), (new Autor(db.createNewId(map), nome)));
            return true;

        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update(int id, String nome) {
        try {
            HashMap<Integer, Autor> map = db.getTbAutor();

            if (!map.containsKey(id)) {
                return false;
            }

            map.put(id, ((new Autor(id, nome))));
            return true;

        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            HashMap<Integer, Autor> map = db.getTbAutor();

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

    public List<Autor> findAll() {
        return new ArrayList<>(db.getTbAutor().values());
    }

    public Autor findByNome(String nome) {
        for (Autor autor : db.getTbAutor().values()) {
            if (autor.getNome().equals(nome)) {
                return autor;
            }
        }
        return null;
    }

    public Optional<Autor> findById(int id) {
        return Optional.ofNullable(db.getTbAutor().get(id));
    }
}

package org.example.repository;

import org.example.database.Database;
import org.example.model.Autor;
import org.example.model.Editora;
import org.example.repository.interfaces.IEditoraRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class EditoraRepository implements IEditoraRepository {

    private Database db;

    public EditoraRepository(Database db) {
        this.db = db;
    }

    public boolean create(String nome, String endereco, Integer anoFundacao) {
        try {
            HashMap<Integer, Editora> map = db.getTbEditora();
            map.put(db.createNewId(map), (new Editora(db.createNewId(map), nome, endereco, anoFundacao)));
            return true;

        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update(int id, String nome, String endereco, Integer anoFundacao) {
        try {
            HashMap<Integer, Editora> map = db.getTbEditora();

            if (!map.containsKey(id)) {
                return false;
            }

            map.put(id,(new Editora(id, nome, endereco, anoFundacao)));
            return true;

        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            HashMap<Integer, Editora> map = db.getTbEditora();

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

    public List<Editora> findAll() {
        return new ArrayList<>(db.getTbEditora().values());
    }

    public Editora findByNome(String nome) {
        for (Editora editora : db.getTbEditora().values()) {
            if (editora.getNome().equals(nome)) {
                return editora;
            }
        }
        return null;
    }

    public Optional<Editora> findById(int id) {
        return Optional.ofNullable(db.getTbEditora().get(id));
    }
}

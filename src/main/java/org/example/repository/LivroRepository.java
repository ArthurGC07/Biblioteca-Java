package org.example.repository;

import org.example.database.Database;
import org.example.model.Livro;
import org.example.repository.interfaces.ILivroRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class LivroRepository implements ILivroRepository{

    private Database db;

    public LivroRepository(Database db) {
        this.db = db;
    }

    public boolean create(Livro livro) {
        try {

            HashMap<Integer, Livro> map = db.getTbLivro();
            map.put(db.createNewId(map), livro);
            return true;

        } catch (RuntimeException e) {

            System.out.println(e);
            return false;
        }

    }

    public boolean update(int id, Livro livroAtualizado) {
        try {
            HashMap<Integer, Livro> map = db.getTbLivro();

            if (!map.containsKey(id)) {
                return false;
            }

            map.put(id, livroAtualizado); // replace
            return true;

        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            HashMap<Integer, Livro> map = db.getTbLivro();

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

    public List<Livro> findAll() {
        return new ArrayList<>(db.getTbLivro().values());
    }

    public Livro findByIsbn(String isbn) {
        for (Livro livro : db.getTbLivro().values()) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    public Optional<Livro> findById(int id) {
        return Optional.ofNullable(db.getTbLivro().get(id));
    }


}

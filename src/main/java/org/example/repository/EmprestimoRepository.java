package org.example.repository;

import org.example.database.Database;
import org.example.model.Emprestimo;
import org.example.repository.interfaces.IEmprestimoRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class EmprestimoRepository implements IEmprestimoRepository {

    private Database db;

    public EmprestimoRepository(Database db) {
        this.db = db;
    }

    public boolean create(Emprestimo emprestimo) {
        try {
            HashMap<Integer, Emprestimo> map = db.getTbEmprestimo();
            map.put(db.createNewId(map), emprestimo);
            return true;

        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update(int id, Emprestimo emprestimoAtualizado) {
        try {
            HashMap<Integer, Emprestimo> map = db.getTbEmprestimo();

            if (!map.containsKey(id)) {
                return false;
            }

            map.put(id, emprestimoAtualizado); // replace
            return true;

        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            HashMap<Integer, Emprestimo> map = db.getTbEmprestimo();

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

    public List<Emprestimo> findAll() {
        return new ArrayList<>(db.getTbEmprestimo().values());
    }

    public String findByTituloLivro(String tituloLivro) {
        for (Emprestimo emprestimo : db.getTbEmprestimo().values()) {
            if (emprestimo.getLivro().getTitulo().equals(tituloLivro)) {
                return emprestimo.toString();
            }
        }
        return null;
    }

    public Optional<Emprestimo> findById(int id) {
        return Optional.ofNullable(db.getTbEmprestimo().get(id));
    }
}

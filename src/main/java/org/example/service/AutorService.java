package org.example.service;

import org.example.model.Autor;
import org.example.repository.AutorRepository;

import java.util.List;
import java.util.Optional;

public class AutorService {

    private AutorRepository repo;

    public AutorService(AutorRepository repo) {
        this.repo = repo;
    }

    public boolean create(String nome){
        boolean check = repo.create(nome);

        if (check){
            System.out.println("Autor cadastrado com sucesso!");
            return true;
        }
        else {
            return false;
        }

    }

    public boolean update(int id, String nome){
        boolean check = repo.update(id, nome);

        if (check){
            System.out.println("Autor atualizado com sucesso!");
            return true;
        }
        else {
            return false;
        }
    }

    public List<Autor> findAll(){
        return repo.findAll();
    }

    public boolean delete(int id){
        return repo.delete(id);
    }
}

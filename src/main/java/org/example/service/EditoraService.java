package org.example.service;

import org.example.model.Autor;
import org.example.model.Editora;
import org.example.repository.AutorRepository;
import org.example.repository.EditoraRepository;

import java.util.List;

public class EditoraService {

    private EditoraRepository repo;

    public EditoraService(EditoraRepository repo) {
        this.repo = repo;
    }

    public boolean create(String nome, String endereco, Integer anoFundacao){
        boolean check = repo.create(nome, endereco, anoFundacao);

        if (check){
            System.out.println("Autor cadastrado com sucesso!");
            return true;
        }
        else {
            return false;
        }

    }

    public boolean update(int id, String nome, String endereco, Integer anoFundacao){
        boolean check = repo.update(id, nome, endereco, anoFundacao);

        if (check){
            System.out.println("Editora atualizado com sucesso!");
            return true;
        }
        else {
            return false;
        }
    }

    public List<Editora> findAll(){
        return repo.findAll();
    }

    public boolean delete(int id){
        return repo.delete(id);
    }
}

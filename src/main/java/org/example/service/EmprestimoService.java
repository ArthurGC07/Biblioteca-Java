package org.example.service;

import org.example.repository.AutorRepository;
import org.example.repository.EmprestimoRepository;

public class EmprestimoService {

    private EmprestimoRepository repo;

    public EmprestimoService(EmprestimoRepository repo) {
        this.repo = repo;
    }
}

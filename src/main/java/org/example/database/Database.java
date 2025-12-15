package org.example.database;

import org.example.model.*;
import org.example.model.enumerations.StatusLivro;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

//Essa classe funciona como um pseudo database
public class Database {

    private HashMap<Integer, Livro> tbLivro = new HashMap<>();
    private HashMap<Integer, Editora> tbEditora = new HashMap<>();
    private HashMap<Integer, Autor> tbAutor = new HashMap<>();
    private HashMap<Integer, Usuario> tbUsuario = new HashMap<>();
    private HashMap<Integer, Emprestimo> tbEmprestimo = new HashMap<>();

    public Database() {
        initDummyData();
    }

    private void initDummyData() {

        // ===== AUTORES =====
        Autor autor1 = new Autor(1,"George Orwell");
        Autor autor2 = new Autor(2,"J. R. R. Tolkien");

        tbAutor.put(1, autor1);
        tbAutor.put(2, autor2);

        // ===== EDITORAS =====
        Editora editora1 = new Editora(1, "Companhia das Letras", "Rua ABC", 2020);
        Editora editora2 = new Editora(2, "HarperCollins", "Oak Street 12", 2018);

        tbEditora.put(1, editora1);
        tbEditora.put(2, editora2);

        // ===== LIVROS =====
        Livro livro1 = new Livro(
                "1984",
                autor1,
                editora1,
                "9780451524935",
                5
        );

        Livro livro2 = new Livro(
                "The Hobbit",
                autor2,
                editora2,
                "9780261103344",
                4
        );

        tbLivro.put(1, livro1);
        tbLivro.put(2, livro2);

        // ===== USUÁRIOS =====
        Usuario usuario1 = new Usuario("Alice", "alice@email.com");
        Usuario usuario2 = new Usuario("Bob", "bob@email.com");

        tbUsuario.put(1, usuario1);
        tbUsuario.put(2, usuario2);

        // ===== EMPRÉSTIMOS =====
        Emprestimo emprestimo1 = new Emprestimo(
                livro1,
                StatusLivro.EMPRESTADO,
                usuario1,
                LocalDate.now(),
                LocalDate.now().plusDays(7),
                null // ainda não devolvido
        );

        Emprestimo emprestimo2 = new Emprestimo(
                livro2,
                StatusLivro.EMPRESTADO,
                usuario2,
                LocalDate.of(2025, 8, 13),
                LocalDate.of(2025, 8, 20),
                null // ainda não devolvido
        );

        tbEmprestimo.put(1, emprestimo1);
        tbEmprestimo.put(2, emprestimo2);
    }

    public HashMap<Integer, Livro> getTbLivro() {
        return tbLivro;
    }

    public HashMap<Integer, Editora> getTbEditora() {
        return tbEditora;
    }

    public HashMap<Integer, Autor> getTbAutor() {
        return tbAutor;
    }

    public HashMap<Integer, Usuario> getTbUsuario() {
        return tbUsuario;
    }

    public HashMap<Integer, Emprestimo> getTbEmprestimo() {
        return tbEmprestimo;
    }

    //  conta o ID maximo do mapa e soma + 1 para evitar conflitos de chave
    public int createNewId(HashMap<Integer,?> table){
        int max = 0;
        for (Integer key : table.keySet()){
            if (key > max){
                max = key;
            }
        }

        return max + 1;
    }
}


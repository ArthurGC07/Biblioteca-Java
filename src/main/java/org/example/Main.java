package org.example;

import org.example.database.Database;
import org.example.gui.Gui;
import org.example.repository.*;
import org.example.service.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

//        singleton para realizar DI
        Database db = new Database();

//        Repositorios para DI
        AutorRepository autorRepository = new AutorRepository(db);
        EditoraRepository editoraRepository = new EditoraRepository(db);
        EmprestimoRepository emprestimoRepository = new EmprestimoRepository(db);
        LivroRepository livroRepository = new LivroRepository(db);
        UsuarioRepository usuarioRepository = new UsuarioRepository(db);

        // Services para utilização
        AutorService autorService = new AutorService(autorRepository);
        EditoraService editoraService = new EditoraService(editoraRepository);
        EmprestimoService emprestimoService = new EmprestimoService(emprestimoRepository);
        LivroService livroService = new LivroService(livroRepository);
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);

//        --------------------- Inicializacao da GUI ---------------------

        Scanner sc = new Scanner(System.in);
        Gui gui = new Gui(autorService, editoraService, emprestimoService, livroService, usuarioService, sc);

        boolean boot = true;
        while (boot) {

            System.out.println("\n====== BIBLIOTECA ======");
            System.out.println("1 - Livros");
            System.out.println("2 - Autores");
            System.out.println("3 - Usuarios");
            System.out.println("4 - Editoras");
            System.out.println("5 - Emprestimos");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            int opcao = -1;
            String entry = sc.nextLine();

            try {
                opcao = Integer.parseInt(entry);
            } catch (NumberFormatException e) {
                System.out.println("opcao nao eh um numero");
                continue;
            }

            switch (opcao) {

                case 1:
                    gui.telaLivros();
                    break;

                case 2:
                    gui.telaAutor();
                    break;

                case 4:
                    gui.telaEditora();
                    break;
                case 0:
                    System.out.println("Encerrando Sistema...");
                    boot = false;
                    break;
            }

        }

        sc.close();
    }


}
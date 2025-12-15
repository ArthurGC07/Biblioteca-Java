package org.example.gui;

import org.example.model.Autor;
import org.example.model.Editora;
import org.example.service.*;

import java.util.List;
import java.util.Scanner;

public class Gui {

    private AutorService autorService;
    private EditoraService editoraService;
    private EmprestimoService emprestimoService;
    private LivroService livroService;
    private UsuarioService usuarioService;
    private Scanner sc;

    public Gui(AutorService autorService, EditoraService editoraService, EmprestimoService emprestimoService, LivroService livroService, UsuarioService usuarioService, Scanner sc) {
        this.autorService = autorService;
        this.editoraService = editoraService;
        this.emprestimoService = emprestimoService;
        this.livroService = livroService;
        this.usuarioService = usuarioService;
        this.sc = sc;
    }

    public void telaLivros() {
        boolean running = true;

        while (running) {
            System.out.println("\n====== LIVROS ======");
            System.out.println("\n====== ATENCAO! PARA CADASTRAR LIVRO PRIMEIRO CADASTRE O AUTOR E A EDITORA ====== \n");
            System.out.println("1 - Cadastrar novo Livro");
            System.out.println("2 - Atualizar livro existente");
            System.out.println("3 - Remover livro");
            System.out.println("4 - Mostrar todos os livros");
            System.out.println("5 - Pesquisar livro por ISBN");
            System.out.println("6 - Pesquisar livro por ID");
            System.out.println("0 - Voltar");
            System.out.print("Opcao: ");

            int opcao = -1;
            try {
                opcao = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("opcao nao eh um numero");
                continue;
            }

            switch (opcao) {

                case 1:
                    System.out.println("Insira o titulo do livro: ");
                    String titulo = sc.nextLine();
//                    ....

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }


    }

    public void telaAutor(){
        boolean running = true;

        while (running) {
            System.out.println("\n====== Autor ======\n");
            System.out.println("1 - Cadastrar novo Autor");
            System.out.println("2 - Atualizar Autor existente");
            System.out.println("3 - Remover Autor");
            System.out.println("4 - Mostrar todos os Autores");
            System.out.println("0 - Voltar");
            System.out.print("Opcao: ");

            int opcao = -1;
            try {
                opcao = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("opcao nao eh um numero");
                continue;
            }

            switch (opcao) {

                case 1:
                    System.out.println("Insira o nome do autor: ");
                    String nome = sc.nextLine();
                    boolean check = autorService.create(nome);

                    if (check){
                        continue;
                    }

                    break;

                case 2:
                    System.out.println("selecione o Autor para atualizar");
                    List<Autor> list = autorService.findAll();
                    if (!list.isEmpty()){
                        for (Autor autor : list){
                            System.out.println(autor.getId() + " - " + autor.getNome());
                        }
                    }

                    int autorId = Integer.parseInt(sc.nextLine());

                    System.out.println("Novo nome para o Autor: ");
                    String nomeAut = sc.nextLine();
                    var test = autorService.update(autorId, nomeAut);
                    System.out.println(test);

                    break;

                case 3:
                    System.out.println("Qual Autor deseja remover?");
                    list = autorService.findAll();
                    if (!list.isEmpty()){
                        for (Autor autor : list){
                            System.out.println(autor.getId() + " - " + autor.getNome());
                        }
                    }

                    autorService.delete(Integer.parseInt(sc.nextLine()));

                    break;

                case 4:
                    list = autorService.findAll();
                    if (!list.isEmpty()){
                        System.out.println(" ===== AUTORES CADASTRADOS ===== \n");
                        for (Autor autor : list){
                            System.out.println(autor.getId() + " - " + autor.getNome());
                        }
                    }
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }

    public void telaEditora(){
        boolean running = true;

        while (running) {
            System.out.println("\n====== Editora ======\n");
            System.out.println("1 - Cadastrar nova Editora");
            System.out.println("2 - Atualizar Editora existente");
            System.out.println("3 - Remover Editora");
            System.out.println("4 - Mostrar todos as Editoras");
            System.out.println("0 - Voltar");
            System.out.print("Opcao: ");

            int opcao = -1;
            try {
                opcao = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("opcao nao eh um numero");
                continue;
            }

            switch (opcao) {

                case 1:
                    System.out.println("Insira o nome da editora: ");
                    String nome = sc.nextLine();

                    System.out.println("Insira o Endereco da editora: ");
                    String endereco = sc.nextLine();

                    System.out.println("Insira a data de fundacao da editora: ");
                    Integer anoFundacao = Integer.parseInt(sc.nextLine());

                    boolean check = editoraService.create(nome, endereco, anoFundacao);

                    if (check){
                        continue;
                    }

                    break;

                case 2:
                    System.out.println("selecione a editora para atualizar");
                    List<Editora> list = editoraService.findAll();
                    if (!list.isEmpty()){
                        for (Editora editora : list){
                            System.out.println(editora.getId() + " - " + editora.getNome() + " | " + editora.getEndereco() + " | " + editora.getAnoFundacao());
                        }
                    }

                    int editoraId = Integer.parseInt(sc.nextLine());

                    System.out.println("Novo nome para a Editora: ");
                    nome = sc.nextLine();

                    System.out.println("Novo endereco para a Editora: ");
                    endereco = sc.nextLine();

                    System.out.println("Novo ano de fundacao da Editora: ");
                    anoFundacao = Integer.parseInt(sc.nextLine());

                    var test = editoraService.update(editoraId, nome, endereco, anoFundacao);
                    System.out.println(test);

                    break;

                case 3:
                    System.out.println("Qual Editora deseja remover?");
                    list = editoraService.findAll();
                    if (!list.isEmpty()){
                        for (Editora editora : list){
                            System.out.println(editora.getId() + " - " + editora.getNome());
                        }
                    }

                    editoraService.delete(Integer.parseInt(sc.nextLine()));

                    break;

                case 4:
                    list = editoraService.findAll();
                    if (!list.isEmpty()){
                        System.out.println(" ===== EDITORAS CADASTRADAS ===== \n");
                        System.out.println(" ===== ID | NOME | ENDERECO | DT FUNDACAO ===== \n");
                        for (Editora editora : list){
                            System.out.println(editora.getId() + " - " + editora.getNome() + " | " + editora.getEndereco() + " | " + editora.getAnoFundacao());
                        }
                    }
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }
}

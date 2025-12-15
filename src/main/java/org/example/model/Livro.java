package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.model.enumerations.StatusLivro;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Livro {

    private String titulo;
    private Autor autor;
    private Editora editora;
    private String isbn;
    private int qtdDisponivel;
}

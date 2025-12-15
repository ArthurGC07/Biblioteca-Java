package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.enumerations.StatusLivro;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Emprestimo {

    private Livro livro;
    private StatusLivro status;
    private Usuario usuario;
    private LocalDate dtEmprestimo;
    private LocalDate dtDevolucaoEstimada;
    private LocalDate dtDevolucao;
}

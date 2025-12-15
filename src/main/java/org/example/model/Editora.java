package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Editora {

    private Integer id;
    private String nome;
    private String endereco;
    private Integer anoFundacao;
}

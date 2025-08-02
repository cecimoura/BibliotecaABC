package com.biblioteca.biblioteca_ABC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Livro {
    private int id;
    private String issn;
    private String titulo;
    private String sinopse;
    private int ano;
    private int numeroPaginas;
}

package com.biblioteca.biblioteca_ABC.service;

import com.biblioteca.biblioteca_ABC.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {
    private List<Livro>livros = new ArrayList<>();

    public List<Livro> listAll(){
        return livros;
    }

    public Livro findById(int id){
        for(Livro livro : livros){
            if(livro.getId() == id){
                return livro;
            }
        }
        return null;
    }

    //save, update, delete





}


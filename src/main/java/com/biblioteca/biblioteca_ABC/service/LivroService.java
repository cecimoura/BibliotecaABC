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

    public Livro save(Livro livro){
        livros.add(livro);
        return livro;
    }

    public Livro update(int id, Livro livroUpdate) {
        Livro livro = findById(id);

        if (livro != null) {
            livro.setIssn(livroUpdate.getIssn());
            livro.setTitulo(livroUpdate.getTitulo());
            livro.setSinopse(livroUpdate.getSinopse());
            livro.setAno(livroUpdate.getAno());
            livro.setNumeroPaginas(livroUpdate.getNumeroPaginas());
        }
        return livro;
    }

    public void delete(int id){
        for(int i = 0; i < livros.size(); i++){
            if(livros.get(i).getId() == id){
                livros.remove(i);
                break;
            }
        }
    }
    
}


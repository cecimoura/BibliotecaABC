package com.biblioteca.biblioteca_ABC.service;

import com.biblioteca.biblioteca_ABC.model.Biblioteca;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BibliotecaService {
    private final List<Biblioteca> bibliotecaList = new ArrayList<>();

    public List<Biblioteca> listAll(){
        return bibliotecaList;
    }

    public Biblioteca findById(int id){
        for (Biblioteca biblioteca : bibliotecaList){
            if (biblioteca.getId() == id){
                return biblioteca;
            }
        }
        return null;
    }

    public Biblioteca save(Biblioteca biblioteca){
        bibliotecaList.add(biblioteca);
        return biblioteca;
    }

    public Biblioteca update (int id, Biblioteca bibliotecaUpdate){
        for(int i = 0; i < bibliotecaList.size(); i++){
            if(bibliotecaList.get(i).getId() == id){
                bibliotecaList.set(i, bibliotecaUpdate);
                return bibliotecaUpdate;
            }
        }
        return null;
    }

    public void delete(int id){
        Biblioteca biblioteca = findById(id); //reutiliza o metodo q busca o ID
       if(biblioteca != null){
           bibliotecaList.remove(biblioteca);
       }
   }
}

package com.biblioteca.biblioteca_ABC.service;

import com.biblioteca.biblioteca_ABC.model.Autor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {
    private List<Autor> autorLista = new ArrayList<>();

    public List<Autor> listAll(){
        return autorLista;
    }

    public Autor findById(int id){
        for (Autor autor : autorLista){
            if(autor.getId() == id){
                return autor;
            }
        }
        return null;
    }

    public Autor save(Autor autor){
        autorLista.add(autor);
        return autor;
    }

    public Autor update(int id, Autor autorUpdate) {
        for (int i = 0; i < autorLista.size(); i++) {
            if (autorLista.get(i).getId() == id) {
                autorLista.set(i, autorUpdate);
                return autorUpdate;
            }
        }
        return null;
    }


    public void delete(int id){
        for(int i = 0; i < autorLista.size(); i++){
            if(autorLista.get(i).getId() == id){
                autorLista.remove(i);
                break;
            }
        }
    }


}

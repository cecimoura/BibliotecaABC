package com.biblioteca.biblioteca_ABC.service;

import com.biblioteca.biblioteca_ABC.model.Editora;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EditoraService {
    private final List<Editora> editoraList = new ArrayList<>();

    public List<Editora> listAll(){
        return editoraList;
    }

    public Editora findById(int id){
        for(Editora editora : editoraList){
            if(editora.getId() == id){
                return editora;
            }
        }
        return null;
    }

    public Editora save(Editora editora){
        editoraList.add(editora);
        return editora;
    }

    public Editora update(int id, Editora editoraUpdate){
        for(int i = 0; i < editoraList.size(); i++){
            if(editoraList.get(i).getId() == id){
                editoraList.set(i, editoraUpdate);
                    return editoraUpdate;

            }
        }
        return null;
    }

    public void delete(int id){
        Editora editora = findById(id);

        if(editora != null){
            editoraList.remove(editora);
        }
    }

}

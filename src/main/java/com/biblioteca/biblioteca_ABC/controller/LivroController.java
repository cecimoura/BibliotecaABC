package com.biblioteca.biblioteca_ABC.controller;

import com.biblioteca.biblioteca_ABC.model.Livro;
import com.biblioteca.biblioteca_ABC.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros") // Base da URL para os endpoints da entidade Livro

public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    //Lista todos os livros
    @GetMapping("/findAll")
    public ResponseEntity<List<Livro>>findAll(){
        try{
            var result = livroService.listAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Busca livro pelo ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<Livro> findById(@PathVariable int id){
        try{
            var result = livroService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch(Exception ignored){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    //Cadastra um novo livro
    @PostMapping("/save")
    public ResponseEntity<Livro> save (@RequestBody Livro livro){
        try{
            var result = livroService.save(livro);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
        catch (Exception ignored){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //Atualiza um livro existente
    @PutMapping("/update/{id}")
    public ResponseEntity<Livro> update (@PathVariable int id, @RequestBody Livro livroUpdate){
        try{
            var result = livroService.update(id, livroUpdate);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //Remove um livro pelo ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            livroService.delete(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (Exception ignored) {
            return ResponseEntity.badRequest().build(); // 400
        }
    }

}

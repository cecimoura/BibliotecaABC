package com.biblioteca.biblioteca_ABC.controller;

import com.biblioteca.biblioteca_ABC.model.Editora;
import com.biblioteca.biblioteca_ABC.service.EditoraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editora")

public class EditoraController {
    private final EditoraService editoraService;

    public EditoraController(EditoraService editoraService) {
        this.editoraService = editoraService;

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Editora>> findAll() {
        try {
            var result = editoraService.listAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Editora> findById(@PathVariable int id) {
        try {
            var result = editoraService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Editora> save(@RequestBody Editora editora) {
        try {
            var result = editoraService.save(editora);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Editora> update(@PathVariable int id, @RequestBody Editora editoraUpdate) {
        try {
            var result = editoraService.update(id, editoraUpdate);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ignored) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            editoraService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

}

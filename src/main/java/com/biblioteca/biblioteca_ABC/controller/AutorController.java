package com.biblioteca.biblioteca_ABC.controller;

import com.biblioteca.biblioteca_ABC.model.Autor;
import com.biblioteca.biblioteca_ABC.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autor")

public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Autor>> findAll() {
        try {
            var result = autorService.listAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Autor> findById(@PathVariable int id) {
        try {
            var result = autorService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Autor> save(@RequestBody Autor autor) {
        try {
            var result = autorService.save(autor);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Autor> update(@PathVariable int id, @RequestBody Autor autorUpdate) {
        try {
            var result = autorService.update(id, autorUpdate);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            autorService.delete(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build(); // 400
        }
    }
}

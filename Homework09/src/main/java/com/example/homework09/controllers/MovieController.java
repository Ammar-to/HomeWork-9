package com.example.homework09.controllers;


import com.example.homework09.models.Movies;
import com.example.homework09.services.MovieServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor
@RequestMapping("api/v1/movie")
public class MovieController {
    private final MovieServices movieServices;

    @GetMapping("/")
    public ResponseEntity getMovies(){
        return ResponseEntity.status(200).body(movieServices.getMovies());
    }

    @PostMapping("/")
    public ResponseEntity addMovie(@RequestBody Movies movie, Errors error){
        if(error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        movieServices.addMovie(movie);
        return ResponseEntity.status(201).body("Successfully added!");

    }

    @PutMapping("/{id}")
    public ResponseEntity updateMovie(@RequestBody Movies movie, Errors error, @PathVariable Integer id){
        if(error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        movieServices.updateMovie(movie, id);
        return ResponseEntity.status(201).body("Successfully updated!");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        movieServices.deleteMovie(id);
        return ResponseEntity.status(201).body("Successfully deleted!");

    }


}

package com.example.homework09.services;

import com.example.homework09.models.Movies;
import com.example.homework09.repository.MoviesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service @RequiredArgsConstructor
public class MovieServices {
    private final MoviesRepository moviesRepository;

    public List getMovies(){
       return moviesRepository.findAll();
    }

    public void addMovie(Movies movie){
        moviesRepository.save(movie);
    }
    public void updateMovie(Movies movie, Integer id){
        Movies mo = moviesRepository.findById(id).get();
        mo.setDate(movie.getDate());
        mo.setDuration(movie.getDuration());
        mo.setName(movie.getName());
        mo.setRating(movie.getRating());
        mo.setGenre(movie.getGenre());
        moviesRepository.save(mo);
    }

    public void deleteMovie(Integer id){
        moviesRepository.deleteById(id);
    }
}

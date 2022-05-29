package com.example.homework09.repository;

import com.example.homework09.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {}




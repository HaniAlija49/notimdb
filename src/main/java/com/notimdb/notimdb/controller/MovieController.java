package com.notimdb.notimdb.controller;

import com.notimdb.notimdb.pojo.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MovieController {
@Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return MovieService.findAll();
    }
    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable int id){
        return MovieService.getMovieById(id);
    }

    @PostMapping("/movies")
    public Movie createStudent(@RequestBody Movie newMovie) {
        Movie movie = new Movie();
        movie.setTitle(newMovie.getTitle());
        movie.setReleaseDate(newMovie.getReleaseDate());
        movie.setDescription(newMovie.getDescription());
        movie.setRating(newMovie.getRating());
        movie.setTitle(newMovie.getTitle());
        movie.setPosterUrl(newMovie.getPosterUrl());

        return MovieServie.CreateMovie(movie);
    }
}

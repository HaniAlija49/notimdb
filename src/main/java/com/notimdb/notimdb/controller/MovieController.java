package com.notimdb.notimdb.controller;

import com.notimdb.notimdb.pojo.dto.MovieUpdateRequest;
import com.notimdb.notimdb.pojo.entity.Movie;
import com.notimdb.notimdb.repository.MovieRepository;
import com.notimdb.notimdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable int id){
        return movieService.getMovieById(id);
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

        return movieService.createMovie(movie);
    }
    @PutMapping("/movies/{id}")
    public Movie update(
            @PathVariable Integer id,
            @RequestBody MovieUpdateRequest request) {



        return movieService.updateMovie(id,request);
    }
}

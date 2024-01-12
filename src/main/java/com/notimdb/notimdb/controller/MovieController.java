package com.notimdb.notimdb.controller;

import com.notimdb.notimdb.pojo.dto.MovieCreateRequest;
import com.notimdb.notimdb.pojo.dto.MovieUpdateRequest;
import com.notimdb.notimdb.pojo.entity.Director;
import com.notimdb.notimdb.pojo.entity.Movie;
import com.notimdb.notimdb.repository.DirectorRepository;
import com.notimdb.notimdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MovieController {
    MovieService movieService;
    DirectorRepository directorRepository;

    @Autowired
    public MovieController(MovieService movieService,DirectorRepository directorRepository) {
        this.movieService = movieService;
        this.directorRepository = directorRepository;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable int id){
        return movieService.getMovieById(id);
    }

    @PostMapping("/movies")
    public Movie createMovie(@RequestBody MovieCreateRequest newMovie) {
        Movie movie = new Movie();
        movie.setTitle(newMovie.getTitle());
        movie.setReleaseDate(newMovie.getReleaseDate());
        movie.setDescription(newMovie.getDescription());
        movie.setRating(newMovie.getRating());
        movie.setTitle(newMovie.getTitle());
        movie.setPosterUrl(newMovie.getPosterUrl());
        Director director = directorRepository.findById(newMovie.getDirectorId()).orElse(null);
        movie.setDirector(director);

        return movieService.createMovie(movie);
    }
    @PutMapping("/movies/{id}")
    public Movie update(
            @PathVariable Integer id,
            @RequestBody MovieUpdateRequest request) {



        return movieService.updateMovie(id,request);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
    }
}

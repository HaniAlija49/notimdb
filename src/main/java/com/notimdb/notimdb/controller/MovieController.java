package com.notimdb.notimdb.controller;

import com.notimdb.notimdb.pojo.dto.MovieCreateRequest;
import com.notimdb.notimdb.pojo.dto.MovieUpdateRequest;
import com.notimdb.notimdb.pojo.entity.Director;
import com.notimdb.notimdb.pojo.entity.Genre;
import com.notimdb.notimdb.pojo.entity.Movie;
import com.notimdb.notimdb.repository.DirectorRepository;
import com.notimdb.notimdb.repository.GenreRepository;
import com.notimdb.notimdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class MovieController {
    MovieService movieService;
    DirectorRepository directorRepository;
    GenreRepository genreRepository;

    @Autowired
    public MovieController(MovieService movieService,DirectorRepository directorRepository,GenreRepository genreRepository) {
        this.movieService = movieService;
        this.directorRepository = directorRepository;
        this.genreRepository=genreRepository;
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
        Set<Genre> genres = new HashSet<>();
        for (Integer id:newMovie.getGenresIds()) {
            Genre genre = genreRepository.findById(id).orElse(null);
            genres.add(genre);
        }
        movie.setGenres(genres);
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

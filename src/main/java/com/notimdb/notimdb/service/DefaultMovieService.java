package com.notimdb.notimdb.service;

import com.notimdb.notimdb.pojo.dto.MovieUpdateRequest;
import com.notimdb.notimdb.pojo.entity.Movie;
import com.notimdb.notimdb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie updateMovie(Integer id, MovieUpdateRequest request) {
       Movie movie = getMovieById(id);
        if (movie != null) {
            movie.setTitle(request.getTitle());
            movie.setReleaseDate(request.getReleaseDate());
            movie.setDescription(request.getDescription());
            movie.setRating(request.getRating());
            movie.setTitle(request.getTitle());
            movie.setPosterUrl(request.getPosterUrl());
            movieRepository.save(movie);
        }
        return movie;
    }
}

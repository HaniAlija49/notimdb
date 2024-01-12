package com.notimdb.notimdb.service;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(Integer id);

    Movie createMovie(Movie movie);

    void deleteMovie(Integer id);

}

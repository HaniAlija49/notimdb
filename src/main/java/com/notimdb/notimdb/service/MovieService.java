package com.notimdb.notimdb.service;

import com.notimdb.notimdb.pojo.dto.MovieUpdateRequest;
import com.notimdb.notimdb.pojo.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(Integer id);

    Movie createMovie(Movie movie);

    void deleteMovie(Integer id);

    Movie updateMovie(Integer id, MovieUpdateRequest request);

    List<Movie> getMovieByActor(Integer id);

    List<Movie> getMovieByGenre(Integer id);

    List<Movie> getMovieByDirector(Integer id);

    Long getTotalNrOfMovies();

}

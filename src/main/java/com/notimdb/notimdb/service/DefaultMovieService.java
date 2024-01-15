package com.notimdb.notimdb.service;

import com.notimdb.notimdb.pojo.dto.MovieUpdateRequest;
import com.notimdb.notimdb.pojo.entity.*;
import com.notimdb.notimdb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DefaultMovieService implements MovieService{
    @Autowired
    private MovieRepository movieRepository;
    DirectorRepository directorRepository;
    GenreRepository genreRepository;
    ActorRepository actorRepository;
    ReviewRepository reviewRepository;

    @Autowired
    public DefaultMovieService(MovieRepository movieRepository,DirectorRepository directorRepository,GenreRepository genreRepository,ActorRepository actorRepository,ReviewRepository reviewRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
        this.genreRepository=genreRepository;
        this.actorRepository=actorRepository;
        this.reviewRepository=reviewRepository;
    }

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
            Director director = directorRepository.findById(request.getDirectorId()).orElse(null);
            movie.setDirector(director);
            Set<Genre> genres = new HashSet<>();
            for (Integer reqid:request.getGenresIds()) {
                Genre genre = genreRepository.findById(reqid).orElse(null);
                genres.add(genre);
            }
            movie.setGenres(genres);
            Set<Actor> actors = new HashSet<>();
            for (Integer reqid:request.getActorsIds()) {
                Actor actor = actorRepository.findById(reqid).orElse(null);
                actors.add(actor);
            }
            movie.setActors(actors);
            Set<Review> reviews = new HashSet<>();
            for (Integer reqid:request.getReviewIds()) {
                Review review = reviewRepository.findById(reqid).orElse(null);
                reviews.add(review);
            }
            movie.setReviews(reviews);
            movieRepository.save(movie);
        }
        return movie;
    }

    @Override
    public List<Movie> getMovieByActor(Integer id) {
        Actor actor = actorRepository.findById(id).orElse(null);
        List<Movie> moviesOfTheActor= new ArrayList<>();
        for (Movie movie:movieRepository.findAll()) {
            if (movie.getActors().contains(actor)){
                moviesOfTheActor.add(movie);
            }
        }
        return moviesOfTheActor;
    }

    @Override
    public List<Movie> getMovieByGenre(Integer id) {
        Genre genre = genreRepository.findById(id).orElse(null);
        List<Movie> moviesOfGenre = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            if (movie.getGenres().contains(genre)) {
                moviesOfGenre.add(movie);
            }
        }
        return moviesOfGenre;
    }

    @Override
    public List<Movie> getMovieByDirector(Integer id) {
        Director director = directorRepository.findById(id).orElse(null);
        List<Movie> moviesOfDirector = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            if (movie.getDirector().equals(director)) {
                moviesOfDirector.add(movie);
            }
        }
        return moviesOfDirector;
    }

    @Override
    public Long getTotalNrOfMovies() {
        return movieRepository.count();
    }
}

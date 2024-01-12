package com.notimdb.notimdb.controller;

import com.notimdb.notimdb.pojo.entity.Director;
import com.notimdb.notimdb.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/genres")
    public List<Genre> getAllGenres() {
        return (List<Genre>) genreRepository.findAll();
    }

    @GetMapping("/genres/{id}")
    public Director getGenreById(@PathVariable Integer id){
        return genreRepository.findById(id).orElse(null);
    }

    @PostMapping("/genres")
    public Genre createGenre(@RequestBody Genre newGenre) {
        Genre genre = new Genre();
        genre.setName(newGenre.getFirstName());
        return genreRepository.save(genre);
    }
}

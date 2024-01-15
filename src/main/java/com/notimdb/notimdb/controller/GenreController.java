package com.notimdb.notimdb.controller;

import com.notimdb.notimdb.pojo.dto.GenreCreateRequest;
import com.notimdb.notimdb.pojo.entity.Genre;
import com.notimdb.notimdb.repository.GenreRepository;
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
    public Genre getGenreById(@PathVariable Integer id){
        return genreRepository.findById(id).orElse(null);
    }

    @PostMapping("/genres")
    public Genre createGenre(@RequestBody GenreCreateRequest newGenre) {
        Genre genre = new Genre();
        genre.setName(newGenre.getName());
        return genreRepository.save(genre);
    }

    @GetMapping("genres/count")
    public Long getTotalNrOfGenres(){
        return genreRepository.count();
    }
}

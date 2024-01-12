package com.notimdb.notimdb.controller;

import com.notimdb.notimdb.pojo.entity.Director;
import com.notimdb.notimdb.pojo.entity.Movie;
import com.notimdb.notimdb.repository.DirectorRepository;
import com.notimdb.notimdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectorController {
    @Autowired
    private DirectorRepository directorRepository;

    @GetMapping("/directors")
    public List<Director> getAllDirectors() {
        return (List<Director>) directorRepository.findAll();
    }
    @GetMapping("/directors/{id}")
    public Director getDirectorById(@PathVariable Integer id){
        return directorRepository.findById(id).orElse(null);
    }

    @PostMapping("/directors")
    public Director createStudent(@RequestBody Director newDirector) {
        Director director = new Director();
        director.setFirstName(newDirector.getFirstName());
       director.setLastName(newDirector.getLastName());
       director.setBirthDate(newDirector.getBirthDate());
       director.setNationality(newDirector.getNationality());
       director.setMovies(newDirector.getMovies());

       return directorRepository.save(director);
    }
}

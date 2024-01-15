package com.notimdb.notimdb.controller;

import com.notimdb.notimdb.pojo.dto.ActorCreateRequest;
import com.notimdb.notimdb.pojo.dto.GenreCreateRequest;
import com.notimdb.notimdb.pojo.entity.Actor;
import com.notimdb.notimdb.pojo.entity.Genre;
import com.notimdb.notimdb.repository.ActorRepository;
import com.notimdb.notimdb.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ActorController {

        @Autowired
        private ActorRepository actorRepository;

        @GetMapping("/actors")
        public List<Actor> getAllActors() {
            return (List<Actor>) actorRepository.findAll();
        }

        @GetMapping("/actors/{id}")
        public Actor getActorById(@PathVariable Integer id){
            return actorRepository.findById(id).orElse(null);
        }

        @PostMapping("/actors")
        public Actor createActors(@RequestBody ActorCreateRequest newActor) {
            Actor actor = new Actor();
            actor.setFirstName(newActor.getFirstName());
            actor.setLastName(newActor.getLastName());
            actor.setBirthDate(newActor.getBirthDate());
            actor.setNationality(newActor.getNationality());
            return actorRepository.save(actor);
        }

    @GetMapping("actors/count")
    public Long getTotalNrOfActors(){
        return actorRepository.count();
    }
}

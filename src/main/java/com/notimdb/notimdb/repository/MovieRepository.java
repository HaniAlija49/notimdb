package com.notimdb.notimdb.repository;

import com.notimdb.notimdb.pojo.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
}

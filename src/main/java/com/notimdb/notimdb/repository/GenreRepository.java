package com.notimdb.notimdb.repository;

import com.notimdb.notimdb.pojo.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
}

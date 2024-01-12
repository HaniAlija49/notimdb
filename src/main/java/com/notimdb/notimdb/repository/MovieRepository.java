package com.notimdb.notimdb.repository;

import com.notimdb.notimdb.pojo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}

package com.notimdb.notimdb.repository;

import com.notimdb.notimdb.pojo.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}

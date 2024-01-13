package com.notimdb.notimdb.repository;

import com.notimdb.notimdb.pojo.entity.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository <Actor, Integer> {
}

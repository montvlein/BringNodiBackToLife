package com.BringBackToLife.nodi.Persistence.ORM;

import com.BringBackToLife.nodi.Models.Entities.Grupo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface group_repository extends MongoRepository<Grupo, Long> {
}

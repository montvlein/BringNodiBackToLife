package com.BringBackToLife.nodi.Persistence.ORM;

import com.BringBackToLife.nodi.Models.Entities.Telefono;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface phone_repository extends MongoRepository<Telefono, String> {
}

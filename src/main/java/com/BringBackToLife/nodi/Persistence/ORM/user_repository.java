package com.BringBackToLife.nodi.Persistence.ORM;

import com.BringBackToLife.nodi.Models.Entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface user_repository extends MongoRepository<Usuario,Long> {
}

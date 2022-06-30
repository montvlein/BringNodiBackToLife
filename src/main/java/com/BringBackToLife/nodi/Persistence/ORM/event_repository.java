package com.BringBackToLife.nodi.Persistence.ORM;

import com.BringBackToLife.nodi.Models.Entities.Evento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface event_repository extends MongoRepository<Evento, Long> {
}

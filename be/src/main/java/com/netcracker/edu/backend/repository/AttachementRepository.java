package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Attachement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachementRepository extends CrudRepository<Attachement,Long> {
    Iterable<Attachement> findByTaskId(long taskId);
      Attachement findById(long id);
}

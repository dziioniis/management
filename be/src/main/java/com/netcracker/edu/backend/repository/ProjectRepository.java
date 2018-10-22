package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
}

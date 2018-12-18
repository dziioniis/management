package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Comment;
import com.netcracker.edu.backend.entity.Project;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment,Long> {
    Iterable<Comment> findByTaskId(long taskId);
}

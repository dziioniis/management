package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Task c SET c.status = :status WHERE c.id = :id")
    void updateStatus(@Param("id") Long id, @Param("status") String status);

    @Transactional
    @Modifying
    @Query("UPDATE Task c SET c.status = :status,c.resolved=:resolved WHERE c.id = :id")
    void resolvedStatus(@Param("id") Long id, @Param("status") String status,@Param("resolved") String resolved);

    @Transactional
    @Modifying
    @Query("UPDATE Task c SET c.status = :status,c.closed= :closed WHERE c.id = :id")
    void closedStatus(@Param("id") Long id, @Param("status") String status,@Param("closed") String closed);

    @Transactional
    @Modifying
    @Query("UPDATE Task c SET c.assignee = :assignee,c.priority= :priority,c.description=:description,c.reporter=:reporter,c.estimation=:estimation WHERE c.id = :id")
    void updateTask(@Param("id") Long id, @Param("assignee") String assignee,@Param("priority") String priority,@Param("description") String description,@Param("reporter") String reporter,@Param("estimation")String estimation);


    Iterable<Task> findByTicketCode(String ticketCode);

}

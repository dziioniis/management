package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Project;
import com.netcracker.edu.backend.entity.Task;
import com.netcracker.edu.backend.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project,Long> {

    Project findByCode(String username);

    @Modifying
    @Query("UPDATE Project c SET c.status = :status,c.closed=:closed WHERE c.code = :code")
    void updateStatusAndClosed(@Param("code") String code, @Param("status") String status,@Param("closed")String closed);

    @Modifying
    @Query("UPDATE Project c SET c.status = :status,c.closed=null WHERE c.code = :code")
    void openStatus(@Param("code") String code, @Param("status") String status);

}

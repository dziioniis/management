package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);

    @Query("select c FROM User c where c.role = :developer or  c.role = :tester")
    Iterable<User> findByRole(@Param("developer") String developer, @Param("tester") String tester);
}


package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    @Query("select c FROM User c where c.roleId=:a or  c.roleId=:b or c.roleId=:d")
    Iterable<User> findByRole(@Param("a") long a,@Param("b") long b,@Param("d")long d);

    @Modifying
    @Query("UPDATE User c SET c.refreshToken = :refreshToken WHERE c.id = :id")
    void refreshToken(@Param("id") long id, @Param("refreshToken")String refreshToken);

    @Modifying
    @Query("UPDATE User c SET c.email = :mail WHERE c.id = :id")
    void updateMail(@Param("id") long id, @Param("mail")String mail);


    @Modifying
    @Query("UPDATE User c SET c.password = :password WHERE c.id = :id")
    void updatePassword(@Param("id") long id, @Param("password")String password);

}


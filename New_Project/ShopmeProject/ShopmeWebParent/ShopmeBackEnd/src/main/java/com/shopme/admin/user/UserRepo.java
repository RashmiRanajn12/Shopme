package com.shopme.admin.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopme.common.entity.Users;

@Repository
public interface UserRepo extends CrudRepository<Users, Integer> {
 @Query("SELECT u FROM Users u WHERE u.email = :email")
  public Users getUserByEmail(@Param("email") String email);
}

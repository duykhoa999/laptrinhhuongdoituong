package com.group28.laptrinhhuongdoituong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group28.laptrinhhuongdoituong.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  @Query(value = "SELECT * FROM users u, roles r WHERE u.role_id = r.id and CONCAT(u.first_name,' ',u.last_name,' ',u.gender,' ',u.dob,' ',u.address,' ',u.phone,' ',u.email,' ',c.password,' ',r.name) LIKE %?%", nativeQuery=true)
  public List<UserEntity> search(String keyword);
}

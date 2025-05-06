package com.project.smartfamily.Repositories;

import com.project.smartfamily.Entities.UserHome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserHomeRepository extends JpaRepository<UserHome, Long> {
    List<UserHome> findByUser_UserId(Long userId);
    List<UserHome> findByHome_Id(Long homeId);
}

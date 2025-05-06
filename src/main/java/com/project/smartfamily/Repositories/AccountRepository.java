package com.project.smartfamily.Repositories;

import com.project.smartfamily.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByHome_Id(Long homeId);
}

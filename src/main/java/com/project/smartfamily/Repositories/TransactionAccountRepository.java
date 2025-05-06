package com.project.smartfamily.Repositories;

import com.project.smartfamily.Entities.TransactionAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionAccountRepository extends JpaRepository<TransactionAccount, Long> {
    List<TransactionAccount> findByAccount_Id(Long accountId);
    List<TransactionAccount> findByUser_UserId(Long userId);
}

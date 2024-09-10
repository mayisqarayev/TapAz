package com.TapazApp.repository;

import com.TapazApp.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {


    @Transactional
    @Modifying
    @Query("update AccountEntity a set a.totalViewOfAccount = a.totalViewOfAccount + 1 where a.id = ?1")
    void updateTotalViewOfAccountById(String id);


}

package com.TapazApp.repository;

import com.TapazApp.entity.CategoryEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.beans.Transient;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {

    @Transactional
    @Modifying
    @Query("UPDATE CategoryEntity a set a.categoryStatus = false where a.id = ?1")
    void deleteCategoryById(String id);
}

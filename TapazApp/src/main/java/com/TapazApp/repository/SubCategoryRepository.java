package com.TapazApp.repository;

import com.TapazApp.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, String > {

    @Transactional
    @Modifying
    @Query("update SubCategoryEntity a set a.subCategoryStatus = false where a.id = ?1")
    void deleteSubCategoryById(String id);
}

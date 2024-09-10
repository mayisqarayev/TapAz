package com.TapazApp.repository;

import com.TapazApp.entity.ParameterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends JpaRepository<ParameterEntity, String> {

    @Query("select a.isNew from ParameterEntity a where a.id = ?1")
    Boolean findIsNewOfParameterByStickerId(String stickerId);

}

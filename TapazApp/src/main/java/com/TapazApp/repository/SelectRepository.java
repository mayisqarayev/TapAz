package com.TapazApp.repository;

import com.TapazApp.entity.SelectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectRepository extends JpaRepository<SelectEntity, String> {
}

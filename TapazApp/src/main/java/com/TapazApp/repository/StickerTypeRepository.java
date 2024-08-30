package com.TapazApp.repository;

import com.TapazApp.entity.StickerTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickerTypeRepository extends JpaRepository<StickerTypeEntity, String > {
}

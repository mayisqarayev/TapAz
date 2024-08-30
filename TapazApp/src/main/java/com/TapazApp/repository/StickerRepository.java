package com.TapazApp.repository;

import com.TapazApp.entity.StickerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickerRepository extends JpaRepository<StickerEntity, String> {
}

package com.TapazApp.repository;

import com.TapazApp.entity.StickerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface StickerRepository extends JpaRepository<StickerEntity, String> {

    @Query("select count(a) from StickerEntity a group by a.fkAccountId")
    BigDecimal findCountOfStickersByAccountId(String accountId);

    @Query("select a from StickerEntity a where a.id = ?1 order by a.stickerPrice asc")
    List<StickerEntity> findAllStickersByAccountIdSortByStickerPrice(String accountId);

    @Query("select a from StickerEntity a where a.id = ?1 order by a.deploymentDate asc")
    List<StickerEntity> getAllStickersByAccountIdSortByDeploymentDate(String accountId);

    @Query("select a from StickerEntity a where a.id = ?1 order by a.stickerPrice desc")
    List<StickerEntity> findAllStickersByAccountIdSortByStickerPriceDesc(String accountId);

}

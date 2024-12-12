package msa.innoit.prices.data.infrastructure.adapter.out.prices.repository;

import java.time.LocalDateTime;
import msa.innoit.prices.data.infrastructure.adapter.out.prices.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {

  @Query(value = "SELECT * FROM T_PRICES WHERE PRI_PRODUCT_ID = ?2 AND "
      + "PRI_BRAND_ID = ?3 AND ?1 BETWEEN PRI_START_DATE AND PRI_END_DATE", nativeQuery = true)
  List<PriceEntity> findByApplicationDateAndProductIdAndBrandId(LocalDateTime applicationDate,
      Integer productId, Integer brandId);
}

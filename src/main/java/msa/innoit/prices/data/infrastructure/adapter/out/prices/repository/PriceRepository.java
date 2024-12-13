package msa.innoit.prices.data.infrastructure.adapter.out.prices.repository;

import java.time.LocalDateTime;
import msa.innoit.prices.data.infrastructure.adapter.out.prices.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {

  @Query(value = "SELECT p FROM PriceEntity p WHERE p.productId = ?2 AND "
      + "p.brandId = ?3 AND ?1 BETWEEN p.startDate AND p.endDate")
  List<PriceEntity> findByApplicationDateAndProductIdAndBrandId(LocalDateTime applicationDate,
      Integer productId, Integer brandId);
}

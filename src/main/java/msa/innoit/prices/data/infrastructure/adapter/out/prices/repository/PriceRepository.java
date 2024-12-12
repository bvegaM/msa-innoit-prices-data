package msa.innoit.prices.data.infrastructure.adapter.out.prices.repository;

import msa.innoit.prices.data.infrastructure.adapter.out.prices.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {
}

package msa.innoit.prices.data.infrastructure.adapter.out.prices;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import msa.innoit.prices.data.application.port.out.PriceOutputPort;
import msa.innoit.prices.data.domain.model.Price;
import msa.innoit.prices.data.infrastructure.adapter.out.prices.entity.PriceEntity;
import msa.innoit.prices.data.infrastructure.adapter.out.prices.mapper.PriceEntityMapper;
import msa.innoit.prices.data.infrastructure.adapter.out.prices.repository.PriceRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriceAdapter implements PriceOutputPort {

  private final PriceRepository priceRepository;
  private final PriceEntityMapper priceEntityMapper;

  @Override
  public List<Price> getPricesByApplicationDateAndProductIdAndBrandId(LocalDateTime applicationDate,
      Integer productId,
      Integer brandId){
    List<PriceEntity> priceEntities = priceRepository.findByApplicationDateAndProductIdAndBrandId(
        applicationDate, productId, brandId);

    return priceEntityMapper.toPrices(priceEntities);
  }
}

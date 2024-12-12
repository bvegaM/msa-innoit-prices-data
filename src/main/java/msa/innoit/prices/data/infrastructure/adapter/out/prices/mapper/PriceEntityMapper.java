package msa.innoit.prices.data.infrastructure.adapter.out.prices.mapper;

import java.util.List;
import msa.innoit.prices.data.domain.model.Price;
import msa.innoit.prices.data.infrastructure.adapter.out.prices.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

  List<Price> toPrices(List<PriceEntity> prices);
}

package msa.innoit.prices.data.infrastructure.adapter.in.rest.mapper;

import msa.innoit.prices.data.domain.model.Price;
import msa.innoit.prices.data.server.models.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceDtoMapper {

  @Mapping(target = "price", source = "priceProduct")
  PriceDto toPriceDto(Price price);
}

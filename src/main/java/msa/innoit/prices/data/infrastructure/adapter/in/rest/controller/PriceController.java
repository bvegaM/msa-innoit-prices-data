package msa.innoit.prices.data.infrastructure.adapter.in.rest.controller;

import lombok.RequiredArgsConstructor;
import msa.innoit.prices.data.application.port.in.PriceService;
import msa.innoit.prices.data.domain.model.Price;
import msa.innoit.prices.data.infrastructure.adapter.in.rest.mapper.PriceDtoMapper;
import msa.innoit.prices.data.infrastructure.utils.Util;
import msa.innoit.prices.data.server.PricesApi;
import msa.innoit.prices.data.server.models.PriceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PriceController implements PricesApi {

  private final PriceService priceService;
  private final PriceDtoMapper priceDtoMapper;

  @Override
  @CrossOrigin
  public ResponseEntity<PriceDto> pricesApplicableGet(String applicationDate, Integer productId,
      Integer brandId) {
    Price price = priceService.getPriceByApplicationDateAndProductIdAndBrandIdAndPriority(
        Util.transformDate(applicationDate), productId, brandId);
    return ResponseEntity.ok().body(priceDtoMapper.toPriceDto(price));
  }
}

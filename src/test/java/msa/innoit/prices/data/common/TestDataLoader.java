package msa.innoit.prices.data.common;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import msa.innoit.prices.data.domain.enums.CurrencyEnum;
import msa.innoit.prices.data.domain.model.Price;
import msa.innoit.prices.data.infrastructure.adapter.out.prices.entity.PriceEntity;

public class TestDataLoader {

  public static List<PriceEntity> generateRandomPriceEntities() {
    return List.of(
        PriceEntity.builder()
            .id(1)
            .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
            .priority(0)
            .priceProduct(new BigDecimal("35.50"))
            .brandId(1)
            .priceList(1)
            .productId(35455)
            .curr(CurrencyEnum.EUR)
            .build(),
        PriceEntity.builder()
            .id(2)
            .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
            .endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
            .priority(1)
            .priceProduct(new BigDecimal("25.45"))
            .brandId(1)
            .priceList(2)
            .productId(35455)
            .curr(CurrencyEnum.EUR)
            .build(),
        PriceEntity.builder()
            .id(3)
            .startDate(LocalDateTime.of(2020, 6, 15, 0, 0, 0))
            .endDate(LocalDateTime.of(2020, 6, 15, 11, 0, 0))
            .priority(1)
            .priceProduct(new BigDecimal("30.50"))
            .brandId(1)
            .priceList(3)
            .productId(35455)
            .curr(CurrencyEnum.EUR)
            .build(),
        PriceEntity.builder()
            .id(4)
            .startDate(LocalDateTime.of(2020, 6, 15, 16, 0, 0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
            .priority(1)
            .priceProduct(new BigDecimal("38.95"))
            .brandId(1)
            .priceList(4)
            .productId(35455)
            .curr(CurrencyEnum.EUR)
            .build()
    );
  }

  public static List<Price> generateRandomPrices() {
    return List.of(
        Price.builder()
            .id(1)
            .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
            .priority(0)
            .priceProduct(new BigDecimal("35.50"))
            .brandId(1)
            .priceList(1)
            .productId(35455)
            .curr(CurrencyEnum.EUR)
            .build(),
        Price.builder()
            .id(2)
            .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
            .endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
            .priority(1)
            .priceProduct(new BigDecimal("25.45"))
            .brandId(1)
            .priceList(2)
            .productId(35455)
            .curr(CurrencyEnum.EUR)
            .build(),
        Price.builder()
            .id(3)
            .startDate(LocalDateTime.of(2020, 6, 15, 0, 0, 0))
            .endDate(LocalDateTime.of(2020, 6, 15, 11, 0, 0))
            .priority(1)
            .priceProduct(new BigDecimal("30.50"))
            .brandId(1)
            .priceList(3)
            .productId(35455)
            .curr(CurrencyEnum.EUR)
            .build(),
        Price.builder()
            .id(4)
            .startDate(LocalDateTime.of(2020, 6, 15, 16, 0, 0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
            .priority(1)
            .priceProduct(new BigDecimal("38.95"))
            .brandId(1)
            .priceList(4)
            .productId(35455)
            .curr(CurrencyEnum.EUR)
            .build()
    );
  }


  public static List<Price> filterPricesByCriteria(List<Price> prices, LocalDateTime applicationDate, Integer productId, Integer brandId) {
    return prices.stream()
        .filter(price -> price.getProductId().equals(productId))
        .filter(price -> price.getBrandId().equals(brandId))
        .filter(price -> !applicationDate.isBefore(price.getStartDate()) &&
            !applicationDate.isAfter(price.getEndDate()))
        .sorted(Comparator.comparing(Price::getPriority).reversed())
        .toList();
  }


}

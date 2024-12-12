package msa.innoit.prices.data.domain.model;

import java.util.Comparator;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import msa.innoit.prices.data.domain.enums.CurrencyEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import msa.innoit.prices.data.domain.exception.NotFoundException;

@Data
@Builder
public class Price {

  private Integer id;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private Integer priority;

  private BigDecimal priceProduct;

  private Integer brandId;

  private Integer priceList;

  private Integer productId;

  private CurrencyEnum curr;

  public static Price filterPricesByComparator(List<Price> prices, Comparator<Price> comparator)
      throws NotFoundException {
    return prices.stream().max(comparator)
        .orElseThrow(() -> new NotFoundException("Price applicable not found"));
  }
}

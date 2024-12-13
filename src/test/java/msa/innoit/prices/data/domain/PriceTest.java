package msa.innoit.prices.data.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import msa.innoit.prices.data.domain.model.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceTest {


  @Test
  @DisplayName("Test filterPricesByComparator")
  void testFilterPricesByComparator() {
    // Given
    List<Price> prices = new ArrayList<>();
    Price price1 = Price.builder().id(1).priceProduct(new BigDecimal("10.0")).build();
    Price price2 = Price.builder().id(2).priceProduct(new BigDecimal("20.0")).build();
    prices.add(price1);
    prices.add(price2);

    // When
    Price result = Price.filterPricesByComparator(prices, Comparator.comparing(Price::getPriceProduct));

    // Then
    assertEquals(price2, result);
  }

}

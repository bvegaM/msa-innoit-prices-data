package msa.innoit.prices.data.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import msa.innoit.prices.data.application.port.out.PriceOutputPort;
import msa.innoit.prices.data.common.TestDataLoader;
import msa.innoit.prices.data.domain.exception.NotFoundException;
import msa.innoit.prices.data.domain.model.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

  @InjectMocks
  private PriceServiceImpl priceServiceImpl;

  @Mock
  private PriceOutputPort priceOutputPort;


  @Test
  @DisplayName("petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
  void whenGetPriceByApplicationDateAndProductIdAndBrandIdAndPriority_thenShouldReturnPrice_case_1() {
    List<Price> prices = TestDataLoader.generateRandomPrices();
    // Given
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
    Integer productId = 35455;
    Integer brandId = 1;
    Price priceExpected = prices.get(0);

    // When
    when(
        priceOutputPort.getPricesByApplicationDateAndProductIdAndBrandId(applicationDate, productId,
            brandId)).thenReturn(
        TestDataLoader.filterPricesByCriteria(prices, applicationDate, productId, brandId));

    // Then
    Price priceCurrent = priceServiceImpl.getPriceByApplicationDateAndProductIdAndBrandIdAndPriority(
        applicationDate, productId, brandId);

    // Assertions
    assertEquals(priceExpected, priceCurrent);
  }

  @Test
  @DisplayName("petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
  void whenGetPriceByApplicationDateAndProductIdAndBrandIdAndPriority_thenShouldReturnPrice_case_2() {
    List<Price> prices = TestDataLoader.generateRandomPrices();
    // Given
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
    Integer productId = 35455;
    Integer brandId = 1;
    Price priceExpected = prices.get(1);

    // When
    when(
        priceOutputPort.getPricesByApplicationDateAndProductIdAndBrandId(applicationDate, productId,
            brandId)).thenReturn(
        TestDataLoader.filterPricesByCriteria(prices, applicationDate, productId, brandId));

    // Then
    Price priceCurrent = priceServiceImpl.getPriceByApplicationDateAndProductIdAndBrandIdAndPriority(
        applicationDate, productId, brandId);

    // Assertions
    assertEquals(priceExpected, priceCurrent);
  }

  @Test
  @DisplayName("petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
  void whenGetPriceByApplicationDateAndProductIdAndBrandIdAndPriority_thenShouldReturnPrice_case_3() {
    List<Price> prices = TestDataLoader.generateRandomPrices();
    // Given
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
    Integer productId = 35455;
    Integer brandId = 1;
    Price priceExpected = prices.get(0);

    // When
    when(
        priceOutputPort.getPricesByApplicationDateAndProductIdAndBrandId(applicationDate, productId,
            brandId)).thenReturn(
        TestDataLoader.filterPricesByCriteria(prices, applicationDate, productId, brandId));

    // Then
    Price priceCurrent = priceServiceImpl.getPriceByApplicationDateAndProductIdAndBrandIdAndPriority(
        applicationDate, productId, brandId);

    // Assertions
    assertEquals(priceExpected, priceCurrent);
  }

  @Test
  @DisplayName("petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")
  void whenGetPriceByApplicationDateAndProductIdAndBrandIdAndPriority_thenShouldReturnPrice_case_4() {
    List<Price> prices = TestDataLoader.generateRandomPrices();
    // Given
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
    Integer productId = 35455;
    Integer brandId = 1;
    Price priceExpected = prices.get(2);

    // When
    when(
        priceOutputPort.getPricesByApplicationDateAndProductIdAndBrandId(applicationDate, productId,
            brandId)).thenReturn(
        TestDataLoader.filterPricesByCriteria(prices, applicationDate, productId, brandId));

    // Then
    Price priceCurrent = priceServiceImpl.getPriceByApplicationDateAndProductIdAndBrandIdAndPriority(
        applicationDate, productId, brandId);

    // Assertions
    assertEquals(priceExpected, priceCurrent);
  }

  @Test
  @DisplayName("petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")
  void whenGetPriceByApplicationDateAndProductIdAndBrandIdAndPriority_thenShouldReturnPrice_case_5() {
    List<Price> prices = TestDataLoader.generateRandomPrices();
    // Given
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
    Integer productId = 35455;
    Integer brandId = 1;
    Price priceExpected = prices.get(3);

    // When
    when(
        priceOutputPort.getPricesByApplicationDateAndProductIdAndBrandId(applicationDate, productId,
            brandId)).thenReturn(
        TestDataLoader.filterPricesByCriteria(prices, applicationDate, productId, brandId));

    // Then
    Price priceCurrent = priceServiceImpl.getPriceByApplicationDateAndProductIdAndBrandIdAndPriority(
        applicationDate, productId, brandId);

    // Assertions
    assertEquals(priceExpected, priceCurrent);
  }

  @Test
  @DisplayName("when prices is empty then should return NotFoundException")
  void whenPricesIsEmpty_thenShouldReturnNotFoundException() {
    // Given
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
    Integer productId = 35455;
    Integer brandId = 1;

    // When
    when(
        priceOutputPort.getPricesByApplicationDateAndProductIdAndBrandId(applicationDate, productId,
            brandId)).thenReturn(List.of());

    // Then
    assertThrows(NotFoundException.class, () -> priceServiceImpl.getPriceByApplicationDateAndProductIdAndBrandIdAndPriority(
        applicationDate, productId, brandId));
  }

}

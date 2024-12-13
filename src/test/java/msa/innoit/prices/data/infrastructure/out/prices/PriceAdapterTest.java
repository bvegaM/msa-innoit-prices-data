package msa.innoit.prices.data.infrastructure.out.prices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import msa.innoit.prices.data.common.TestDataLoader;
import msa.innoit.prices.data.domain.model.Price;
import msa.innoit.prices.data.infrastructure.adapter.out.prices.PriceAdapter;
import msa.innoit.prices.data.infrastructure.adapter.out.prices.entity.PriceEntity;
import msa.innoit.prices.data.infrastructure.adapter.out.prices.mapper.PriceEntityMapper;
import msa.innoit.prices.data.infrastructure.adapter.out.prices.repository.PriceRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceAdapterTest {

  @InjectMocks
  private PriceAdapter priceAdapter;

  @Mock
  private PriceRepository priceRepository;

  @Mock
  private PriceEntityMapper priceEntityMapper;

  @Test
  @DisplayName("When search prices by application date and product id and brand id then should return prices")
  void whenSearchPricesByApplicationDateAndProductIdAndBrandId_thenShouldReturnPrices() {
    List<Price> pricesExpected = TestDataLoader.generateRandomPrices();
    List<PriceEntity> priceEntities = TestDataLoader.generateRandomPriceEntities();

    // Given
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
    Integer productId = 35455;
    Integer brandId = 1;

    // When
    when(priceRepository.findByApplicationDateAndProductIdAndBrandId(applicationDate, productId, brandId)).thenReturn(priceEntities);
    when(priceEntityMapper.toPrices(priceEntities)).thenReturn(TestDataLoader.generateRandomPrices());

    // Then
    List<Price> pricesCurrent = priceAdapter.getPricesByApplicationDateAndProductIdAndBrandId(applicationDate, productId, brandId);

    // Assertions
    assertEquals(pricesExpected.size(), pricesCurrent.size());
  }

  @Test
  @DisplayName("When search prices by application date and product id and brand id then should return empty list")
  void whenSearchPricesByApplicationDateAndProductIdAndBrandId_thenShouldReturnEmptyList() {
    // Given
    LocalDateTime applicationDate = LocalDateTime.of(0000, 6, 14, 10, 0, 0);
    Integer productId = 9999;
    Integer brandId = 9999;

    // When
    when(priceRepository.findByApplicationDateAndProductIdAndBrandId(applicationDate, productId, brandId)).thenReturn(
        List.of());
    when(priceEntityMapper.toPrices(List.of())).thenReturn(List.of());

    // Then
    List<Price> priceEntitiesCurrent = priceAdapter.getPricesByApplicationDateAndProductIdAndBrandId(applicationDate, productId, brandId);

    // Assertions
    assertEquals(0, priceEntitiesCurrent.size());
  }
}

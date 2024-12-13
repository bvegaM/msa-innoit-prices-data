package msa.innoit.prices.data.application.port.in;

import java.time.LocalDateTime;
import msa.innoit.prices.data.domain.exception.NotFoundException;
import msa.innoit.prices.data.domain.model.Price;

public interface PriceService {

  /**
   * Get price by application date and product id and brand id and priority
   * @param applicationDate
   * @param productId
   * @param brandId
   * @return Price
   */
  Price getPriceByApplicationDateAndProductIdAndBrandIdAndPriority(LocalDateTime applicationDate,
      Integer productId, Integer brandId) throws NotFoundException;

}

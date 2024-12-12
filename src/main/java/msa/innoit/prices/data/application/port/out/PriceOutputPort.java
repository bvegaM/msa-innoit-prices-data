package msa.innoit.prices.data.application.port.out;

import java.time.LocalDateTime;
import java.util.List;
import msa.innoit.prices.data.domain.exception.NotFoundException;
import msa.innoit.prices.data.domain.model.Price;

public interface PriceOutputPort {

    /**
     * Get prices by application date and product id and brand id
     * @param applicationDate
     * @param productId
     * @param brandId
     * @return List<Price>
     * @throws NotFoundException if prices not found or criteria not valid
     */
  List<Price> getPricesByApplicationDateAndProductIdAndBrandId(LocalDateTime applicationDate,
      Integer productId, Integer brandId);
}

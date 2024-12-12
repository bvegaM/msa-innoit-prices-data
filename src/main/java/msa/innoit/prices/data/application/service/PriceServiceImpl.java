package msa.innoit.prices.data.application.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import msa.innoit.prices.data.application.port.in.PriceService;
import msa.innoit.prices.data.application.port.out.PriceOutputPort;
import msa.innoit.prices.data.domain.exception.NotFoundException;
import msa.innoit.prices.data.domain.model.Price;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

  private final PriceOutputPort priceOutputPort;

  @Override
  public Price getPriceByApplicationDateAndProductIdAndBrandIdAndPriority(
      LocalDateTime applicationDate, Integer productId, Integer brandId) throws NotFoundException {

    List<Price> prices = priceOutputPort.getPricesByApplicationDateAndProductIdAndBrandId(
        applicationDate, productId, brandId);

    if (prices.isEmpty()) {
      throw new NotFoundException("Price criteria not found");
    }

    Comparator<Price> priorityComparator = Comparator.comparingInt(Price::getPriority);

    return Price.filterPricesByComparator(prices, priorityComparator);
  }
}

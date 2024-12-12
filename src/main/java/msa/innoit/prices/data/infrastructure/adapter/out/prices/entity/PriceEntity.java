package msa.innoit.prices.data.infrastructure.adapter.out.prices.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import msa.innoit.prices.data.domain.enums.CurrencyEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "T_PRICES")
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PRI_ID", nullable = false, unique = true)
  private Integer id;

  @Column(name = "PRI_START_DATE", nullable = false)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime startDate;

  @Column(name = "PRI_END_DATE", nullable = false)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime endDate;

  @Column(name = "PRI_PRIORITY", nullable = false)
  private Integer priority;

  @Column(name = "PRI_PRICE", nullable = false)
  private BigDecimal priceProduct;

  @Column(name = "PRI_BRAND_ID", nullable = false)
  private Integer brandId;

  @Column(name = "PRI_PRICE_LIST", nullable = false)
  private Integer priceList;

  @Column(name = "PRI_PRODUCT_ID", nullable = false)
  private Integer productId;

  @Column(name = "PRI_CURR", nullable = false)
  @Enumerated(EnumType.STRING)
  private CurrencyEnum curr;
}

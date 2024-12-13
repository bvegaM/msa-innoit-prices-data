package msa.innoit.prices.data.domain.enums;

import lombok.Getter;

@Getter
public enum CurrencyEnum {

    EUR("EUR");

    private String description;

    CurrencyEnum(String description) {
        this.description = description;
    }
}

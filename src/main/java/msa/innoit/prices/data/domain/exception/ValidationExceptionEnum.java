package msa.innoit.prices.data.domain.exception;

import lombok.Getter;

@Getter
public enum ValidationExceptionEnum {

  DATE_VALIDATION("must match \"^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}$\"", "This field must be in format yyyy-MM-ddTHH:mm:ss");

  private String pattern;
  private String description;

  ValidationExceptionEnum(String pattern, String description) {
    this.pattern = pattern;
    this.description = description;
  }

  public static Boolean containsPattern(String pattern){
    for (ValidationExceptionEnum error : ValidationExceptionEnum.values()) {
      if (error.getPattern().equals(pattern)) {
        return true;
      }
    }
    return false;
  }

  public static ValidationExceptionEnum fromPattern(String pattern) {
    for (ValidationExceptionEnum error : ValidationExceptionEnum.values()) {
      if (error.getPattern().equals(pattern)) {
        return error;
      }
    }
    throw new IllegalArgumentException("No enum found for pattern: " + pattern);
  }


}

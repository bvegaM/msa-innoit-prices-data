package msa.innoit.prices.data.infrastructure.utils;

import java.time.LocalDateTime;

public class Util {

  /**
   * Transform a string date to a LocalDateTime
   * @param date
   * @return LocalDateTime
   */
  public static LocalDateTime transformDate(String date) {
    return LocalDateTime.parse(date);
  }

}

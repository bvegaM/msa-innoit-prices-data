package msa.innoit.prices.data.infrastructure.utils;

import jakarta.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.util.List;
import msa.innoit.prices.data.domain.exception.ValidationExceptionEnum;
import msa.innoit.prices.data.server.models.Error;
import msa.innoit.prices.data.server.models.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class Util {

  private Util() {

  }

  /**
   * Transform a string date to a LocalDateTime
   * @param date
   * @return LocalDateTime
   */
  public static LocalDateTime transformDate(String date) {
    return LocalDateTime.parse(date);
  }

  /**
   * Generate an ErrorDetail object from an ObjectError
   * @param error ObjectError
   * @return ErrorDetail
   */
  public static ErrorDetail generateErrorDetail(ObjectError error) {
    ErrorDetail errorDetail = new ErrorDetail();
    String attributeName = "unknown";

    if (error instanceof FieldError fieldError) {
      attributeName = fieldError.getField();
    }

    String message = formatErrorMessage(attributeName, error.getDefaultMessage());
    errorDetail.message(message);

    return errorDetail;
  }

  /**
   * Generate an ErrorDetail object from a ConstraintViolation
   * @param violation ConstraintViolation
   * @return ErrorDetail
   */
  public static ErrorDetail generateErrorDetail(ConstraintViolation<?> violation) {
    ErrorDetail errorDetail = new ErrorDetail();

    String attributeName = violation.getPropertyPath().toString();

    String message = formatErrorMessage(attributeName, violation.getMessage());
    errorDetail.message(message);

    return errorDetail;
  }

  /**
   * Generate an ErrorDetail object from a message
   * @param message
   * @return ErrorDetail
   */
  public static ErrorDetail generateErrorDetail(String message) {
    ErrorDetail errorDetail = new ErrorDetail();
    errorDetail.message(message);
    return errorDetail;
  }

  /**
   * Format an error message
   * @param attributeName
   * @param defaultMessage
   * @return String
   */
  private static String formatErrorMessage(String attributeName, String defaultMessage) {
    if (Boolean.TRUE.equals(ValidationExceptionEnum.containsPattern(defaultMessage))) {
      return attributeName + ":" + ValidationExceptionEnum.fromPattern(defaultMessage).getDescription();
    } else {
      return attributeName + ":" + defaultMessage;
    }
  }

  /**
   * Create an Error object
   * @param title
   * @param detail
   * @param errorDetails
   * @param status
   * @return Error
   */
  public static Error createError(String title, String detail, List<ErrorDetail> errorDetails, HttpStatus status) {
    Error error = new Error();
    error.setTitle(title);
    error.setDetail(detail);
    error.setErrors(errorDetails);
    error.setStatus(status.value());
    return error;
  }

}

package msa.innoit.prices.data.infrastructure.in.rest.controller;


import static org.assertj.core.api.Assertions.assertThat;

import msa.innoit.prices.data.PricesDataApplication;
import msa.innoit.prices.data.server.models.PriceDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = PricesDataApplication.class)
class PriceControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    @DisplayName("Given application date, product id and brand id, when get price, then returns price")
    void givenApplicationDateAndProductIdAndBrandId_whenGetPrice_thenReturnsPrice() {
        String applicationDate = "2020-06-14T10:00:00";
        Integer productId = 35455;
        Integer brandId = 1;

        ResponseEntity<PriceDto> response = restTemplate.getForEntity(
                "/prices/applicable?applicationDate={applicationDate}&productId={productId}&brandId={brandId}",
                PriceDto.class,
                applicationDate,
                productId,
                brandId
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @DisplayName("Given bad application date, product id and brand id, when get price, then returns bad request")
    void givenBadApplicationDateAndProductIdAndBrandId_whenGetPrice_thenReturnsBadRequest() {
        String applicationDate = "2020-06-1410:00:00";
        Integer productId = 35455;
        Integer brandId = 1;

        ResponseEntity<PriceDto> response = restTemplate.getForEntity(
                "/prices/applicable?applicationDate={applicationDate}&productId={productId}&brandId={brandId}",
                PriceDto.class,
                applicationDate,
                productId,
                brandId
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("Given invalid application date, product id and brand id, when get price, then returns not found")
    void givenInvalidApplicationDateAndProductIdAndBrandId_whenGetPrice_thenReturnsNotFound() {
        String applicationDate = "2000-06-14T10:00:00";
        Integer productId = 99999;
        Integer brandId = 99999;

        ResponseEntity<PriceDto> response = restTemplate.getForEntity(
                "/prices/applicable?applicationDate={applicationDate}&productId={productId}&brandId={brandId}",
                PriceDto.class,
                applicationDate,
                productId,
                brandId
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    @DisplayName("Given application date and empty product id and brand id, when get price, then returns bad request")
    void givenApplicationDateAndEmptyProductIdAndBrandId_whenGetPrice_thenReturnsBadRequest() {
        String applicationDate = "2020-06-14T10:00:00";
        Integer productId = null;
        Integer brandId = null;

        ResponseEntity<PriceDto> response = restTemplate.getForEntity(
                "/prices/applicable?applicationDate={applicationDate}&productId={productId}&brandId={brandId}",
                PriceDto.class,
                applicationDate,
                productId,
                brandId
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("Given correct application date but bad format, when get price, then returns bad request")
    void givenCorrectApplicationDateButBadFormat_whenGetPrice_thenReturnsBadRequest() {
        String applicationDate = "2020-00-00T10:00:00";
        Integer productId = 9999;
        Integer brandId = 9999;

        ResponseEntity<PriceDto> response = restTemplate.getForEntity(
            "/prices/applicable?applicationDate={applicationDate}&productId={productId}&brandId={brandId}",
            PriceDto.class,
            applicationDate,
            productId,
            brandId
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }


}

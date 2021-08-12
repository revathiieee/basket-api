package com.nn.basket.controller;

import com.nn.basket.exception.BasketHttpException;
import com.nn.basket.model.Basket;
import com.nn.basket.model.PriceResponse;
import com.nn.basket.service.BasketService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

/**
 * Rest Controller to handle basket data
 *
 * @author Revathi
 */
@RestController
@RequestMapping("/api/basket/v1")
@Slf4j
@Validated
public class BasketController {

    /**
     * Field Basket Service
     */
    private final BasketService basketService;

    /**
     * Constructor instantiation with BasketService
     *
     * @param basketService basketService
     */
    public BasketController (BasketService basketService) {
        this.basketService = basketService;
    }

    /**
     * Retrieve basket information which includes boxes, fruits and prices
     *
     * @return Basket object
     * @throws BasketHttpException with Http status and Message
     */
    @PostMapping
    @Operation(method = "GET", summary = "Get Basket Price", description = "To Know Basket Price information")
    public ResponseEntity<PriceResponse> getBasketPrice(@RequestBody Basket basket) throws BasketHttpException {
        return ResponseEntity.status(OK).body(basketService.getBasketPrice(basket));
    }
}

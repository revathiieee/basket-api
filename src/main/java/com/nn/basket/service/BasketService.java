package com.nn.basket.service;

import com.nn.basket.model.Basket;
import com.nn.basket.model.Box;
import com.nn.basket.model.Fruit;
import com.nn.basket.model.PriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BasketService {
    /**
     * Field Basket Repository
     */
   // private final BasketRepository basketRepository;

    /**
     * Constructor instantiation with BasketRepository
     */
//    public BasketService(BasketRepository basketRepository) {
//        this.basketRepository = basketRepository;
//    }

    public PriceResponse getBasketPrice(Basket basket) {
        //Calculate the Basket information with the provided fruits and boxes
        double basketPrice = basket.getBktPrice() + calculateFruitsPrice(basket.getFruits()) + calculateBoxesPrice(basket.getBoxes());
        return PriceResponse.builder().basketPrice(basketPrice).build();
    }

    /**
     * Calculate the multiple Boxes cost
     *
     * @param boxes boxes
     * @return the cost of the box
     */
    private Double calculateBoxesPrice(List<Box> boxes) {
        for(Box box : boxes){
            double costOfBox = box.getBoxPrice();
            double fruitsCost = calculateFruitsPrice(box.getFruits());
            double boxPrices = calculateBoxesPrice(box.getBoxes());
            return costOfBox + fruitsCost + boxPrices;
        }
        return 0.0;
    }

    /**
     * Calculate the multiple fruits cost
     *
     * @param fruits fruits
     * @return fruitsPrice
     */
    private Double calculateFruitsPrice(List<Fruit> fruits) {
        return fruits.stream().mapToDouble(Fruit::getPrice).sum();
    }

}

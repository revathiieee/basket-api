package com.nn.basket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Basket Entity
 *
 * @author Revathi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "tb_basket")
@Builder
@Accessors(chain = true)
public class Basket {

    /**
     * Field basketId
     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer basketId;
    /**
     * Field list of fruits
     */
    //@Column(name = "fruits")
    private List<Fruit> fruits = new ArrayList<>();
    /**
     * Field list of boxes
     */
    //@Column(name = "box")
    private List<Box> boxes = new ArrayList<>();

    //@Column(name = "bkt_price")
    private double bktPrice;
}

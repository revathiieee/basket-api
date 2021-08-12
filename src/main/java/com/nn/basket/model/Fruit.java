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


/**
 * Fruit Entity
 *
 * @author Revathi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "tb_fruit")
@Builder
@Accessors(chain = true)
public class Fruit {

    /**
     * Field fruitId
     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fruitId;
    /**
     * Field movieName
     */
    //@Column(name = "fruit_name")
    private String fruitName;
    /**
     * Field movieInfo
     */
    //@Column(name = "price")
    private Double price;
}

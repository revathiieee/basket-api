package com.nn.basket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
public class PriceResponse {
    @JsonProperty("basketPrice")
    private Double basketPrice;
}

package com.Jumbotail.e_commerceJumbotail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShippingResponseDTO {
    private Double shippingCharge;
    private WarehouseResponseDTO nearestWarehouse;
}

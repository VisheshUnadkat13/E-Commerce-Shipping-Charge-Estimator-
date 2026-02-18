package com.Jumbotail.e_commerceJumbotail.dto;

import com.Jumbotail.e_commerceJumbotail.model.DeliverySpeed;
import lombok.Data;

@Data
public class ShippingRequestDTO {
    private Long sellerId;
    private Long customerId;
    private DeliverySpeed deliverySpeed;
}

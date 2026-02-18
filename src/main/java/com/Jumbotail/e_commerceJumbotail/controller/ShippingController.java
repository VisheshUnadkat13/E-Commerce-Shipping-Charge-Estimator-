package com.Jumbotail.e_commerceJumbotail.controller;

import com.Jumbotail.e_commerceJumbotail.dto.ShippingRequestDTO;
import com.Jumbotail.e_commerceJumbotail.dto.ShippingResponseDTO;
import com.Jumbotail.e_commerceJumbotail.dto.WarehouseResponseDTO;
import com.Jumbotail.e_commerceJumbotail.model.DeliverySpeed;
import com.Jumbotail.e_commerceJumbotail.model.Warehouse;
import com.Jumbotail.e_commerceJumbotail.service.ShippingService;
import com.Jumbotail.e_commerceJumbotail.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shipping-charge")
public class ShippingController {

    private final ShippingService shippingService;
    private final WarehouseService warehouseService;

    @GetMapping
    public Map<String, Double> getShippingFromWarehouse(
            @RequestParam Long warehouseId,
            @RequestParam Long customerId,
            @RequestParam DeliverySpeed deliverySpeed) {

        double charge = shippingService.calculateShippingFromWarehouse(
                warehouseId,
                customerId,
                deliverySpeed);

        return Map.of("shippingCharge", charge);
    }


    @PostMapping("/calculate")
    public ShippingResponseDTO calculate(@RequestBody ShippingRequestDTO request) {

        double charge = shippingService.calculateShipping(
                request.getSellerId(),
                request.getCustomerId(),
                request.getDeliverySpeed());

        Warehouse warehouse =
                warehouseService.getNearestWarehouse(request.getSellerId());

        WarehouseResponseDTO dto =
                new WarehouseResponseDTO(
                        warehouse.getId(),
                        warehouse.getLatitude(),
                        warehouse.getLongitude());

        return new ShippingResponseDTO(charge, dto);
    }
}

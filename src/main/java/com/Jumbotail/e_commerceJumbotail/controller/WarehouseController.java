package com.Jumbotail.e_commerceJumbotail.controller;

import com.Jumbotail.e_commerceJumbotail.dto.WarehouseResponseDTO;
import com.Jumbotail.e_commerceJumbotail.model.Warehouse;
import com.Jumbotail.e_commerceJumbotail.service.WarehouseService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;

    @GetMapping("/nearest")
    public WarehouseResponseDTO getNearest(@RequestParam Long sellerId)
    {
        Warehouse warehouse = warehouseService.getNearestWarehouse(sellerId);

        return new WarehouseResponseDTO(
                warehouse.getId(),
                warehouse.getLatitude(),
                warehouse.getLongitude()
        );

    }


}

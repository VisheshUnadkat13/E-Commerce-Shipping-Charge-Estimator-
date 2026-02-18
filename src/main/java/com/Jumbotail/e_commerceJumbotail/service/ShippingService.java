package com.Jumbotail.e_commerceJumbotail.service;

import com.Jumbotail.e_commerceJumbotail.exception.BadRequestException;
import com.Jumbotail.e_commerceJumbotail.exception.ResourceNotFoundException;
import com.Jumbotail.e_commerceJumbotail.model.Customer;
import com.Jumbotail.e_commerceJumbotail.model.DeliverySpeed;
import com.Jumbotail.e_commerceJumbotail.model.Warehouse;
import com.Jumbotail.e_commerceJumbotail.repo.CustomerRepository;
import com.Jumbotail.e_commerceJumbotail.repo.ProductRepository;
import com.Jumbotail.e_commerceJumbotail.repo.WarehouseRepository;
import com.Jumbotail.e_commerceJumbotail.service.strategy.AeroplaneStrategy;
import com.Jumbotail.e_commerceJumbotail.service.strategy.MiniVanStrategy;
import com.Jumbotail.e_commerceJumbotail.service.strategy.TransportStrategy;
import com.Jumbotail.e_commerceJumbotail.service.strategy.TruckStrategy;
import com.Jumbotail.e_commerceJumbotail.util.DistanceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ShippingService {
    private final WarehouseService warehouseService;
    private final CustomerRepository customerRepository;
    private final WarehouseRepository warehouseRepository;
    private final ProductRepository productRepository;
    private final DistanceUtil distanceUtil;

    private final MiniVanStrategy miniVan;
    private final TruckStrategy truck;
    private final AeroplaneStrategy aeroplane;

    public double calculateShippingFromWarehouse(Long warehouseId,
                                                 Long customerId,
                                                 DeliverySpeed deliverySpeed) {

        Warehouse warehouse = warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found"));

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        double distance = distanceUtil.calculateDistance(
                warehouse.getLatitude(),
                warehouse.getLongitude(),
                customer.getLatitude(),
                customer.getLongitude());

        // For this API, assume customer ordering from warehouse directly
        // So weight must be provided or calculated separately.
        // For simplicity, assume fixed 10kg for demo OR pass weight later.

        double weight = 10; // Dummy for now (can improve later)

        TransportStrategy strategy;

        if (distance <= 100)
            strategy = miniVan;
        else if (distance <= 500)
            strategy = truck;
        else
            strategy = aeroplane;

        double shipping = strategy.calculate(distance, weight);

        shipping += 10; // Base charge

        if (deliverySpeed == DeliverySpeed.EXPRESS)
            shipping += 1.2 * weight;

        return Math.round(shipping * 100.0) / 100.0;
    }


    public double calculateShipping(Long sellerId,
                                    Long customerId,
                                    DeliverySpeed deliverySpeed) {

        Warehouse warehouse = warehouseService.getNearestWarehouse(sellerId);

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        double distance = distanceUtil.calculateDistance(
                warehouse.getLatitude(),
                warehouse.getLongitude(),
                customer.getLatitude(),
                customer.getLongitude());

        Double totalWeight = productRepository.getTotalWeightBySellerId(sellerId);

        if (totalWeight == null || totalWeight == 0)
            throw new BadRequestException("Seller has no products");

        TransportStrategy strategy;

        if (distance <= 100)
            strategy = miniVan;
        else if (distance <= 500)
            strategy = truck;
        else
            strategy = aeroplane;

        double shipping = strategy.calculate(distance, totalWeight);

        shipping += 10;

        if (deliverySpeed == DeliverySpeed.EXPRESS)
            shipping += 1.2 * totalWeight;

        return Math.round(shipping * 100.0) / 100.0;
    }
}

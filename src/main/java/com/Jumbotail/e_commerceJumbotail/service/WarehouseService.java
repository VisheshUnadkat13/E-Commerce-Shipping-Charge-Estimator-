package com.Jumbotail.e_commerceJumbotail.service;

import com.Jumbotail.e_commerceJumbotail.exception.ResourceNotFoundException;
import com.Jumbotail.e_commerceJumbotail.model.Seller;
import com.Jumbotail.e_commerceJumbotail.model.Warehouse;
import com.Jumbotail.e_commerceJumbotail.repo.SellerRepository;
import com.Jumbotail.e_commerceJumbotail.repo.WarehouseRepository;
import com.Jumbotail.e_commerceJumbotail.util.DistanceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;
    private final SellerRepository sellerRepository;
    private final DistanceUtil distanceUtil;

    @Cacheable("nearestWarehouse")
    public Warehouse getNearestWarehouse(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new ResourceNotFoundException("Seller not found"));

        return warehouseRepository.findAll().stream()
                .min(Comparator.comparing(w ->
                        distanceUtil.calculateDistance(
                                seller.getLatitude(),
                                seller.getLongitude(),
                                w.getLatitude(),
                                w.getLongitude())))
                .orElseThrow(() -> new ResourceNotFoundException("No warehouse found"));

    }
}

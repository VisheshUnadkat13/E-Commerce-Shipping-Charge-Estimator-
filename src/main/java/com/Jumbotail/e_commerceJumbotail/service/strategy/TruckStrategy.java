package com.Jumbotail.e_commerceJumbotail.service.strategy;

import org.springframework.stereotype.Component;

@Component
public class TruckStrategy implements TransportStrategy{
    @Override
    public double calculate(double distanceKm, double weightKg) {
        return distanceKm * 2 * weightKg;
    }
}

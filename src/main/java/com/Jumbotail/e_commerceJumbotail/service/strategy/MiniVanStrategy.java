package com.Jumbotail.e_commerceJumbotail.service.strategy;

import org.springframework.stereotype.Component;

@Component
public class MiniVanStrategy implements TransportStrategy{
    @Override
    public double calculate(double distanceKm, double weightKg) {
        return distanceKm * 3 * weightKg;
    }
}

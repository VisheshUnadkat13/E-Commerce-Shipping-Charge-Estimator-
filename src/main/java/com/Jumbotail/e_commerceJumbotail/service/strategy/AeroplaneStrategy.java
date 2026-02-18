package com.Jumbotail.e_commerceJumbotail.service.strategy;

import org.springframework.stereotype.Component;

@Component
public class AeroplaneStrategy implements TransportStrategy{
    @Override
    public double calculate(double distanceKm, double weightKg) {
        return distanceKm * 1 * weightKg;
    }

}

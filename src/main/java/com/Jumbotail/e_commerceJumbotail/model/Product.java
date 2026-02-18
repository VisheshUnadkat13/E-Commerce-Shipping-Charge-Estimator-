package com.Jumbotail.e_commerceJumbotail.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "products")
public class Product extends BaseEntity{

    @Column(name = "product_name",nullable = false)
    private String productName;
    private Double price;
    private Double weightKg;

    private Double lengthCm;
    private Double widthCm;
    private Double heightCm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

}

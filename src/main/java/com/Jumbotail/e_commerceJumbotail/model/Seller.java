package com.Jumbotail.e_commerceJumbotail.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "sellers")

public class Seller extends BaseEntity{

    @Column(name = "seller_name",nullable = false)
    private String sellerName;

    private Double latitude;
    private Double longitude;

    private String gstNumber;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Product> products;


}

package com.Jumbotail.e_commerceJumbotail.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
@Getter
@Setter
public class Customer extends BaseEntity{

    @Column(nullable = false,name = "customer_name")
    private String customerName;

    @Column(name = "phone_number",nullable = false,unique = true)
    private String phoneNumber;

    private Double latitude;
    private Double longitude;

    private String city;
}

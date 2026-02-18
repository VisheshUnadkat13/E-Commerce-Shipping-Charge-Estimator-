package com.Jumbotail.e_commerceJumbotail.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "warehouses")
public class Warehouse extends BaseEntity{
    private String name;
    private Double latitude;
    private Double longitude;
    private String city;
}

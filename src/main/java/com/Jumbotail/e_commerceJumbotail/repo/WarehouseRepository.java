package com.Jumbotail.e_commerceJumbotail.repo;

import com.Jumbotail.e_commerceJumbotail.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}

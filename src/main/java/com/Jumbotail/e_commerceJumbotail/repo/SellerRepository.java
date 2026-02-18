package com.Jumbotail.e_commerceJumbotail.repo;

import com.Jumbotail.e_commerceJumbotail.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SellerRepository extends JpaRepository<Seller,Long> {
}

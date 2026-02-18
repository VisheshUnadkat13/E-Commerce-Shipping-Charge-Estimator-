package com.Jumbotail.e_commerceJumbotail.repo;

import com.Jumbotail.e_commerceJumbotail.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

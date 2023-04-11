package com.github.ihorshulha8.consumer.repository;

import com.github.ihorshulha8.consumer.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

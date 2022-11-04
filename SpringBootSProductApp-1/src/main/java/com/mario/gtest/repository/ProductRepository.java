package com.mario.gtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mario.gtest.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> , IProductCustomRepository
{
 // no code at all
}


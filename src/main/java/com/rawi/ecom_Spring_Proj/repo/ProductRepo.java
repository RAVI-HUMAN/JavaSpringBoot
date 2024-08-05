package com.rawi.ecom_Spring_Proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rawi.ecom_Spring_Proj.model.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}

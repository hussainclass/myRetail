package com.myretail.product.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myretail.product.entity.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

}

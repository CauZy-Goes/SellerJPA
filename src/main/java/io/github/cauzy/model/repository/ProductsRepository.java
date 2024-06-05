package io.github.cauzy.model.repository;

import io.github.cauzy.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository  extends JpaRepository<Product, Integer> {
}

package com.cerrano.InventoryAPI.service;

import com.cerrano.InventoryAPI.model.Product;
import com.cerrano.InventoryAPI.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // This tells Spring Boot: "This class is the Manager"
public class ProductService {

    private final ProductRepository repository; // The Manager's connection to the Butler

    // Constructor: Assigns the Butler (Repository) to this Manager
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
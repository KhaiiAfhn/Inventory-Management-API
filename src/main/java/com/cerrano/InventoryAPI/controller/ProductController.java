package com.cerrano.InventoryAPI.controller;
import org.springframework.stereotype.Service;

// Importing our "Watch" blueprint
import com.cerrano.InventoryAPI.model.Product;
// Importing our "Manager" (Service Layer)
import com.cerrano.InventoryAPI.service.ProductService;
// Importing the "Security Guard" tool to check our rules (@Min, @NotBlank)
import jakarta.validation.Valid;
// Importing tools that handle Web Requests (GET, POST, etc.)
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Tells Spring: "This class is an API; it sends data (JSON) back to the user"
@RequestMapping("/api/products") // Sets the base "address" for all requests in this shop
public class ProductController {

    // Creating a private spot to keep the Manager (ProductService)
    private final ProductService productService;

    // Constructor: When the shop opens, assign this specific Manager to the Front Desk
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // --- GET ALL WATCHES ---
    @GetMapping // Listen for a "GET" request to /api/products
    public List<Product> getAllProducts() {
        // Tells the Manager: "Get me the full list of watches from the vault"
        return productService.getAllProducts();
    }

    // --- ADD A NEW WATCH ---
    @PostMapping // Listen for a "POST" request to /api/products
    public Product addProduct(@Valid @RequestBody Product product) {
        // @Valid = Inspect the watch (Security Guard)
        // @RequestBody = Extract the JSON data from the "delivery box" sent by Postman
        return productService.saveProduct(product); // Hand the new watch to the Manager
    }

    // --- GET ONE SPECIFIC WATCH ---
    @GetMapping("/{id}") // Listen for "GET" to /api/products/1 (or any ID number)
    public Product getProductById(@PathVariable Long id) {
        // @PathVariable = Pull the ID number out of the URL address
        return productService.getProductById(id); // Ask the Manager to find that specific watch
    }

    // --- UPDATE A WATCH'S INFO ---
    @PutMapping("/{id}") // Listen for "PUT" to /api/products/1
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product productDetails) {
        // 1. Ask the Manager to find the existing watch in the vault first
        Product product = productService.getProductById(id);

        // 2. Take the new info from the customer and update the watchOS tags
        product.setName(productDetails.getName());
        product.setSku(productDetails.getSku());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());

        // 3. Hand the updated watch back to the Manager to save it
        return productService.saveProduct(product);
    }

    // --- REMOVE A WATCH ---
    @DeleteMapping("/{id}") // Listen for "DELETE" to /api/products/1
    public void deleteProduct(@PathVariable Long id) {
        // Tell the Manager: "Throw away the watch with this ID number"
        productService.deleteProduct(id);
    }
}
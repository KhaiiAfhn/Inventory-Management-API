package com.cerrano.InventoryAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity // This is a signal to Spring: "This isn't just a regular Java class; it's a database table."
@Table(name = "products") // This tells SQL Server to name the table products. If you didn't have this, it would just name it Product by default.
@Getter
@Setter // Instead of you manually writing public String getName() for every variable, Lombok does it in the background while the app is running.
@NoArgsConstructor // Creates a constructor with no parameters (Spring needs this to "build" the object when it pulls data from SQL).
@AllArgsConstructor // Creates a constructor that lets you set all values (id, name, etc.) at once.
public class Product {

    @Id // Marks the id field as the Primary Key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This is the "Auto-Increment." It tells SQL Server, "Hey, don't ask me for an ID number; you generate it ($1, 2, 3...$) every time I add a new product."
    private Long id; // Using Long (a big number) is standard for IDs.

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "SKU is required")
    private String sku;

    @Min(value = 0, message = "Price cannot be negative")
    private Double price;

    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;
}
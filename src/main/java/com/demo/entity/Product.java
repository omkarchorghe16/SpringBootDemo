package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

/**
 * Entity representing a product in the system. Contains product details like name, quantity, and price.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for better portability across databases
    private int id;

    //@NotNull // Ensure name is mandatory
    //@Size(min = 1, max = 100) // Ensure the name length is between 1 and 100 characters
    private String name;

    //@Min(0) // Ensure that quantity cannot be negative
    private int quantity;

    //@Min(0) // Ensure the price is not negative
    private BigDecimal price; // Use BigDecimal for better precision when handling monetary values
}
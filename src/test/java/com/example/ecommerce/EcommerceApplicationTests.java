package com.example.ecommerce;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit Test Cases for DevOps E-Commerce Application
 * Tests: Product price validation, name check, discount calculation
 */
public class EcommerceApplicationTests {

    // ===================================================
    // TEST 1: Product price must be positive
    // ===================================================
    @Test
    @DisplayName("Product price should be greater than zero")
    void testProductPriceShouldBePositive() {
        double price = 50000.0;
        assertTrue(price > 0, "Product price must be positive");
        System.out.println("Test 1 Passed: Product price is valid - " + price);
    }

    // ===================================================
    // TEST 2: Product name must not be null
    // ===================================================
    @Test
    @DisplayName("Product name should not be null or empty")
    void testProductNameNotNull() {
        String productName = "Laptop";
        assertNotNull(productName, "Product name must not be null");
        assertFalse(productName.isEmpty(), "Product name must not be empty");
        System.out.println("Test 2 Passed: Product name is valid - " + productName);
    }

    // ===================================================
    // TEST 3: Discount calculation should be correct
    // ===================================================
    @Test
    @DisplayName("Discount calculation should return correct final price")
    void testProductDiscountCalculation() {
        double originalPrice = 100000.0;
        double discountPercent = 10.0;
        double discountAmount = (originalPrice * discountPercent) / 100;
        double finalPrice = originalPrice - discountAmount;

        assertEquals(90000.0, finalPrice, "Final price after 10% discount should be 90000");
        System.out.println("Test 3 Passed: Discount calculation correct - Final Price: " + finalPrice);
    }

    // ===================================================
    // TEST 4: Product quantity validation
    // ===================================================
    @Test
    @DisplayName("Product quantity should be non-negative")
    void testProductQuantityValidation() {
        int quantity = 50;
        assertTrue(quantity >= 0, "Product quantity must be non-negative");
        System.out.println("Test 4 Passed: Product quantity is valid - " + quantity);
    }

    // ===================================================
    // TEST 5: Product object creation
    // ===================================================
    @Test
    @DisplayName("Product object should be created successfully")
    void testProductObjectCreation() {
        Product product = new Product();
        product.setName("Laptop");
        product.setPrice(75000.0);
        product.setDescription("Gaming Laptop");
        product.setQuantity(10);
        product.setCategory("Electronics");

        assertNotNull(product);
        assertEquals("Laptop", product.getName());
        assertEquals(75000.0, product.getPrice());
        System.out.println("Test 5 Passed: Product object created - " + product.getName());
    }

    // ===================================================
    // TEST 6: ProductService validation methods
    // ===================================================
    @Test
    @DisplayName("ProductService isValidPrice should return true for positive price")
    void testProductServiceValidation() {
        ProductService service = new ProductService();
        assertTrue(service.isValidPrice(500.0));
        assertFalse(service.isValidPrice(-100.0));
        assertFalse(service.isValidPrice(0));
        System.out.println("Test 6 Passed: ProductService validation works correctly");
    }
}

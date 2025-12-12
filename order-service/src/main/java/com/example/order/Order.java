package com.example.order;

public class Order {
    private Long id;
    private Long userId;
    private String product;
    private double amount;

    public Order(Long id, Long userId, String product, double amount) {
        this.id = id;
        this.userId = userId;
        this.product = product;
        this.amount = amount;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getProduct() { return product; }
    public double getAmount() { return amount; }
}
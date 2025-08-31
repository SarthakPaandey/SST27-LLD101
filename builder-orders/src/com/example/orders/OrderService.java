package com.example.orders;

import java.util.List;

public class OrderService {

    public Order createOrder(String id, String email, List<OrderLine> lines, Integer discount, boolean expedited, String notes) {
        Order.Builder builder = new Order.Builder(id, email);
        
        if (lines != null) {
            for (OrderLine line : lines) {
                builder.addLine(line);
            }
        }
        
        if (discount != null) {
            builder.discountPercent(discount);
        }
        
        builder.expedited(expedited);
        
        if (notes != null) {
            builder.notes(notes);
        }
        
        return builder.build();
    }

    public Order createMinimalOrder(String id, String email, OrderLine line) {
        return new Order.Builder(id, email)
                .addLine(line)
                .build();
    }

    public Order createOrderWithDiscount(String id, String email, List<OrderLine> lines, int discountPercent) {
        Order.Builder builder = new Order.Builder(id, email);
        
        for (OrderLine line : lines) {
            builder.addLine(line);
        }
        
        builder.discountPercent(discountPercent);
        
        return builder.build();
    }
}

package com.example.orders;

import java.util.List;

public class OrderService {

    public Order createOrder(String id, String email, List<OrderLine> lines, Integer discount, boolean expedited,
            String notes) {
        Order.Builder b = new Order.Builder(id, email);
        if (lines != null)
            b.addLines(lines);
        b.discountPercent(discount)
                .expedited(expedited)
                .notes(notes);
        return b.build();
    }
}

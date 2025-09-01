package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    private Order(Builder b) {
        this.id = b.id;
        this.customerEmail = b.customerEmail;
        List<OrderLine> copy = new ArrayList<>(b.lines.size());
        for (OrderLine l : b.lines) {
            copy.add(new OrderLine(l.getSku(), l.getQuantity(), l.getUnitPriceCents()));
        }
        this.lines = Collections.unmodifiableList(copy);
        this.discountPercent = b.discountPercent;
        this.expedited = b.expedited;
        this.notes = b.notes;
    }

    public static class Builder {
        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String customerEmail) {
            this.id = Objects.requireNonNull(id, "id required");
            this.customerEmail = Objects.requireNonNull(customerEmail, "customerEmail required");
        }

        public Builder addLine(OrderLine line) {
            Objects.requireNonNull(line, "line cannot be null");
            this.lines.add(line);
            return this;
        }

        public Builder addLines(List<OrderLine> lines) {
            Objects.requireNonNull(lines, "lines cannot be null");
            for (OrderLine l : lines)
                addLine(l);
            return this;
        }

        public Builder discountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder expedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            if (this.lines.isEmpty()) {
                throw new IllegalArgumentException("order must have at least one line");
            }
            if (!PricingRules.isValidEmail(this.customerEmail)) {
                throw new IllegalArgumentException("invalid customer email: " + this.customerEmail);
            }
            if (!PricingRules.isValidDiscount(this.discountPercent)) {
                throw new IllegalArgumentException("invalid discount percent: " + this.discountPercent);
            }
            return new Order(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public boolean isExpedited() {
        return expedited;
    }

    public String getNotes() {
        return notes;
    }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines)
            sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null)
            return base;
        return base - (base * discountPercent / 100);
    }
}

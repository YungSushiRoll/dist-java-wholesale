package edu.wctc.wholesale.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "wholesale_order")
public class WholesaleOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(name = "purchase_order_num")
    private String purchaseOrderNumber;

    @Column(name = "terms")
    private String terms;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @Column(name = "shipped_date")
    private LocalDateTime shippedDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

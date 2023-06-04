package com.example.apiproject.access;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "t_Order")
public class Order {
    @Id
    @Column(name = "OrderID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "Username")
    private User user;

    @Column(name = "OrderDate",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date orderDate;

    @Column(name = "OrderStatus", length = 50)
    private String orderStatus;

    @Column(name = "TotalAmount", precision = 10, scale = 2)
    private BigDecimal totalAmount;
}

package com.example.apiproject.access;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Entity
@Table(name = "t_Order")
public class Order {
    @Id
    @Column(name = "OrderID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = testOrderID, defaultValue = testOrderID)
    private Integer orderId;
    public static final String testOrderID = "1";

    @ManyToOne
    @JoinColumn(name = "Username")
    private User user;

    @Column(name = "OrderDate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Schema(example = testOrderDate, defaultValue = testOrderDate)
    private Date orderDate;
    public static final String testOrderDate = "2023/6/23";

    @Column(name = "OrderStatus", length = 50)
    @Schema(example = testOrderStatus, defaultValue = testOrderStatus)
    private String orderStatus;
    public static final String testOrderStatus = "订单状态";

    @Column(name = "TotalAmount", precision = 10, scale = 2)
    @Schema(example = testTotalAmount, defaultValue = testTotalAmount)
    private BigDecimal totalAmount;
    public static final String testTotalAmount = "10";
}

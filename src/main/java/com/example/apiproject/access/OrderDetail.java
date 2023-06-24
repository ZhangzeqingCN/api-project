package com.example.apiproject.access;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_OrderDetail")
public class OrderDetail {
    @Id
    @Column(name = "OrderDetailID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = testOrderDetailID, defaultValue = testOrderDetailID)
    private Integer orderDetailId;
    public static final String testOrderDetailID = "1";

    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "CommodityID")
    private Commodity commodity;

    @Column(name = "Quantity")
    @Schema(example = testQuantity,defaultValue = testQuantity)
    private Integer quantity;
    public static final String testQuantity = "10";

    @Column(name = "UnitPrice", precision = 10, scale = 2)
    private BigDecimal unitPrice;
}

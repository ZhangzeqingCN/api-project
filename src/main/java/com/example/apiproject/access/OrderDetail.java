package com.example.apiproject.access;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "t_OrderDetail")
public class OrderDetail {
    @Id
    @Column(name = "OrderDetailID")
    private Integer orderDetailId;

/*    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order order;*/

    @ManyToOne
    @JoinColumn(name = "CommodityID")
    private Commodity commodity;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "UnitPrice", precision = 10, scale = 2)
    private BigDecimal unitPrice;


}

package com.example.apiproject.access;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_ShoppingCart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartID")
    @Schema(example = testCartID,defaultValue = testCartID)
    private Integer cartId;
    public static final String testCartID = "1";

    @ManyToOne
    @JoinColumn(name = "Username")
    private User user;

    @ManyToOne
    @JoinColumn(name = "CommodityID")
    private Commodity commodity;

    @Column(name = "Quantity")
    @Schema(example = testQuantity,defaultValue = testQuantity)
    private Integer quantity;
    public static final String testQuantity = "100";
}

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
@Table(name = "t_Commodity")
public class Commodity {//商品
    @Id
    @Column(name = "CommodityID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commodityID;

    @Column(name = "CommodityName", length = 100)
    private String commodityName;

    @Column(name = "Price", precision = 10, scale = 2)
    private Float price;

    @Column(name = "CommodityDescription", length = 255)
    private String commodityDescription;

    @Column(name = "StockQuantity")
    private Integer stockQuantity;

    @Column(name = "ImageURL", length = 200)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;


}

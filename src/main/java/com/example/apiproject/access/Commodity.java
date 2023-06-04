package com.example.apiproject.access;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "t_Commodity")
public class Commodity {
    @Id
    @Column(name = "CommodityID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commodityID;

    @Column(name = "CommodityName", length = 100)
    private String commodityName;

    @Column(name = "Price")
    private Float price;

    @Column(name = "CommodityDescription", length = 255)
    private String commodityDescription;

    @Column(name = "StockQuantity")
    private Integer stockQuantity;

    @Column(name = "ImageURL", length = 200)
    private String imageUrl;

    @ManyToOne()
    @JoinColumn(name = "categoryPid")
    private Category category;

}

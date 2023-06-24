package com.example.apiproject.access;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_Commodity")
@Tag(name = "Commodity",description = "Commodity")
public class Commodity {
    @Id
    @Column(name = "CommodityID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = testCommodityID,defaultValue = testCommodityID)
    private int commodityID;

    public static final String testCommodityID = "1";

    @Column(name = "CommodityName", length = 100)
    @Schema(example = testCommodityName,defaultValue = testCommodityName)
    private String commodityName;

    public static final String testCommodityName = "手机";

    @Column(name = "Price")
    @Schema(example = testPrice,defaultValue = testPrice)
    private Float price;

    public static final String testPrice = "6000";

    @Column(name = "CommodityDescription", length = 255)
    @Schema(example = testCommodityDescription,defaultValue = testCommodityDescription)
    private String commodityDescription;

    public static final String testCommodityDescription = "一部手机";

    @Column(name = "StockQuantity")
    @Schema(example = testStockQuantity,defaultValue = testStockQuantity)
    private Integer stockQuantity;
    public static final String testStockQuantity = "10";

    @Column(name = "ImageURL", length = 200)
    @Schema(example = testImageUrl,defaultValue = testImageUrl)
    private String imageUrl;
    public static final String testImageUrl = "https://test.com/URLtest";

    @ManyToOne()
    @JoinColumn(name = "categoryPid")
    private Category category;

}

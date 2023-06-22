// Generated by delombok at Tue Jun 20 17:11:51 CST 2023
package com.example.delombok.access;

import jakarta.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "categoryPid")
    private com.example.delombok.access.Category category;


    @java.lang.SuppressWarnings("all")
    public static class CommodityBuilder {
        @java.lang.SuppressWarnings("all")
        private int commodityID;
        @java.lang.SuppressWarnings("all")
        private String commodityName;
        @java.lang.SuppressWarnings("all")
        private Float price;
        @java.lang.SuppressWarnings("all")
        private String commodityDescription;
        @java.lang.SuppressWarnings("all")
        private Integer stockQuantity;
        @java.lang.SuppressWarnings("all")
        private String imageUrl;
        @java.lang.SuppressWarnings("all")
        private com.example.delombok.access.Category category;

        @java.lang.SuppressWarnings("all")
        CommodityBuilder() {
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public Commodity.CommodityBuilder commodityID(final int commodityID) {
            this.commodityID = commodityID;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public Commodity.CommodityBuilder commodityName(final String commodityName) {
            this.commodityName = commodityName;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public Commodity.CommodityBuilder price(final Float price) {
            this.price = price;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public Commodity.CommodityBuilder commodityDescription(final String commodityDescription) {
            this.commodityDescription = commodityDescription;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public Commodity.CommodityBuilder stockQuantity(final Integer stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public Commodity.CommodityBuilder imageUrl(final String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public Commodity.CommodityBuilder category(final com.example.delombok.access.Category category) {
            this.category = category;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public Commodity build() {
            return new Commodity(this.commodityID, this.commodityName, this.price, this.commodityDescription, this.stockQuantity, this.imageUrl, this.category);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        public java.lang.String toString() {
            return "Commodity.CommodityBuilder(commodityID=" + this.commodityID + ", commodityName=" + this.commodityName + ", price=" + this.price + ", commodityDescription=" + this.commodityDescription + ", stockQuantity=" + this.stockQuantity + ", imageUrl=" + this.imageUrl + ", category=" + this.category + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    public static Commodity.CommodityBuilder builder() {
        return new Commodity.CommodityBuilder();
    }

    @java.lang.SuppressWarnings("all")
    public void setCommodityID(final int commodityID) {
        this.commodityID = commodityID;
    }

    @java.lang.SuppressWarnings("all")
    public void setCommodityName(final String commodityName) {
        this.commodityName = commodityName;
    }

    @java.lang.SuppressWarnings("all")
    public void setPrice(final Float price) {
        this.price = price;
    }

    @java.lang.SuppressWarnings("all")
    public void setCommodityDescription(final String commodityDescription) {
        this.commodityDescription = commodityDescription;
    }

    @java.lang.SuppressWarnings("all")
    public void setStockQuantity(final Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @java.lang.SuppressWarnings("all")
    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @java.lang.SuppressWarnings("all")
    public void setCategory(final com.example.delombok.access.Category category) {
        this.category = category;
    }

    @java.lang.SuppressWarnings("all")
    public int getCommodityID() {
        return this.commodityID;
    }

    @java.lang.SuppressWarnings("all")
    public String getCommodityName() {
        return this.commodityName;
    }

    @java.lang.SuppressWarnings("all")
    public Float getPrice() {
        return this.price;
    }

    @java.lang.SuppressWarnings("all")
    public String getCommodityDescription() {
        return this.commodityDescription;
    }

    @java.lang.SuppressWarnings("all")
    public Integer getStockQuantity() {
        return this.stockQuantity;
    }

    @java.lang.SuppressWarnings("all")
    public String getImageUrl() {
        return this.imageUrl;
    }

    @java.lang.SuppressWarnings("all")
    public com.example.delombok.access.Category getCategory() {
        return this.category;
    }

    @java.lang.SuppressWarnings("all")
    public Commodity(final int commodityID, final String commodityName, final Float price, final String commodityDescription, final Integer stockQuantity, final String imageUrl, final Category category) {
        this.commodityID = commodityID;
        this.commodityName = commodityName;
        this.price = price;
        this.commodityDescription = commodityDescription;
        this.stockQuantity = stockQuantity;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    @java.lang.SuppressWarnings("all")
    public Commodity() {
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "Commodity(commodityID=" + this.getCommodityID() + ", commodityName=" + this.getCommodityName() + ", price=" + this.getPrice() + ", commodityDescription=" + this.getCommodityDescription() + ", stockQuantity=" + this.getStockQuantity() + ", imageUrl=" + this.getImageUrl() + ", category=" + this.getCategory() + ")";
    }
}
// Generated by delombok at Tue Jun 20 17:11:51 CST 2023
package com.example.delombok.access;

import jakarta.persistence.*;

@Entity
@Table(name = "t_ShoppingCart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartID")
    private Integer cartId;
    @ManyToOne
    @JoinColumn(name = "Username")
    private User user;
    @ManyToOne
    @JoinColumn(name = "CommodityID")
    private Commodity commodity;
    @Column(name = "Quantity")
    private Integer quantity;


    @java.lang.SuppressWarnings("all")
    public static class ShoppingCartBuilder {
        @java.lang.SuppressWarnings("all")
        private Integer cartId;
        @java.lang.SuppressWarnings("all")
        private User user;
        @java.lang.SuppressWarnings("all")
        private Commodity commodity;
        @java.lang.SuppressWarnings("all")
        private Integer quantity;

        @java.lang.SuppressWarnings("all")
        ShoppingCartBuilder() {
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public ShoppingCart.ShoppingCartBuilder cartId(final Integer cartId) {
            this.cartId = cartId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public ShoppingCart.ShoppingCartBuilder user(final User user) {
            this.user = user;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public ShoppingCart.ShoppingCartBuilder commodity(final Commodity commodity) {
            this.commodity = commodity;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public ShoppingCart.ShoppingCartBuilder quantity(final Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public ShoppingCart build() {
            return new ShoppingCart(this.cartId, this.user, this.commodity, this.quantity);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        public java.lang.String toString() {
            return "ShoppingCart.ShoppingCartBuilder(cartId=" + this.cartId + ", user=" + this.user + ", commodity=" + this.commodity + ", quantity=" + this.quantity + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    public static ShoppingCart.ShoppingCartBuilder builder() {
        return new ShoppingCart.ShoppingCartBuilder();
    }

    @java.lang.SuppressWarnings("all")
    public void setCartId(final Integer cartId) {
        this.cartId = cartId;
    }

    @java.lang.SuppressWarnings("all")
    public void setUser(final User user) {
        this.user = user;
    }

    @java.lang.SuppressWarnings("all")
    public void setCommodity(final Commodity commodity) {
        this.commodity = commodity;
    }

    @java.lang.SuppressWarnings("all")
    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    @java.lang.SuppressWarnings("all")
    public Integer getCartId() {
        return this.cartId;
    }

    @java.lang.SuppressWarnings("all")
    public User getUser() {
        return this.user;
    }

    @java.lang.SuppressWarnings("all")
    public Commodity getCommodity() {
        return this.commodity;
    }

    @java.lang.SuppressWarnings("all")
    public Integer getQuantity() {
        return this.quantity;
    }

    @java.lang.SuppressWarnings("all")
    public ShoppingCart(final Integer cartId, final User user, final Commodity commodity, final Integer quantity) {
        this.cartId = cartId;
        this.user = user;
        this.commodity = commodity;
        this.quantity = quantity;
    }

    @java.lang.SuppressWarnings("all")
    public ShoppingCart() {
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "ShoppingCart(cartId=" + this.getCartId() + ", user=" + this.getUser() + ", commodity=" + this.getCommodity() + ", quantity=" + this.getQuantity() + ")";
    }
}

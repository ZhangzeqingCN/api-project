# ShoppingCart
```sql
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
    private Integer cartId;
    @ManyToOne
    @JoinColumn(name = "Username")
    private User user;
    @ManyToOne
    @JoinColumn(name = "CommodityID")
    private Commodity commodity;
    @Column(name = "Quantity")
    private Integer quantity;
}
```
```sql
create table PUBLIC.T_SHOPPING_CART
(
    CARTID      INTEGER auto_increment
        primary key,
    QUANTITY    INTEGER,
    COMMODITYID INTEGER,
    USERNAME    CHARACTER VARYING(50),
    constraint FKD8NL66YB35CFENIGVIMCXBPIH
        foreign key (USERNAME) references PUBLIC.T_USER,
    constraint FKF3C7V6CILJUYGF5QUAIOBC6D9
        foreign key (COMMODITYID) references PUBLIC.T_COMMODITY
);
```

# User
```java
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_User")
public class User {
    @Id
    @Column(name = "Username", length = 50, unique = true)
    @NotBlank
    String name;
    @Column(name = "Password", length = 50)
    String password;
    @Builder.Default
    @Column(name = "Gender", length = 20)
    @NotBlank
    Gender gender = Gender.Unknown;
    @Column(name = "Email", length = 50)
    @Email
    String email;
    @Column(name = "Phone", length = 20)
    String phone;
    @Column(name = "Address", length = 100)
    String address;
}
```
```sql
create table PUBLIC.T_USER
(
    USERNAME CHARACTER VARYING(50) not null
        primary key,
    ADDRESS  CHARACTER VARYING(100),
    EMAIL    CHARACTER VARYING(50),
    GENDER   TINYINT,
    PASSWORD CHARACTER VARYING(50),
    PHONE    CHARACTER VARYING(20),
    check ("GENDER" BETWEEN 0 AND 2)
);
```

# Category
```java
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Integer categoryId;
    @Column(name = "CategoryName", length = 50)
    private String categoryName;
}
```
```sql
create table PUBLIC.T_CATEGORY
(
    CATEGORYID    INTEGER auto_increment
        primary key,
    CATEGORY_NAME CHARACTER VARYING(50)
);
```

# Order
```java
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
```
```sql
create table PUBLIC.T_ORDER
(
    ORDERID      INTEGER auto_increment
        primary key,
    ORDER_DATE   TIMESTAMP default CURRENT_TIMESTAMP,
    ORDER_STATUS CHARACTER VARYING(50),
    TOTAL_AMOUNT NUMERIC(10, 2),
    USERNAME     CHARACTER VARYING(50),
    constraint FKRPFD6Y4J2I7ALGS0QMABQNO8R
        foreign key (USERNAME) references PUBLIC.T_USER
);
```

# OrderDetail
```java
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
    private Integer orderDetailId;
    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "CommodityID")
    private Commodity commodity;
    @Column(name = "Quantity")
    private Integer quantity;
    @Column(name = "UnitPrice", precision = 10, scale = 2)
    private BigDecimal unitPrice;
}
```
```sql
create table PUBLIC.T_ORDER_DETAIL
(
    ORDER_DETAILID INTEGER auto_increment
        primary key,
    QUANTITY       INTEGER,
    UNIT_PRICE     NUMERIC(10, 2),
    COMMODITYID    INTEGER,
    ORDERID        INTEGER,
    constraint FK4SNEG2MHNS6TW18O97Y8FODA7
        foreign key (ORDERID) references PUBLIC.T_ORDER,
    constraint FK8G0E93I1O05R65W2UMHFSCTKY
        foreign key (COMMODITYID) references PUBLIC.T_COMMODITY
);
```

# Commodity
```java
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
```
```sql
create table PUBLIC.T_COMMODITY
(
    COMMODITYID           INTEGER auto_increment
        primary key,
    COMMODITY_DESCRIPTION CHARACTER VARYING(255),
    COMMODITY_NAME        CHARACTER VARYING(100),
    IMAGEURL              CHARACTER VARYING(200),
    PRICE                 REAL,
    STOCK_QUANTITY        INTEGER,
    CATEGORY_PID          INTEGER,
    constraint FKIJFI6Q7TC0IE28HQDKS4DD4DX
        foreign key (CATEGORY_PID) references PUBLIC.T_CATEGORY
);
```

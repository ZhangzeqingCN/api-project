package com.example.apiproject.access;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "t_ShoppingCart")
public class ShoppingCart {
    @Id
    @Column(name = "CartID")
    private Integer cartId;

  /*  @ManyToOne
    @JoinColumn(name = "Username")
    private User user;*/

    @OneToMany(mappedBy = "commodity",cascade = CascadeType.ALL)
    private List<Commodity> commodity;

    @Column(name = "Quantity")
    private Integer quantity;
}

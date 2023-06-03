package com.example.apiproject.domain.commodity;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class FindByPriceDomain {
    Float price;
}

package com.example.apiproject.access;


import com.sun.jdi.IntegerValue;
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
@Table(name = "t_Category")
@Tag(name = "Category",description = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    @Schema(example = testCategoryID, defaultValue = testCategoryID)
    private Integer categoryId;

    public static final String testCategoryID = "1";

    @Column(name = "CategoryName", length = 50)
    @Schema(example = testCategoryName,defaultValue = testCategoryName)
    private String categoryName;

    public static final String testCategoryName = "电子产品";

}
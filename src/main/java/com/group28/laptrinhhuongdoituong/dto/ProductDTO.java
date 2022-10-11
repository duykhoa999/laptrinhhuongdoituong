package com.group28.laptrinhhuongdoituong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Integer id;
    private String name;
    private String slug;
    private Double price;
    private String description;
    private String image;
    private Integer amount;
    private Integer category_id;
    private Integer vendor_id;
    private Boolean deleted;
}

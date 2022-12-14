package com.group28.laptrinhhuongdoituong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Long id;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NotBlank(message = "Slug cannot be empty")
    private String slug;
    @NotNull(message = "Price cannot be empty")
    private Double price;
    private String description;
    @NotBlank(message = "Image cannot be empty")
    private String image;
    @NotNull(message = "Amount cannot be empty")
    private Integer amount;
    @NotNull(message = "Category cannot be empty")
    private Integer category_id;
    @NotNull(message = "Vendor cannot be empty")
    private Integer vendor_id;
    private Boolean deleted = false;
}

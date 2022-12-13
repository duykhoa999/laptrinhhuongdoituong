package com.group28.laptrinhhuongdoituong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {
    private Long id;
    @NotBlank(message = "Code cannot be blank")
    private String code;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Slug cannot be blank")
    private String slug;
    private Boolean deleted = Boolean.FALSE;
}

package com.group28.laptrinhhuongdoituong.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CategoryDTO {
    private long id;
    private String name;
    private String slug;
    private boolean deleted;
}

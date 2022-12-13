package com.group28.laptrinhhuongdoituong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImportDTO {
    private Long id;
    private String code;
    private LocalDateTime date;
    private Long user_id;
    private Long vendor_order_id;
    private Boolean deleted = Boolean.FALSE;
}

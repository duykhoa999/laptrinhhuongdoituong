package com.group28.laptrinhhuongdoituong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImportDTO {
    private Long id;
    private Date date;
    private Integer staff_id;
    private Integer vendor_order_id;
    private Boolean deleted = Boolean.FALSE;
}

package com.group28.laptrinhhuongdoituong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {
    private Long id;
    private Date date;
    private String receiver_name;
    private String receiver_address;
    private String receiver_phone;
    private Date delivery_date;
    private String note;
    private Integer status;
    private Integer payments;
    private Integer created_by;
    private Long user_id;
    private Boolean deleted = Boolean.FALSE;
}

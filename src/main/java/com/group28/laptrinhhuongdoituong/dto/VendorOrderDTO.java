package com.group28.laptrinhhuongdoituong.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendorOrderDTO {
  private Long id;
  private String code;
  private Date date;
  private Long vendor_id;
  private Long user_id;
  private Boolean deleted = Boolean.FALSE;
}

package com.group28.laptrinhhuongdoituong.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendorOrderDTO {
  private Integer id;
  private String code;
  private LocalDateTime date;
  private Long vendor_id;
  private Long user_id;
  private Boolean deleted = Boolean.FALSE;
}

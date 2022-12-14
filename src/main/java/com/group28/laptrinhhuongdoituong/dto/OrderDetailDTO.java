package com.group28.laptrinhhuongdoituong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDTO {
  private Long order_id;
  private Long product_id;
  private Integer amount;
  private Double price;
  private Boolean deleted = Boolean.FALSE;
}
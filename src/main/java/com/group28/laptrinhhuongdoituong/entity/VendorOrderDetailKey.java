package com.group28.laptrinhhuongdoituong.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class VendorOrderDetailKey implements Serializable {
  @Column(name = "vendor_order_id")
  Long vendorOrderId;

  @Column(name = "product_id")
  Long productId;
}

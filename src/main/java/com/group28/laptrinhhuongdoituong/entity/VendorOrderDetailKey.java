package com.group28.laptrinhhuongdoituong.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VendorOrderDetailKey implements Serializable {
  @Column(name = "vendor_order_id")
  Long vendorOrderId;

  @Column(name = "product_id")
  Long productId;
}

package com.group28.laptrinhhuongdoituong.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailKey implements Serializable {
  @Column(name = "order_id")
  Long orderId;

  @Column(name = "product_id")
  Long productId;
}

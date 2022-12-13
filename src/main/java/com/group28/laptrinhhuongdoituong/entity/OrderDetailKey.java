package com.group28.laptrinhhuongdoituong.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class OrderDetailKey implements Serializable {
  @Column(name = "order_id")
  Long orderId;

  @Column(name = "product_id")
  Long productId;
}

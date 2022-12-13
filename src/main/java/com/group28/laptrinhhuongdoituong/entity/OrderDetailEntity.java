package com.group28.laptrinhhuongdoituong.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "order_detail")
@SQLDelete(sql = "UPDATE order_detail SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class OrderDetailEntity {
  @EmbeddedId
  private OrderDetailKey id;

  @ManyToOne
  @MapsId("orderId")
  @JoinColumn(name = "order_id")
  private OrderEntity order_id;

  @ManyToOne
  @MapsId("productId")
  @JoinColumn(name = "product_id")
  private ProductEntity product_id;

  private Integer amount;
  private Double price;
  private Boolean deleted = Boolean.FALSE;
}

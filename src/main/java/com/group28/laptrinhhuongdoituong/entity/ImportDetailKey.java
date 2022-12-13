package com.group28.laptrinhhuongdoituong.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ImportDetailKey implements Serializable {
  @Column(name = "import_id")
  Long importId;

  @Column(name = "product_id")
  Long productId;
}
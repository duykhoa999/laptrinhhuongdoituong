package com.group28.laptrinhhuongdoituong.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class ImportDetailKey implements Serializable {
  @Column(name = "import_id")
  Long importId;

  @Column(name = "product_id")
  Long productId;
}

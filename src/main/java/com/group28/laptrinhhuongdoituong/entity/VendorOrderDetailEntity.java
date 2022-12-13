package com.group28.laptrinhhuongdoituong.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "vendor_order_detail")
@SQLDelete(sql = "UPDATE vendor_order_detail SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class VendorOrderDetailEntity implements Serializable {
    @Id
    private Integer vendor_order_id;
    @Id
    private Integer product_id;
    private Integer amount;
    private Double price;
    private Boolean deleted = Boolean.FALSE;
}

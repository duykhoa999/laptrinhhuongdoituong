package com.group28.laptrinhhuongdoituong.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "vendor_order")
@SQLDelete(sql = "UPDATE vendor_order SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class VendorOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    private Integer vendor_id;
    private Integer staff_id;
    private Boolean deleted;
}

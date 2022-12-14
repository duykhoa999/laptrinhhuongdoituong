package com.group28.laptrinhhuongdoituong.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private Long id;
    private String code;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private VendorEntity vendor;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UserEntity user;

    @OneToMany(mappedBy = "vendor_order_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VendorOrderDetailEntity> vendorOrderDetail = new HashSet<>();
    private Boolean deleted = Boolean.FALSE;
}

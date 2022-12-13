package com.group28.laptrinhhuongdoituong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "imports")
@SQLDelete(sql = "UPDATE imports SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ImportEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String code;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "vendor_order_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private VendorOrderEntity vendorOrder;
    private Boolean deleted = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UserEntity user;
}

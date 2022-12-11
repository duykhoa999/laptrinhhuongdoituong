package com.group28.laptrinhhuongdoituong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "orders")
@SQLDelete(sql = "UPDATE orders SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String receiver_name;
    private String receiver_address;
    private String receiver_phone;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date delivery_date;
    private String note;
    private Integer status;
    private Integer payments;
    private Long staff_id;
    private Long customer_id;

    private Boolean deleted = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private StaffEntity staff;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CustomerEntity customer;
}

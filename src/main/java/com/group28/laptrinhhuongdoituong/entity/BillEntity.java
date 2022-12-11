package com.group28.laptrinhhuongdoituong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "bills")
@SQLDelete(sql = "UPDATE bills SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class BillEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private Float total;
    private Long order_id;
    private Long staff_id;
    private Boolean deleted = Boolean.FALSE;

    @OneToOne
    @JoinColumn(name = "order_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private StaffEntity staff;
}

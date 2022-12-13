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
    private String code;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private Double total;
    private Boolean deleted = Boolean.FALSE;

    @OneToOne
    @JoinColumn(name = "order_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UserEntity user;
}

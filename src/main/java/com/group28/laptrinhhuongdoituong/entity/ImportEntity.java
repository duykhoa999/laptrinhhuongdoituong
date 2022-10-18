package com.group28.laptrinhhuongdoituong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
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
@Table(name = "import")
@SQLDelete(sql = "UPDATE import SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ImportEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private Integer staff_id;
    private Integer vendor_order_id;

    private Boolean deleted = Boolean.FALSE;
}

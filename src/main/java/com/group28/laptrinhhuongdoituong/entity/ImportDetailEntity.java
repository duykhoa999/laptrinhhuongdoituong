package com.group28.laptrinhhuongdoituong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
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
@Table(name = "import_detail")
@SQLDelete(sql = "UPDATE import_detail SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ImportDetailEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long import_id;
    @Id
    private Long product_id;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private Long staff_id;
    private Long vendor_order_id;

    private Boolean deleted = Boolean.FALSE;
}

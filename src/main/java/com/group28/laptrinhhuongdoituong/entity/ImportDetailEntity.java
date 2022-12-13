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

    @EmbeddedId
    private ImportDetailKey id;

    @ManyToOne
    @MapsId("import_id")
    @JoinColumn(name = "import_id")
    private ImportEntity import_id;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private ProductEntity product_id;

    private Integer amount;
    private Double price;
    private Boolean deleted = Boolean.FALSE;
}

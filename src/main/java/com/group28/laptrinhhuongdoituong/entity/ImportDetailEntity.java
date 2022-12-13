package com.group28.laptrinhhuongdoituong.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.io.Serializable;

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
    @MapsId("importId")
    @JoinColumn(name = "import_id")
    private ImportEntity import_id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity product_id;

    private Integer amount;
    private Double price;
    private Boolean deleted = Boolean.FALSE;
}

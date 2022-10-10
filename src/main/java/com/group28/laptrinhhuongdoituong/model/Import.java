package com.group28.laptrinhhuongdoituong.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "import")
@SQLDelete(sql = "UPDATE import SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Import implements Serializable {
    private static final long serialVersionUID = 1L;
    private String date;
    private long staff_id;
    private long vendor_order_id;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private boolean deleted = Boolean.FALSE;
}

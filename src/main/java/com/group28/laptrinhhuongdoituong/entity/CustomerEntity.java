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
@Table(name = "customers")
@SQLDelete(sql = "UPDATE customers SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CustomerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean gender;
    private String dob;
    private String address;
    private String phone;
    private String email;
    private String password;
    private Long role_id;

    private Boolean deleted = Boolean.FALSE;
}
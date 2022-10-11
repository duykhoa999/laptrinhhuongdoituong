package com.group28.laptrinhhuongdoituong.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "staff")
@SQLDelete(sql = "UPDATE staff SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class StaffEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String gender;
    private LocalDateTime dob;
    private String address;
    private String phone;
    private String email;
    private String password;
    private Integer role_id;
    private Boolean deleted;
}

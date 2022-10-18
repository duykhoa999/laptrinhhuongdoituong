package com.group28.laptrinhhuongdoituong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    private Long id;
    private String name;
    private Boolean gender;
    private String dob;
    private String address;
    private String phone;
    private String email;
    private String password;
    private Integer role_id;

    private Boolean deleted = Boolean.FALSE;
}

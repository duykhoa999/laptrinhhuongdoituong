package com.group28.laptrinhhuongdoituong.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StaffDTO implements Serializable {
  private Long id;
  private String gender;
  private LocalDateTime dob;
  private String address;
  private String phone;
  private String email;
  private String password;
  private Integer role_id;
  private Boolean deleted = Boolean.FALSE;
}

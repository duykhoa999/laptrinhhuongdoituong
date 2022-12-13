package com.group28.laptrinhhuongdoituong.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendorDTO implements Serializable {
  private static final long serialVersionUID = 1L;
  private Long id;
  @NotBlank(message = "Name cannot be empty")
  private String name;
  @NotBlank(message = "Address cannot be empty")
  private String address;
  @NotBlank(message = "Email cannot be empty")
  private String email;
  private Boolean deleted = Boolean.FALSE;
}

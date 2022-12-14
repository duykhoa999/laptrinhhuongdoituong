package com.group28.laptrinhhuongdoituong.message;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDateRequest {
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date fromDate;
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date toDate;
}

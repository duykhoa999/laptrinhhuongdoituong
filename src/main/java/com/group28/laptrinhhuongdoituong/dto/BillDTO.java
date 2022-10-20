package com.group28.laptrinhhuongdoituong.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BillDTO {
    private Long id;
    private Date date;
    private Float total;
    private Long order_id;
    private Long staff_id;
    private Boolean deleted = Boolean.FALSE;
}

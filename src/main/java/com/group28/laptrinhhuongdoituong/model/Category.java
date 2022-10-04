package com.group28.laptrinhhuongdoituong.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String slug;
    @Id
    private String id;
}

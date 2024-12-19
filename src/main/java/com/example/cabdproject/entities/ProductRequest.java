package com.example.cabdproject.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class ProductRequest {
    private Integer id_p;
    private Integer id_c;
}

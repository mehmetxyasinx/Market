package com.example.marketplace.Entity;


import com.example.marketplace.Enum.MaterialType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 20)
    private String code;
    @Column(length = 100)
    private String description;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy/hh/mm/ss")
    Date date = new Date();


    public BaseEntity(String code, String description, Date date ) {
        this.code = code;
        this.description = description;
        this.date = date;
    }
}


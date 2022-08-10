package com.example.marketplace.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "material_barcode")
public class MaterialBarcodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20)
    private String barcode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy/hh/mm/ss")
    Date date = new Date();
    @ManyToOne
    private MaterialEntity material;
}

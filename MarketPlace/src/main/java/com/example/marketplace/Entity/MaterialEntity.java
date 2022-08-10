package com.example.marketplace.Entity;

import com.example.marketplace.Enum.MaterialType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import javax.persistence.*;
import java.util.Collection;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Material")
public class MaterialEntity extends BaseEntity {


    private MaterialType type;
    @ManyToOne
    @JoinColumn(name ="brand_id")
    private BrandEntity brand;

    @ManyToOne
    @JoinColumn(name = "rayon_id")
    private RayonEntity rayon;

    @OneToMany(mappedBy = "material")
    Collection<MaterialBarcodeEntity> materialBarcodes;


}

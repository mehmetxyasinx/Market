package com.example.marketplace.Services;

import com.example.marketplace.Entity.MaterialBarcodeEntity;
import com.example.marketplace.Repo.MaterialBarcode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialBarcodeService {

    MaterialBarcode materialBarcode;

    public MaterialBarcodeService(MaterialBarcode materialBarcode) {
        this.materialBarcode = materialBarcode;
    }



    public Optional<MaterialBarcodeEntity> findById(Long id) {
        return materialBarcode.findById(id);
    }

    public List<MaterialBarcodeEntity> findAll() {
        return materialBarcode.findAll();
    }

    public void deleteById(Long id) {
        materialBarcode.deleteById(id);
    }

    public void save(MaterialBarcodeEntity foundMaterials) {
        materialBarcode.save(foundMaterials);
    }
}

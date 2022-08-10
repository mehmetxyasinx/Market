package com.example.marketplace.Repo;

import com.example.marketplace.Entity.MaterialBarcodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialBarcode extends JpaRepository<MaterialBarcodeEntity,Long> {
}

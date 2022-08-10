package com.example.marketplace.Services;


import com.example.marketplace.Entity.MaterialEntity;
import com.example.marketplace.Repo.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;

    }

    public MaterialEntity save(MaterialEntity entity) {
        return materialRepository.save(entity);
    }

    public Optional<MaterialEntity> findById(Long id) {
        return materialRepository.findById(id);
    }

    public List<MaterialEntity> findAll(MaterialEntity material) {
        return materialRepository.findAll();
    }

    public void deleteById(Long id) {
        materialRepository.deleteById(id);
    }
}

package com.example.marketplace.Services;

import com.example.marketplace.Entity.BrandEntity;
import com.example.marketplace.Repo.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public BrandEntity save(BrandEntity brand) {
        return brandRepository.save(brand);
    }

    public Optional<BrandEntity> findById(Long id) {
        return brandRepository.findById(id);

    }

    public List<BrandEntity> findAll() {
        return brandRepository.findAll();
    }

    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }
}

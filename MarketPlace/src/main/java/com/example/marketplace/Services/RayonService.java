package com.example.marketplace.Services;

import com.example.marketplace.Entity.RayonEntity;
import com.example.marketplace.Repo.RayonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RayonService {
    RayonRepository rayonRepository;

    public RayonService(RayonRepository rayonRepository) {
        this.rayonRepository = rayonRepository;
    }

    public RayonEntity save(RayonEntity rayon) {
        return rayonRepository.save(rayon);
    }

    public Optional<RayonEntity> findById(Long id) {
        return rayonRepository.findById(id);
    }

    public List<RayonEntity> findAll() {
        return rayonRepository.findAll();
    }

    public void deleteById(Long id) {
        rayonRepository.deleteById(id);
    }
}

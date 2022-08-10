package com.example.marketplace.Controller;

import com.example.marketplace.Entity.RayonEntity;
import com.example.marketplace.Services.RayonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rayon")
public class RayonController {
    RayonService rayonService;

    public RayonController(RayonService rayonService) {
        this.rayonService = rayonService;
    }

    @PostMapping /* * İd sine göre Materiali Gönderir **/
    public RayonEntity createUserById(@RequestBody RayonEntity rayon) {
        return rayonService.save(rayon);


    }

    @GetMapping("/{id}") /* * İd sine göre Materiali Getirir **/
    public RayonEntity getById(@PathVariable Long id) {
        return rayonService.findById(id).orElse(null);
    }

    @GetMapping /* * Her Materiali Getirir **/
    public List<RayonEntity> getAllMaterials() {
        return rayonService.findAll();
    }

    @PutMapping("/{id}") /* * İd sine göre Materiali Günceller * */
    public RayonEntity UpdateUserById(@PathVariable Long id, @RequestBody RayonEntity rayon) {
        Optional<RayonEntity> rayonEntity = rayonService.findById(id);
        if (rayonEntity.isPresent()) {
            RayonEntity foundRayon = rayonEntity.get();
            foundRayon.setCode(rayon.getCode());
            foundRayon.setDescription(rayon.getDescription());
            rayonService.save(foundRayon);
            return foundRayon;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")/* * İd sine göre Materiali Siler * */
    public void deleteById(@PathVariable Long id) {
        rayonService.deleteById(id);
    }

}


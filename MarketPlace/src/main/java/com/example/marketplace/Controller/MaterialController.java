package com.example.marketplace.Controller;

import com.example.marketplace.Entity.MaterialEntity;

import com.example.marketplace.Services.MaterialService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/material")
public class MaterialController {

    private MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @PostMapping /* * İd sine göre Materiali Gönderir **/
    public MaterialEntity createUserById(@RequestBody MaterialEntity entity){
        materialService.save(entity);
        return entity;

    }

    @GetMapping("/{id}") /* * İd sine göre Materiali Getirir **/
    public MaterialEntity getById(@PathVariable Long id) {
       return materialService.findById(id).orElse(null);
    }

    @GetMapping /* * Her Materiali Getirir **/
    public List<MaterialEntity> getAllMaterials(MaterialEntity material){
        return materialService.findAll(material);
    }

    @PutMapping("/{id}") /* * İd sine göre Materiali Günceller * */
    public MaterialEntity UpdateUserById(@PathVariable Long id,@RequestBody MaterialEntity entity){
        Optional<MaterialEntity>entitys=materialService.findById(id);
        if (entitys.isPresent()){
            MaterialEntity foundEntity=entitys.get();
            foundEntity.setCode(entity.getCode());
            foundEntity.setDescription(entity.getDescription());
            foundEntity.setType(entity.getType());
            materialService.save(foundEntity);
            return foundEntity;
        }
        else {
            return null;
        }
    }
    @DeleteMapping("/{id}")/* * İd sine göre Materiali Siler * */
    public void deleteById(@PathVariable Long id){
        materialService.deleteById(id);
    }

}

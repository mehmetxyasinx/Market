package com.example.marketplace.Controller;

import com.example.marketplace.Entity.BrandEntity;


import com.example.marketplace.Services.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brand")
public class BrandController {

    BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    @PostMapping /* * İd sine göre Brand Gönderir **/
    public BrandEntity createUserById(@RequestBody BrandEntity brand){
        brandService.save(brand);
            return brand;
    }
    @GetMapping("/{id}") /* * İd sine göre Brand Getirir **/
    public BrandEntity getById(@PathVariable Long id) {
        return brandService.findById(id).orElse(null);
    }

    @GetMapping /* * Her Brand getirir **/
    public List<BrandEntity> getAllMaterials(){
        return brandService.findAll();
    }

    @PutMapping("/{id}") /* * İd sine göre Brand günceller * */
    public BrandEntity UpdateUserById(@PathVariable Long id, @RequestBody BrandEntity brand){
        Optional<BrandEntity> brandEntity=brandService.findById(id);
        if (brandEntity.isPresent()){
            BrandEntity foundBrand =brandEntity.get();
            foundBrand.setCode(brand.getCode());
            foundBrand.setDescription(brand.getDescription());
            brandService.save(foundBrand);
            return foundBrand;
        }
        else {
            return null;
        }
    }
    @DeleteMapping("/{id}")/* * İd sine göre Brand Siler * */
    public void deleteById(@PathVariable Long id){


        brandService.deleteById(id);
    }

}


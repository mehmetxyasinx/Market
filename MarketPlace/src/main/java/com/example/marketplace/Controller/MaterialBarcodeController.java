package com.example.marketplace.Controller;


import com.example.marketplace.Entity.MaterialBarcodeEntity;
import com.example.marketplace.Services.MaterialBarcodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/barcode")
public class MaterialBarcodeController {

    MaterialBarcodeService materialBarcodeService;

    public MaterialBarcodeController(MaterialBarcodeService materialBarcodeService) {
        this.materialBarcodeService = materialBarcodeService;
    }
    @PostMapping /* * İd sine göre Barcode Gönderir **/
    public MaterialBarcodeEntity createUser(@RequestBody MaterialBarcodeEntity materialBarcode){
        materialBarcodeService.save(materialBarcode);
        return materialBarcode;
    }
    @GetMapping("/{id}") /* * İd sine göre Barcode Getirir **/
    public MaterialBarcodeEntity getById(@PathVariable Long id) {
        return materialBarcodeService.findById(id).orElse(null);
    }

    @GetMapping /* * Her Barcode getirir **/
    public List<MaterialBarcodeEntity> getAllMaterials(){
        return materialBarcodeService.findAll();
    }

    @PutMapping("/{id}") /* * İd sine göre Barcode günceller * */
    public MaterialBarcodeEntity UpdateUserById(@PathVariable Long id, @RequestBody MaterialBarcodeEntity materialBarcode){
        Optional<MaterialBarcodeEntity> brandEntity=materialBarcodeService.findById(id);
        if (brandEntity.isPresent()){
            MaterialBarcodeEntity foundMaterials =brandEntity.get();
            foundMaterials.setBarcode(materialBarcode.getBarcode());
            materialBarcodeService.save(foundMaterials);
            return foundMaterials;
        }
        else {
            return null;
        }
    }
    @DeleteMapping("/{id}")/* * İd sine göre Barcode Siler * */
    public void deleteById(@PathVariable Long id) {
        materialBarcodeService.deleteById(id);

    }
}
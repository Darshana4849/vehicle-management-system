package lk.zerocode.vehicle_management_system.controllers;

import lk.zerocode.vehicle_management_system.controllers.requests.BrandRequest;
import lk.zerocode.vehicle_management_system.controllers.response.BrandResponse;
import lk.zerocode.vehicle_management_system.exception.BrandNotFoundException;
import lk.zerocode.vehicle_management_system.models.Brand;
import lk.zerocode.vehicle_management_system.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BrandController {

    private BrandService brandService;

    public BrandController(BrandService brandService){
        this.brandService = brandService;
    }
    @PostMapping("/brands")
    public void create(@RequestBody BrandRequest brandRequest) {

        brandService.create(brandRequest);

    }
    @GetMapping("/brands/{brand-id}")
    public BrandResponse getById(@PathVariable("brand-id") Long brandId) {

        Brand brand = brandService.findById(brandId);
        BrandResponse brandResponse = new BrandResponse();

        brandResponse.setName(brand.getName());

        return brandResponse;

    }
    @GetMapping("/brands")
    public List<BrandResponse> getAllBrands(){

        List<Brand> brandList = brandService.findAll();
        List<BrandResponse> response = new ArrayList<>();

        for(Brand modelObject :  brandList) {
            BrandResponse brandResponse = new BrandResponse();

            brandResponse.setName(modelObject.getName());
            response.add(brandResponse);

        }

        return response;

    }

    @PutMapping("brands/{brand-id}")
    public void updateBrandById(@PathVariable("brand-id") Long brandId,
                                @RequestBody BrandRequest brandRequest){

        brandService.updateById(brandId, brandRequest);

    }

    @DeleteMapping("brands/{brand-id}")
    public void deleteBrandById(@PathVariable("brand-id") Long brandId){

        brandService.deleteById(brandId);

    }
}






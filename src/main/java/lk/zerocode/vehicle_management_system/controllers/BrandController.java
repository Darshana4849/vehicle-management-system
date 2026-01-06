package lk.zerocode.vehicle_management_system.controllers;

import lk.zerocode.vehicle_management_system.controllers.requests.BrandRequest;
import lk.zerocode.vehicle_management_system.controllers.response.BrandResponse;
import lk.zerocode.vehicle_management_system.exception.BrandNotFoundException;
import lk.zerocode.vehicle_management_system.models.Brand;
import lk.zerocode.vehicle_management_system.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping(value="/brands")
    public void create(@RequestBody BrandRequest brandRequest){
        brandService.create(brandRequest);
    }

    @GetMapping(value="/brands/{brand-id}")
    public BrandResponse getById(@PathVariable ("brand-id") Long id) throws BrandNotFoundException {
        Brand brand = brandService.findById(id);

        BrandResponse brandResponse = new BrandResponse();

        brandResponse.setName(brand.getName());
        return brandResponse;

    }
}





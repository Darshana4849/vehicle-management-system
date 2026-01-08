package lk.zerocode.vehicle_management_system.controllers;

import lk.zerocode.vehicle_management_system.controllers.requests.BrandRequest;
import lk.zerocode.vehicle_management_system.controllers.response.BrandResponse;
import lk.zerocode.vehicle_management_system.models.Brand;
import lk.zerocode.vehicle_management_system.models.Model;
import lk.zerocode.vehicle_management_system.services.BrandService;
import lk.zerocode.vehicle_management_system.services.ModelService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;
    private final ModelService modelService;

    public BrandController(BrandService brandService,
                           ModelService modelService) {
        this.brandService = brandService;
        this.modelService = modelService;
    }

    @PostMapping
    public void create(@RequestBody BrandRequest brandRequest) {
        brandService.create(brandRequest);
    }

    @GetMapping("/{brandId}")
    public BrandResponse getById(@PathVariable Long brandId) {

        Brand brand = brandService.findById(brandId);

        BrandResponse response = new BrandResponse();
        response.setName(brand.getName());

        return response;
    }

    @GetMapping
    public List<BrandResponse> getAllBrands() {

        List<Brand> brands = brandService.findAll();
        List<BrandResponse> responses = new ArrayList<>();

        for (Brand brand : brands) {
            BrandResponse res = new BrandResponse();
            res.setName(brand.getName());
            responses.add(res);
        }
        return responses;
    }

    //add new
    @GetMapping("/{brandId}/models")
    public List<Model> getModelsByBrand(@PathVariable Long brandId) {
        return modelService.getModelsByBrand(brandId);
    }

    @PutMapping("/{brandId}")
    public void update(@PathVariable Long brandId,
                       @RequestBody BrandRequest brandRequest) {
        brandService.updateById(brandId, brandRequest);
    }

    @DeleteMapping("/{brandId}")
    public void delete(@PathVariable Long brandId) {
        brandService.deleteById(brandId);
    }
}

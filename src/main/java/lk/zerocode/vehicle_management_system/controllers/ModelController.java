package lk.zerocode.vehicle_management_system.controllers;

import lk.zerocode.vehicle_management_system.controllers.requests.ModelRequest;
import lk.zerocode.vehicle_management_system.controllers.response.ModelResponse;
import lk.zerocode.vehicle_management_system.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping("/models/{brand-id}")
    public void create(
            @PathVariable("brand-id") Long brandId, @RequestBody ModelRequest modelRequest
    ) {
        modelService.create(brandId, modelRequest);
    }

    @GetMapping("/brands/{brand-id}/models")
    public List<ModelResponse> getModelsByBrand (@PathVariable("brand-id") Long brandId
    ) {
        return modelService.getModelsByBrandId(brandId);
    }
}


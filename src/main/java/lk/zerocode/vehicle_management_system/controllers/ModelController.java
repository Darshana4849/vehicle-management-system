package lk.zerocode.vehicle_management_system.controllers;

import lk.zerocode.vehicle_management_system.controllers.requests.ModelRequest;
import lk.zerocode.vehicle_management_system.services.ModelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands/{brandId}/models")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping
    public void create(@PathVariable Long brandId,
                       @RequestBody ModelRequest modelRequest) {

        modelService.create(brandId, modelRequest);
    }
}

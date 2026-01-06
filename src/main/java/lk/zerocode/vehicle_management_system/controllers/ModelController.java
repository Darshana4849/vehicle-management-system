package lk.zerocode.vehicle_management_system.controllers;

import lk.zerocode.vehicle_management_system.controllers.requests.ModelRequest;
import lk.zerocode.vehicle_management_system.controllers.response.ModelResponse;
import lk.zerocode.vehicle_management_system.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ModelController {

    private ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping("brands/{brand-id}/models")
    public void create(@PathVariable("brand-id") Long brandId,
                       @RequestBody ModelRequest modelRequest) {

        modelService.create(brandId, modelRequest);

    }

}


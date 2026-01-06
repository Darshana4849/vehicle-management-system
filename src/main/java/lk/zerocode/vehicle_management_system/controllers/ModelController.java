package lk.zerocode.vehicle_management_system.controllers;

import lk.zerocode.vehicle_management_system.controllers.requests.BrandRequest;
import lk.zerocode.vehicle_management_system.controllers.requests.ModelRequest;
import lk.zerocode.vehicle_management_system.services.BrandService;
import lk.zerocode.vehicle_management_system.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ModelController {
    @Autowired
    private ModelService modelService;

    @PostMapping(value="/models")
    public void create(@RequestBody ModelRequest modelRequest){
        modelService.create(modelRequest);
    }
}

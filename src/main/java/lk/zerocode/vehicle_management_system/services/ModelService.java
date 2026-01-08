package lk.zerocode.vehicle_management_system.services;

import lk.zerocode.vehicle_management_system.controllers.requests.ModelRequest;
import lk.zerocode.vehicle_management_system.models.Brand;
import lk.zerocode.vehicle_management_system.models.Model;

import java.util.List;

public interface ModelService {

    void create(Long brandId, ModelRequest modelRequest);

    Brand findBrandById(Long brandId);

    List<Model> getModelsByBrand(Long brandId);
}

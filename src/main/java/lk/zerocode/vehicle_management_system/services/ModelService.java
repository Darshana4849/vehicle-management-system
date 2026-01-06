package lk.zerocode.vehicle_management_system.services;

import lk.zerocode.vehicle_management_system.controllers.requests.ModelRequest;
import lk.zerocode.vehicle_management_system.controllers.response.ModelResponse;

import java.util.List;

public interface ModelService {

    void create(Long brandId, ModelRequest modelRequest);

    List<ModelResponse> getModelsByBrandId(Long brandId);
}

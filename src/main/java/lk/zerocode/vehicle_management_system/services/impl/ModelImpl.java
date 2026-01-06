package lk.zerocode.vehicle_management_system.services.impl;
import lk.zerocode.vehicle_management_system.controllers.requests.ModelRequest;
import lk.zerocode.vehicle_management_system.controllers.response.ModelResponse;
import lk.zerocode.vehicle_management_system.models.Brand;
import lk.zerocode.vehicle_management_system.models.Model;
import lk.zerocode.vehicle_management_system.repository.BrandRepository;
import lk.zerocode.vehicle_management_system.repository.ModelRepository;
import lk.zerocode.vehicle_management_system.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public void create(Long brandId, ModelRequest modelRequest) {

        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        Model model = new Model();
        model.setModelName(modelRequest.getModelName());
        model.setBrand(brand);

        modelRepository.save(model);
    }

    @Override
    public List<ModelResponse> getModelsByBrandId(Long brandId) {

        List<Model> models = modelRepository.findByBrandId(brandId);

        return models.stream().map(model -> {
            ModelResponse response = new ModelResponse();
            response.setModelName(model.getModelName());
            return response;
        }).toList();
    }
}


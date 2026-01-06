package lk.zerocode.vehicle_management_system.services.impl;
import lk.zerocode.vehicle_management_system.controllers.requests.ModelRequest;
import lk.zerocode.vehicle_management_system.exception.BrandNotFoundException;
import lk.zerocode.vehicle_management_system.exception.ModelNotFoundException;
import lk.zerocode.vehicle_management_system.models.Brand;
import lk.zerocode.vehicle_management_system.models.Model;
import lk.zerocode.vehicle_management_system.repository.BrandRepository;
import lk.zerocode.vehicle_management_system.repository.ModelRepository;
import lk.zerocode.vehicle_management_system.services.ModelService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary
public class ModelServiceImpl implements ModelService {

    private ModelRepository modelRepository;
    private BrandRepository brandRepository;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void create(Long brandId, ModelRequest modelRequest) {

        Brand brand = findBrandById(brandId);

        Model model = new Model();
        model.setModelName(modelRequest.getModelName());
        model.setBrand(brand);

        try {
            modelRepository.save(model);
        } catch (RuntimeException exception) {
            throw new ModelNotFoundException(exception.getMessage());
        }

    }

    @Override
    public Brand findBrandById(Long brandId) {
        return brandRepository.findById(brandId).orElseThrow(
                () -> new BrandNotFoundException("brand is unavailable")
        );
    }

}


package lk.zerocode.vehicle_management_system.services.impl;

import lk.zerocode.vehicle_management_system.controllers.requests.BrandRequest;
import lk.zerocode.vehicle_management_system.exception.BrandNotFoundException;
import lk.zerocode.vehicle_management_system.models.Brand;
import lk.zerocode.vehicle_management_system.repository.BrandRepository;
import lk.zerocode.vehicle_management_system.services.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void create(BrandRequest brandRequest) {

        Brand brand = new Brand();
        brand.setName(brandRequest.getName());

        brandRepository.save(brand);
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() ->
                        new BrandNotFoundException("Brand not found"));
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public void updateById(Long id, BrandRequest brandRequest) {

        Brand brand = findById(id);
        brand.setName(brandRequest.getName());

        brandRepository.save(brand);
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }
}

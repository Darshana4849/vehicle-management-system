package lk.zerocode.vehicle_management_system.services.impl;

import lk.zerocode.vehicle_management_system.controllers.requests.BrandRequest;
import lk.zerocode.vehicle_management_system.exception.BrandNotFoundException;
import lk.zerocode.vehicle_management_system.models.Brand;
import lk.zerocode.vehicle_management_system.repository.BrandRepository;
import lk.zerocode.vehicle_management_system.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public void create(BrandRequest brandRequest) {

        System.out.println("Service " + brandRequest.getName());
        Brand brand = new Brand();

        brand.setName(brandRequest.getName());

        brandRepository.save(brand);

    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id).orElseThrow (
                () -> new BrandNotFoundException("Brand Not Found!"));

    }




}




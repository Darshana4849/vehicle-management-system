package lk.zerocode.vehicle_management_system.services.impl;

import lk.zerocode.vehicle_management_system.controllers.requests.BrandRequest;
import lk.zerocode.vehicle_management_system.controllers.response.BrandResponse;
import lk.zerocode.vehicle_management_system.exception.BrandNotFoundException;
import lk.zerocode.vehicle_management_system.models.Brand;
import lk.zerocode.vehicle_management_system.repository.BrandRepository;
import lk.zerocode.vehicle_management_system.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public void create(BrandRequest brandRequest) {

        System.out.println("Service " + brandRequest.getName());
        Brand brand = new Brand();

        brand.setBrandId(brandRequest.getBrandId());
        brand.setName(brandRequest.getName());

        brandRepository.save(brand);

    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id).orElseThrow (
                () -> new BrandNotFoundException("Brand Not Found!"));

    }




//        Optional <Brand> brandOptional = brandRepository.findById(id);
//        if (brandOptional.isPresent()){
//            Brand brand = brandOptional.get();
//            return brand;
//        }
//        return null;
//
//        throw new BrandNotFoundException("Brand Not Found!");
//    }
}




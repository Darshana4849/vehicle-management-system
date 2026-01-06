package lk.zerocode.vehicle_management_system.services.impl;

import lk.zerocode.vehicle_management_system.controllers.requests.BrandRequest;
import lk.zerocode.vehicle_management_system.exception.BrandNotFoundException;
import lk.zerocode.vehicle_management_system.models.Brand;
import lk.zerocode.vehicle_management_system.repository.BrandRepository;
import lk.zerocode.vehicle_management_system.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Primary
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @Override
    public void create(BrandRequest brandRequest) {

        Brand brand = new Brand();

        brand.setName(brandRequest.getName());

        try {
            brandRepository.save(brand);
        } catch (RuntimeException exception) {
            throw new BrandNotFoundException(exception.getMessage());
        }

    }

    @Override
    public Brand findById(Long brandId) {

        return brandRepository.findById(brandId).orElseThrow(
                () -> new BrandNotFoundException("brand is unavailable")
        );

    }

    @Override
    public List<Brand> findAll() {

        List<Brand> brandList = brandRepository.findAll();

        if(brandList.isEmpty()) {
            throw new BrandNotFoundException("no vehicle brands in database");
        }

        return brandList;
    }

    @Override
    public void updateById(Long brandId, BrandRequest brandRequest) {

        Brand brand = findById(brandId);

        if(brand.getName().equals(brandRequest.getName())){
            throw new BrandNotFoundException("this brand name already exist");
        }

        brand.setName(brandRequest.getName());

        brandRepository.save(brand);

    }

    @Override
    public void deleteById(Long brandId) {

        brandRepository.deleteById(brandId);

    }


}




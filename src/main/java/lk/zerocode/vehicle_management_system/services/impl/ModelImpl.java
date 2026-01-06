package lk.zerocode.vehicle_management_system.services.impl;
import lk.zerocode.vehicle_management_system.controllers.requests.ModelRequest;
import lk.zerocode.vehicle_management_system.models.Model;
import lk.zerocode.vehicle_management_system.repository.ModelRepository;
import lk.zerocode.vehicle_management_system.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class ModelImpl implements ModelService {

        @Autowired
        private ModelRepository modelRepository;

        @Override
        public void create(ModelRequest modelRequest) {

            System.out.println("Service " + modelRequest.getModelId());
            Model model = new Model();

            model.setModelId(modelRequest.getModelId());
            model.setModelName(modelRequest.getModelName());

            modelRepository.save(model);

        }
}

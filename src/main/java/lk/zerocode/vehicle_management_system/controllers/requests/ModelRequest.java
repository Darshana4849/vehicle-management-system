package lk.zerocode.vehicle_management_system.controllers.requests;

import lombok.Data;

@Data
public class ModelRequest {

    private String modelName;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
